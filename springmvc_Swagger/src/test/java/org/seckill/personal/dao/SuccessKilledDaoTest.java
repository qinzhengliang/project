package org.seckill.personal.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.personal.entity.SuccessKilled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SuccessKilledDaoTest
{
    @Autowired
    private SuccessKilledDao successKilledDao;
    
    @Test
    public void testInsertSuccessKilled()
    {
        long seckillId = 1000;
        long userPhone = 13451876050l;
        int insertCount = successKilledDao.insertSuccessKilled(seckillId, userPhone);
        System.out.println("insertCount : " + insertCount);
    }
    
    @Test
    public void testQueryByIdWithSeckill()
    {
        long seckillId = 1000;
        long userPhone = 13451876050l;
        SuccessKilled successkilled = successKilledDao.queryByIdWithSeckill(seckillId, userPhone);
        System.out.println(successkilled);
    }
    
}
