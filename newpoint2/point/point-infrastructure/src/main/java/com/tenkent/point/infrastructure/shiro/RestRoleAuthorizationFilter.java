package com.tenkent.point.infrastructure.shiro;

import com.tenkent.point.infrastructure.base.Global;
import com.tenkent.point.infrastructure.base.Response;
import com.tenkent.point.infrastructure.utility.JsonUtility;
import com.tenkent.point.infrastructure.utility.WebUtility;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2016/7/23.
 */
public class RestRoleAuthorizationFilter extends AuthorizationFilter {
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        Subject subject = getSubject(request, response);
        if (subject.getPrincipal() == null) {
            Response responseObject = new Response(Global.ERROR,"您尚未登录或登录时间过长,请重新登录!");
            WebUtility.sendJsonResponse(httpResponse, JsonUtility.toJSONString(responseObject));
        } else {
            if (WebUtility.isAjaxRequest(httpRequest)) {
                Response responseObject = new Response(Global.ERROR, "您没有足够的权限执行该操作!");
                WebUtility.sendJsonResponse(httpResponse, JsonUtility.toJSONString(responseObject));
            }
        }
        return false;
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        Subject subject = getSubject(servletRequest, servletResponse);
        if (subject.getPrincipal() != null) {
            return true;
        }
        return false;
    }
}
