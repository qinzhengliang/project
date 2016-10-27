package com.tenkent.point.infrastructure.exceptionHandling;

import com.tenkent.point.infrastructure.exceptionHandling.BaseException;
import com.tenkent.point.infrastructure.utility.StringUtility;

/**
 * Created by 6418000384 on 2016/7/15.
 */
public class ServiceException extends BaseException {
    private static String errmessage = "业务逻辑处理错误";

    public ServiceException(){
        super();
        this.setDetailMessage(errmessage);
    }

    public ServiceException(String message){
        super(message);
        this.setDetailMessage(errmessage);
    }

    public ServiceException(String messageTemplate, Object... params){
        super(StringUtility.format(messageTemplate, params));
        this.setDetailMessage(errmessage);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
        this.setDetailMessage(errmessage);
    }

    public ServiceException(Throwable cause,String messageTemplate, Object... params){
        super(StringUtility.format(messageTemplate, params),cause);
        this.setDetailMessage(errmessage);

    }
}
