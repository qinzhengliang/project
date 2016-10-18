package com.zte.alm.safety.service.impl;

import com.zte.alm.safety.common.service.BaseService;
import com.zte.alm.safety.repository.entity.SysInspectionProblem;
import com.zte.alm.safety.repository.entity.SysUser;
import com.zte.alm.safety.repository.mapper.SysInspectionProblemMapper;
import com.zte.alm.safety.service.IInspectionProblemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 00202353 on 2016/7/20.
 */
@Service
public class InspectionProblemService extends BaseService implements IInspectionProblemService {
    @Resource
    private SysInspectionProblemMapper SysInspectionProblemMapper;

    @Override
    public int add(SysInspectionProblem sysInspectionProblem){
        return SysInspectionProblemMapper.insertSelective(sysInspectionProblem);
    }

    @Override
    public void deleteByPrimaryKey(Long id){
        SysInspectionProblemMapper.deleteByPrimaryKey(id);
    }

    /*
    * * @param map 基本信息查询条件
     *            map.get(organization) 街道
     *            map.get(enterprise) 被督查的企业
     *            map.get(discoverTime) 发现时间*/
    @Override
    public List<Map> query(Map map,SysUser user) throws Exception{
        Map queryMap = new HashMap();
        if (!this.isMapKeyNull(map,"organization")) {
            queryMap.put("organization",this.getMapString(map,"organization"));
        }
        if (!this.isMapKeyNull(map,"enterprise")) {
            queryMap.put("enterprise",this.getMapString(map,"enterprise"));
        }
        if (!this.isMapKeyNull(map,"discoverTime")) {
            queryMap.put("discoverTime",this.getMapString(map,"discoverTime"));
        }
        //获取符合条件的数据
        List<Map> queryResult = SysInspectionProblemMapper.query(queryMap);

        return queryResult;
    }
    @Override
    public List<Map> queryAll() throws Exception{
        List<Map> queryResult = SysInspectionProblemMapper.queryAll();
        return queryResult;
    }

    @Override
    public int update(SysInspectionProblem SysInspectionProblem){
        return SysInspectionProblemMapper.updateByPrimaryKey(SysInspectionProblem);
    }

    @Override
    public SysInspectionProblem selectByPrimaryKey(Long id){

        return SysInspectionProblemMapper.selectByPrimaryKey(id);
    }
}
