package com.zte.alm.safety.service.impl;

import com.zte.alm.safety.common.service.BaseService;
import com.zte.alm.safety.repository.entity.SysGroup;
import com.zte.alm.safety.repository.entity.SysUser;
import com.zte.alm.safety.repository.mapper.SysGroupMapper;
import com.zte.alm.safety.service.IGroupService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 00202353 on 2016/7/21.
 */
@Service
public class GroupService extends BaseService implements IGroupService {
    @Resource
    private SysGroupMapper sysGroupMapper;

    @Override
    public int add(SysGroup sysGroup){
        return sysGroupMapper.insertSelective(sysGroup);
    }

    @Override
    public void deleteByPrimaryKey(Long id){
        sysGroupMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Map> query(Map map,SysUser user) throws Exception{
        Map queryMap = new HashMap();
        if (this.isMapKeyNull(map,"name")) {
        } else {
            queryMap.put("name",this.getMapString(map,"name"));
        }
        if(!this.isMapKeyNull(map,"createdBy"))
        {
            queryMap.put("createdBy",this.getMapString(map,"createdBy"));
        }
        //获取符合条件的数据
        List<Map> queryResult = sysGroupMapper.query(queryMap);

        return queryResult;
    }
    @Override
    public List<Map> queryAll() throws Exception{
        List<Map> queryResult = sysGroupMapper.queryAll();
        return queryResult;
    }

    @Override
    public int update(SysGroup sysGroup){
        return sysGroupMapper.updateByPrimaryKey(sysGroup);
    }

    @Override
    public SysGroup selectByPrimaryKey(Long id){

        return sysGroupMapper.selectByPrimaryKey(id);
    }
}
