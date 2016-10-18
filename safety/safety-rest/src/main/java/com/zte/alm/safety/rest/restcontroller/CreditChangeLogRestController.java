package com.zte.alm.safety.rest.restcontroller;

import com.zte.alm.safety.infrastructure.base.Response;
import com.zte.alm.safety.infrastructure.utility.BeanHelper;
import com.zte.alm.safety.repository.entity.SysCreditChangeLog;
import com.zte.alm.safety.repository.entity.SysUser;
import com.zte.alm.safety.rest.controller.BaseController;
import com.zte.alm.safety.service.ICreditChangeLogService;
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
 * 安全生产诚信 信用分变更日志数据接口
 * 安全生产信用变更时，需自动记录日志，增加后不能更新，最好不要删除
 * 用于查看某个人的生产诚信信息的时候，显示诚信分变更历史记录
 */
@RestController
@RequestMapping(value = "api/creditChangeLog")
public class CreditChangeLogRestController extends BaseController {
    @Resource
    private ICreditChangeLogService iCreditChangeLogService;

    /*
     *查询安全生产信用分更改日志基本信息
     * @param map.get(creaditId)
     * * @param map.get(changedBy)
     *根据当前登录人的组织信息过滤查询的安全生产信用分更改日志数据
     */
    @RequestMapping(value = "query")
    public Response queryCreditChangeLog(@RequestBody Map map)throws Exception{
        //  SysUser user = this.getLoginUser().getSysUser();
        SysUser user = null;
        List<Map> queryResult = iCreditChangeLogService.query(map,user);
        return new Response(queryResult);
    }

    /*
     * 根据安全生产诚信Id获取其对应的变更日志列表
     */
    public Response queryCreditChangeLogByCredit(@RequestBody Map map)throws Exception{
        //  SysUser user = this.getLoginUser().getSysUser();
        SysUser user = null;
        List<Map> queryResult = iCreditChangeLogService.query(map,user);
        return new Response(queryResult);
    }

    /*
     *删除安全生产信用分更改日志信息
     */
    @RequestMapping(value = "delete/{id}")
    public Response deleteCreditChangeLog(@PathVariable(value = "id") long id){
        iCreditChangeLogService.deleteByPrimaryKey(id);
        return new Response();
    }

    /*
     *查看安全生产信用分更改日志详细信息
     */
    @RequestMapping(value = "{id}")
    public Response queryCreditChangeLogDetail(@PathVariable(value = "id") Long id)throws Exception{
        SysCreditChangeLog  sysCreditChangeLog = iCreditChangeLogService.selectByPrimaryKey(id);
        return new Response(sysCreditChangeLog);
    }
}
