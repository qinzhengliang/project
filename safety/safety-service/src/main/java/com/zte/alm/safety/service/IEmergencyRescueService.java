package com.zte.alm.safety.service;

import com.zte.alm.safety.repository.entity.SysEmergencyRescue;
import com.zte.alm.safety.repository.entity.SysUser;

import java.util.List;
import java.util.Map;

/**
 * Created by 6418000384 on 2016/7/20.
 */
public interface IEmergencyRescueService {
    public int add(SysEmergencyRescue sysEmergencyRescue);

    public void deleteByPrimaryKey(Long id);

    public List<Map> query(Map map,SysUser user) throws Exception;

    public List<Map> queryAll() throws Exception;

    public int update(SysEmergencyRescue sysEmergencyRescue);

    public SysEmergencyRescue selectByPrimaryKey(Long id);
}
