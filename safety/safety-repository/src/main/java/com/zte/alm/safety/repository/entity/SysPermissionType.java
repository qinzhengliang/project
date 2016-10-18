package com.zte.alm.safety.repository.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_permission_type")
public class SysPermissionType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * menu:菜单，operate：菜单,organize:组织数据权限
     */
    @Column(name = "permission_type")
    private String permissionType;

    /**
     * 权限id
     */
    @Column(name = "permission_id")
    private Long permissionId;

    @Column(name = "creation_time")
    private Date creationTime;

    @Column(name = "created_by")
    private Long createdBy;

    @Column(name = "last_update_time")
    private Date lastUpdateTime;

    @Column(name = "last_updated_by")
    private Long lastUpdatedBy;

    @Column(name = "enabled_flag")
    private Boolean enabledFlag;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取menu:菜单，operate：菜单,organize:组织数据权限
     *
     * @return permission_type - menu:菜单，operate：菜单,organize:组织数据权限
     */
    public String getPermissionType() {
        return permissionType;
    }

    /**
     * 设置menu:菜单，operate：菜单,organize:组织数据权限
     *
     * @param permissionType menu:菜单，operate：菜单,organize:组织数据权限
     */
    public void setPermissionType(String permissionType) {
        this.permissionType = permissionType == null ? null : permissionType.trim();
    }

    /**
     * 获取权限id
     *
     * @return permission_id - 权限id
     */
    public Long getPermissionId() {
        return permissionId;
    }

    /**
     * 设置权限id
     *
     * @param permissionId 权限id
     */
    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    /**
     * @return creation_time
     */
    public Date getCreationTime() {
        return creationTime;
    }

    /**
     * @param creationTime
     */
    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    /**
     * @return created_by
     */
    public Long getCreatedBy() {
        return createdBy;
    }

    /**
     * @param createdBy
     */
    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * @return last_update_time
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * @param lastUpdateTime
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    /**
     * @return last_updated_by
     */
    public Long getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    /**
     * @param lastUpdatedBy
     */
    public void setLastUpdatedBy(Long lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    /**
     * @return enabled_flag
     */
    public Boolean getEnabledFlag() {
        return enabledFlag;
    }

    /**
     * @param enabledFlag
     */
    public void setEnabledFlag(Boolean enabledFlag) {
        this.enabledFlag = enabledFlag;
    }
}