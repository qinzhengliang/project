package com.zte.alm.safety.rest.restcontroller;

import com.zte.alm.safety.infrastructure.base.Response;
import com.zte.alm.safety.rest.controller.BaseController;
import com.zte.alm.safety.service.ICategoryService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by 00202353 on 2016/7/19.
 * 企业基本信息 行业类型数据接口 没有权限限制
 */
@RestController
@RequestMapping(value = "api/category")
public class CategoryRestController extends BaseController {
    @Resource
    private ICategoryService iCategoryService;
    /*
     *查询行业类型基本信息
     */
    @RequestMapping(value = "query")
    public Response queryCategory(@RequestBody Map map)throws Exception{
        List<Map> queryResult = iCategoryService.query(map);
        return new Response(queryResult);
    }

    /*
     * 行业类型是与组织权限没有关系，行业类型树是查询整个行业类型数据
     *
     */
    public Response queryCategoryTree()throws Exception{
        return new Response();
    }

    /*
     * 根据父节点Id查询其下直接关联的子行业类型，第一级别父Id为0
     */
    public Response queryCategoryByParentId()throws Exception{
        return new Response();
    }

    /*
     * 增加行业类型，如果没有上级信息就是顶级，如果有上级信息，就要挂到某个上级信息
     */
    public Response addCategory()throws Exception{
        return new Response();
    }

    /*
     * 删除行业类型，要同时删除所有下级行业类型
     * 同时考虑处理相关的企业基本信息中的行业类型数据
     */
    public Response deleteCategory()throws Exception{
        return new Response();
    }

    /*
     * 更新行业类型，更新基本信息，不改变父节点
     */
    public Response updateCategory()throws Exception{
        return new Response();
    }

}
