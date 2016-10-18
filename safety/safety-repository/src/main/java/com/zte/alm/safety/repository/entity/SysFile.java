package com.zte.alm.safety.repository.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_file")
public class SysFile {
    /**
     * 系统文件表序列Id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 文件名称
     */
    private String name;

    /**
     * 文件完整名称
     */
    @Column(name = "full_name")
    private String fullName;

    /**
     * 文件格式
     */
    private String format;

    /**
     * 文件大小
     */
    private Integer size;

    /**
     * 文件所在服务器
     */
    private String server;

    /**
     * 文件访问路径
     */
    private String path;

    /**
     * 系统文件名称
     */
    @Column(name = "sys_name")
    private String sysName;

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
     * 获取系统文件表序列Id
     *
     * @return id - 系统文件表序列Id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置系统文件表序列Id
     *
     * @param id 系统文件表序列Id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取文件名称
     *
     * @return name - 文件名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置文件名称
     *
     * @param name 文件名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取文件完整名称
     *
     * @return full_name - 文件完整名称
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * 设置文件完整名称
     *
     * @param fullName 文件完整名称
     */
    public void setFullName(String fullName) {
        this.fullName = fullName == null ? null : fullName.trim();
    }

    /**
     * 获取文件格式
     *
     * @return format - 文件格式
     */
    public String getFormat() {
        return format;
    }

    /**
     * 设置文件格式
     *
     * @param format 文件格式
     */
    public void setFormat(String format) {
        this.format = format == null ? null : format.trim();
    }

    /**
     * 获取文件大小
     *
     * @return size - 文件大小
     */
    public Integer getSize() {
        return size;
    }

    /**
     * 设置文件大小
     *
     * @param size 文件大小
     */
    public void setSize(Integer size) {
        this.size = size;
    }

    /**
     * 获取文件所在服务器
     *
     * @return server - 文件所在服务器
     */
    public String getServer() {
        return server;
    }

    /**
     * 设置文件所在服务器
     *
     * @param server 文件所在服务器
     */
    public void setServer(String server) {
        this.server = server == null ? null : server.trim();
    }

    /**
     * 获取文件访问路径
     *
     * @return path - 文件访问路径
     */
    public String getPath() {
        return path;
    }

    /**
     * 设置文件访问路径
     *
     * @param path 文件访问路径
     */
    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    /**
     * 获取系统文件名称
     *
     * @return sys_name - 系统文件名称
     */
    public String getSysName() {
        return sysName;
    }

    /**
     * 设置系统文件名称
     *
     * @param sysName 系统文件名称
     */
    public void setSysName(String sysName) {
        this.sysName = sysName == null ? null : sysName.trim();
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