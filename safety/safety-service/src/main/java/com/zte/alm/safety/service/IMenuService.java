package com.zte.alm.safety.service;

import com.zte.alm.safety.repository.entity.SysMenu;
import com.zte.alm.safety.service.datacontract.MenuInfo;

import java.util.List;
import java.util.Map;

/**
 * Created by 6418000384 on 2016/7/21.
 */
public interface IMenuService {
    public int add(SysMenu sysMenu);

    public void deleteByPrimaryKey(Long id);

    public List<Map> query(Map map) throws Exception;

    public int update(SysMenu sysMenu);

    public SysMenu selectByPrimaryKey(Long id);

    public List<Map> queryAll() throws Exception;

    public List<MenuInfo> queryAllMenuTree();
}
