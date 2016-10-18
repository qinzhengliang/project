package com.zte.alm.safety.rest.restcontroller;

import com.zte.alm.safety.infrastructure.base.Response;
import com.zte.alm.safety.infrastructure.utility.BeanHelper;
import com.zte.alm.safety.repository.entity.SysChemical;
import com.zte.alm.safety.repository.entity.SysUser;
import com.zte.alm.safety.rest.controller.BaseController;
import com.zte.alm.safety.service.IChemicalService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by 6418000384 on 2016/7/20.
 * 应急救援 危化品数据接口 没有权限限制
 */
@RestController
@RequestMapping(value = "api/chemical")
public class ChemicalRestController extends BaseController {
    @Resource
    private IChemicalService iChemicalService;

    /**
     * 新增危化品信息
     */
    @RequestMapping(value = "add")
    public Response addChemical(@RequestBody Map map)throws Exception{
        int result = 0;
        SysChemical sysChemical = (SysChemical)
                BeanHelper.mapToObject(map, SysChemical.class);
        result = iChemicalService.add(sysChemical);
        return new Response(result);
    }
    /*
    * 根据条件查询危化品列表
    * @param map 基本信息查询条件
    * map.get(cnName)中文
    * map.get(enName)英文
    *
    * @return
    */
    @RequestMapping(value = "query")
    public Response queryChemical(@RequestBody Map map) throws Exception{
        SysUser user = null;
        List<Map> queryResult = iChemicalService.query(map,user);
        return new Response(queryResult);
    }

    /**
     * 查看危化品详细信息
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "{id}")
    public Response queryChemicalDetail(@PathVariable(value = "id") Long id)throws Exception{
        SysChemical sysChemical = null;
        sysChemical = iChemicalService.selectByPrimaryKey(id);
        return new Response(sysChemical);
    }

    /*
     *查看所有危化品信息
     */
    @RequestMapping(value = "queryAll")
    public Response queryChemicalAll()throws Exception{
        List<Map> queryResult = iChemicalService.queryAll();
        return new Response(queryResult);
    }

    /*
     * 根据中文名称模糊查询危化品理化特性数据
     */
    public Response queryChemicalByCnName()throws Exception{
        List<Map> queryResult = iChemicalService.queryAll();
        return new Response(queryResult);
    }

    /**
     * 删除危化品
     * @param id
     * @return
     */
    @RequestMapping(value = "delete/{id}")
    public Response deleteChemical(@PathVariable(value = "id") long id){
        iChemicalService.deleteByPrimaryKey(id);
        return new Response();
    }

    /**
     * 更新危化品
     * @param map
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "update/{id}")
    public Response updateChemical(@RequestBody Map map,
                                     @PathVariable(value = "id") long id)throws Exception {
        SysChemical sysChemical = null;
        SysUser user = null;
        sysChemical = (SysChemical)
                BeanHelper.mapToObject(map, SysChemical.class);
        //先获取
        SysChemical updateSysChemical = iChemicalService.selectByPrimaryKey(id);
        //再获取更新数据
        updateSysChemical.setCnName(sysChemical.getCnName());
        updateSysChemical.setEnName(sysChemical.getEnName());
        //更新
        int result = iChemicalService.update(updateSysChemical);
        return new Response(result);
    }
}
