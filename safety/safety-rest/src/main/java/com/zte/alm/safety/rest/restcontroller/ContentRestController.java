package com.zte.alm.safety.rest.restcontroller;


import com.zte.alm.safety.infrastructure.base.Response;
import com.zte.alm.safety.infrastructure.utility.BeanHelper;
import com.zte.alm.safety.repository.entity.SysContent;
import com.zte.alm.safety.repository.entity.SysUser;
import com.zte.alm.safety.rest.controller.BaseController;
import com.zte.alm.safety.service.IContentService;
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
 * 安全教育 内容数据接口 没有组织权限限制
 */
@RestController
@RequestMapping(value = "api/content")
public class ContentRestController extends BaseController {
    @Resource
    private IContentService iContentService;
    /**
     * 新增内容，支持管理员发布安全教育相关文章
     * @param map 内容对象
     * @return
     */
    @RequestMapping(value = "add")
    public Response addContent(@RequestBody Map map) throws Exception {
        int result = 0;
        SysContent sysContent = null;
        sysContent = (SysContent)
                BeanHelper.mapToObject(map, SysContent.class);
        result = iContentService.add(sysContent);
        return new Response(result);
    }

    /*
     * 根据相关条件，查询内容列表，列表不需要具体内容
     * map.get(type)
     * map.get(title)
     *根据当前登录人的组织信息过滤查询的内容数据
     */
    @RequestMapping(value = "query")
    public Response queryContent(@RequestBody Map map)throws Exception{
        //  SysUser user = this.getLoginUser().getSysUser();
        SysUser user = null;
        List<Map> queryResult = iContentService.query(map,user);
        return new Response(queryResult);
    }

    /*
     *查询所有内容列表，列表不需要具体内容
     */
    @RequestMapping(value = "queryAll")
    public Response queryAllContent()throws Exception{
        List<Map> queryResult = iContentService.queryAll();
        return new Response(queryResult);
    }

    /*
     * 查询当前登录用户的文章列表
     */
    public Response queryMyContent()throws Exception{
        List<Map> queryResult = iContentService.queryAll();
        return new Response(queryResult);
    }

    /*
     *删除内容信息, 支持删除文章
     */
    @RequestMapping(value = "delete/{id}")
    public Response deleteContent(@PathVariable(value = "id") long id){
        iContentService.deleteByPrimaryKey(id);
        return new Response();
    }

    /*
     * 更新内容基本信息，支持文章的编辑更新
     * todo 只能更新当前用户创建的文章？暂时不实现，都可以编辑
     */
    @RequestMapping(value = "update/{id}")
    public Response updateContent(@RequestBody Map map,
                                     @PathVariable(value = "id") long id)throws Exception{
        SysUser user = null;
        SysContent SysContent  =
                (SysContent) BeanHelper.mapToObject(map, SysContent.class);
        //先获取
        SysContent updateSysContent = iContentService.selectByPrimaryKey(id);
        //再获取更新数据
        updateSysContent.setLastUpdatedBy(user.getId());
        updateSysContent.setLastUpdateTime(new Date());
        //更新
        int result = iContentService.update(updateSysContent);
        return new Response(result);
    }

    /*
     * 查看内容详细信息,支持文章查看及文章中视频和图片查看
     */
    @RequestMapping(value = "{id}")
    public Response queryContentDetail(@PathVariable(value = "id") Long id)throws Exception{
        SysContent  sysContent = iContentService.selectByPrimaryKey(id);
        return new Response(sysContent);
    }
}
