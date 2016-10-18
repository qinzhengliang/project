package com.zte.alm.safety.repository.mapper;

import com.zte.alm.safety.repository.entity.SysOrganization;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface SysOrganizationMapper extends Mapper<SysOrganization> {
    public List<Map> query(Map queryMap);

    public List<Map> queryAll();
}