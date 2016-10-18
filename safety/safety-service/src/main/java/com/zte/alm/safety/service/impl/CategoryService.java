package com.zte.alm.safety.service.impl;

import com.zte.alm.safety.common.service.BaseService;
import com.zte.alm.safety.repository.mapper.SysCategoryMapper;
import com.zte.alm.safety.service.ICategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 00202353 on 2016/7/19.
 */
@Service
public class CategoryService extends BaseService implements ICategoryService {
    @Resource
    private SysCategoryMapper sysCategoryMapper;

    @Override
    public List<Map> query(Map map) throws Exception{
        Map queryMap = new HashMap();
        if(!this.isMapKeyNull(map,"parentId"))
        {
            queryMap.put("parentId",this.getMapString(map,"parentId"));
        }
        //获取符合条件的数据
        List<Map> queryResult = sysCategoryMapper.query(queryMap);

        return queryResult;
    }

}
