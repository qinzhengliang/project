package org.seckill.personal.service;

import java.util.Date;
import java.util.List;

import org.seckill.personal.dto.Exposer;
import org.seckill.personal.dto.SeckillExecution;
import org.seckill.personal.entity.Seckill;
import org.seckill.personal.exception.RepeatSeckillException;
import org.seckill.personal.exception.SeckillCloseException;
import org.seckill.personal.exception.SeckillException;

public interface SeckillService
{
    int updateEndTime(long seckillId, Date endTime);
    
    List<Seckill> getSeckillList();
    
    Seckill getById(long seckillId);
    
    Exposer exportSeckillUrl(long seckill);
    
    SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
        throws SeckillException, SeckillCloseException, RepeatSeckillException;
    
    SeckillExecution executeSeckillProcedure(long seckillId, long userPhone, String md5);
}
