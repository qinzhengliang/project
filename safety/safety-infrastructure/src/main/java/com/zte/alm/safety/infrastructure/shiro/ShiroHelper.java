package com.zte.alm.safety.infrastructure.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 10115916 on 2016/7/21 0021.
 */
public class ShiroHelper {
    public static Subject getSubject(){
        return SecurityUtils.getSubject();
    }

    public static Object getPrincipal(){
        return SecurityUtils.getSubject().getPrincipal();
    }

    public static List<Long> getEnterpriseAuthorization(){
        return new ArrayList<Long>();
    }
}
