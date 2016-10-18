package com.zte.alm.safety.service.datacontract;

import com.zte.alm.safety.repository.entity.SysOrganization;

import java.util.List;

/**
 * Created by 10115916 on 2016/7/21 0021.
 */
public class OrganizationInfo extends SysOrganization {

    private List<SysOrganization> children;

    public List<SysOrganization> getChildren() {
        return children;
    }

    public void setChildren(List<SysOrganization> children) {
        this.children = children;
    }
}
