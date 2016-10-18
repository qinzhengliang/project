package com.zte.alm.safety.repository.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_rescue_expert")
public class SysRescueExpert {
    /**
     * 应急专家序列号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 专家姓名
     */
    private String name;

    /**
     * 专家类别
     */
    private Long type;

    /**
     * 所属区域
     */
    private Long organization;

    /**
     * 性别
     */
    private Boolean sex;

    /**
     * 移动电话
     */
    private String phone;

    /**
     * 工作单位
     */
    private String company;

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
     * 获取应急专家序列号
     *
     * @return id - 应急专家序列号
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置应急专家序列号
     *
     * @param id 应急专家序列号
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取专家姓名
     *
     * @return name - 专家姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置专家姓名
     *
     * @param name 专家姓名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取专家类别
     *
     * @return type - 专家类别
     */
    public Long getType() {
        return type;
    }

    /**
     * 设置专家类别
     *
     * @param type 专家类别
     */
    public void setType(Long type) {
        this.type = type;
    }

    /**
     * 获取所属区域
     *
     * @return organization - 所属区域
     */
    public Long getOrganization() {
        return organization;
    }

    /**
     * 设置所属区域
     *
     * @param organization 所属区域
     */
    public void setOrganization(Long organization) {
        this.organization = organization;
    }

    /**
     * 获取性别
     *
     * @return sex - 性别
     */
    public Boolean getSex() {
        return sex;
    }

    /**
     * 设置性别
     *
     * @param sex 性别
     */
    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    /**
     * 获取移动电话
     *
     * @return phone - 移动电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置移动电话
     *
     * @param phone 移动电话
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 获取工作单位
     *
     * @return company - 工作单位
     */
    public String getCompany() {
        return company;
    }

    /**
     * 设置工作单位
     *
     * @param company 工作单位
     */
    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
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