package com.zte.alm.safety.rest.restcontroller;

import com.zte.alm.safety.infrastructure.base.Response;
import com.zte.alm.safety.infrastructure.utility.BeanHelper;
import com.zte.alm.safety.repository.entity.SysField;
import com.zte.alm.safety.repository.entity.SysUser;
import com.zte.alm.safety.service.IFieldService;
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
 * 扩展字段配置不需要暴露API接口，Repository层需要获取数据
 * 后续如果需要配置界面需要API接口
 */
@RestController
@RequestMapping(value = "api/field")
public class FieldRestController {
    @Resource
    private IFieldService iFieldService;
    /**
     * 新增扩展字段表
     * @param map 扩展字段表对象
     * @return
     */
    @RequestMapping(value = "add")
    public Response addField(@RequestBody Map map) throws Exception {
        int result = 0;
        SysField sysField = null;
        sysField = (SysField)
                BeanHelper.mapToObject(map, SysField.class);
        result = iFieldService.add(sysField);
        return new Response(result);
    }

    /*
     *查询扩展字段表基本信息
     * map.get(displayName)
     * map.get(tableName)
     *根据当前登录人的组织信息过滤查询的扩展字段表数据
     */
    @RequestMapping(value = "query")
    public Response queryField(@RequestBody Map map)throws Exception{
        //  SysUser user = this.getLoginUser().getSysUser();
        SysUser user = null;
        List<Map> queryResult = iFieldService.query(map,user);
        return new Response(queryResult);
    }
    /*
     *查询扩展字段表基本信息
     *根据当前登录人的组织信息过滤查询的扩展字段表数据
     */
    @RequestMapping(value = "queryAll")
    public Response queryAllField()throws Exception{
        //  SysUser user = this.getLoginUser().getSysUser();
        SysUser user = null;
        List<Map> queryResult = iFieldService.queryAll();
        return new Response(queryResult);
    }
    /*
     *删除扩展字段表信息
     */
    @RequestMapping(value = "delete/{id}")
    public Response deleteField(@PathVariable(value = "id") long id){
        iFieldService.deleteByPrimaryKey(id);
        return new Response();
    }

    /*
     *更新扩展字段表基本信息
     */
    @RequestMapping(value = "update/{id}")
    public Response updateField(@RequestBody Map map,
                                     @PathVariable(value = "id") long id)throws Exception{
        SysUser user = null;
        SysField sysField  =
                (SysField) BeanHelper.mapToObject(map, SysField.class);
        //先获取
        SysField updatesysField = iFieldService.selectByPrimaryKey(id);
        //再获取更新数据
        updatesysField.setLastUpdatedBy(user.getId());
        updatesysField.setLastUpdateTime(new Date());
        //更新
        int result = iFieldService.update(updatesysField);
        return new Response(result);
    }

    /*
     *查看扩展字段表详细信息
     */
    @RequestMapping(value = "{id}")
    public Response queryFieldDetail(@PathVariable(value = "id") Long id)throws Exception{
        SysField  sysField = iFieldService.selectByPrimaryKey(id);
        return new Response(sysField);
    }
}
