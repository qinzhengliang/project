package com.zte.alm.safety.service.impl;

import com.zte.alm.safety.common.service.BaseService;
import com.zte.alm.safety.repository.entity.SysChemical;
import com.zte.alm.safety.repository.entity.SysUser;
import com.zte.alm.safety.repository.mapper.SysChemicalMapper;
import com.zte.alm.safety.service.IChemicalService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 6418000384 on 2016/7/20.
 */
@Service
public class ChemicalService extends BaseService implements IChemicalService {

    @Resource
    private SysChemicalMapper sysChemicalMapper;

    @Override
    public int add(SysChemical sysChemical){

        return sysChemicalMapper.insertSelective(sysChemical);
    }

    @Override
    public void deleteByPrimaryKey(Long id){
        sysChemicalMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Map> query(Map map,SysUser user) throws Exception{

        Map queryMap = new HashMap();

        if(!this.isMapKeyNull(map,"cnName"))
        {
            queryMap.put("cnName",this.getMapString(map,"cnName"));
        }
        if(!this.isMapKeyNull(map,"enName"))
        {
            queryMap.put("enName",this.getMapString(map,"enName"));
        }
        //获取符合条件的数据
        List<Map> queryResult = sysChemicalMapper.query(queryMap);

        return queryResult;
    }

    @Override
    public List<Map> queryAll() throws Exception{

        //获取符合条件的数据
        List<Map> queryResult = sysChemicalMapper.queryAll();

        return queryResult;
    }
    @Override
    public int update(SysChemical sysChemical){
        return sysChemicalMapper.updateByPrimaryKey(sysChemical);
    }

    @Override
    public SysChemical selectByPrimaryKey(Long id){
        return sysChemicalMapper.selectByPrimaryKey(id);
    }
}
