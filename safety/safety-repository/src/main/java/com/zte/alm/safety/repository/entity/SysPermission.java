package com.zte.alm.safety.repository.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_permission")
public class SysPermission {
    /**
     * 权限资源Id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 资源名称
     */
    private String name;

    /**
     * 权限类型:菜单权限,功能权限,数据权限等
     */
    private String type;

    /**
     * 权限标识
     */
    private String sn;

    /**
     * 资源描述
     */
    private String description;

    /**
     * 所属模块
     */
    @Column(name = "model_id")
    private Long modelId;

    /**
     * 资源
     */
    @Column(name = "model_sn")
    private String modelSn;

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
     * 获取权限资源Id
     *
     * @return id - 权限资源Id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置权限资源Id
     *
     * @param id 权限资源Id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取资源名称
     *
     * @return name - 资源名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置资源名称
     *
     * @param name 资源名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取权限类型:菜单权限,功能权限,数据权限等
     *
     * @return type - 权限类型:菜单权限,功能权限,数据权限等
     */
    public String getType() {
        return type;
    }

    /**
     * 设置权限类型:菜单权限,功能权限,数据权限等
     *
     * @param type 权限类型:菜单权限,功能权限,数据权限等
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 获取权限标识
     *
     * @return sn - 权限标识
     */
    public String getSn() {
        return sn;
    }

    /**
     * 设置权限标识
     *
     * @param sn 权限标识
     */
    public void setSn(String sn) {
        this.sn = sn == null ? null : sn.trim();
    }

    /**
     * 获取资源描述
     *
     * @return description - 资源描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置资源描述
     *
     * @param description 资源描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 获取所属模块
     *
     * @return model_id - 所属模块
     */
    public Long getModelId() {
        return modelId;
    }

    /**
     * 设置所属模块
     *
     * @param modelId 所属模块
     */
    public void setModelId(Long modelId) {
        this.modelId = modelId;
    }

    /**
     * 获取资源
     *
     * @return model_sn - 资源
     */
    public String getModelSn() {
        return modelSn;
    }

    /**
     * 设置资源
     *
     * @param modelSn 资源
     */
    public void setModelSn(String modelSn) {
        this.modelSn = modelSn == null ? null : modelSn.trim();
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