package com.zte.alm.safety.rest.restcontroller;

import com.zte.alm.safety.infrastructure.base.Response;
import com.zte.alm.safety.infrastructure.utility.BeanHelper;
import com.zte.alm.safety.repository.entity.SysFireBrigade;
import com.zte.alm.safety.repository.entity.SysUser;
import com.zte.alm.safety.service.IFireBrigadeService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by 6418000384 on 2016/7/20.
 * 应急救援 消防中队数据接口 没有数据权限限制
 */
@RestController
@RequestMapping(value = "api/fireBrigade")
public class FireBrigadeRestController {
    @Resource
    private IFireBrigadeService iFireBrigadeService;

    /**
     * 新增消防信息
     */
    @RequestMapping(value = "add")
    public Response addFireBrigade(@RequestBody Map map)throws Exception{
        int result = 0;
        SysFireBrigade sysFireBrigade = (SysFireBrigade)
                BeanHelper.mapToObject(map, SysFireBrigade.class);
        result = iFireBrigadeService.add(sysFireBrigade);
        return new Response(result);
    }

    /*
    * 根据相关条件查询消防列表
    * @param map 基本信息查询条件
    * map.get(name)名称
    * map.get(organization)组织
    * map.get(address)地址
    *
    * @return
    */
    @RequestMapping(value = "query")
    public Response queryFireBrigade(@RequestBody Map map) throws Exception{
        SysUser user = null;
        List<Map> queryResult = iFireBrigadeService.query(map,user);
        return new Response(queryResult);
    }

    /*
     * 根据组织Id获取，相应组织下的消防中队列表
     */
    @RequestMapping(value = "queryByOrganization/{organizationId}")
    public Response queryFireBrigadeByOrganization(@RequestBody Map map) throws Exception{
        SysUser user = null;
        List<Map> queryResult = iFireBrigadeService.query(map,user);
        return new Response(queryResult);
    }

    /*
     *查看消防详细信息
     */
    @RequestMapping(value = "{id}")
    public Response queryFireBrigadeDetail(@PathVariable(value = "id") Long id)throws Exception{
        SysFireBrigade sysFireBrigade = null;
        sysFireBrigade = iFireBrigadeService.selectByPrimaryKey(id);
        return new Response(sysFireBrigade);
    }

    /*
     *查看所有消防信息
     */
    @RequestMapping(value = "queryAll")
    public Response queryFireBrigadeAll()throws Exception{
        SysUser user = null;
        List<Map> queryResult = iFireBrigadeService.queryAll();
        return new Response(queryResult);
    }

    /**删除消防信息
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "delete/{id}")
    public Response deleteFireBrigade(@PathVariable(value = "id") long id){
        iFireBrigadeService.deleteByPrimaryKey(id);
        return new Response();
    }

    /**更新消防
     *
     * @param map
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "update/{id}")
    public Response updateFireBrigade(@RequestBody Map map,
                                          @PathVariable(value = "id") long id)throws Exception {
        SysFireBrigade sysFireBrigade = null;
        SysUser user = null;
        sysFireBrigade = (SysFireBrigade)
                BeanHelper.mapToObject(map, SysFireBrigade.class);
        //先获取
        SysFireBrigade updateSysFireBrigade = iFireBrigadeService.selectByPrimaryKey(id);
        //再获取更新数据


        //更新
        int result = iFireBrigadeService.update(updateSysFireBrigade);
        return new Response(result);
    }
}
