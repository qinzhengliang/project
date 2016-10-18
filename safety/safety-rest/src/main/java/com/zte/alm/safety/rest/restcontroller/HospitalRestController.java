package com.zte.alm.safety.rest.restcontroller;

import com.zte.alm.safety.infrastructure.base.Response;
import com.zte.alm.safety.infrastructure.utility.BeanHelper;
import com.zte.alm.safety.repository.entity.SysHospital;
import com.zte.alm.safety.repository.entity.SysUser;
import com.zte.alm.safety.rest.controller.BaseController;
import com.zte.alm.safety.service.IHospitalService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by 00202353 on 2016/7/20.
 * 应急救援 医院数据接口 没有数据权限限制
 */
@RestController
@RequestMapping(value = "api/hospital")
public class HospitalRestController extends BaseController {
    @Resource
    private IHospitalService iHospitalService;
    /**
     * 新增
     * @param map 医院对象
     * @return
     */
    @RequestMapping(value = "add")
    public Response addHospital(@RequestBody Map map) throws Exception {
        int result = 0;
        SysHospital sysHospital = null;
        sysHospital = (SysHospital)
                BeanHelper.mapToObject(map, SysHospital.class);
        result = iHospitalService.add(sysHospital);
        return new Response(result);
    }

    /*
     *查询医院基本信息列表
     *根据医院所在的镇街道信息过滤查询的医院数据
     */
    @RequestMapping(value = "query")
    public Response queryHospital(@RequestBody Map map)throws Exception{
        //  SysUser user = this.getLoginUser().getSysUser();
        SysUser user = null;
        List<Map> queryResult = iHospitalService.query(map,user);
        return new Response(queryResult);
    }

    /*
     * 查询给定组织下的医院列表
     */
    @RequestMapping(value = "queryByOrganization/{OrganizationId}")
    public Response queryHospitalByOrganization(@RequestBody Map map)throws Exception{
        //  SysUser user = this.getLoginUser().getSysUser();
        SysUser user = null;
        List<Map> queryResult = iHospitalService.query(map,user);
        return new Response(queryResult);
    }

    /*
     *查询所有医院基本信息列表
     *根据当前登录人的组织信息过滤查询的医院数据
     */
    @RequestMapping(value = "queryAll")
    public Response queryAllHospital()throws Exception{
        //  SysUser user = this.getLoginUser().getSysUser();
        SysUser user = null;
        List<Map> queryResult = iHospitalService.queryAll();
        return new Response(queryResult);
    }

    /*
     *删除医院信息
     */
    @RequestMapping(value = "delete/{id}")
    public Response deleteHospital(@PathVariable(value = "id") long id){
        iHospitalService.deleteByPrimaryKey(id);
        return new Response();
    }

    /*
     *更新医院基本信息
     */
    @RequestMapping(value = "update/{id}")
    public Response updateHospital(@RequestBody Map map,
                                     @PathVariable(value = "id") long id)throws Exception{
        SysUser user = null;
        SysHospital sysHospital  =
                (SysHospital) BeanHelper.mapToObject(map, SysHospital.class);
        //先获取
        SysHospital updateSysHospital = iHospitalService.selectByPrimaryKey(id);
        //再获取更新数据
        sysHospital.setLastUpdatedBy(user.getId());
        sysHospital.setLastUpdateTime(new Date());
        //更新
        int result = iHospitalService.update(sysHospital);
        return new Response(result);
    }

    /*
     *查看医院详细信息
     */
    @RequestMapping(value = "{id}")
    public Response queryHospitalDetail(@PathVariable(value = "id") Long id)throws Exception{
        SysHospital  sysHospital = iHospitalService.selectByPrimaryKey(id);
        return new Response(sysHospital);
    }
}
