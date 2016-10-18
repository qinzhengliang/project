package com.zte.alm.safety.repository.mapper;

import com.zte.alm.safety.repository.entity.SysMenu;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface SysMenuMapper extends Mapper<SysMenu> {
    public List<Map> query(Map queryMap);

    public List<Map> queryAll();

    List<SysMenu> queryAllMenuTree();
}