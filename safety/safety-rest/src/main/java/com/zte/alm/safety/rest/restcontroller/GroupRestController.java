package com.zte.alm.safety.rest.restcontroller;

import com.zte.alm.safety.infrastructure.base.Response;
import com.zte.alm.safety.infrastructure.utility.BeanHelper;
import com.zte.alm.safety.repository.entity.SysGroup;
import com.zte.alm.safety.repository.entity.SysUser;
import com.zte.alm.safety.rest.controller.BaseController;
import com.zte.alm.safety.service.IGroupService;
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
 * 用户组数据接口，暂时不需要提供API接口
 */
@RestController
@RequestMapping(value = "api/group")
public class GroupRestController extends BaseController {
    @Resource
    private IGroupService iGroupService;
    /**
     * 新增用户组
     * @param map 用户组对象
     * map sysGroup对象
     * @return
     */
    @RequestMapping(value = "add")
    public Response addGroup(@RequestBody Map map) throws Exception {
        int result = 0;
        SysGroup sysGroup = null;
        sysGroup = (SysGroup)
                BeanHelper.mapToObject(map, SysGroup.class);
        result = iGroupService.add(sysGroup);
        return new Response(result);
    }

    /*
     *查询用户组基本信息
     * * @param map 用户组对象
     * map.get(name)
     * map.get(createdBy)
     *根据当前登录人的组织信息过滤查询的用户组数据
     */
    @RequestMapping(value = "query")
    public Response queryGroup(@RequestBody Map map)throws Exception{
        //  SysUser user = this.getLoginUser().getSysUser();
        SysUser user = null;
        List<Map> queryResult = iGroupService.query(map,user);
        return new Response(queryResult);
    }
    /*
     *查询用户组基本信息
     *根据当前登录人的组织信息过滤查询的用户组数据
     */
    @RequestMapping(value = "queryAll")
    public Response queryAllGroup()throws Exception{
        //  SysUser user = this.getLoginUser().getSysUser();
        SysUser user = null;
        List<Map> queryResult = iGroupService.queryAll();
        return new Response(queryResult);
    }
    /*
     *删除用户组信息
     */
    @RequestMapping(value = "delete/{id}")
    public Response deleteGroup(@PathVariable(value = "id") long id){
        iGroupService.deleteByPrimaryKey(id);
        return new Response();
    }

    /*
     *更新用户组基本信息
     */
    @RequestMapping(value = "update/{id}")
    public Response updateGroup(@RequestBody Map map,
                                     @PathVariable(value = "id") long id)throws Exception{
        SysUser user = null;
        SysGroup sysGroup  =
                (SysGroup) BeanHelper.mapToObject(map, SysGroup.class);
        //先获取
        SysGroup updatesysGroup = iGroupService.selectByPrimaryKey(id);
        //再获取更新数据
        updatesysGroup.setLastUpdatedBy(user.getId());
        updatesysGroup.setLastUpdateTime(new Date());
        //更新
        int result = iGroupService.update(sysGroup);
        return new Response(result);
    }

    /*
     *查看用户组详细信息
     */
    @RequestMapping(value = "{id}")
    public Response queryGroupDetail(@PathVariable(value = "id") Long id)throws Exception{
        SysGroup  sysGroup = iGroupService.selectByPrimaryKey(id);
        return new Response(sysGroup);
    }
}
