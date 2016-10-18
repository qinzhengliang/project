package com.zte.alm.safety.service;

import com.zte.alm.safety.repository.entity.SysFile;

import java.util.List;
import java.util.Map;

/**
 * Created by 6418000384 on 2016/7/19.
 */
public interface IFileService {

    public int add(SysFile sysFile);

    public void deleteByPrimaryKey(Long id);

    public List<Map> query(Map map) throws Exception;

    public int update(SysFile sysFile);

    public SysFile selectByPrimaryKey(Long id);

    public List<Map> queryAll() throws Exception;

    public SysFile download(Long id);

}
