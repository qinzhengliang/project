package com.zte.alm.safety.repository.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_menu")
public class SysMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 菜单名称
     */
    @Column(name = "cn_name")
    private String cnName;

    /**
     * 菜单英文名称
     */
    @Column(name = "en_name")
    private String enName;

    /**
     * 描述
     */
    private String description;

    /**
     * 优先级，用于菜单排序
     */
    private Integer priority;

    /**
     * 菜单标识
     */
    private String sn;

    /**
     * 菜单url
     */
    private String url;

    /**
     * 父级
     */
    @Column(name = "parent_id")
    private Long parentId;

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
     * 菜单前图标
     */
    @Column(name = "class_name")
    private String className;

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
     * 获取菜单名称
     *
     * @return cn_name - 菜单名称
     */
    public String getCnName() {
        return cnName;
    }

    /**
     * 设置菜单名称
     *
     * @param cnName 菜单名称
     */
    public void setCnName(String cnName) {
        this.cnName = cnName == null ? null : cnName.trim();
    }

    /**
     * 获取菜单英文名称
     *
     * @return en_name - 菜单英文名称
     */
    public String getEnName() {
        return enName;
    }

    /**
     * 设置菜单英文名称
     *
     * @param enName 菜单英文名称
     */
    public void setEnName(String enName) {
        this.enName = enName == null ? null : enName.trim();
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
     * 获取优先级，用于菜单排序
     *
     * @return priority - 优先级，用于菜单排序
     */
    public Integer getPriority() {
        return priority;
    }

    /**
     * 设置优先级，用于菜单排序
     *
     * @param priority 优先级，用于菜单排序
     */
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    /**
     * 获取菜单标识
     *
     * @return sn - 菜单标识
     */
    public String getSn() {
        return sn;
    }

    /**
     * 设置菜单标识
     *
     * @param sn 菜单标识
     */
    public void setSn(String sn) {
        this.sn = sn == null ? null : sn.trim();
    }

    /**
     * 获取菜单url
     *
     * @return url - 菜单url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置菜单url
     *
     * @param url 菜单url
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 获取父级
     *
     * @return parent_id - 父级
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 设置父级
     *
     * @param parentId 父级
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
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
     * 获取菜单前图标
     *
     * @return class_name - 菜单前图标
     */
    public String getClassName() {
        return className;
    }

    /**
     * 设置菜单前图标
     *
     * @param className 菜单前图标
     */
    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }
}