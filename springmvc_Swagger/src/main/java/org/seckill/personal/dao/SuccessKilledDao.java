package org.seckill.personal.dao;


import org.apache.ibatis.annotations.Param;
import org.seckill.personal.entity.SuccessKilled;

public interface SuccessKilledDao
{
    int insertSuccessKilled(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);
    
    SuccessKilled queryByIdWithSeckill(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);
}
