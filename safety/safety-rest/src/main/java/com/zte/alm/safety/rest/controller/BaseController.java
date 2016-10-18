package com.zte.alm.safety.rest.controller;

import com.github.pagehelper.Page;
import com.zte.alm.safety.infrastructure.utility.BaseClass;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 6418000384 on 2016/7/18.
 */
public class BaseController extends BaseClass{
     /***
     * 生成分页返回值
     * @param entity
     * @return
     */
    public Object buildPaginationResult(Object entity)
    {
        Map resultMap = new HashMap();
        if(entity == null || !(entity instanceof Page)){
            resultMap.put("data", entity);
            Map pagination = new HashMap();
            resultMap.put("page", pagination);
        }else{
            resultMap = new HashMap();
            resultMap.put("data", entity);
            Map pagination = new HashMap();
            pagination.put("page", ((Page) entity).getPageNum());
            pagination.put("pageSize", ((Page) entity).getPageSize());
            pagination.put("total", ((Page) entity).getTotal());
            resultMap.put("page", pagination);
        }
        return resultMap;
    }
}
