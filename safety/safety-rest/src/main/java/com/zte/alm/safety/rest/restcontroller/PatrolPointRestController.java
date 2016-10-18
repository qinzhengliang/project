package com.zte.alm.safety.rest.restcontroller;

import com.zte.alm.safety.infrastructure.base.Response;
import com.zte.alm.safety.infrastructure.utility.BeanHelper;
import com.zte.alm.safety.repository.entity.SysPatrolPoint;
import com.zte.alm.safety.repository.entity.SysUser;
import com.zte.alm.safety.service.IPatrolPointService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by 6418000384 on 2016/7/21.
 */
@RestController
@RequestMapping(value = "api/patrolPoint")
public class PatrolPointRestController {
    @Resource
    private IPatrolPointService iPatrolPointService;

    /**
     * 新增巡更点信息
     */
    @RequestMapping(value = "add")
    public Response addPatrolPoint(@RequestBody Map map)throws Exception{
        int result = 0;
        SysPatrolPoint sysPatrolPoint = (SysPatrolPoint)
                BeanHelper.mapToObject(map, SysPatrolPoint.class);
        result = iPatrolPointService.add(sysPatrolPoint);
        return new Response(result);
    }
    /*
    *查询巡更点列表
    * 根据当前登录人的组织信息过滤查询的巡更点数据
    * @param map 基本信息查询条件
    *
    * @return
    */
    @RequestMapping(value = "query")
    public Response queryPatrolPoint(@RequestBody Map map) throws Exception{
        SysUser user = null;
        List<Map> queryResult = iPatrolPointService.query(map,user);
        return new Response(queryResult);
    }

    /*
     *查看巡更点详细信息
     */
    @RequestMapping(value = "{id}")
    public Response queryPatrolPointDetail(@PathVariable(value = "id") Long id)throws Exception{
        SysPatrolPoint sysPatrolPoint = null;
        sysPatrolPoint = iPatrolPointService.selectByPrimaryKey(id);
        return new Response(sysPatrolPoint);
    }

    /*
     *查看所有巡更点信息
     */
    @RequestMapping(value = "queryAll")
    public Response queryPatrolPointAll()throws Exception{
        SysUser user = null;
        List<Map> queryResult = iPatrolPointService.queryAll();
        return new Response(queryResult);
    }

    /**删除巡更点信息
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "delete/{id}")
    public Response deletePatrolPoint(@PathVariable(value = "id") long id){
        iPatrolPointService.deleteByPrimaryKey(id);
        return new Response();
    }

    /**更新巡更点
     *
     * @param map
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "update/{id}")
    public Response updatePatrolPoint(@RequestBody Map map,
                                      @PathVariable(value = "id") long id)throws Exception {
        SysPatrolPoint sysPatrolPoint = null;
        SysUser user = null;
        sysPatrolPoint = (SysPatrolPoint)
                BeanHelper.mapToObject(map, SysPatrolPoint.class);
        //先获取
        SysPatrolPoint updateSysPatrolPoint = iPatrolPointService.selectByPrimaryKey(id);
        //再获取更新数据

        updateSysPatrolPoint.setLastUpdateTime(new Date());
        //更新
        int result = iPatrolPointService.update(updateSysPatrolPoint);
        return new Response(result);
    }
}
