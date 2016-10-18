package com.zte.alm.safety.service;

import com.zte.alm.safety.repository.entity.SysEnterprise;
import com.zte.alm.safety.repository.entity.SysUser;

import java.util.List;
import java.util.Map;
/**
 * Created by 6418000384 on 2016/7/15.
 */
public interface IEnterpriseService {
    public int add(SysEnterprise sysEnterprise);
    public void deleteByPrimaryKey(Long id);
    public List<Map> query(Map map,SysUser user) throws Exception;
    public List<Map> queryAll() throws Exception;
    public int update(SysEnterprise sysEnterprise);
    public SysEnterprise selectByPrimaryKey(Long id);
}

