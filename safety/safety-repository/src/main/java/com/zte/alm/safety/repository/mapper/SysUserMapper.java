package com.zte.alm.safety.repository.mapper;

import com.zte.alm.safety.repository.entity.SysUser;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface SysUserMapper extends Mapper<SysUser> {
    public SysUser selectUserByNameAndPassword(@Param("name")String name, @Param("password")String password);

    public List<Map> query(Map queryMap);
    public List<Map> queryAll();
}