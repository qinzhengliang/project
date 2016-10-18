package com.zte.alm.safety.service.impl;

import com.zte.alm.safety.common.service.BaseService;
import com.zte.alm.safety.repository.entity.SysChemical;
import com.zte.alm.safety.repository.entity.SysEmergencyRescue;
import com.zte.alm.safety.repository.entity.SysUser;
import com.zte.alm.safety.repository.mapper.SysChemicalMapper;
import com.zte.alm.safety.repository.mapper.SysEmergencyRescueMapper;
import com.zte.alm.safety.service.IEmergencyRescueService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 6418000384 on 2016/7/20.
 */
@Service
public class EmergencyRescueService extends BaseService implements IEmergencyRescueService {
    @Resource
    private SysEmergencyRescueMapper sysEmergencyRescueMapper;

    @Override
    public int add(SysEmergencyRescue sysEmergencyRescue){

        return sysEmergencyRescueMapper.insertSelective(sysEmergencyRescue);
    }

    @Override
    public void deleteByPrimaryKey(Long id){
        sysEmergencyRescueMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Map> query(Map map,SysUser user) throws Exception{
        Map queryMap = new HashMap();
        if(!this.isMapKeyNull(map,"id"))
        {
            queryMap.put("id",this.getMapString(map,"id"));
        }
        //获取符合条件的数据
        List<Map> queryResult = sysEmergencyRescueMapper.query(queryMap);

        return queryResult;
    }

    @Override
    public List<Map> queryAll() throws Exception{

        //获取符合条件的数据
        List<Map> queryResult = sysEmergencyRescueMapper.queryAll();
//        if (queryResult.size() > 0) {
//            //根据当前用户过滤符合条件的数据，用户有查看权限的数据
//            queryResult = queryViewRightInfo(queryResult, user);
//        }
        return queryResult;
    }
    @Override
    public int update(SysEmergencyRescue sysEmergencyRescue){
        return sysEmergencyRescueMapper.updateByPrimaryKey(sysEmergencyRescue);
    }

    @Override
    public SysEmergencyRescue selectByPrimaryKey(Long id){
        return sysEmergencyRescueMapper.selectByPrimaryKey(id);
    }
}
