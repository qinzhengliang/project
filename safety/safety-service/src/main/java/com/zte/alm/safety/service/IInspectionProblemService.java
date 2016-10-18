package com.zte.alm.safety.service;

import com.zte.alm.safety.repository.entity.SysHospital;
import com.zte.alm.safety.repository.entity.SysInspectionProblem;
import com.zte.alm.safety.repository.entity.SysUser;

import java.util.List;
import java.util.Map;

/**
 * Created by 00202353 on 2016/7/20.
 */
public interface IInspectionProblemService {
    public int add(SysInspectionProblem sysInspectionProblem);
    public void deleteByPrimaryKey(Long id);
    public List<Map> query(Map map,SysUser user) throws Exception;
    public List<Map> queryAll() throws Exception;
    public int update(SysInspectionProblem sysInspectionProblem);
    public SysInspectionProblem selectByPrimaryKey(Long id);
}
