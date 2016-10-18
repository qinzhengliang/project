package com.zte.alm.safety.rest.restcontroller;

import com.zte.alm.safety.infrastructure.base.Response;
import com.zte.alm.safety.infrastructure.utility.BeanHelper;
import com.zte.alm.safety.repository.entity.SysInspectionProblem;
import com.zte.alm.safety.repository.entity.SysUser;
import com.zte.alm.safety.rest.controller.BaseController;
import com.zte.alm.safety.service.IInspectionProblemService;
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
 */
@RestController
@RequestMapping(value = "api/inspectionProblem")
public class InspectionProblemRestController extends BaseController {
    @Resource
    private IInspectionProblemService iInspectionProblemService;
    /**
     * 新增
     * @param map 督查隐患对象
     * @return
     */
    @RequestMapping(value = "add")
    public Response addInspectionProblem(@RequestBody Map map) throws Exception {
        int result = 0;
        SysInspectionProblem sysInspectionProblem = null;
        sysInspectionProblem = (SysInspectionProblem)
                BeanHelper.mapToObject(map, SysInspectionProblem.class);
        result = iInspectionProblemService.add(sysInspectionProblem);
        return new Response(result);
    }

    /*
     *查询督查隐患基本信息
     * @param map 基本信息查询条件
     *            map.get(organization) 街道
     *            map.get(enterprise) 被督查的企业
     *            map.get(discoverTime) 发现时间
     *根据督查隐患所在的镇街道信息过滤查询的督查隐患数据
     */
    @RequestMapping(value = "query")
    public Response queryInspectionProblem(@RequestBody Map map)throws Exception{
        //  SysUser user = this.getLoginUser().getSysUser();
        SysUser user = null;
        List<Map> queryResult = iInspectionProblemService.query(map,user);
        return new Response(queryResult);
    }
    /*
     *查询所有督查隐患基本信息
     *根据当前登录人的组织信息过滤查询的督查隐患数据
     */
    @RequestMapping(value = "queryAll")
    public Response queryAllInspectionProblem()throws Exception{
        //  SysUser user = this.getLoginUser().getSysUser();
        SysUser user = null;
        List<Map> queryResult = iInspectionProblemService.queryAll();
        return new Response(queryResult);
    }
    /*
     *删除督查隐患信息
     */
    @RequestMapping(value = "delete/{id}")
    public Response deleteInspectionProblem(@PathVariable(value = "id") long id){
        iInspectionProblemService.deleteByPrimaryKey(id);
        return new Response();
    }

    /*
     *更新督查隐患基本信息
     */
    @RequestMapping(value = "update/{id}")
    public Response updateInspectionProblem(@RequestBody Map map,
                                   @PathVariable(value = "id") long id)throws Exception{
        SysUser user = null;
        SysInspectionProblem sysInspectionProblem  =
                (SysInspectionProblem) BeanHelper.mapToObject(map, SysInspectionProblem.class);
        //先获取
        SysInspectionProblem updateSysInspectionProblem = iInspectionProblemService.selectByPrimaryKey(id);
        //再获取更新数据
        sysInspectionProblem.setLastUpdatedBy(user.getId());
        sysInspectionProblem.setLastUpdateTime(new Date());
        //更新
        int result = iInspectionProblemService.update(sysInspectionProblem);
        return new Response(result);
    }

    /*
     *查看督查隐患详细信息
     */
    @RequestMapping(value = "{id}")
    public Response queryInspectionProblem(@PathVariable(value = "id") Long id)throws Exception{
        SysInspectionProblem  sysInspectionProblem = iInspectionProblemService.selectByPrimaryKey(id);
        return new Response(sysInspectionProblem);
    }
}
