package com.zte.alm.safety.service.impl;

import com.zte.alm.safety.common.service.BaseService;
import com.zte.alm.safety.repository.entity.SysInspection;
import com.zte.alm.safety.repository.entity.SysUser;
import com.zte.alm.safety.repository.mapper.SysInspectionMapper;
import com.zte.alm.safety.service.IInspectionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 6418000384 on 2016/7/15.
 */
@Service
public class InspectionService extends BaseService implements IInspectionService {
    @Resource
    private SysInspectionMapper sysInspectionMapper;

    @Override
    public int add(SysInspection sysInspection){

        return sysInspectionMapper.insertSelective(sysInspection);
    }

    @Override
    public void deleteByPrimaryKey(Long id){
        sysInspectionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Map> query(Map map,SysUser user) throws Exception{
        Map queryMap = new HashMap();
        if(!this.isMapKeyNull(map,"inspectionTime"))
        {
            queryMap.put("inspectionTime",this.getMapString(map,"inspectionTime"));
        }
        if(!this.isMapKeyNull(map,"inspector"))
        {
            queryMap.put("inspector",this.getMapString(map,"inspector"));
        }
        if(!this.isMapKeyNull(map,"department"))
        {
            queryMap.put("department",this.getMapString(map,"department"));
        }
        //获取符合条件的数据
        List<Map> queryResult = sysInspectionMapper.query(queryMap);
        return queryResult;
    }

    @Override
    public List<Map> queryAll() throws Exception{

        //获取符合条件的数据
        List<Map> queryResult = sysInspectionMapper.queryAll();

        return queryResult;
    }
    @Override
    public int update(SysInspection sysInspection){
        return sysInspectionMapper.updateByPrimaryKey(sysInspection);
    }

    @Override
    public SysInspection selectByPrimaryKey(Long id){
        return sysInspectionMapper.selectByPrimaryKey(id);
    }
}
