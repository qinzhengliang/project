package com.zte.alm.safety.repository.mapper;

import com.zte.alm.safety.repository.entity.SysContent;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface SysContentMapper extends Mapper<SysContent> {
    public List<Map> query(Map map);
    public List<Map> queryAll();
}