package com.zte.alm.safety.service;

import com.zte.alm.safety.repository.entity.SysEnterprise;
import com.zte.alm.safety.repository.entity.SysRescueExpert;
import com.zte.alm.safety.repository.entity.SysUser;

import java.util.List;
import java.util.Map;

/**
 * Created by 00202353 on 2016/7/20.
 */
public interface IRescueExpertService {
    public int add(SysRescueExpert sysRescueExpert);
    public void deleteByPrimaryKey(Long id);
    public List<Map> query(Map map,SysUser user) throws Exception;
    public List<Map> queryAll() throws Exception;
    public int update(SysRescueExpert sysRescueExpert);
    public SysRescueExpert selectByPrimaryKey(Long id);
}
