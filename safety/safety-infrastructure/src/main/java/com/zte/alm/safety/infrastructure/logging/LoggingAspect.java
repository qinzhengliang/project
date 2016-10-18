package com.zte.alm.safety.infrastructure.logging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 10115916 on 2016/7/18 0018.
 */
public class LoggingAspect {
    public Object LoggingAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object classMethod=proceedingJoinPoint.getSignature();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String now=sdf.format(date);

        LoggerManager.info(LoggingAspect.class,classMethod + " starting when " + now);
        Object result = proceedingJoinPoint.proceed();
        LoggerManager.info(LoggingAspect.class,classMethod + " executed!");
        return result;
    }
}
