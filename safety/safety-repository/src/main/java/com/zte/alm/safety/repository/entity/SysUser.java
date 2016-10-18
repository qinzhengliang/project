package com.zte.alm.safety.repository.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_user")
public class SysUser {
    /**
     * 用户表序列
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 登录用户名
     */
    @Id
    private String name;

    /**
     * 系统显示用户名
     */
    @Column(name = "display_name")
    private String displayName;

    /**
     * 登录密码加密值
     */
    private String password;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 用户手机号
     */
    private String phone;

    /**
     * 用户状态，配置在字典中
     */
    private Long status;

    /**
     * 用户类型，配置在字典中，企业用户、安监站用户
     */
    private Long type;

    /**
     * 用户所属组织，用户数据隔离，企业用户只能查看本企业数据
     */
    private Long organization;

    /**
     * 所属企业
     */
    private Long enterprise;

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
     * 获取用户表序列
     *
     * @return id - 用户表序列
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置用户表序列
     *
     * @param id 用户表序列
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取登录用户名
     *
     * @return name - 登录用户名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置登录用户名
     *
     * @param name 登录用户名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取系统显示用户名
     *
     * @return display_name - 系统显示用户名
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * 设置系统显示用户名
     *
     * @param displayName 系统显示用户名
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName == null ? null : displayName.trim();
    }

    /**
     * 获取登录密码加密值
     *
     * @return password - 登录密码加密值
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置登录密码加密值
     *
     * @param password 登录密码加密值
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取用户邮箱
     *
     * @return email - 用户邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置用户邮箱
     *
     * @param email 用户邮箱
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 获取用户手机号
     *
     * @return phone - 用户手机号
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置用户手机号
     *
     * @param phone 用户手机号
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 获取用户状态，配置在字典中
     *
     * @return status - 用户状态，配置在字典中
     */
    public Long getStatus() {
        return status;
    }

    /**
     * 设置用户状态，配置在字典中
     *
     * @param status 用户状态，配置在字典中
     */
    public void setStatus(Long status) {
        this.status = status;
    }

    /**
     * 获取用户类型，配置在字典中，企业用户、安监站用户
     *
     * @return type - 用户类型，配置在字典中，企业用户、安监站用户
     */
    public Long getType() {
        return type;
    }

    /**
     * 设置用户类型，配置在字典中，企业用户、安监站用户
     *
     * @param type 用户类型，配置在字典中，企业用户、安监站用户
     */
    public void setType(Long type) {
        this.type = type;
    }

    /**
     * 获取用户所属组织，用户数据隔离，企业用户只能查看本企业数据
     *
     * @return organization - 用户所属组织，用户数据隔离，企业用户只能查看本企业数据
     */
    public Long getOrganization() {
        return organization;
    }

    /**
     * 设置用户所属组织，用户数据隔离，企业用户只能查看本企业数据
     *
     * @param organization 用户所属组织，用户数据隔离，企业用户只能查看本企业数据
     */
    public void setOrganization(Long organization) {
        this.organization = organization;
    }

    /**
     * 获取所属企业
     *
     * @return enterprise - 所属企业
     */
    public Long getEnterprise() {
        return enterprise;
    }

    /**
     * 设置所属企业
     *
     * @param enterprise 所属企业
     */
    public void setEnterprise(Long enterprise) {
        this.enterprise = enterprise;
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