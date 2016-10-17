package org.seckill.personal.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.personal.entity.Seckill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest
{
    @Autowired
    private SeckillDao seckillDao;
    
    @Test
    public void testQueryById()
    {
        System.out.println("-----------------");
        
        long id = 1000;
        Seckill seckill = seckillDao.queryById(id);
        System.out.println(seckill.getName());
        System.out.println(seckill);
        
        System.out.println("-----------------");
    }
    
    @Test
    public void testQueryAll()
    {
        int offset = 0;
        int limit = 10;
        List<Seckill> seckills = seckillDao.queryAll(offset, limit);
        
        for (Seckill k : seckills)
        {
            System.out.println(k);
        }
    }
    
    @Test
    public void testReduceNumber()
    {
        long seckillId = 1000;
        Date killTime = new Date(new Date().getTime() - 3600 * 55 * 1000);
        int reduceNumber = seckillDao.reduceNumber(seckillId, killTime);
        System.out.println("reduceNumber:  " + reduceNumber);
    }
    
    @Test
    public void testkillByProcedure()
    {
        long seckillId = 1000;
        Date killTime = new Date();
        long phone = 13451876061l;
        int result = -3;
        Map<String, Object> param = new HashMap<String, Object>();
        
        param.put("seckillId", seckillId);
        param.put("killTime", killTime);
        param.put("phone", phone);
        param.put("result", result);
        
        seckillDao.killByProcedure(param);
        System.out.println(param.get("result"));
    }
    
    @Test
    public void updateEndTime()
    {
        long seckillId = 1000;
        Date endTime = new Date(System.currentTimeMillis() + 3600 * 1000 * 12);
        int updateCount = seckillDao.updateEndTime(seckillId, endTime);
        System.out.println("updateCount:  " + updateCount);
    }
    
    @Test
    public void testDate()
    {
        /*
         * 1475424000000  1475510400000
         */
        long timestamp = 1475424000000l;
        Date date = new Date();
        System.out.println((date.getTime() - timestamp) / (3600 * 1000));
        System.out.println(new Date(timestamp));
        
        System.out.println(new Date().getTime() - 3600 * 55 * 1000 - 1475424000000l);
        System.out.println(new Date().getTime() - 3600 * 55 * 1000 - 1475510400000l);
    }
    
}
