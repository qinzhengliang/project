package com.zte.alm.safety.repository.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_organization")
public class SysOrganization {
    /**
     * 组织表序列
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 组织名称
     */
    private String name;

    /**
     * 组织类型，字典中定义
     */
    private Long type;

    /**
     * 组织描述
     */
    private String description;

    /**
     * 上级组织序列号
     */
    @Column(name = "parent_id")
    private Long parentId;

    /**
     * 组织完整名称路径
     */
    @Column(name = "full_name")
    private String fullName;

    /**
     * 组织完整Id路径
     */
    @Column(name = "full_id")
    private String fullId;

    /**
     * 经度
     */
    private String longitude;

    /**
     * 维度
     */
    private String latitude;

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
     * 优先级
     */
    private Integer priority;

    /**
     * 获取组织表序列
     *
     * @return id - 组织表序列
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置组织表序列
     *
     * @param id 组织表序列
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取组织名称
     *
     * @return name - 组织名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置组织名称
     *
     * @param name 组织名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取组织类型，字典中定义
     *
     * @return type - 组织类型，字典中定义
     */
    public Long getType() {
        return type;
    }

    /**
     * 设置组织类型，字典中定义
     *
     * @param type 组织类型，字典中定义
     */
    public void setType(Long type) {
        this.type = type;
    }

    /**
     * 获取组织描述
     *
     * @return description - 组织描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置组织描述
     *
     * @param description 组织描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 获取上级组织序列号
     *
     * @return parent_id - 上级组织序列号
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 设置上级组织序列号
     *
     * @param parentId 上级组织序列号
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取组织完整名称路径
     *
     * @return full_name - 组织完整名称路径
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * 设置组织完整名称路径
     *
     * @param fullName 组织完整名称路径
     */
    public void setFullName(String fullName) {
        this.fullName = fullName == null ? null : fullName.trim();
    }

    /**
     * 获取组织完整Id路径
     *
     * @return full_id - 组织完整Id路径
     */
    public String getFullId() {
        return fullId;
    }

    /**
     * 设置组织完整Id路径
     *
     * @param fullId 组织完整Id路径
     */
    public void setFullId(String fullId) {
        this.fullId = fullId == null ? null : fullId.trim();
    }

    /**
     * 获取经度
     *
     * @return longitude - 经度
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * 设置经度
     *
     * @param longitude 经度
     */
    public void setLongitude(String longitude) {
        this.longitude = longitude == null ? null : longitude.trim();
    }

    /**
     * 获取维度
     *
     * @return latitude - 维度
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * 设置维度
     *
     * @param latitude 维度
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
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
}