package com.zte.alm.safety.repository.mapper;

import com.zte.alm.safety.repository.entity.SysRescueExpert;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface SysRescueExpertMapper extends Mapper<SysRescueExpert> {
    public List<Map> query(Map map);
    public List<Map> queryAll();
}