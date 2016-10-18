package com.zte.alm.safety.repository.mapper;

import com.zte.alm.safety.repository.entity.SysProductionSafetyCredit;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface SysProductionSafetyCreditMapper extends Mapper<SysProductionSafetyCredit> {
    public List<Map> query(java.util.Map map);
    public java.util.List<Map> queryAll();
}