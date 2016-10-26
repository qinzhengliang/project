package com.tenkent.point.mail.service;

import com.tenkent.point.mall.repository.entity.PointTestL;
import com.tenkent.point.mall.service.IPointTestService;
import com.tenkent.point.mall.service.impl.IPointTestServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class IPointTestServiceImplTest {

    @Autowired
    IPointTestService iPointTestService;

    @Test
    public void testGetAll() throws Exception {

        List<PointTestL> list = iPointTestService.getAll();

        for (PointTestL tt : list) {
            System.out.println(tt);
        }
    }
}
