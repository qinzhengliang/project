package com.zte.alm.safety.service;

import com.zte.alm.safety.repository.entity.SysContent;
import com.zte.alm.safety.repository.entity.SysUser;

import java.util.List;
import java.util.Map;

/**
 * Created by 00202353 on 2016/7/21.
 */
public interface IContentService {
    public int add(SysContent sysContent);
    public void deleteByPrimaryKey(Long id);
    public List<Map> query(Map map,SysUser user) throws Exception;
    public List<Map> queryAll() throws Exception;
    public int update(SysContent sysContent);
    public SysContent selectByPrimaryKey(Long id);
}
