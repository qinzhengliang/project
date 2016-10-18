package com.zte.alm.safety.rest.restcontroller;

import com.zte.alm.safety.infrastructure.base.Response;
import com.zte.alm.safety.infrastructure.utility.BeanHelper;
import com.zte.alm.safety.repository.entity.SysUser;
import com.zte.alm.safety.rest.controller.BaseController;
import com.zte.alm.safety.service.IUserService;
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
 * 用户数据接口 有数据权限限制
 */
@RestController
@RequestMapping(value = "api/user")
public class UserRestController extends BaseController {
    @Resource
    private IUserService iUserService;
    /**
     * 新增用户
     * @param map 用户对象
     * map.get(base) SysUser对象
     * @return
     */
    @RequestMapping(value = "add")
    public Response addUser(@RequestBody Map map) throws Exception{
        int result = 0;
        SysUser sysUser = null;
        sysUser = (SysUser)
                BeanHelper.mapToObject(map, SysUser.class);
        result = iUserService.add(sysUser);
        return new Response(result);
    }

    /*
     *查询用户
     * map.get(id)
     * map.get(name)
     * map.get(status)
     * map.get(type)
     * map.get(organization)
     * map.get(enterprise)
     */
    @RequestMapping(value = "query")
    public Response queryUser(@RequestBody Map map) throws Exception{
        List<Map> queryResult = iUserService.query(map);
        return new Response(queryResult);
    }
    /*
     *无条件查询所有用户
     *
     */
    @RequestMapping(value = "queryAll")
    public Response queryAllUser() throws Exception{
        List<Map> queryResult = iUserService.queryAll();
        return new Response(queryResult);
    }

    /*
     *删除用户信息
     */
    @RequestMapping(value = "delete/{id}")
    public Response deleteUser(@PathVariable(value = "id") long id){
        iUserService.deleteByPrimaryKey(id);
        return new Response();
    }

    /*
     *更新用户信息
     */
    @RequestMapping(value = "update/{id}")
    public Response updateUser(@RequestBody Map map,
                                 @PathVariable(value = "id") long id)throws Exception{
        SysUser sysUser = null;
        sysUser = (SysUser)
                BeanHelper.mapToObject(map, SysUser.class);
        //先获取
        SysUser updateSysUser = iUserService.selectByPrimaryKey(id);
        //再获取更新数据
        updateSysUser.setName(sysUser.getName());
        updateSysUser.setDisplayName(sysUser.getDisplayName());
        updateSysUser.setStatus(sysUser.getStatus());
        updateSysUser.setPassword(sysUser.getPassword());
        updateSysUser.setEmail(sysUser.getEmail());
        updateSysUser.setPhone(sysUser.getPhone());
        updateSysUser.setType(sysUser.getType());
        updateSysUser.setOrganization(sysUser.getOrganization());
        updateSysUser.setLastUpdatedBy(sysUser.getId());
        updateSysUser.setLastUpdateTime(new Date());
        //更新
        int result = iUserService.update(updateSysUser);
        return new Response(result);
    }
    /*
    *查看企业详细信息
    */
    @RequestMapping(value = "{id}")
    public Response queryUserDetail(@PathVariable(value = "id") Long id)throws Exception{
        SysUser sysUser = iUserService.selectByPrimaryKey(id);
        return new Response(sysUser);
    }
}
