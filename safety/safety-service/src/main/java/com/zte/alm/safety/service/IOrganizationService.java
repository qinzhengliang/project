package com.zte.alm.safety.service;

import com.zte.alm.safety.repository.entity.SysOrganization;

import java.util.List;
import java.util.Map;

/**
 * Created by 6418000384 on 2016/7/19.
 */
public interface IOrganizationService {
    public int add(SysOrganization sysOrganization);

    public void deleteByPrimaryKey(Long id);

    public List<Map> query(Map map) throws Exception;

    public int update(SysOrganization sysOrganization);

    public SysOrganization selectByPrimaryKey(Long id);

    public List<Map> queryAll() throws Exception;
}
