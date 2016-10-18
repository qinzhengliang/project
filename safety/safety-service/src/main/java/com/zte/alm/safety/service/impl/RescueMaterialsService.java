package com.zte.alm.safety.service.impl;

import com.zte.alm.safety.common.service.BaseService;
import com.zte.alm.safety.repository.entity.SysRescueMaterials;
import com.zte.alm.safety.repository.entity.SysUser;
import com.zte.alm.safety.repository.mapper.SysRescueMaterialsMapper;
import com.zte.alm.safety.service.IRescueMaterialsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 00202353 on 2016/7/20.
 */
@Service
public class RescueMaterialsService extends BaseService implements IRescueMaterialsService {
    @Resource
    private SysRescueMaterialsMapper sysRescueMaterialsMapper;

    @Override
    public int add(SysRescueMaterials sysRescueMaterials){
        return sysRescueMaterialsMapper.insertSelective(sysRescueMaterials);
    }

    @Override
    public void deleteByPrimaryKey(Long id){
        sysRescueMaterialsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Map> query(Map map,SysUser user) throws Exception{
        Map queryMap = new HashMap();
        if (this.isMapKeyNull(map,"organization")) {
        } else {
            queryMap.put("organization",this.getMapString(map,"organization"));
        }
        if(!this.isMapKeyNull(map,"name"))
        {
            queryMap.put("name",this.getMapString(map,"name"));
        }
        if(!this.isMapKeyNull(map,"type"))
        {
            queryMap.put("type",this.getMapString(map,"type"));
        }
        //获取符合条件的数据
        List<Map> queryResult = sysRescueMaterialsMapper.query(queryMap);

        return queryResult;
    }
    @Override
    public List<Map> queryAll() throws Exception{
        List<Map> queryResult = sysRescueMaterialsMapper.queryAll();
        return queryResult;
    }

    @Override
    public int update(SysRescueMaterials sysRescueMaterials){
        return sysRescueMaterialsMapper.updateByPrimaryKey(sysRescueMaterials);
    }

    @Override
    public SysRescueMaterials selectByPrimaryKey(Long id){

        return sysRescueMaterialsMapper.selectByPrimaryKey(id);
    }
}
