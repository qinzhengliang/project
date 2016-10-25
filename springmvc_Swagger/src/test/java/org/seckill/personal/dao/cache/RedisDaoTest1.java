package org.seckill.personal.dao.cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.personal.dao.SeckillDao;
import org.seckill.personal.entity.Seckill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class RedisDaoTest1
{
    private int id = 1000;
    
    @Autowired
    private SeckillDao seckillDao;
    
    @Autowired
    private RedisDao redisDao;
    
    @Test
    public void testSeckill()
    {
        Seckill seckill = redisDao.getSeckill(id);
        if (null == seckill)
        {
            seckill = seckillDao.queryById(id);
            
            if (null != seckill)
            {
                String result = redisDao.putSeckill(seckill);
                System.out.println("result:" + result);
                
                seckill = redisDao.getSeckill(id);
                System.out.println(seckill);
            }
            
        }
    }
}
