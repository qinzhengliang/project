package com.zte.alm.safety.service;

import com.zte.alm.safety.repository.entity.SysPatrolPoint;
import com.zte.alm.safety.repository.entity.SysUser;

import java.util.List;
import java.util.Map;

/**
 * Created by 6418000384 on 2016/7/21.
 */
public interface IPatrolPointService {

    public int add(SysPatrolPoint sysPatrolPoint);

    public void deleteByPrimaryKey(Long id);

    public List<Map> query(Map map,SysUser user) throws Exception;

    public List<Map> queryAll() throws Exception;

    public int update(SysPatrolPoint sysPatrolPoint);

    public SysPatrolPoint selectByPrimaryKey(Long id);
}
