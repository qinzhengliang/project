package com.zte.alm.safety.repository.mapper;

import com.zte.alm.safety.repository.entity.SysEmergencyRescue;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface SysEmergencyRescueMapper extends Mapper<SysEmergencyRescue> {
    public List<Map> query(Map queryMap);

   public List<Map> queryAll();
}