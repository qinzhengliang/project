package com.zte.alm.safety.repository.mapper;

import com.zte.alm.safety.repository.entity.SysEnterprisePatrol;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface SysEnterprisePatrolMapper extends Mapper<SysEnterprisePatrol> {
    public List<Map> query(Map map);

    public List<Map> queryAll();
}