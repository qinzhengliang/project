package com.zte.alm.safety.rest.restcontroller;

import com.zte.alm.safety.infrastructure.base.Response;
import com.zte.alm.safety.infrastructure.exceptionHandling.RestException;
import com.zte.alm.safety.infrastructure.shiro.ShiroHelper;
import com.zte.alm.safety.repository.entity.SysUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by 10115916 on 2016/7/14 0014.
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "api/login")
public class LoginRestController {
    @RequestMapping(value = "")
    public Response login(@RequestBody Map map) throws Exception {
        String name = map.get("name").toString();
        String password = map.get("password").toString();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(name, password);
        Subject subject = SecurityUtils.getSubject();
        try{
            subject.login(usernamePasswordToken);
        } catch (AuthenticationException ex){
            throw new Exception("用户名密码不正确！", ex);
        }
        return new Response(ShiroHelper.getPrincipal());
    }

    @RequestMapping(value = "getCurrentUser")
    public Response getCurrentUser() throws RestException {
        Object object = ShiroHelper.getPrincipal();
        if(null == object){
            throw new RestException("已过期，请重新登陆");
        }
        SysUser sysUser = (SysUser)object;
        sysUser.setPassword("");
        return new Response(sysUser);
    }

    @RequestMapping(value = "logout")
    public Response logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return new Response();
    }
}
