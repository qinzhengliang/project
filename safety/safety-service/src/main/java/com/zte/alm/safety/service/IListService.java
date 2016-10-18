package com.zte.alm.safety.service;

import com.zte.alm.safety.repository.entity.SysEnterprisePatrol;
import com.zte.alm.safety.repository.entity.SysList;
import com.zte.alm.safety.repository.entity.SysUser;

import java.util.List;
import java.util.Map;

/**
 * Created by 10115916 on 2016/7/13 0013.
 */
public interface IListService {

    public int add(SysList sysList);

    public List<Map> query(Map map) throws Exception;

    public List<Map> queryAll() throws Exception;

    public void deleteByPrimaryKey(Long id);

    public int update(SysList sysList);

    public SysList selectByPrimaryKey(Long id);

    public SysList GetListByName(String listName);
}
