package com.zte.alm.safety.service.impl;

import com.zte.alm.safety.common.service.BaseService;
import com.zte.alm.safety.repository.entity.SysList;
import com.zte.alm.safety.repository.mapper.SysListMapper;
import com.zte.alm.safety.service.IListService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 10115916 on 2016/7/13 0013.
 */
@Service
public class ListService extends BaseService implements IListService {
    @Resource
    private SysListMapper sysListMapper;

    @Override
    public int add(SysList sysList){
        return sysListMapper.insertSelective(sysList);
    }

    @Override
    public void deleteByPrimaryKey(Long id){
        sysListMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Map> query(Map map) throws Exception{
        Map queryMap = new HashMap();
        if(!this.isMapKeyNull(map,"id"))
        {
            queryMap.put("id",this.getMapString(map,"id"));
        }
        //获取符合条件的数据
        List<Map> queryResult = sysListMapper.query(queryMap);
//        if (queryResult.size() > 0) {
//            //根据当前用户过滤符合条件的数据，用户有查看权限的数据
//            queryResult = queryViewRightInfo(queryResult, user);
//        }
        return queryResult;
    }

    @Override
    public List<Map> queryAll() throws Exception{
        //获取符合条件的数据
        List<Map> queryResult = sysListMapper.queryAll();
        return queryResult;
    }

    @Override
    public int update(SysList sysList){
        return sysListMapper.updateByPrimaryKey(sysList);
    }

    @Override
    public SysList selectByPrimaryKey(Long id){
        return sysListMapper.selectByPrimaryKey(id);
    }

    @Override
    public SysList GetListByName(String listName) {

        return null;
    }
}
