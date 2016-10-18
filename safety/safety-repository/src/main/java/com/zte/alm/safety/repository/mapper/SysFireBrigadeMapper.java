package com.zte.alm.safety.repository.mapper;

import com.zte.alm.safety.repository.entity.SysFireBrigade;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface SysFireBrigadeMapper extends Mapper<SysFireBrigade> {
    public List<Map> queryAll();

   public List<Map> query(Map queryMap);
}