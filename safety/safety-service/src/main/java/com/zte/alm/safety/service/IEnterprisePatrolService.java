package com.zte.alm.safety.service;

import com.zte.alm.safety.repository.entity.SysEnterprisePatrol;
import com.zte.alm.safety.repository.entity.SysUser;

import java.util.List;
import java.util.Map;

/**
 * Created by 6418000384 on 2016/7/15.
 */
public interface IEnterprisePatrolService {
    public int add(SysEnterprisePatrol sysEnterprisePatrol);

    public void deleteByPrimaryKey(Long id);

    public List<Map> query(Map map,SysUser user) throws Exception;

    public List<Map> queryAll() throws Exception;

    public int update(SysEnterprisePatrol sysEnterprisePatrol);

    public SysEnterprisePatrol selectByPrimaryKey(Long id);
}
