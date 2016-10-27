package com.tenkent.point.infrastructure.exceptionHandling;

import com.tenkent.point.infrastructure.utility.StringUtility;

/**
 * Created by 6418000384 on 2016/7/15.
 */
public class RestException extends BaseException {

    private static String errmessage = "控制层处理错误";

    public RestException(){
        super();
        this.setDetailMessage(errmessage);
    }

    public RestException(String message){
        super(message);
        this.setDetailMessage(errmessage);
    }

    public RestException(String messageTemplate, Object... params){
        super(StringUtility.format(messageTemplate, params));
        this.setDetailMessage(errmessage);
    }

    public RestException(String message, Throwable cause) {
        super(message, cause);
        this.setDetailMessage(errmessage);
    }

    public RestException(Throwable cause,String messageTemplate, Object... params){
        super(StringUtility.format(messageTemplate, params),cause);
        this.setDetailMessage(errmessage);

    }
}
