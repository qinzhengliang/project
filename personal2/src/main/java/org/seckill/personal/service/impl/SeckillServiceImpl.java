package org.seckill.personal.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.seckill.personal.dao.SeckillDao;
import org.seckill.personal.dao.SuccessKilledDao;
import org.seckill.personal.dao.cache.RedisDao;
import org.seckill.personal.dto.Exposer;
import org.seckill.personal.dto.SeckillExecution;
import org.seckill.personal.entity.Seckill;
import org.seckill.personal.entity.SuccessKilled;
import org.seckill.personal.enums.SeckillStateEnum;
import org.seckill.personal.exception.RepeatSeckillException;
import org.seckill.personal.exception.SeckillCloseException;
import org.seckill.personal.exception.SeckillException;
import org.seckill.personal.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

@Service
public class SeckillServiceImpl implements SeckillService
{
    private static final String md5_key = "aafdsdasdkn@!#%KNKO*&GHKM:L:";
    
    private Logger logger = LoggerFactory.getLogger(getClass());
    
    @Autowired
    private SeckillDao seckillDao;
    
    @Autowired
    private SuccessKilledDao successKilledDao;
    
    @Autowired
    private RedisDao redisDao;
    
    @Override
    public List<Seckill> getSeckillList()
    {
        return seckillDao.queryAll(0, 4);
    }
    
    @Override
    public Seckill getById(long seckillId)
    {
        Seckill seckill = redisDao.getSeckill(seckillId);
        if (null == seckill)
        {
            seckill = seckillDao.queryById(seckillId);
            if (null != seckill)
            {
                redisDao.putSeckill(seckill);
            }
        }
        return seckill;
    }
    
    public int updateEndTime(long seckillId, Date endTime)
    {
        return seckillDao.updateEndTime(seckillId, endTime);
    }
    
    @Override
    public Exposer exportSeckillUrl(long seckillId)
    {
        Seckill seckill = redisDao.getSeckill(seckillId);
        if (null == seckill)
        {
            seckill = seckillDao.queryById(seckillId);
            if (null == seckill)
            {
                return new Exposer(false, seckillId);
            }
            else
            {
                redisDao.putSeckill(seckill);
            }
        }
        
        logger.info("exportSeckillUrl seckill:{}", seckill);
        
        Date startTime = seckill.getStartTime();
        Date endTime = seckill.getEndTime();
        Date currentTime = new Date();
        
        if (currentTime.getTime() < startTime.getTime() || currentTime.getTime() > endTime.getTime())
        {
            logger.info("exportSeckillUrl currentTime {} not between {} {}",
                currentTime.getTime(),
                startTime.getTime(),
                endTime.getTime());
            return new Exposer(false, seckillId, currentTime.getTime(), startTime.getTime(), endTime.getTime());
        }
        logger.info("exportSeckillUrl seccess");
        return new Exposer(true, getMd5(seckillId), seckillId);
    }
    
    private String getMd5(long seckillId)
    {
        String baseStr = md5_key + seckillId;
        String md5 = DigestUtils.md5DigestAsHex(baseStr.getBytes());
        return md5;
    }
    
    @Override
    @Transactional
    public SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
        throws SeckillException, SeckillCloseException, RepeatSeckillException
    {
        if (null == md5 || !md5.equals(getMd5(seckillId)))
        {
            throw new SeckillException("seckill data rewrite");
        }
        
        try
        {
            int reduceCount = seckillDao.reduceNumber(seckillId, new Date());
            if (reduceCount <= 0)
            {
                throw new SeckillCloseException("seckill is closed");
            }
            else
            {
                int insertCount = successKilledDao.insertSuccessKilled(seckillId, userPhone);
                if (insertCount <= 0)
                {
                    throw new RepeatSeckillException("seckill repeated");
                }
                else
                {
                    SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(seckillId, userPhone);
                    return new SeckillExecution(seckillId, SeckillStateEnum.SUCCESS, successKilled);
                }
            }
        }
        catch (SeckillCloseException e)
        {
            throw e;
        }
        catch (RepeatSeckillException e)
        {
            throw e;
        }
        catch (Exception e)
        {
            throw new SeckillException("seckill inner error:" + e.getMessage());
        }
    }
    
    @Override
    public SeckillExecution executeSeckillProcedure(long seckillId, long userPhone, String md5)
    {
        if (null == md5 || !md5.equals(getMd5(seckillId)))
        {
            return new SeckillExecution(seckillId, SeckillStateEnum.DATA_REWRITE);
        }
        
        Date killTime = new Date();
        int result = -2;
        Map<String, Object> param = new HashMap<String, Object>();
        
        param.put("seckillId", seckillId);
        param.put("killTime", killTime);
        param.put("phone", userPhone);
        param.put("result", result);
        
        seckillDao.killByProcedure(param);
        result = (Integer)param.get("result");
        try
        {
            if (1 == result)
            {
                SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(seckillId, userPhone);
                return new SeckillExecution(seckillId, SeckillStateEnum.SUCCESS, successKilled);
            }
            else
            {
                return new SeckillExecution(seckillId, SeckillStateEnum.statsseOf(result));
            }
            
        }
        catch (Exception e)
        {
            logger.debug(e.getMessage(), e);
            return new SeckillExecution(seckillId, SeckillStateEnum.INNER_ERROR);
        }
    }
    
}
