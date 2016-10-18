package com.zte.alm.safety.rest.restcontroller;

import com.zte.alm.safety.infrastructure.base.Response;
import com.zte.alm.safety.infrastructure.utility.BeanHelper;
import com.zte.alm.safety.repository.entity.SysList;
import com.zte.alm.safety.repository.entity.SysUser;
import com.zte.alm.safety.rest.controller.BaseController;
import com.zte.alm.safety.service.IListService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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
 * 字典数据接口 没有数据权限限制，字典和字典项相关接口都这里定义
 */
@RestController
@RequestMapping(value = "api/list")
public class ListRestController extends BaseController {
    @Resource
    private IListService iListService;

    /**
     * 新增字典
     */
    @RequestMapping(value = "add")
    public Response addList(@RequestBody Map map) throws Exception{
        int result = 0;
        SysList sysList = null;
        sysList = (SysList)
                BeanHelper.mapToObject(map, SysList.class);
        result = iListService.add(sysList);
        return new Response(result);
    }

    /**
     *查询字典列表
     * map.get(id)
     */
    @RequestMapping(value = "query")
    public Response queryList(@RequestBody Map map) throws Exception{
        List<Map> queryResult = iListService.query(map);
        return new Response(queryResult);
    }

    /*
    *查看字典详细信息
    */
    @Cacheable
    @RequestMapping(value = "{id}")
    public Response queryContentDetail(@PathVariable(value = "id") Long id)throws Exception{
        SysList sysList = null;
        sysList = iListService.selectByPrimaryKey(id);
        return new Response(sysList);
    }

    /*
     *查看所有字典信息
     */
    @RequestMapping(value = "queryAll")
    public Response queryContentAll()throws Exception{
        List<Map> queryResult = iListService.queryAll();
        return new Response(queryResult);
    }
    /*
     *删除字典项信息
     */
    @RequestMapping(value = "delete/{id}")
    public Response deleteList(@PathVariable(value = "id") long id){
//        int result = 0;
//        SysUser user = null;
//        //先获取
//        SysList updateSysList = iListService.selectByPrimaryKey(id);
//        updateSysList.setEnabledFlag(false);
////        updateSysList.setLastUpdatedBy(user.getId());
//        updateSysList.setLastUpdateTime(new Date());
//        result = iListService.update(updateSysList);
//        return new Response(result);
        iListService.deleteByPrimaryKey(id);
        return new Response();
    }

    /*
     *更新字典信息
     */
    @RequestMapping(value = "update/{id}")
    public Response updateList(@RequestBody Map map,
                                 @PathVariable(value = "id") long id)throws Exception{
        SysList sysList = null;
        SysUser user = null;
        sysList = (SysList)
                BeanHelper.mapToObject(map, SysList.class);
        //先获取
        SysList updateSysList = iListService.selectByPrimaryKey(id);
        //再获取更新数据
//        updateSysList.setName(sysList.getName());
//        updateSysList.setDescription(sysList.getDescription());
//        updateSysList.setLastUpdatedBy(user.getId());
        updateSysList.setLastUpdateTime(new Date());
        //更新
        int result = iListService.update(updateSysList);
        return new Response(result);
    }

    /*
     * 根据字典名称获取对应的字典项, 由于名称是中文，做成POST方式
     */
    @RequestMapping(value = "getListMemberByListName")
    public Response getListMemberByListName( @PathVariable(value = "name") String name)throws Exception{
        SysList sysList = null;
        sysList = iListService.GetListByName(name);
        return new Response(sysList);
    }
}
