package com.zte.alm.safety.service.shiro;

import com.zte.alm.safety.infrastructure.logging.LoggerManager;
import com.zte.alm.safety.repository.entity.SysUser;
import com.zte.alm.safety.repository.mapper.SysUserMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/7/17.
 */
@Service("permissionsRealm")
public class PermissionsRealm extends AuthorizingRealm {
    @Resource
    private SysUserMapper sysUserMapper;

    /**
     * 用户权限源（shiro调用此方法获取用户权限，至于从何处获取权限项，由我们定义。）
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

        return authorizationInfo;
    }

    /**
     * 用户登录验证源（shiro调用此方法执行认证）
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        SimpleAuthenticationInfo authenticationInfo = null;
        String userName = token.getUsername();
        String password = new String(token.getPassword());

        if (userName != null && !"".equals(userName)) {
            SysUser user = sysUserMapper.selectUserByNameAndPassword(userName, password);
            if (user != null) {
                doGetAuthorizationInfo(SecurityUtils.getSubject().getPrincipals());
                authenticationInfo = new SimpleAuthenticationInfo(user, token.getPassword(), getName());
                return authenticationInfo;
            }
        }
        return null;
    }

}
