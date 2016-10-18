package com.zte.alm.safety.infrastructure.utility;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2016/7/23.
 */
public class WebUtility {
    public static boolean isAjaxRequest(HttpServletRequest httpServletRequest){
        if("XMLHttpRequest".equals(httpServletRequest.getHeader("X-Requested-With"))){
            return true;
        }
        return false;
    }

    public static void sendJsonResponse(HttpServletResponse httpServletResponse, String jsonString) throws IOException {
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json; charset=utf-8");
        PrintWriter out = null;
        try{
            out = httpServletResponse.getWriter();
            out.append(jsonString);
        }catch (Exception ex){

        }finally {
            if(null!=out){
                out.close();
            }
        }

    }
}
