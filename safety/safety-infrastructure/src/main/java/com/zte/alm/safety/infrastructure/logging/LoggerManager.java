package com.zte.alm.safety.infrastructure.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by 10115916 on 2016/7/15 0015.
 */
public class LoggerManager {

    public static void info(Class clazz, String message){
        Logger logger = LoggerFactory.getLogger(clazz);
        logger.info(message);
    }

    public static void error(Class clazz, String message, Exception ex){
        Logger logger = LoggerFactory.getLogger(clazz);
        logger.error(message, ex);
    }
}
