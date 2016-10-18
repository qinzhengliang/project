package com.zte.alm.safety.rest.restcontroller;

import com.zte.alm.safety.infrastructure.base.Response;
import com.zte.alm.safety.infrastructure.utility.BeanHelper;
import com.zte.alm.safety.repository.entity.SysRescueMaterials;
import com.zte.alm.safety.repository.entity.SysUser;
import com.zte.alm.safety.rest.controller.BaseController;
import com.zte.alm.safety.service.IRescueMaterialsService;
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
 * 应急救援 应急救援物资库数据接口 没有数据权限
 */
@RestController
@RequestMapping(value = "api/rescueMaterials")
public class RescueMaterialsRestController  extends BaseController {
    @Resource
    private IRescueMaterialsService iRescueMaterialsService;
    /**
     * 新增
     * @param map 应急物资对象
     * @return
     */
    @RequestMapping(value = "add")
    public Response addRescueMaterials(@RequestBody Map map) throws Exception {
        int result = 0;
        SysRescueMaterials sysRescueMaterials = null;
        sysRescueMaterials = (SysRescueMaterials)
                BeanHelper.mapToObject(map, SysRescueMaterials.class);
        result = iRescueMaterialsService.add(sysRescueMaterials);
        return new Response(result);
    }

    /*
     *查询应急物资基本信息
     * @param map 基本信息查询条件
     *            map.get(name) 名称，模糊查询
     *            map.get(type) 物资类别
     *            map.get(organization) 所属区域
     *根据应急物资姓名和专业类型信息过滤查询的应急物资数据
     */
    @RequestMapping(value = "query")
    public Response queryRescueMaterials(@RequestBody Map map)throws Exception{
        //  SysUser user = this.getLoginUser().getSysUser();
        SysUser user = null;
        List<Map> queryResult = iRescueMaterialsService.query(map,user);
        return new Response(queryResult);
    }
    /*
     *查询所有应急物资基本信息
     *根据当前登录人的组织信息过滤查询的应急物资数据
     */
    @RequestMapping(value = "queryAll")
    public Response queryAllRescueMaterials()throws Exception{
        //  SysUser user = this.getLoginUser().getSysUser();
        SysUser user = null;
        List<Map> queryResult = iRescueMaterialsService.queryAll();
        return new Response(queryResult);
    }
    /*
     *删除应急物资信息
     */
    @RequestMapping(value = "delete/{id}")
    public Response deleteRescueMaterials(@PathVariable(value = "id") long id){
        iRescueMaterialsService.deleteByPrimaryKey(id);
        return new Response();
    }

    /*
     *更新应急物资基本信息
     */
    @RequestMapping(value = "update/{id}")
    public Response updateRescueMaterials(@RequestBody Map map,
                                       @PathVariable(value = "id") long id)throws Exception{
        SysUser user = null;
        SysRescueMaterials sysRescueMaterials  =
                (SysRescueMaterials) BeanHelper.mapToObject(map, SysRescueMaterials.class);
        //先获取
        SysRescueMaterials updateSysRescueMaterials = iRescueMaterialsService.selectByPrimaryKey(id);
        //再获取更新数据
        sysRescueMaterials.setLastUpdatedBy(user.getId());
        sysRescueMaterials.setLastUpdateTime(new Date());
        //更新
        int result = iRescueMaterialsService.update(sysRescueMaterials);
        return new Response(result);
    }

    /*
     *查看应急物资详细信息
     */
    @RequestMapping(value = "{id}")
    public Response queryRescueMaterials(@PathVariable(value = "id") Long id)throws Exception{
        SysRescueMaterials  sysRescueMaterials = iRescueMaterialsService.selectByPrimaryKey(id);
        return new Response(sysRescueMaterials);
    }
}
