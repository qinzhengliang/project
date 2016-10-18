package com.zte.alm.safety.service.impl;

import com.zte.alm.safety.common.service.BaseService;
import com.zte.alm.safety.repository.entity.SysUser;
import com.zte.alm.safety.repository.mapper.SysUserMapper;
import com.zte.alm.safety.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 6418000384 on 2016/7/19.
 */
@Service
public class UserService extends BaseService implements IUserService {
    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public int add(SysUser sysUser){

        return sysUserMapper.insertSelective(sysUser);
    }

    @Override
    public void deleteByPrimaryKey(Long id){
        sysUserMapper.deleteByPrimaryKey(id);
    }

    /**查询用户
    * map.get(id)
    * map.get(name)
    * map.get(status)
    * map.get(type)
    * map.get(organization)
    * map.get(enterprise)
    */
    @Override
    public List<Map> query(Map map) throws Exception{
        Map queryMap = new HashMap();
        if(!this.isMapKeyNull(map,"id"))
        {
            queryMap.put("id",this.getMapString(map,"id"));
        }
        if(!this.isMapKeyNull(map,"name"))
        {
            queryMap.put("name",this.getMapString(map,"name"));
        }
        if(!this.isMapKeyNull(map,"status"))
        {
            queryMap.put("status",this.getMapString(map,"status"));
        }
        if(!this.isMapKeyNull(map,"type"))
        {
            queryMap.put("type",this.getMapString(map,"type"));
        }
        if(!this.isMapKeyNull(map,"organization"))
        {
            queryMap.put("organization",this.getMapString(map,"organization"));
        }
        if(!this.isMapKeyNull(map,"enterprise"))
        {
            queryMap.put("enterprise",this.getMapString(map,"enterprise"));
        }
        //获取符合条件的数据
        List<Map> queryResult = sysUserMapper.query(queryMap);
        return queryResult;
    }

    /*
    *查询所有用户
     */
    @Override
    public List<Map> queryAll() throws Exception{
        //获取符合条件的数据
        List<Map> queryResult = sysUserMapper.queryAll();
        return queryResult;
    }

    @Override
    public int update(SysUser sysUser){

        return sysUserMapper.updateByPrimaryKey(sysUser);
    }

    @Override
    public SysUser selectByPrimaryKey(Long id){

        return sysUserMapper.selectByPrimaryKey(id);
    }

}
