package com.zte.alm.safety.repository.mapper;

import com.zte.alm.safety.repository.entity.SysCategory;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface SysCategoryMapper extends Mapper<SysCategory> {
    public List<Map> query(Map map);
}