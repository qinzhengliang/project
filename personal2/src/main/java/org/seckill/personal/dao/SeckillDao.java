package org.seckill.personal.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.seckill.personal.entity.Seckill;

public interface SeckillDao
{
    int reduceNumber(@Param("seckillId") long seckillId, @Param("killTime") Date killTime);
    
    Seckill queryById(long seckillId);
    
    List<Seckill> queryAll(@Param("offset") int offset, @Param("limit") int limit);
    
    int updateEndTime(@Param("seckillId") long seckillId, @Param("endTime") Date endTime);
    
    void killByProcedure(Map<String, Object> param);
}