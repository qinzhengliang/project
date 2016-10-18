package com.zte.alm.safety.service.impl;

import com.zte.alm.safety.common.service.BaseService;
import com.zte.alm.safety.repository.entity.SysEnterprisePatrol;
import com.zte.alm.safety.repository.entity.SysUser;
import com.zte.alm.safety.repository.mapper.SysEnterprisePatrolMapper;
import com.zte.alm.safety.service.IEnterprisePatrolService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 6418000384 on 2016/7/15.
 */
@Service
public class EnterprisePatrolService extends BaseService implements IEnterprisePatrolService {
    @Resource
    private SysEnterprisePatrolMapper sysEnterprisePatrolMapper;

    @Override
    public int add(SysEnterprisePatrol sysEnterprisePatrol){

        return sysEnterprisePatrolMapper.insertSelective(sysEnterprisePatrol);
    }
    @Override
    public void deleteByPrimaryKey(Long id){
        sysEnterprisePatrolMapper.deleteByPrimaryKey(id);
    }
    @Override
    public List<Map> query(Map map,SysUser user) throws Exception{
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        Map queryMap = new HashMap();
        if(!this.isMapKeyNull(map,"organization"))
        {
            queryMap.put("organization",this.getMapString(map,"organization"));
        }
        if(!this.isMapKeyNull(map,"category"))
        {
            queryMap.put("category",this.getMapString(map,"category"));
        }
        if(!this.isMapKeyNull(map,"problemHandling"))
        {
            queryMap.put("problemHandling",this.getMapString(map,"problemHandling"));
        }
        //获取符合条件的数据
        List<Map> queryResult = sysEnterprisePatrolMapper.query(queryMap);
//        if (queryResult.size() > 0) {
//            //根据当前用户过滤符合条件的数据，用户有查看权限的数据
//            queryResult = queryViewRightInfo(queryResult, user);
//        }
        return queryResult;
    }

    @Override
    public List<Map> queryAll() throws Exception{
        List<Map> queryResult = sysEnterprisePatrolMapper.queryAll();
        return queryResult;
    }

    @Override
    public int update(SysEnterprisePatrol sysEnterprisePatrol){

        return sysEnterprisePatrolMapper.updateByPrimaryKey(sysEnterprisePatrol);
    }

    @Override
    public SysEnterprisePatrol selectByPrimaryKey(Long id){

        return sysEnterprisePatrolMapper.selectByPrimaryKey(id);
    }
}
