package com.zte.alm.safety.service.impl;

import com.zte.alm.safety.common.service.BaseService;
import com.zte.alm.safety.repository.entity.SysCreditChangeLog;
import com.zte.alm.safety.repository.entity.SysUser;
import com.zte.alm.safety.repository.mapper.SysCreditChangeLogMapper;
import com.zte.alm.safety.service.ICreditChangeLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 00202353 on 2016/7/21.
 */
@Service
public class CreditChangeLogService extends BaseService implements ICreditChangeLogService {
    @Resource
    private SysCreditChangeLogMapper sysCreditChangeLogMapper;

    @Override
    public int add(SysCreditChangeLog sysCreditChangeLog){
        return sysCreditChangeLogMapper.insertSelective(sysCreditChangeLog);
    }

    @Override
    public void deleteByPrimaryKey(Long id){
        sysCreditChangeLogMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Map> query(Map map,SysUser user) throws Exception{
        Map queryMap = new HashMap();
        if (this.isMapKeyNull(map,"creaditId")) {
        } else {
            queryMap.put("creaditId",this.getMapString(map,"creaditId"));
        }
        if(!this.isMapKeyNull(map,"changedBy"))
        {
            queryMap.put("changedBy",this.getMapString(map,"changedBy"));
        }
        //获取符合条件的数据
        List<Map> queryResult = sysCreditChangeLogMapper.query(queryMap);

        return queryResult;
    }
    @Override
    public List<Map> queryAll() throws Exception{
        List<Map> queryResult = sysCreditChangeLogMapper.queryAll();
        return queryResult;
    }

    @Override
    public int update(SysCreditChangeLog sysCreditChangeLog){
        return sysCreditChangeLogMapper.updateByPrimaryKey(sysCreditChangeLog);
    }

    @Override
    public SysCreditChangeLog selectByPrimaryKey(Long id){

        return sysCreditChangeLogMapper.selectByPrimaryKey(id);
    }
}
