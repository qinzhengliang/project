package com.zte.alm.safety.rest.restcontroller;

import com.zte.alm.safety.infrastructure.base.Response;
import com.zte.alm.safety.infrastructure.utility.BeanHelper;
import com.zte.alm.safety.repository.entity.SysInspection;
import com.zte.alm.safety.repository.entity.SysUser;
import com.zte.alm.safety.rest.controller.BaseController;
import com.zte.alm.safety.service.IInspectionService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by 6418000384 on 2016/7/15.
 */
@RestController
@RequestMapping(value = "api/inspection")
public class InspectionRestController extends BaseController {
    @Resource
    private IInspectionService inspectionService;

    /**
     * 新增督查
     */
    @RequestMapping(value = "add")
    public Response addInspection(@RequestBody Map map)throws Exception{
        int result = 0;
        SysInspection sysInspection = (SysInspection)
                BeanHelper.mapToObject(map, SysInspection.class);
        sysInspection.setCreationTime(new Date());
        result = inspectionService.add(sysInspection);
        return new Response(result);
    }
    /*
    *查询督查列表
    * 根据当前登录人的组织信息过滤查询的督查数据
    * @param map 基本信息查询条件
    * map.get(inspectionTime)督查时间
    *            map.get(inspector) 督查人
    *            map.get(department) 督查科室
    *
    * @return
    */
    @RequestMapping(value = "query")
    public Response queryInspection(@RequestBody Map map) throws Exception{
        SysUser user = null;
        List<Map> queryResult = inspectionService.query(map,user);
        return new Response(queryResult);
    }

    /*
     *查看督查详细信息
     */
    @RequestMapping(value = "{id}")
    public Response queryInspectionDetail(@PathVariable(value = "id") Long id)throws Exception{
        SysInspection sysInspection = null;
        sysInspection = inspectionService.selectByPrimaryKey(id);
        return new Response(sysInspection);
    }

    /*
     *查看所有督查信息
     */
    @RequestMapping(value = "queryAll")
    public Response queryInspectionAll()throws Exception{
        SysUser user = null;
        List<Map> queryResult = inspectionService.queryAll();
        return new Response(queryResult);
    }

    /*
    *删除督查
     */
    @RequestMapping(value = "delete/{id}")
    public Response deleteInspection(@PathVariable(value = "id") long id){
        inspectionService.deleteByPrimaryKey(id);
        return new Response();
    }
    /*
    *更新督查
     */
    @RequestMapping(value = "update/{id}")
    public Response updateInspection(@RequestBody Map map,
                                     @PathVariable(value = "id") long id)throws Exception {
        SysInspection sysInspection = null;
        SysUser user = null;
        sysInspection = (SysInspection)
                BeanHelper.mapToObject(map, SysInspection.class);
        //先获取
        SysInspection updateSysInspection = inspectionService.selectByPrimaryKey(id);
        //再获取更新数据
        updateSysInspection.setLastUpdateTime(new Date());
        //更新
        int result = inspectionService.update(updateSysInspection);
        return new Response(result);
    }
}
