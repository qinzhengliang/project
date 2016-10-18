package com.zte.alm.safety.rest.restcontroller;

import com.zte.alm.safety.infrastructure.base.Response;
import com.zte.alm.safety.infrastructure.utility.BeanHelper;
import com.zte.alm.safety.repository.entity.SysOrganization;
import com.zte.alm.safety.repository.entity.SysOrganizationRole;
import com.zte.alm.safety.repository.entity.SysUser;
import com.zte.alm.safety.rest.controller.BaseController;
import com.zte.alm.safety.service.IOrganizationRoleService;
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
 * Created by 6418000384 on 2016/7/21.
 * 组织角色数据接口 暂时不提供
 */
@RestController
@RequestMapping(value = "api/organizationRole")
public class OrganizationRoleRestController extends BaseController {

    @Resource
    private IOrganizationRoleService iOrganizationRoleServer;
    /**
     * 新增组织角色
     * @param map 组织角色对象
     * @return
     */
    @RequestMapping(value = "add")
    public Response addOrganizationRole(@RequestBody Map map) throws Exception{
        int result = 0;
        SysOrganizationRole sysOrganizationRole = null;
        sysOrganizationRole = (SysOrganizationRole)
                BeanHelper.mapToObject(map, SysOrganizationRole.class);
        result = iOrganizationRoleServer.add(sysOrganizationRole);
        return new Response(result);
    }

    /*
     *查询组织角色
     * map.get(roleId)
     */
    @RequestMapping(value = "query")
    public Response queryOrganizationRole(@RequestBody Map map) throws Exception{
        List<Map> queryResult = iOrganizationRoleServer.query(map);
        return new Response(queryResult);
    }

    /*
    *查看组织角色详细信息
    */
    @RequestMapping(value = "{id}")
    public Response queryOrganizationRoleDetail(@PathVariable(value = "id") Long id)throws Exception{
        SysOrganizationRole sysOrganizationRole = null;
        sysOrganizationRole = iOrganizationRoleServer.selectByPrimaryKey(id);
        return new Response(sysOrganizationRole);
    }

    /*
     *查看所有组织角色
     */
    @RequestMapping(value = "queryAll")
    public Response queryOrganizationRoleAll()throws Exception{
        SysUser user = null;
        List<Map> queryResult = iOrganizationRoleServer.queryAll();
        return new Response(queryResult);
    }

    /*
     *删除组织角色信息
     */
    @RequestMapping(value = "delete/{id}")
    public Response deleteOrganizationRole(@PathVariable(value = "id") long id){
        iOrganizationRoleServer.deleteByPrimaryKey(id);
        return new Response();
    }

    /*
     *更新组织角色信息
     */
    @RequestMapping(value = "update/{id}")
    public Response updateOrganizationRole(@RequestBody Map map,
                                       @PathVariable(value = "id") long id)throws Exception{
        SysOrganizationRole sysOrganizationRole = null;
        sysOrganizationRole = (SysOrganizationRole)
                BeanHelper.mapToObject(map, SysOrganizationRole.class);
        //先获取
        SysOrganizationRole updateSysOrganizationRole = iOrganizationRoleServer.selectByPrimaryKey(id);
        //再获取更新数据
        updateSysOrganizationRole.setLastUpdateTime(new Date());
        //更新
        int result = iOrganizationRoleServer.update(updateSysOrganizationRole);
        return new Response(result);
    }

}
