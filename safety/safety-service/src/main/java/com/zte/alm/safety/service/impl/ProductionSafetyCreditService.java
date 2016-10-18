package com.zte.alm.safety.service.impl;

import com.zte.alm.safety.common.service.BaseService;
import com.zte.alm.safety.repository.entity.SysProductionSafetyCredit;
import com.zte.alm.safety.repository.entity.SysUser;
import com.zte.alm.safety.repository.mapper.SysProductionSafetyCreditMapper;
import com.zte.alm.safety.service.IProductionSafetyCreditService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 00202353 on 2016/7/21.
 */
@Service
public class ProductionSafetyCreditService extends BaseService implements IProductionSafetyCreditService {
    @Resource
    private SysProductionSafetyCreditMapper sysProductionSafetyCreditMapper;

    @Override
    public int add(SysProductionSafetyCredit sysProductionSafetyCredit){
        return sysProductionSafetyCreditMapper.insertSelective(sysProductionSafetyCredit);
    }

    @Override
    public void deleteByPrimaryKey(Long id){
        sysProductionSafetyCreditMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Map> query(Map map,SysUser user) throws Exception{
        Map queryMap = new HashMap();
        if (this.isMapKeyNull(map,"type")) {
        } else {
            queryMap.put("type",this.getMapString(map,"type"));
        }
        if(!this.isMapKeyNull(map,"createdBy"))
        {
            queryMap.put("createdBy",this.getMapString(map,"createdBy"));
        }
        //获取符合条件的数据
        List<Map> queryResult = sysProductionSafetyCreditMapper.query(queryMap);

        return queryResult;
    }
    @Override
    public List<Map> queryAll() throws Exception{
        List<Map> queryResult = sysProductionSafetyCreditMapper.queryAll();
        return queryResult;
    }

    @Override
    public int update(SysProductionSafetyCredit sysProductionSafetyCredit){
        return sysProductionSafetyCreditMapper.updateByPrimaryKey(sysProductionSafetyCredit);
    }

    @Override
    public SysProductionSafetyCredit selectByPrimaryKey(Long id){

        return sysProductionSafetyCreditMapper.selectByPrimaryKey(id);
    }
}
