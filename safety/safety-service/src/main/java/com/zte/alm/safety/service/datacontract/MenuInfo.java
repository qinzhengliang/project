package com.zte.alm.safety.service.datacontract;

import com.zte.alm.safety.repository.entity.SysMenu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 10115916 on 2016/7/21 0021.
 */
public class MenuInfo extends SysMenu {
    private List<MenuInfo> children;

    public List<MenuInfo> getChildren() {
        return children;
    }

    public MenuInfo(){}

    public MenuInfo(SysMenu sysMenu){
        this.setId(sysMenu.getId());
        this.setCnName(sysMenu.getCnName());
        this.setEnName(sysMenu.getEnName());
        this.setParentId(sysMenu.getParentId());
        this.setDescription(sysMenu.getDescription());
        this.setClassName(sysMenu.getClassName());
        this.setEnabledFlag(sysMenu.getEnabledFlag());
        this.setPriority(sysMenu.getPriority());
        this.setSn(sysMenu.getSn());
        this.setUrl(sysMenu.getUrl());

        this.setChildren(new ArrayList<MenuInfo>());
    }

    public void setChildren(List<MenuInfo> children) {
        this.children = children;
    }
}
