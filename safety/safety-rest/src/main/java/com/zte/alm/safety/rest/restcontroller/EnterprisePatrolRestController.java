package com.zte.alm.safety.rest.restcontroller;

import com.zte.alm.safety.infrastructure.base.Response;
import com.zte.alm.safety.infrastructure.utility.BeanHelper;
import com.zte.alm.safety.repository.entity.SysEnterprisePatrol;
import com.zte.alm.safety.repository.entity.SysUser;
import com.zte.alm.safety.rest.controller.BaseController;
import com.zte.alm.safety.service.IEnterprisePatrolService;
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
 *
 */
@RestController
@RequestMapping(value = "api/enterprisePatrol")
public class EnterprisePatrolRestController extends BaseController {
    @Resource
    private IEnterprisePatrolService iEnterprisePatrolService;
    /**
     * 新增企业巡查隐患
     * @param map
     * @return
     */
    @RequestMapping(value = "add")
    public Response addPatrol(@RequestBody Map map) throws Exception{
        int result = 0;
        SysEnterprisePatrol sysEnterprisePatrol = (SysEnterprisePatrol)
                BeanHelper.mapToObject(map, SysEnterprisePatrol.class);
        sysEnterprisePatrol.setCreationTime(new Date());
        result = iEnterprisePatrolService.add(sysEnterprisePatrol);
        return new Response(result);
    }

    /*
     *查询巡查列表
     * 根据当前登录人的组织信息过滤查询的巡查数据
     * @param map 基本信息查询条件
     *            map.get(organization) 街道
     *            map.get(category) 行业类型
     *            map.get(problemHandling) 整改情况
     *
     * @return
     */
    @RequestMapping(value = "query")
    public Response queryPatrol(@RequestBody Map map) throws Exception{
//        SysUser user = this.getLoginUser().getSysUser();
        SysUser user = null;
        List<Map> queryResult = iEnterprisePatrolService.query(map,user);
        return new Response(queryResult);
    }
    /*
     *查看巡查详细信息
     */
    @RequestMapping(value = "{id}")
    public Response queryPatrolDetail(@PathVariable(value = "id") Long id)throws Exception{
        SysEnterprisePatrol sysEnterprisePatrol = null;
        sysEnterprisePatrol = iEnterprisePatrolService.selectByPrimaryKey(id);
        return new Response(sysEnterprisePatrol);
    }

    /*
     *查看所有巡查信息
     */
    @RequestMapping(value = "queryAll")
    public Response queryPatrolAll()throws Exception{
        SysUser user = null;
        List<Map> queryResult = iEnterprisePatrolService.queryAll();
        return new Response(queryResult);
    }

    /*
     *删除巡查信息
     */
    @RequestMapping(value = "delete/{id}")
    public Response deletePatrol(@PathVariable(value = "id") long id){
        iEnterprisePatrolService.deleteByPrimaryKey(id);
        return new Response();
    }

    /*
     *更新巡查信息
     */
    @RequestMapping(value = "update/{id}")
    public Response updatePatrol(@RequestBody Map map,
                                 @PathVariable(value = "id") long id)throws Exception{
        SysEnterprisePatrol sysEnterprisePatrol = null;
        SysUser user = null;
        sysEnterprisePatrol = (SysEnterprisePatrol)
                BeanHelper.mapToObject(map, SysEnterprisePatrol.class);
        //先获取
        SysEnterprisePatrol updateSysEnterprisePatrol = iEnterprisePatrolService.selectByPrimaryKey(id);
        //再获取更新数据
        updateSysEnterprisePatrol.setLastUpdateTime(new Date());
        //更新
        int result = iEnterprisePatrolService.update(updateSysEnterprisePatrol);
        return new Response(result);
    }



    /*
     *新增隐患整改情况
     */
    @RequestMapping(value = "addRectification/{id}")
    public Response addRectification(@RequestBody Map map,
                                     @PathVariable(value = "id") long id) throws Exception{
        SysEnterprisePatrol sysEnterprisePatrol = null;
        SysUser user = null;
        sysEnterprisePatrol = (SysEnterprisePatrol)
                BeanHelper.mapToObject(map, SysEnterprisePatrol.class);
        //先获取
        SysEnterprisePatrol updateSysEnterprisePatrol = iEnterprisePatrolService.selectByPrimaryKey(id);
        //再获取更新数据
        updateSysEnterprisePatrol.setStatus(sysEnterprisePatrol.getStatus());
        updateSysEnterprisePatrol.setProblemHandling(sysEnterprisePatrol.getProblemHandling());
        updateSysEnterprisePatrol.setHandlingTime(new Date());
        updateSysEnterprisePatrol.setLastUpdatedBy(user.getId());
        updateSysEnterprisePatrol.setLastUpdateTime(new Date());
        //更新
        int result = iEnterprisePatrolService.update(updateSysEnterprisePatrol);
        return new Response(result);
    }

    /*
     *巡查隐患统计--按时间
     * map.get(startTime)
     * map.get(endTime)
     */
    @RequestMapping(value = "statisticByTime")
    public Response statisticByTimePatrol(@RequestBody Map map) {

        return new Response();
    }

    /*
     *巡查隐患统计--按街道
     */
    @RequestMapping(value = "statisticByOrganization")
    public Response statisticByOrganizationPatrol(@RequestBody Map map) {
        return new Response();
    }

    /*
     *隐患类型排名
     */
    @RequestMapping(value = "dangerTypeRank")
    public Response dangerTypeRank(@RequestBody Map map) {
        return new Response();
    }

    /*
     *隐患企业排名
     */
    @RequestMapping(value = "dangerEnterpriseRank")
    public Response dangerEnterpriseRank(@RequestBody Map map) {
        return new Response();
    }

    /*
     *巡更隐患历史记录
     */
    @RequestMapping(value = "patrolHistory")
    public Response patrolHistory(@RequestBody Map map) {
        return new Response();
    }

}
