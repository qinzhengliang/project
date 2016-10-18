package com.zte.alm.safety.rest.restcontroller;

import com.zte.alm.safety.infrastructure.base.Response;
import com.zte.alm.safety.infrastructure.utility.BeanHelper;
import com.zte.alm.safety.repository.entity.SysRescueExpert;
import com.zte.alm.safety.repository.entity.SysUser;
import com.zte.alm.safety.rest.controller.BaseController;
import com.zte.alm.safety.service.IRescueExpertService;
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
 * 应急救援 救援专家数据接口 没有数据权限
 */
@RestController
@RequestMapping(value = "api/rescueExpert")
public class RescueExpertRestController  extends BaseController {
    @Resource
    private IRescueExpertService iRescueExpertService;
    /**
     * 新增
     * @param map 应急专家对象
     * @return
     */
    @RequestMapping(value = "add")
    public Response addRescueExpert(@RequestBody Map map) throws Exception {
        int result = 0;
        SysRescueExpert sysRescueExpert = null;
        sysRescueExpert = (SysRescueExpert)
                BeanHelper.mapToObject(map, SysRescueExpert.class);
        result = iRescueExpertService.add(sysRescueExpert);
        return new Response(result);
    }

    /*
     *查询应急专家基本信息
     * @param map 基本信息查询条件
     *            map.get(name) 姓名
     *            map.get(type) 专家类别
     *根据应急专家姓名和专业类型信息过滤查询的应急专家数据
     */
    @RequestMapping(value = "query")
    public Response queryRescueExpert(@RequestBody Map map)throws Exception{
        //  SysUser user = this.getLoginUser().getSysUser();
        SysUser user = null;
        List<Map> queryResult = iRescueExpertService.query(map,user);
        return new Response(queryResult);
    }
    /*
     *查询所有应急专家基本信息
     *根据当前登录人的组织信息过滤查询的应急专家数据
     */
    @RequestMapping(value = "queryAll")
    public Response queryAllRescueExpert()throws Exception{
        //  SysUser user = this.getLoginUser().getSysUser();
        SysUser user = null;
        List<Map> queryResult = iRescueExpertService.queryAll();
        return new Response(queryResult);
    }
    /*
     *删除应急专家信息
     */
    @RequestMapping(value = "delete/{id}")
    public Response deleteRescueExpert(@PathVariable(value = "id") long id){
        iRescueExpertService.deleteByPrimaryKey(id);
        return new Response();
    }

    /*
     *更新应急专家基本信息
     */
    @RequestMapping(value = "update/{id}")
    public Response updateRescueExpert(@RequestBody Map map,
                                            @PathVariable(value = "id") long id)throws Exception{
        SysUser user = null;
        SysRescueExpert sysRescueExpert  =
                (SysRescueExpert) BeanHelper.mapToObject(map, SysRescueExpert.class);
        //先获取
        SysRescueExpert updateSysRescueExpert = iRescueExpertService.selectByPrimaryKey(id);
        //再获取更新数据
        sysRescueExpert.setLastUpdatedBy(user.getId());
        sysRescueExpert.setLastUpdateTime(new Date());
        //更新
        int result = iRescueExpertService.update(sysRescueExpert);
        return new Response(result);
    }

    /*
     *查看应急专家详细信息
     */
    @RequestMapping(value = "{id}")
    public Response queryRescueExpert(@PathVariable(value = "id") Long id)throws Exception{
        SysRescueExpert  sysRescueExpert = iRescueExpertService.selectByPrimaryKey(id);
        return new Response(sysRescueExpert);
    }
}
