package com.zte.alm.safety.rest.restcontroller;

import com.zte.alm.safety.infrastructure.base.Response;
import com.zte.alm.safety.infrastructure.utility.BeanHelper;
import com.zte.alm.safety.repository.entity.SysEmergencyRescue;
import com.zte.alm.safety.repository.entity.SysUser;
import com.zte.alm.safety.service.IEmergencyRescueService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by 6418000384 on 2016/7/20.
 * 应急救援 应急救援数据接口
 */
@RestController
@RequestMapping(value = "api/emergencyRescue")
public class EmergencyRescueRestController {
    @Resource
    private IEmergencyRescueService iEmergencyRescueService;

    /**
     * 新增应急救援信息
     */
    @RequestMapping(value = "add")
    public Response addEmergencyRescue(@RequestBody Map map)throws Exception{
        int result = 0;
        SysEmergencyRescue sysEmergencyRescue = (SysEmergencyRescue)
                BeanHelper.mapToObject(map, SysEmergencyRescue.class);
        result = iEmergencyRescueService.add(sysEmergencyRescue);
        return new Response(result);
    }

    /*
    *查询紧急救援列表
    * 根据当前登录人的组织信息过滤查询的危化品数据
    * @param map 基本信息查询条件
    * map.get(id)中文
    *
    * @return
    */
    @RequestMapping(value = "query")
    public Response queryEmergencyRescue(@RequestBody Map map) throws Exception{
        SysUser user = null;
        List<Map> queryResult = iEmergencyRescueService.query(map,user);
        return new Response(queryResult);
    }

    /*
     *查看紧急救援详细信息
     */
    @RequestMapping(value = "{id}")
    public Response queryEmergencyRescueDetail(@PathVariable(value = "id") Long id)throws Exception{
        SysEmergencyRescue sysEmergencyRescue = null;
        sysEmergencyRescue = iEmergencyRescueService.selectByPrimaryKey(id);
        return new Response(sysEmergencyRescue);
    }

    /*
     *查看所有紧急救援信息
     */
    @RequestMapping(value = "queryAll")
    public Response queryEmergencyRescueAll()throws Exception{
        SysUser user = null;
        List<Map> queryResult = iEmergencyRescueService.queryAll();
        return new Response(queryResult);
    }

    /*
     *删除紧急救援信息
     */
    @RequestMapping(value = "delete/{id}")
    public Response deleteEmergencyRescue(@PathVariable(value = "id") long id){
        iEmergencyRescueService.deleteByPrimaryKey(id);
        return new Response();
    }

    /**更新紧急救援信息
     *
     * @param map
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "update/{id}")
    public Response updateEmergencyRescue(@RequestBody Map map,
                                     @PathVariable(value = "id") long id)throws Exception {
        SysEmergencyRescue sysEmergencyRescue = null;
        SysUser user = null;
        sysEmergencyRescue = (SysEmergencyRescue)
                BeanHelper.mapToObject(map, SysEmergencyRescue.class);
        //先获取
        SysEmergencyRescue updateSysEmergencyRescue = iEmergencyRescueService.selectByPrimaryKey(id);
        //再获取更新数据


        //更新
        int result = iEmergencyRescueService.update(updateSysEmergencyRescue);
        return new Response(result);
    }

    /*
     * 更新应急救援资源关系数据，需要前台传应急救援最新的所有资源关系数据
     * 后台可以全删全增也可以增量更新
     */
    public Response updateRescueResource(@RequestBody Map map,
                                          @PathVariable(value = "id") long id)throws Exception {
        return new Response("");
    }

    /*
     * 提供单独的新增应急救援资源接口，如果关系已经存在则不增加
     */
    public Response addRescueResource(@RequestBody Map map,
                                         @PathVariable(value = "id") long id)throws Exception {
        return new Response("");
    }

    /*
     * 提供单据的删除应急救援资源接口
     */
    public Response deleteRescueResource(@RequestBody Map map,
                                      @PathVariable(value = "id") long id)throws Exception {
        return new Response("");
    }
}
