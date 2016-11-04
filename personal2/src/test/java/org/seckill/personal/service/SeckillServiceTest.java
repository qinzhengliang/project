package org.seckill.personal.service;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.personal.dto.Exposer;
import org.seckill.personal.dto.SeckillExecution;
import org.seckill.personal.entity.Seckill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})
public class SeckillServiceTest
{
	
	//ssssssss
    private final Logger logger = LoggerFactory.getLogger(getClass());
    
    @Autowired
    private SeckillService service;
    
    @Test
    public void testGetSeckillList()
    {
        List<Seckill> kills = service.getSeckillList();
        /*        for (Seckill kill : kills)
        {
            System.out.println(kill);
        }*/
        logger.info("list={}", kills);
    }
    
    @Test
    public void testGetById()
    {
        long seckillId = 1000;
        Seckill seckill = service.getById(seckillId);
        //System.out.println(seckill);
        logger.info("seckill={}", seckill);
    }
    
    @Test
    public void testExportSeckillUrl()
    {
        long seckillId = 1000;
        Date endTime = new Date(System.currentTimeMillis() + 3600*1000*12);
        
        int updateCount = service.updateEndTime(seckillId, endTime);
        logger.info("updateCount={}", updateCount);
        
        Exposer exposer = service.exportSeckillUrl(seckillId);
        logger.info("exposer={}", exposer);
        
        long userPhone = 13451876052l;
        SeckillExecution  seckillExecution  = service.executeSeckill(seckillId, userPhone, exposer.getMd5());
        logger.info("seckillExecution={}", seckillExecution);
    }
}
