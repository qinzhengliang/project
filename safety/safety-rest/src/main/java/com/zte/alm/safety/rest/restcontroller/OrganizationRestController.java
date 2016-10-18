package com.zte.alm.safety.rest.restcontroller;

import com.zte.alm.safety.infrastructure.base.Response;
import com.zte.alm.safety.infrastructure.utility.BeanHelper;
import com.zte.alm.safety.repository.entity.SysOrganization;
import com.zte.alm.safety.repository.entity.SysUser;
import com.zte.alm.safety.rest.controller.BaseController;
import com.zte.alm.safety.service.IOrganizationService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by 6418000384 on 2016/7/19.
 * 组织数据接口 有数据权限
 */
@RestController
@RequestMapping(value = "api/organization")
public class OrganizationRestController extends BaseController {

    @Resource
    private IOrganizationService iOrganizationServer;
    /**
     * 新增组织，暂时不会用到，数据直接初始化
     * @param map 组织对象
     * map.get(base) SysOrganization对象
     * @return
     */
    @RequestMapping(value = "add")
    public Response addOrganization(@RequestBody Map map) throws Exception{
        int result = 0;
        SysOrganization sysOrganization = null;
        sysOrganization = (SysOrganization)
                BeanHelper.mapToObject(map, SysOrganization.class);
        result = iOrganizationServer.add(sysOrganization);
        return new Response(result);
    }

    /*
     *查询组织
     * map.get(parentId)
     */
    @RequestMapping(value = "query")
    public Response queryOrganization(@RequestBody Map map) throws Exception{
        List<Map> queryResult = iOrganizationServer.query(map);
        return new Response(queryResult);
    }

    /*
    *查看组织详细信息
    */
    @RequestMapping(value = "{id}")
    public Response queryOrganizationDetail(@PathVariable(value = "id") Long id)throws Exception{
        SysOrganization sysOrganization = null;
        sysOrganization = iOrganizationServer.selectByPrimaryKey(id);
        return new Response(sysOrganization);
    }

    /*
     *查看所有组织
     */
    @RequestMapping(value = "queryAll")
    public Response queryOrganizationAll()throws Exception{
        SysUser user = null;
        List<Map> queryResult = iOrganizationServer.queryAll();
        return new Response(queryResult);
    }

    /*
     * 获取当前用户的区域权限数据
     */
    @RequestMapping(value = "queryRegion")
    public Response queryRegion()throws Exception{
        SysUser user = null;
        List<Map> queryResult = iOrganizationServer.queryAll();
        return new Response(queryResult);
    }

    /*
     *删除组织信息
     */
    @RequestMapping(value = "delete/{id}")
    public Response deleteOrganization(@PathVariable(value = "id") long id){
        iOrganizationServer.deleteByPrimaryKey(id);
        return new Response();
    }

    /*
     *更新组织信息
     */
    @RequestMapping(value = "update/{id}")
    public Response updateOrganization(@RequestBody Map map,
                                 @PathVariable(value = "id") long id)throws Exception{
        SysOrganization sysOrganization = null;
        sysOrganization = (SysOrganization)
                BeanHelper.mapToObject(map, SysOrganization.class);
        //先获取
        SysOrganization updateSysOrganization = iOrganizationServer.selectByPrimaryKey(id);
        //再获取更新数据
//        updateSysOrganization.setType(sysOrganization.getType());
//        updateSysOrganization.setParentId(sysOrganization.getParentId());
//        updateSysOrganization.setFullId(sysOrganization.getFullId());
//        updateSysOrganization.setFullName(sysOrganization.getFullName());
        updateSysOrganization.setLastUpdateTime(new Date());
        //更新
        int result = iOrganizationServer.update(updateSysOrganization);
        return new Response(result);
    }
}
