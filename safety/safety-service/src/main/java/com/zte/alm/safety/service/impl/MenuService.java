package com.zte.alm.safety.service.impl;

import com.zte.alm.safety.common.service.BaseService;
import com.zte.alm.safety.repository.entity.SysMenu;
import com.zte.alm.safety.repository.mapper.SysMenuMapper;
import com.zte.alm.safety.service.IMenuService;
import com.zte.alm.safety.service.datacontract.MenuInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 6418000384 on 2016/7/21.
 */
@Service
public class MenuService extends BaseService implements IMenuService {
    @Resource
    private SysMenuMapper sysMenuMapper;

    @Override
    public int add(SysMenu sysMenu){

        return sysMenuMapper.insertSelective(sysMenu);
    }

    @Override
    public void deleteByPrimaryKey(Long id){
        sysMenuMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Map> query(Map map) throws Exception{
        Map queryMap = new HashMap();
        if(!this.isMapKeyNull(map,"id"))
        {
            queryMap.put("id",this.getMapString(map,"id"));
        }
        //获取符合条件的数据
        List<Map> queryResult = sysMenuMapper.query(queryMap);
//        if (queryResult.size() > 0) {
//            //根据当前用户过滤符合条件的数据，用户有查看权限的数据
//            queryResult = queryViewRightInfo(queryResult, user);
//        }
        return queryResult;
    }

    @Override
    public List<Map> queryAll() throws Exception{
        //获取符合条件的数据
        List<Map> queryResult = sysMenuMapper.queryAll();
        return queryResult;
    }

    @Override
    public List<MenuInfo> queryAllMenuTree() {
        List<SysMenu> sysMenus = sysMenuMapper.queryAllMenuTree();
        List<MenuInfo> menuInfos = new ArrayList<MenuInfo>();
        for(SysMenu sysMenu : sysMenus){
            if(sysMenu.getParentId() == 0){
                MenuInfo menuInfo = new MenuInfo(sysMenu);
                getTreeFromList(sysMenu, sysMenus, menuInfo);
                menuInfos.add(menuInfo);
            }
        }
        return menuInfos;
    }

    private void getTreeFromList(SysMenu sysMenu, List<SysMenu> sysMenus, MenuInfo menuInfo) {
        List<SysMenu> subMenus = new ArrayList<SysMenu>();
        for(SysMenu menu : sysMenus){
            if(menu.getParentId() == sysMenu.getId()){
                MenuInfo subMenuInfo = new MenuInfo(menu);
                getTreeFromList(menu, sysMenus, subMenuInfo);
                menuInfo.getChildren().add(subMenuInfo);
            }
        }
    }

    @Override
    public int update(SysMenu sysMenu){
        return sysMenuMapper.updateByPrimaryKey(sysMenu);
    }

    @Override
    public SysMenu selectByPrimaryKey(Long id){
        return sysMenuMapper.selectByPrimaryKey(id);
    }
}
