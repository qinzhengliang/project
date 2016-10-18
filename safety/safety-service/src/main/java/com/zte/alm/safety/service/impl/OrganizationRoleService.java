package com.zte.alm.safety.service.impl;

import com.zte.alm.safety.common.service.BaseService;
import com.zte.alm.safety.repository.entity.SysOrganizationRole;
import com.zte.alm.safety.repository.mapper.SysOrganizationRoleMapper;
import com.zte.alm.safety.service.IOrganizationRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 6418000384 on 2016/7/21.
 */
@Service
public class OrganizationRoleService extends BaseService implements IOrganizationRoleService{

    @Resource
    private SysOrganizationRoleMapper sysOrganizationRoleMapper;

    @Override
    public int add(SysOrganizationRole sysOrganizationRole) {
        return sysOrganizationRoleMapper.insertSelective(sysOrganizationRole);
    }

    @Override
    public void deleteByPrimaryKey(Long id) {
        sysOrganizationRoleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Map> query(Map map) throws Exception {
        Map queryMap = new HashMap();
        if(!this.isMapKeyNull(map,"id"))
        {
            queryMap.put("id",this.getMapString(map,"id"));
        }
        if(!this.isMapKeyNull(map,"roleId"))
        {
            queryMap.put("roleId",this.getMapString(map,"roleId"));
        }
        //获取符合条件的数据
        List<Map> queryResult = sysOrganizationRoleMapper.query(queryMap);
        return queryResult;
    }

    @Override
    public int update(SysOrganizationRole sysOrganizationRole) {
        return sysOrganizationRoleMapper.updateByPrimaryKey(sysOrganizationRole);
    }

    @Override
    public SysOrganizationRole selectByPrimaryKey(Long id) {
        return sysOrganizationRoleMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Map> queryAll() throws Exception {
        //获取符合条件的数据
        List<Map> queryResult = sysOrganizationRoleMapper.queryAll();
        return queryResult;
    }
}
