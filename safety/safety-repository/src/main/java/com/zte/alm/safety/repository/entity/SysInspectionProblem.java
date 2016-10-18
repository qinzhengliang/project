package com.zte.alm.safety.repository.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_inspection_problem")
public class SysInspectionProblem {
    /**
     * 督查隐患序列号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 被督察企业
     */
    private Long enterprise;

    /**
     * 发现时间
     */
    @Column(name = "discover_time")
    private Date discoverTime;

    /**
     * 违法行为
     */
    @Column(name = "illegal_action")
    private String illegalAction;

    /**
     * 违法行为照片
     */
    @Column(name = "illegal_photo")
    private String illegalPhoto;

    /**
     * 所属区域
     */
    private Long organization;

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
     * 获取督查隐患序列号
     *
     * @return id - 督查隐患序列号
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置督查隐患序列号
     *
     * @param id 督查隐患序列号
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取被督察企业
     *
     * @return enterprise - 被督察企业
     */
    public Long getEnterprise() {
        return enterprise;
    }

    /**
     * 设置被督察企业
     *
     * @param enterprise 被督察企业
     */
    public void setEnterprise(Long enterprise) {
        this.enterprise = enterprise;
    }

    /**
     * 获取发现时间
     *
     * @return discover_time - 发现时间
     */
    public Date getDiscoverTime() {
        return discoverTime;
    }

    /**
     * 设置发现时间
     *
     * @param discoverTime 发现时间
     */
    public void setDiscoverTime(Date discoverTime) {
        this.discoverTime = discoverTime;
    }

    /**
     * 获取违法行为
     *
     * @return illegal_action - 违法行为
     */
    public String getIllegalAction() {
        return illegalAction;
    }

    /**
     * 设置违法行为
     *
     * @param illegalAction 违法行为
     */
    public void setIllegalAction(String illegalAction) {
        this.illegalAction = illegalAction == null ? null : illegalAction.trim();
    }

    /**
     * 获取违法行为照片
     *
     * @return illegal_photo - 违法行为照片
     */
    public String getIllegalPhoto() {
        return illegalPhoto;
    }

    /**
     * 设置违法行为照片
     *
     * @param illegalPhoto 违法行为照片
     */
    public void setIllegalPhoto(String illegalPhoto) {
        this.illegalPhoto = illegalPhoto == null ? null : illegalPhoto.trim();
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