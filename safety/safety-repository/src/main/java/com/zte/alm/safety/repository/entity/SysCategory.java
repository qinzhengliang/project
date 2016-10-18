package com.zte.alm.safety.repository.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_category")
public class SysCategory {
    /**
     * 行业类别表序列Id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 行业类别代码
     */
    private String code;

    /**
     * 行业类别名称
     */
    private String name;

    /**
     * 上级行业类别Id
     */
    @Column(name = "parent_id")
    private Long parentId;

    /**
     * 行业类别描述
     */
    private String description;

    /**
     * 行业类别类型，门类、大类、中类和小类
     */
    private Long type;

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
     * 获取行业类别表序列Id
     *
     * @return id - 行业类别表序列Id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置行业类别表序列Id
     *
     * @param id 行业类别表序列Id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取行业类别代码
     *
     * @return code - 行业类别代码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置行业类别代码
     *
     * @param code 行业类别代码
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 获取行业类别名称
     *
     * @return name - 行业类别名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置行业类别名称
     *
     * @param name 行业类别名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取上级行业类别Id
     *
     * @return parent_id - 上级行业类别Id
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 设置上级行业类别Id
     *
     * @param parentId 上级行业类别Id
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取行业类别描述
     *
     * @return description - 行业类别描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置行业类别描述
     *
     * @param description 行业类别描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 获取行业类别类型，门类、大类、中类和小类
     *
     * @return type - 行业类别类型，门类、大类、中类和小类
     */
    public Long getType() {
        return type;
    }

    /**
     * 设置行业类别类型，门类、大类、中类和小类
     *
     * @param type 行业类别类型，门类、大类、中类和小类
     */
    public void setType(Long type) {
        this.type = type;
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