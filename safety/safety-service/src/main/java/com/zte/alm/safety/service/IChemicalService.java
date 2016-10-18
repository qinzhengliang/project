package com.zte.alm.safety.service;

import com.zte.alm.safety.repository.entity.SysChemical;
import com.zte.alm.safety.repository.entity.SysUser;

import java.util.List;
import java.util.Map;

/**
 * Created by 6418000384 on 2016/7/20.
 */
public interface IChemicalService {

    public int add(SysChemical sysChemical);

    public void deleteByPrimaryKey(Long id);

    public List<Map> query(Map map,SysUser user) throws Exception;

    public List<Map> queryAll() throws Exception;

    public int update(SysChemical sysChemical);

    public SysChemical selectByPrimaryKey(Long id);
}
