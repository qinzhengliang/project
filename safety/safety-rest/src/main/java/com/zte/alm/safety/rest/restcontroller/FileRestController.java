package com.zte.alm.safety.rest.restcontroller;

import com.zte.alm.safety.infrastructure.base.Response;
import com.zte.alm.safety.infrastructure.utility.BeanHelper;
import com.zte.alm.safety.repository.entity.SysFile;
import com.zte.alm.safety.repository.entity.SysUser;
import com.zte.alm.safety.rest.controller.BaseController;
import com.zte.alm.safety.service.IFileService;
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
 * 文件数据接口
 */
@RestController
@RequestMapping(value = "api/file")
public class FileRestController extends BaseController {

    @Resource
    private IFileService iFileService;

    /**
     * 新增文件，增加文件基本信息
     * todo 要看上传附件需不需要通过此接口
     */
    @RequestMapping(value = "add")
    public Response addFile(@RequestBody Map map) throws Exception{
        int result = 0;
        SysFile sysFile = null;
        sysFile = (SysFile)
                BeanHelper.mapToObject(map, SysFile.class);
        sysFile.setCreationTime(new Date());
        result = iFileService.add(sysFile);
        return new Response(result);
    }

    /**
     * 查询文件，文件一般不需要查询，一般是扩展字段关联多个文件查询
     * map.get(id)
     */
    @RequestMapping(value = "query")
    public Response queryFile(@RequestBody Map map) throws Exception{
        List<Map> queryResult = iFileService.query(map);
        return new Response(queryResult);
    }

    /*
    *查看文件详细信息，一般不需要查看详情
    */
    @RequestMapping(value = "{id}")
    public Response queryFileDetail(@PathVariable(value = "id") Long id)throws Exception{
        SysFile sysFile = null;
        sysFile = iFileService.selectByPrimaryKey(id);
        return new Response(sysFile);
    }

    /*
     *查看所有文件信息，一般不需要
     */
    @RequestMapping(value = "queryAll")
    public Response queryFileAll()throws Exception{
        SysUser user = null;
        List<Map> queryResult = iFileService.queryAll();
        return new Response(queryResult);
    }

    /*
     *删除文件信息，软删除
     */
    @RequestMapping(value = "delete/{id}")
    public Response deleteFile(@PathVariable(value = "id") long id){
        iFileService.deleteByPrimaryKey(id);
        return new Response();
    }

    /*
     *更新文件信息，文件一旦上传，不更新
     */
    @RequestMapping(value = "update/{id}")
    public Response updateFile(@RequestBody Map map,
                               @PathVariable(value = "id") long id)throws Exception{
        SysFile sysFile = null;
        SysUser user = null;
        sysFile = (SysFile)
                BeanHelper.mapToObject(map, SysFile.class);
        //先获取
        SysFile updateSysFile = iFileService.selectByPrimaryKey(id);
        //再获取更新数据
        updateSysFile.setLastUpdateTime(new Date());
        //更新
        int result = iFileService.update(updateSysFile);
        return new Response(result);
    }

    /**
     *下载文件
     */
    @RequestMapping(value = "download/{id}")
    public Response download(@PathVariable(value = "id") long id) throws Exception{
        SysFile downloadSysFile = iFileService.download(id);
        return new Response(downloadSysFile);
    }
}
