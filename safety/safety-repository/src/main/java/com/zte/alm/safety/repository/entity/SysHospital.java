package com.zte.alm.safety.repository.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_hospital")
public class SysHospital {
    /**
     * 医院序列号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 医院名称
     */
    private String name;

    /**
     * 地址
     */
    private String address;

    /**
     * 所属区域
     */
    private Long organization;

    /**
     * 医疗机构等级
     */
    private Long grade;

    /**
     * 主要负责人
     */
    private String manager;

    /**
     * 主要负责人联系方式
     */
    @Column(name = "manager_contact")
    private String managerContact;

    /**
     * 事故救援负责人
     */
    @Column(name = "rescue_manager")
    private String rescueManager;

    /**
     * 事故救援负责人联系方式
     */
    @Column(name = "rescue_manager_contact")
    private String rescueManagerContact;

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
     * 获取医院序列号
     *
     * @return id - 医院序列号
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置医院序列号
     *
     * @param id 医院序列号
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取医院名称
     *
     * @return name - 医院名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置医院名称
     *
     * @param name 医院名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取地址
     *
     * @return address - 地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置地址
     *
     * @param address 地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
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
     * 获取医疗机构等级
     *
     * @return grade - 医疗机构等级
     */
    public Long getGrade() {
        return grade;
    }

    /**
     * 设置医疗机构等级
     *
     * @param grade 医疗机构等级
     */
    public void setGrade(Long grade) {
        this.grade = grade;
    }

    /**
     * 获取主要负责人
     *
     * @return manager - 主要负责人
     */
    public String getManager() {
        return manager;
    }

    /**
     * 设置主要负责人
     *
     * @param manager 主要负责人
     */
    public void setManager(String manager) {
        this.manager = manager == null ? null : manager.trim();
    }

    /**
     * 获取主要负责人联系方式
     *
     * @return manager_contact - 主要负责人联系方式
     */
    public String getManagerContact() {
        return managerContact;
    }

    /**
     * 设置主要负责人联系方式
     *
     * @param managerContact 主要负责人联系方式
     */
    public void setManagerContact(String managerContact) {
        this.managerContact = managerContact == null ? null : managerContact.trim();
    }

    /**
     * 获取事故救援负责人
     *
     * @return rescue_manager - 事故救援负责人
     */
    public String getRescueManager() {
        return rescueManager;
    }

    /**
     * 设置事故救援负责人
     *
     * @param rescueManager 事故救援负责人
     */
    public void setRescueManager(String rescueManager) {
        this.rescueManager = rescueManager == null ? null : rescueManager.trim();
    }

    /**
     * 获取事故救援负责人联系方式
     *
     * @return rescue_manager_contact - 事故救援负责人联系方式
     */
    public String getRescueManagerContact() {
        return rescueManagerContact;
    }

    /**
     * 设置事故救援负责人联系方式
     *
     * @param rescueManagerContact 事故救援负责人联系方式
     */
    public void setRescueManagerContact(String rescueManagerContact) {
        this.rescueManagerContact = rescueManagerContact == null ? null : rescueManagerContact.trim();
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