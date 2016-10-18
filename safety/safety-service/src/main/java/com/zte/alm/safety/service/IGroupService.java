package com.zte.alm.safety.service;

import com.zte.alm.safety.repository.entity.SysGroup;
import com.zte.alm.safety.repository.entity.SysUser;

import java.util.List;
import java.util.Map;

/**
 * Created by 00202353 on 2016/7/21.
 */
public interface IGroupService {
    public int add(SysGroup sysGroup);
    public void deleteByPrimaryKey(Long id);
    public List<Map> query(Map map,SysUser user) throws Exception;
    public List<Map> queryAll() throws Exception;
    public int update(SysGroup sysGroup);
    public SysGroup selectByPrimaryKey(Long id);
}
