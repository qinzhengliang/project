package com.zte.alm.safety.repository.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_organization_role")
public class SysOrganizationRole {
    /**
     * 组织角色Id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 组织ID
     */
    @Column(name = "organization_id")
    private Long organizationId;

    /**
     * 角色Id
     */
    @Column(name = "role_id")
    private Long roleId;

    /**
     * 优先级
     */
    private Integer priority;

    /**
     * 描述
     */
    private String description;

    /**
     * 创建时间
     */
    @Column(name = "creation_time")
    private Date creationTime;

    /**
     * 创建人
     */
    @Column(name = "created_by")
    private Long createdBy;

    /**
     * 最后更新时间
     */
    @Column(name = "last_update_time")
    private Date lastUpdateTime;

    /**
     * 最后更新人
     */
    @Column(name = "last_updated_by")
    private Long lastUpdatedBy;

    /**
     * 启用状态，1表示启用；0表示不启用
     */
    @Column(name = "enabled_flag")
    private Boolean enabledFlag;

    /**
     * 获取组织角色Id
     *
     * @return id - 组织角色Id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置组织角色Id
     *
     * @param id 组织角色Id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取组织ID
     *
     * @return organization_id - 组织ID
     */
    public Long getOrganizationId() {
        return organizationId;
    }

    /**
     * 设置组织ID
     *
     * @param organizationId 组织ID
     */
    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    /**
     * 获取角色Id
     *
     * @return role_id - 角色Id
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * 设置角色Id
     *
     * @param roleId 角色Id
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取优先级
     *
     * @return priority - 优先级
     */
    public Integer getPriority() {
        return priority;
    }

    /**
     * 设置优先级
     *
     * @param priority 优先级
     */
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    /**
     * 获取描述
     *
     * @return description - 描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置描述
     *
     * @param description 描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 获取创建时间
     *
     * @return creation_time - 创建时间
     */
    public Date getCreationTime() {
        return creationTime;
    }

    /**
     * 设置创建时间
     *
     * @param creationTime 创建时间
     */
    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    /**
     * 获取创建人
     *
     * @return created_by - 创建人
     */
    public Long getCreatedBy() {
        return createdBy;
    }

    /**
     * 设置创建人
     *
     * @param createdBy 创建人
     */
    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * 获取最后更新时间
     *
     * @return last_update_time - 最后更新时间
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * 设置最后更新时间
     *
     * @param lastUpdateTime 最后更新时间
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    /**
     * 获取最后更新人
     *
     * @return last_updated_by - 最后更新人
     */
    public Long getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    /**
     * 设置最后更新人
     *
     * @param lastUpdatedBy 最后更新人
     */
    public void setLastUpdatedBy(Long lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    /**
     * 获取启用状态，1表示启用；0表示不启用
     *
     * @return enabled_flag - 启用状态，1表示启用；0表示不启用
     */
    public Boolean getEnabledFlag() {
        return enabledFlag;
    }

    /**
     * 设置启用状态，1表示启用；0表示不启用
     *
     * @param enabledFlag 启用状态，1表示启用；0表示不启用
     */
    public void setEnabledFlag(Boolean enabledFlag) {
        this.enabledFlag = enabledFlag;
    }
}