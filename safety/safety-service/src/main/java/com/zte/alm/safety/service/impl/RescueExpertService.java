package com.zte.alm.safety.service.impl;

import com.zte.alm.safety.common.service.BaseService;
import com.zte.alm.safety.repository.entity.SysRescueExpert;
import com.zte.alm.safety.repository.entity.SysUser;
import com.zte.alm.safety.repository.mapper.SysRescueExpertMapper;
import com.zte.alm.safety.service.IRescueExpertService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 00202353 on 2016/7/20.
 */
@Service
public class RescueExpertService extends BaseService implements IRescueExpertService {
    @Resource
    private SysRescueExpertMapper sysRescueExpertMapper;

    @Override
    public int add(SysRescueExpert sysRescueExpert){
        return sysRescueExpertMapper.insertSelective(sysRescueExpert);
    }

    @Override
    public void deleteByPrimaryKey(Long id){
        sysRescueExpertMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Map> query(Map map,SysUser user) throws Exception{
        Map queryMap = new HashMap();
        if (this.isMapKeyNull(map,"name")) {
        } else {
            queryMap.put("name",this.getMapString(map,"name"));
        }
        if(!this.isMapKeyNull(map,"type"))
        {
            queryMap.put("type",this.getMapString(map,"type"));
        }
        //获取符合条件的数据
        List<Map> queryResult = sysRescueExpertMapper.query(queryMap);

        return queryResult;
    }
    @Override
    public List<Map> queryAll() throws Exception{
        List<Map> queryResult = sysRescueExpertMapper.queryAll();
        return queryResult;
    }

    @Override
    public int update(SysRescueExpert sysRescueExpert){
        return sysRescueExpertMapper.updateByPrimaryKey(sysRescueExpert);
    }

    @Override
    public SysRescueExpert selectByPrimaryKey(Long id){

        return sysRescueExpertMapper.selectByPrimaryKey(id);
    }
}
