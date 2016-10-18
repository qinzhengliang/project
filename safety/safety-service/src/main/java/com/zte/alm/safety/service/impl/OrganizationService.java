package com.zte.alm.safety.service.impl;

import com.zte.alm.safety.common.service.BaseService;
import com.zte.alm.safety.repository.entity.SysOrganization;
import com.zte.alm.safety.repository.mapper.SysOrganizationMapper;
import com.zte.alm.safety.service.IOrganizationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 6418000384 on 2016/7/19.
 */
@Service
public class OrganizationService extends BaseService implements IOrganizationService {

    @Resource
    private SysOrganizationMapper sysOrganizationMapper;

    @Override
    public int add(SysOrganization sysOrganization){

        return sysOrganizationMapper.insertSelective(sysOrganization);
    }

    @Override
    public void deleteByPrimaryKey(Long id){
        sysOrganizationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Map> query(Map map) throws Exception{
        Map queryMap = new HashMap();
        if(!this.isMapKeyNull(map,"id"))
        {
            queryMap.put("id",this.getMapString(map,"id"));
        }
        if(!this.isMapKeyNull(map,"parentId"))
        {
            queryMap.put("parentId",this.getMapString(map,"parentId"));
        }
        //获取符合条件的数据
        List<Map> queryResult = sysOrganizationMapper.query(queryMap);
        return queryResult;
    }

    @Override
    public List<Map> queryAll() throws Exception{
        //获取符合条件的数据
        List<Map> queryResult = sysOrganizationMapper.queryAll();
        return queryResult;
    }

    @Override
    public int update(SysOrganization sysOrganization){
        return sysOrganizationMapper.updateByPrimaryKey(sysOrganization);
    }

    @Override
    public SysOrganization selectByPrimaryKey(Long id){
        return sysOrganizationMapper.selectByPrimaryKey(id);
    }
}
