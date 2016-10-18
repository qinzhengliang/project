package com.zte.alm.safety.service.impl;

import com.zte.alm.safety.common.service.BaseService;
import com.zte.alm.safety.repository.entity.SysPatrolPoint;
import com.zte.alm.safety.repository.entity.SysUser;
import com.zte.alm.safety.repository.mapper.SysPatrolPointMapper;
import com.zte.alm.safety.service.IPatrolPointService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 6418000384 on 2016/7/21.
 */
@Service
public class PatrolPointService extends BaseService implements IPatrolPointService {
    @Resource
    private SysPatrolPointMapper sysPatrolPointMapper;

    @Override
    public int add(SysPatrolPoint sysPatrolPoint){

        return sysPatrolPointMapper.insertSelective(sysPatrolPoint);
    }

    @Override
    public void deleteByPrimaryKey(Long id){
        sysPatrolPointMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Map> query(Map map,SysUser user) throws Exception{
        Map queryMap = new HashMap();
        if(!this.isMapKeyNull(map,"name"))
        {
            queryMap.put("name",this.getMapString(map,"name"));
        }
        if(!this.isMapKeyNull(map,"code"))
        {
            queryMap.put("code",this.getMapString(map,"code"));
        }
        //获取符合条件的数据
        List<Map> queryResult = sysPatrolPointMapper.query(queryMap);
//        if (queryResult.size() > 0) {
//            //根据当前用户过滤符合条件的数据，用户有查看权限的数据
//            queryResult = queryViewRightInfo(queryResult, user);
//        }
        return queryResult;
    }

    @Override
    public List<Map> queryAll() throws Exception{

        //获取符合条件的数据
        List<Map> queryResult = sysPatrolPointMapper.queryAll();
//        if (queryResult.size() > 0) {
//            //根据当前用户过滤符合条件的数据，用户有查看权限的数据
//            queryResult = queryViewRightInfo(queryResult, user);
//        }
        return queryResult;
    }
    @Override
    public int update(SysPatrolPoint sysPatrolPoint){
        return sysPatrolPointMapper.updateByPrimaryKey(sysPatrolPoint);
    }

    @Override
    public SysPatrolPoint selectByPrimaryKey(Long id){
        return sysPatrolPointMapper.selectByPrimaryKey(id);
    }
}
