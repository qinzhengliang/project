package com.zte.alm.safety.repository.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_rescue_materials")
public class SysRescueMaterials {
    /**
     * 应急物资序列号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 物资名称
     */
    private String name;

    /**
     * 企业名称
     */
    private String company;

    /**
     * 地址
     */
    private String address;

    /**
     * 负责人
     */
    private String manager;

    /**
     * 负责人联系方式
     */
    @Column(name = "manager_contact")
    private String managerContact;

    /**
     * 所属区域
     */
    private Long organization;

    /**
     * 物资装备类别
     */
    private Long type;

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
     * 获取应急物资序列号
     *
     * @return id - 应急物资序列号
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置应急物资序列号
     *
     * @param id 应急物资序列号
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取物资名称
     *
     * @return name - 物资名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置物资名称
     *
     * @param name 物资名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取企业名称
     *
     * @return company - 企业名称
     */
    public String getCompany() {
        return company;
    }

    /**
     * 设置企业名称
     *
     * @param company 企业名称
     */
    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
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
     * 获取负责人
     *
     * @return manager - 负责人
     */
    public String getManager() {
        return manager;
    }

    /**
     * 设置负责人
     *
     * @param manager 负责人
     */
    public void setManager(String manager) {
        this.manager = manager == null ? null : manager.trim();
    }

    /**
     * 获取负责人联系方式
     *
     * @return manager_contact - 负责人联系方式
     */
    public String getManagerContact() {
        return managerContact;
    }

    /**
     * 设置负责人联系方式
     *
     * @param managerContact 负责人联系方式
     */
    public void setManagerContact(String managerContact) {
        this.managerContact = managerContact == null ? null : managerContact.trim();
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
     * 获取物资装备类别
     *
     * @return type - 物资装备类别
     */
    public Long getType() {
        return type;
    }

    /**
     * 设置物资装备类别
     *
     * @param type 物资装备类别
     */
    public void setType(Long type) {
        this.type = type;
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