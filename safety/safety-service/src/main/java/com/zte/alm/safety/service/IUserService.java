package com.zte.alm.safety.service;

import com.zte.alm.safety.repository.entity.SysUser;

import java.util.List;
import java.util.Map;

/**
 * Created by 6418000384 on 2016/7/19.
 */
public interface IUserService {
    public int add(SysUser sysUser);

    public void deleteByPrimaryKey(Long id);

    public List<Map> query(Map map) throws Exception;
    public List<Map> queryAll() throws Exception;

    public int update(SysUser sysUser);

    public SysUser selectByPrimaryKey(Long id);
}
