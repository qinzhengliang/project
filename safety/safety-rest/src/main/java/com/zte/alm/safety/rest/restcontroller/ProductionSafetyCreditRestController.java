package com.zte.alm.safety.rest.restcontroller;

import com.zte.alm.safety.infrastructure.base.Response;
import com.zte.alm.safety.infrastructure.utility.BeanHelper;
import com.zte.alm.safety.repository.entity.SysProductionSafetyCredit;
import com.zte.alm.safety.repository.entity.SysUser;
import com.zte.alm.safety.rest.controller.BaseController;
import com.zte.alm.safety.service.IProductionSafetyCreditService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by 00202353 on 2016/7/21.
 * 安全生产 安全生产诚信分数据接口
 */
@RestController
@RequestMapping(value = "api/productionSafetyCredit")
public class ProductionSafetyCreditRestController  extends BaseController {
    @Resource
    private IProductionSafetyCreditService iProductionSafetyCreditService;
    /**
     * 新增安全生产诚信，每个人或者企业的记录应该是自动增加的
     * @param map 安全生产诚信对象
     * map sysProductionSafetyCredit对象
     * @return
     */
    @RequestMapping(value = "add")
    public Response addProductionSafetyCredit(@RequestBody Map map) throws Exception {
        int result = 0;
        SysProductionSafetyCredit sysProductionSafetyCredit = null;
        sysProductionSafetyCredit = (SysProductionSafetyCredit)
                BeanHelper.mapToObject(map, SysProductionSafetyCredit.class);
        result = iProductionSafetyCreditService.add(sysProductionSafetyCredit);
        return new Response(result);
    }

    /*
     *查询安全生产诚信基本信息
     * @param map.get(type)
     * map.get(createdBy)
     *根据当前登录人的组织信息过滤查询的安全生产诚信数据
     */
    @RequestMapping(value = "query")
    public Response queryProductionSafetyCredit(@RequestBody Map map)throws Exception{
        //  SysUser user = this.getLoginUser().getSysUser();
        SysUser user = null;
        List<Map> queryResult = iProductionSafetyCreditService.query(map,user);
        return new Response(queryResult);
    }
    /*
     *查询安全生产诚信基本信息
     *根据当前登录人的组织信息过滤查询的安全生产诚信数据
     */
    @RequestMapping(value = "queryAll")
    public Response queryAllProductionSafetyCredit()throws Exception{
        //  SysUser user = this.getLoginUser().getSysUser();
        SysUser user = null;
        List<Map> queryResult = iProductionSafetyCreditService.queryAll();
        return new Response(queryResult);
    }
    /*
     *删除安全生产诚信信息
     */
    @RequestMapping(value = "delete/{id}")
    public Response deleteProductionSafetyCredit(@PathVariable(value = "id") long id){
        iProductionSafetyCreditService.deleteByPrimaryKey(id);
        return new Response();
    }

    /*
     * 更新安全生产诚信基本信息
     * todo 更新后要同时增加变更日志记录
     */
    @RequestMapping(value = "update/{id}")
    public Response updateProductionSafetyCredit(@RequestBody Map map,
                                     @PathVariable(value = "id") long id)throws Exception{
        SysUser user = null;
        SysProductionSafetyCredit sysProductionSafetyCredit  =
                (SysProductionSafetyCredit) BeanHelper.mapToObject(map, SysProductionSafetyCredit.class);
        //先获取
        SysProductionSafetyCredit updatesysProductionSafetyCredit = iProductionSafetyCreditService.selectByPrimaryKey(id);
        //再获取更新数据
        updatesysProductionSafetyCredit.setLastUpdatedBy(user.getId());
        updatesysProductionSafetyCredit.setLastUpdateTime(new Date());
        //更新
        int result = iProductionSafetyCreditService.update(updatesysProductionSafetyCredit);
        return new Response(result);
    }

    /*
     *查看安全生产诚信详细信息
     */
    @RequestMapping(value = "{id}")
    public Response queryProductionSafetyCreditDetail(@PathVariable(value = "id") Long id)throws Exception{
        SysProductionSafetyCredit  sysProductionSafetyCredit = iProductionSafetyCreditService.selectByPrimaryKey(id);
        return new Response(sysProductionSafetyCredit);
    }
}
