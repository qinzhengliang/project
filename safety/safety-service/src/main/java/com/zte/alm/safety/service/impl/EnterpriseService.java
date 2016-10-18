package com.zte.alm.safety.service.impl;

import com.zte.alm.safety.common.service.BaseService;
import com.zte.alm.safety.repository.entity.SysEnterprise;
import com.zte.alm.safety.repository.entity.SysUser;
import com.zte.alm.safety.repository.mapper.SysEnterpriseMapper;
import com.zte.alm.safety.service.IEnterpriseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 6418000384 on 2016/7/15.
 */
@Service
public class EnterpriseService extends BaseService implements IEnterpriseService {

    @Resource
    private SysEnterpriseMapper sysEnterpriseMapper;

    @Override
    public int add(SysEnterprise sysEnterprise){
        return sysEnterpriseMapper.insertSelective(sysEnterprise);
    }

    @Override
    public void deleteByPrimaryKey(Long id){
        sysEnterpriseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Map> query(Map map,SysUser user) throws Exception{
        Map queryMap = new HashMap();
        if (this.isMapKeyNull(map,"organization")) {
        } else {
            queryMap.put("organization",this.getMapString(map,"organization"));
        }
        if(!this.isMapKeyNull(map,"category"))
        {
            queryMap.put("category",this.getMapString(map,"category"));
        }
        //获取符合条件的数据
        List<Map> queryResult = sysEnterpriseMapper.query(queryMap);

        return queryResult;
    }
    @Override
    public List<Map> queryAll() throws Exception{
        List<Map> queryResult = sysEnterpriseMapper.queryAll();
        return queryResult;
    }

    @Override
    public int update(SysEnterprise sysEnterprise){
        return sysEnterpriseMapper.updateByPrimaryKey(sysEnterprise);
    }

    @Override
    public SysEnterprise selectByPrimaryKey(Long id){

        return sysEnterpriseMapper.selectByPrimaryKey(id);
    }
}
