package com.zte.alm.safety.rest.restcontroller;

import com.zte.alm.safety.infrastructure.shiro.ShiroHelper;
import com.zte.alm.safety.infrastructure.utility.BeanHelper;
import com.zte.alm.safety.infrastructure.base.Response;
import com.zte.alm.safety.repository.entity.SysEnterprise;
import com.zte.alm.safety.repository.entity.SysUser;
import com.zte.alm.safety.rest.controller.BaseController;
import com.zte.alm.safety.service.IEnterpriseService;
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
 * 企业基本信息 企业基本信息数据接口
 */
@RestController
@RequestMapping(value = "api/enterprise")
public class EnterpriseRestController extends BaseController {

    @Resource
    private IEnterpriseService iEnterpriseService;
    /**
     * 新增企业，注册
     * @param map 企业对象
     * @return
     */
    @RequestMapping(value = "add")
    public Response addEnterprise(@RequestBody Map map) throws Exception {
        int result = 0;
        SysEnterprise sysEnterprise = null;
        sysEnterprise = (SysEnterprise)
                BeanHelper.mapToObject( map, SysEnterprise.class);
        result = iEnterpriseService.add(sysEnterprise);
        return new Response(result);
    }

    /*
     * 根据相关条件查询企业基本信息，在此基础上根据当前登录人的所有企业授权过滤查询
     */
    @RequestMapping(value = "query")
    public Response queryEnterprise(@RequestBody Map map)throws Exception{
        List<Long> enterpriseIds = ShiroHelper.getEnterpriseAuthorization();
        List<Map> queryResult = iEnterpriseService.query(map,null);
        return new Response(queryResult);
    }

    /*
     *查询企业基本信息
     *根据当前登录人的组织信息过滤查询的企业数据
     */
    @RequestMapping(value = "queryAll")
    public Response queryAllEnterprise()throws Exception{
        //  SysUser user = this.getLoginUser().getSysUser();
        SysUser user = null;
        List<Map> queryResult = iEnterpriseService.queryAll();
        return new Response(queryResult);
    }

    /*
     *删除企业信息, 所有删除都要软删除，所有的查询都要加enabled_flag=1
     */
    @RequestMapping(value = "delete/{id}")
    public Response deleteEnterprise(@PathVariable(value = "id") long id){
        iEnterpriseService.deleteByPrimaryKey(id);
        return new Response();
    }

    /*
     *更新企业基本信息
     */
    @RequestMapping(value = "update/{id}")
    public Response updateEnterprise(@RequestBody Map map,
                                     @PathVariable(value = "id") long id)throws Exception{
        SysUser user = null;
        SysEnterprise sysEnterprise  =
                (SysEnterprise) BeanHelper.mapToObject(map, SysEnterprise.class);
        //先获取
        SysEnterprise updateSysEnterprise = iEnterpriseService.selectByPrimaryKey(id);
        //再获取更新数据
        sysEnterprise.setLastUpdatedBy(user.getId());
        sysEnterprise.setLastUpdateTime(new Date());
        //更新
        int result = iEnterpriseService.update(sysEnterprise);
        return new Response(result);
    }

    /*
     *查看企业详细信息
     */
    @RequestMapping(value = "{id}")
    public Response queryEnterpriseDetail(@PathVariable(value = "id") Long id)throws Exception{
        SysEnterprise  sysEnterprise = iEnterpriseService.selectByPrimaryKey(id);
        return new Response(sysEnterprise);
    }
}
