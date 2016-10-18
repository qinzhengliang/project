package com.zte.alm.safety.repository.mapper;

import com.zte.alm.safety.repository.entity.SysInspectionProblem;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface SysInspectionProblemMapper extends Mapper<SysInspectionProblem> {
    public List<Map> query(Map map);
    public List<Map> queryAll();
}