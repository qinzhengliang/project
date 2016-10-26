package com.tenkent.point.infrastructure.shiro;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * Created by Administrator on 2016/7/17.
 */
public class ValidCodeUsernamePasswordToken extends UsernamePasswordToken {
    private String validCode;

    public ValidCodeUsernamePasswordToken(String username, char[] password, boolean rememberMe, String host, String validCode) {
        //调用父类的构造函数
        super(username, password, rememberMe, host);
        this.validCode = validCode;
    }

    public String getValidCode() {
        return validCode;
    }

    public void setValidCode(String validCode) {
        this.validCode = validCode;
    }
}
