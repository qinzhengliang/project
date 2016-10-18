package com.zte.alm.safety.service.impl;

import com.zte.alm.safety.common.service.BaseService;
import com.zte.alm.safety.repository.entity.SysContent;
import com.zte.alm.safety.repository.entity.SysUser;
import com.zte.alm.safety.repository.mapper.SysContentMapper;
import com.zte.alm.safety.service.IContentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 00202353 on 2016/7/21.
 */
@Service
public class ContentService extends BaseService implements IContentService {
    @Resource
    private SysContentMapper sysContentMapper;

    @Override
    public int add(SysContent sysContent){
        return sysContentMapper.insertSelective(sysContent);
    }

    @Override
    public void deleteByPrimaryKey(Long id){
        sysContentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Map> query(Map map,SysUser user) throws Exception{
        Map queryMap = new HashMap();
        if (this.isMapKeyNull(map,"title")) {
        } else {
            queryMap.put("title",this.getMapString(map,"title"));
        }
        if(!this.isMapKeyNull(map,"type"))
        {
            queryMap.put("type",this.getMapString(map,"type"));
        }
        //获取符合条件的数据
        List<Map> queryResult = sysContentMapper.query(queryMap);

        return queryResult;
    }
    @Override
    public List<Map> queryAll() throws Exception{
        List<Map> queryResult = sysContentMapper.queryAll();
        return queryResult;
    }

    @Override
    public int update(SysContent sysContent){
        return sysContentMapper.updateByPrimaryKey(sysContent);
    }

    @Override
    public SysContent selectByPrimaryKey(Long id){

        return sysContentMapper.selectByPrimaryKey(id);
    }
}
