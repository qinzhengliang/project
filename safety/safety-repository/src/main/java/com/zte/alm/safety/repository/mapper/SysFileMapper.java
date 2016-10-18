package com.zte.alm.safety.repository.mapper;

import com.zte.alm.safety.repository.entity.SysFile;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface SysFileMapper extends Mapper<SysFile> {
    public List<Map> query(Map queryMap);

    public List<Map> queryAll();
}