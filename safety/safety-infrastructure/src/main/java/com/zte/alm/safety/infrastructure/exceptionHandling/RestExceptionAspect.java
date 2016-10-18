package com.zte.alm.safety.infrastructure.exceptionHandling;

import com.zte.alm.safety.infrastructure.base.Global;
import com.zte.alm.safety.infrastructure.base.Response;
import com.zte.alm.safety.infrastructure.logging.LoggerManager;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/7/17.
 */
public class RestExceptionAspect {
    public Object exceptionAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result = null;
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Exception ex) {
            return new Response(Global.ERROR, ex.getMessage());
        }
        return result;
    }
}
