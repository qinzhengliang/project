package com.zte.alm.safety.service.impl;

import com.zte.alm.safety.common.service.BaseService;
import com.zte.alm.safety.repository.entity.SysField;
import com.zte.alm.safety.repository.entity.SysUser;
import com.zte.alm.safety.repository.mapper.SysFieldMapper;
import com.zte.alm.safety.service.IFieldService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 00202353 on 2016/7/21.
 */
@Service
public class FieldService extends BaseService implements IFieldService {
    @Resource
    private SysFieldMapper sysFieldMapper;

    @Override
    public int add(SysField sysField){
        return sysFieldMapper.insertSelective(sysField);
    }

    @Override
    public void deleteByPrimaryKey(Long id){
        sysFieldMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Map> query(Map map,SysUser user) throws Exception{
        Map queryMap = new HashMap();
        if (this.isMapKeyNull(map,"tableName")) {
        } else {
            queryMap.put("tableName",this.getMapString(map,"tableName"));
        }
        if(!this.isMapKeyNull(map,"displayName"))
        {
            queryMap.put("displayName",this.getMapString(map,"displayName"));
        }
        //获取符合条件的数据
        List<Map> queryResult = sysFieldMapper.query(queryMap);

        return queryResult;
    }
    @Override
    public List<Map> queryAll() throws Exception{
        List<Map> queryResult = sysFieldMapper.queryAll();
        return queryResult;
    }

    @Override
    public int update(SysField sysField){
        return sysFieldMapper.updateByPrimaryKey(sysField);
    }

    @Override
    public SysField selectByPrimaryKey(Long id){

        return sysFieldMapper.selectByPrimaryKey(id);
    }
}
