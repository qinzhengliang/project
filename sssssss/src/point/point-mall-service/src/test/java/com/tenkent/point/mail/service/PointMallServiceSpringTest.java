package com.tenkent.point.mail.service;

import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by 10115916 on 2016/8/10 0010.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContextServiceTest.xml"})
public class PointMallServiceSpringTest extends AbstractJUnit4SpringContextTests {
    public <T> T getBean(Class<T> type){
        return applicationContext.getBean(type);
    }

    public Object getBean(String beanName){
        return applicationContext.getBean(beanName);
    }

    protected ApplicationContext getContext(){
        return applicationContext;
    }
}
