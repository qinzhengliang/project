package com.zte.alm.safety.service.impl;

import com.zte.alm.safety.common.service.BaseService;
import com.zte.alm.safety.repository.entity.SysFile;
import com.zte.alm.safety.repository.mapper.SysFileMapper;
import com.zte.alm.safety.service.IFileService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 6418000384 on 2016/7/19.
 */
@Service
public class FileService extends BaseService implements IFileService {

    @Resource
    private SysFileMapper sysFileMapper;

    @Override
    public int add(SysFile sysFile){
        return sysFileMapper.insertSelective(sysFile);
    }

    @Override
    public void deleteByPrimaryKey(Long id){
        sysFileMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Map> query(Map map) throws Exception{
        Map queryMap = new HashMap();
        if(!this.isMapKeyNull(map,"id"))
        {
            queryMap.put("id",this.getMapString(map,"id"));
        }
        //获取符合条件的数据
        List<Map> queryResult = sysFileMapper.query(queryMap);
//        if (queryResult.size() > 0) {
//            //根据当前用户过滤符合条件的数据，用户有查看权限的数据
//            queryResult = queryViewRightInfo(queryResult, user);
//        }
        return queryResult;
    }

    @Override
    public int update(SysFile sysFile){
        return sysFileMapper.updateByPrimaryKey(sysFile);
    }

    @Override
    public SysFile selectByPrimaryKey(Long id){
        return sysFileMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Map> queryAll() throws Exception{
        //获取符合条件的数据
        List<Map> queryResult = sysFileMapper.queryAll();
        return queryResult;
    }

    @Override
    public SysFile download(Long id){
        return null;
    }


}
