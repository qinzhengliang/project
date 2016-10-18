package com.zte.alm.safety.service;

import com.zte.alm.safety.repository.entity.SysOrganizationRole;

import java.util.List;
import java.util.Map;

/**
 * Created by 6418000384 on 2016/7/21.
 */
public interface IOrganizationRoleService {
    public int add(SysOrganizationRole sysOrganizationRole);

    public void deleteByPrimaryKey(Long id);

    public List<Map> query(Map map) throws Exception;

    public int update(SysOrganizationRole sysOrganizationRole);

    public SysOrganizationRole selectByPrimaryKey(Long id);

    public List<Map> queryAll() throws Exception;
}
