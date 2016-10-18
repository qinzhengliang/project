package com.zte.alm.safety.repository.mapper;

import com.zte.alm.safety.repository.entity.SysGroup;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface SysGroupMapper extends Mapper<SysGroup> {
    public List<Map> query(Map map);
    public List<Map> queryAll();
}