package com.zte.alm.safety.service.impl;

import com.zte.alm.safety.common.service.BaseService;
import com.zte.alm.safety.repository.entity.SysFireBrigade;
import com.zte.alm.safety.repository.entity.SysUser;
import com.zte.alm.safety.repository.mapper.SysFireBrigadeMapper;
import com.zte.alm.safety.service.IFireBrigadeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 6418000384 on 2016/7/20.
 */
@Service
public class FireBrigadeService extends BaseService implements IFireBrigadeService {
    @Resource
    private SysFireBrigadeMapper sysFireBrigadeMapper;

    @Override
    public int add(SysFireBrigade sysFireBrigade){

        return sysFireBrigadeMapper.insertSelective(sysFireBrigade);
    }

    @Override
    public void deleteByPrimaryKey(Long id){
        sysFireBrigadeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Map> query(Map map,SysUser user) throws Exception{
        Map queryMap = new HashMap();
        if(!this.isMapKeyNull(map,"name"))
        {
            queryMap.put("name",this.getMapString(map,"name"));
        }
        if(!this.isMapKeyNull(map,"organization"))
        {
            queryMap.put("organization",this.getMapString(map,"organization"));
        }
        if(!this.isMapKeyNull(map,"address"))
        {
            queryMap.put("address",this.getMapString(map,"address"));
        }
        //获取符合条件的数据
        List<Map> queryResult = sysFireBrigadeMapper.query(queryMap);
        return queryResult;
    }

    @Override
    public List<Map> queryAll() throws Exception{

        //获取符合条件的数据
        List<Map> queryResult = sysFireBrigadeMapper.queryAll();
        return queryResult;
    }
    @Override
    public int update(SysFireBrigade sysFireBrigade){
        return sysFireBrigadeMapper.updateByPrimaryKey(sysFireBrigade);
    }

    @Override
    public SysFireBrigade selectByPrimaryKey(Long id){
        return sysFireBrigadeMapper.selectByPrimaryKey(id);
    }
}
