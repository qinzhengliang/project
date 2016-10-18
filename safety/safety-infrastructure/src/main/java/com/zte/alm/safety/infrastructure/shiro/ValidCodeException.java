package com.zte.alm.safety.infrastructure.shiro;

import org.apache.shiro.authc.AuthenticationException;

/**
 * Created by Administrator on 2016/7/17.
 */
public class ValidCodeException extends AuthenticationException {

    public ValidCodeException(String msg){
        super(msg);
    }
}
