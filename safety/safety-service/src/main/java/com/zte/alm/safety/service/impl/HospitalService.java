package com.zte.alm.safety.service.impl;

import com.zte.alm.safety.common.service.BaseService;
import com.zte.alm.safety.repository.entity.SysEnterprise;
import com.zte.alm.safety.repository.entity.SysHospital;
import com.zte.alm.safety.repository.entity.SysUser;
import com.zte.alm.safety.repository.mapper.SysHospitalMapper;
import com.zte.alm.safety.service.IEnterpriseService;
import com.zte.alm.safety.service.IHospitalService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 00202353 on 2016/7/20.
 */
@Service
public class HospitalService extends BaseService implements IHospitalService {
    @Resource
    private SysHospitalMapper sysHospitalMapper;

    @Override
    public int add(SysHospital sysHospital){
        return sysHospitalMapper.insertSelective(sysHospital);
    }

    @Override
    public void deleteByPrimaryKey(Long id){
        sysHospitalMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Map> query(Map map,SysUser user) throws Exception{
        Map queryMap = new HashMap();
        if (this.isMapKeyNull(map,"organization")) {
        } else {
            queryMap.put("organization",this.getMapString(map,"organization"));
        }
        //获取符合条件的数据
        List<Map> queryResult = sysHospitalMapper.query(queryMap);

        return queryResult;
    }
    @Override
    public List<Map> queryAll() throws Exception{
        List<Map> queryResult = sysHospitalMapper.queryAll();
        return queryResult;
    }

    @Override
    public int update(SysHospital sysHospital){
        return sysHospitalMapper.updateByPrimaryKey(sysHospital);
    }

    @Override
    public SysHospital selectByPrimaryKey(Long id){

        return sysHospitalMapper.selectByPrimaryKey(id);
    }
}
