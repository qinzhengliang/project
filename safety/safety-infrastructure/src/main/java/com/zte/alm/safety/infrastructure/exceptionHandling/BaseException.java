package com.zte.alm.safety.infrastructure.exceptionHandling;

import com.zte.alm.safety.infrastructure.utility.StringUtility;

/**
 * Created by 6418000384 on 2016/7/15.
 */
public class BaseException extends Exception{
    private String detailMessage = "";

    public String getDetailMessage() {
        return detailMessage;
    }

    public void setDetailMessage(String detailMessage) {
        this.detailMessage = detailMessage;
    }

    public BaseException(){
        super();
    }

    public BaseException(String message){
        super(message);
    }

    public BaseException(String messageTemplate, Object... params){
        super(StringUtility.format(messageTemplate, params));
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(Throwable cause,String messageTemplate, Object... params){
        super(StringUtility.format(messageTemplate, params),cause);

    }
}
