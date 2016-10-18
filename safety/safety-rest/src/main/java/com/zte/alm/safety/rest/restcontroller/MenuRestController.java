package com.zte.alm.safety.rest.restcontroller;

import com.zte.alm.safety.infrastructure.base.Response;
import com.zte.alm.safety.infrastructure.utility.BeanHelper;
import com.zte.alm.safety.repository.entity.SysMenu;
import com.zte.alm.safety.repository.entity.SysUser;
import com.zte.alm.safety.rest.controller.BaseController;
import com.zte.alm.safety.service.IMenuService;
import com.zte.alm.safety.service.datacontract.MenuInfo;
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
 * 菜单数据接口 后台配置用户菜单权限 和区域权限没有关系
 */
@RestController
@RequestMapping(value = "api/menu")
public class MenuRestController extends BaseController {
    @Resource
    private IMenuService iMenuServer;
    /**
     * 新增菜单
     */
    @RequestMapping(value = "add")
    public Response addMenu(@RequestBody Map map) throws Exception{
        int result = 0;
        SysMenu sysMenu = null;
        sysMenu = (SysMenu)
                BeanHelper.mapToObject(map, SysMenu.class);
        result = iMenuServer.add(sysMenu);
        return new Response(result);
    }

    /*
     *查询菜单
     * map.get(id)
     */
    @RequestMapping(value = "query")
    public Response queryMenu(@RequestBody Map map) throws Exception{
        List<Map> queryResult = iMenuServer.query(map);
        return new Response(queryResult);
    }

    /*
    *查看菜单详细信息
    */
    @RequestMapping(value = "{id}")
    public Response queryMenuDetail(@PathVariable(value = "id") Long id)throws Exception{
        SysMenu sysMenu = null;
        sysMenu = iMenuServer.selectByPrimaryKey(id);
        return new Response(sysMenu);
    }

    /*
     *查看所有菜单，平级结构
     */
    @RequestMapping(value = "queryAll")
    public Response queryMenuAll()throws Exception{
        SysUser user = null;
        List<Map> queryResult = iMenuServer.queryAll();
        return new Response(queryResult);
    }

    /*
     *查看所有菜单，树形结构
     */
    @RequestMapping(value = "queryAllMenuTree")
    public Response queryAllMenuTree()throws Exception{
        SysUser user = null;
        List<MenuInfo> menuInfos = iMenuServer.queryAllMenuTree();
        return new Response(menuInfos);
    }

    /*
     *删除菜单信息
     */
    @RequestMapping(value = "delete/{id}")
    public Response deleteMenu(@PathVariable(value = "id") long id){
        iMenuServer.deleteByPrimaryKey(id);
        return new Response();
    }

    /*
     *更新菜单信息
     */
    @RequestMapping(value = "update/{id}")
    public Response updateMenu(@RequestBody Map map,
                                       @PathVariable(value = "id") long id)throws Exception{
        SysMenu sysMenu = null;
        sysMenu = (SysMenu)
                BeanHelper.mapToObject(map, SysMenu.class);
        //先获取
        SysMenu updateSysMenu = iMenuServer.selectByPrimaryKey(id);
        //再获取更新数据
//        updateSysOrganization.setType(sysOrganization.getType());
//        updateSysOrganization.setParentId(sysOrganization.getParentId());
//        updateSysOrganization.setFullId(sysOrganization.getFullId());
//        updateSysOrganization.setFullName(sysOrganization.getFullName());
        updateSysMenu.setLastUpdateTime(new Date());
        //更新
        int result = iMenuServer.update(updateSysMenu);
        return new Response(result);
    }
}
