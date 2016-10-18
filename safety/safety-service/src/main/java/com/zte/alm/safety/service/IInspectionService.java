package com.zte.alm.safety.service;

import com.zte.alm.safety.repository.entity.SysEnterprise;
import com.zte.alm.safety.repository.entity.SysEnterprisePatrol;
import com.zte.alm.safety.repository.entity.SysInspection;
import com.zte.alm.safety.repository.entity.SysUser;

import java.util.List;
import java.util.Map;

/**
 * Created by 6418000384 on 2016/7/15.
 */
public interface IInspectionService {

    public int add(SysInspection sysInspection);

    public void deleteByPrimaryKey(Long id);

    public List<Map> query(Map map,SysUser user) throws Exception;

    public List<Map> queryAll() throws Exception;

    public int update(SysInspection sysInspection);

    public SysInspection selectByPrimaryKey(Long id);

}
