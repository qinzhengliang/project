package com.zte.alm.safety.repository.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_enterprise")
public class SysEnterprise {
    /**
     * 企业表序列号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 企业名称
     */
    private String name;

    /**
     * 企业简称
     */
    @Column(name = "short_name")
    private String shortName;

    /**
     * 企业所属区域Id
     */
    private Long organization;

    /**
     * 企业所属行业类别Id
     */
    private Long category;

    /**
     * 危险级别
     */
    @Column(name = "dangerous_level")
    private Long dangerousLevel;

    /**
     * 组织机构代码
     */
    private String code;

    /**
     * 主要负责人
     */
    @Column(name = "main_manager")
    private Long mainManager;

    /**
     * 主要负责人联系方式
     */
    @Column(name = "main_manager_contact")
    private String mainManagerContact;

    /**
     * 安全管理人员
     */
    @Column(name = "safety_manager")
    private Long safetyManager;

    /**
     * 安全管理人员联系方式
     */
    @Column(name = "safety_namager_contact")
    private String safetyNamagerContact;

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
     * 获取企业表序列号
     *
     * @return id - 企业表序列号
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置企业表序列号
     *
     * @param id 企业表序列号
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取企业名称
     *
     * @return name - 企业名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置企业名称
     *
     * @param name 企业名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取企业简称
     *
     * @return short_name - 企业简称
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * 设置企业简称
     *
     * @param shortName 企业简称
     */
    public void setShortName(String shortName) {
        this.shortName = shortName == null ? null : shortName.trim();
    }

    /**
     * 获取企业所属区域Id
     *
     * @return organization - 企业所属区域Id
     */
    public Long getOrganization() {
        return organization;
    }

    /**
     * 设置企业所属区域Id
     *
     * @param organization 企业所属区域Id
     */
    public void setOrganization(Long organization) {
        this.organization = organization;
    }

    /**
     * 获取企业所属行业类别Id
     *
     * @return category - 企业所属行业类别Id
     */
    public Long getCategory() {
        return category;
    }

    /**
     * 设置企业所属行业类别Id
     *
     * @param category 企业所属行业类别Id
     */
    public void setCategory(Long category) {
        this.category = category;
    }

    /**
     * 获取危险级别
     *
     * @return dangerous_level - 危险级别
     */
    public Long getDangerousLevel() {
        return dangerousLevel;
    }

    /**
     * 设置危险级别
     *
     * @param dangerousLevel 危险级别
     */
    public void setDangerousLevel(Long dangerousLevel) {
        this.dangerousLevel = dangerousLevel;
    }

    /**
     * 获取组织机构代码
     *
     * @return code - 组织机构代码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置组织机构代码
     *
     * @param code 组织机构代码
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 获取主要负责人
     *
     * @return main_manager - 主要负责人
     */
    public Long getMainManager() {
        return mainManager;
    }

    /**
     * 设置主要负责人
     *
     * @param mainManager 主要负责人
     */
    public void setMainManager(Long mainManager) {
        this.mainManager = mainManager;
    }

    /**
     * 获取主要负责人联系方式
     *
     * @return main_manager_contact - 主要负责人联系方式
     */
    public String getMainManagerContact() {
        return mainManagerContact;
    }

    /**
     * 设置主要负责人联系方式
     *
     * @param mainManagerContact 主要负责人联系方式
     */
    public void setMainManagerContact(String mainManagerContact) {
        this.mainManagerContact = mainManagerContact == null ? null : mainManagerContact.trim();
    }

    /**
     * 获取安全管理人员
     *
     * @return safety_manager - 安全管理人员
     */
    public Long getSafetyManager() {
        return safetyManager;
    }

    /**
     * 设置安全管理人员
     *
     * @param safetyManager 安全管理人员
     */
    public void setSafetyManager(Long safetyManager) {
        this.safetyManager = safetyManager;
    }

    /**
     * 获取安全管理人员联系方式
     *
     * @return safety_namager_contact - 安全管理人员联系方式
     */
    public String getSafetyNamagerContact() {
        return safetyNamagerContact;
    }

    /**
     * 设置安全管理人员联系方式
     *
     * @param safetyNamagerContact 安全管理人员联系方式
     */
    public void setSafetyNamagerContact(String safetyNamagerContact) {
        this.safetyNamagerContact = safetyNamagerContact == null ? null : safetyNamagerContact.trim();
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
}