package com.zte.alm.safety.repository.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_inspection")
public class SysInspection {
    /**
     * 督查单序列号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 督查时间
     */
    @Column(name = "inspection_time")
    private Date inspectionTime;

    /**
     * 督查人
     */
    private Long inspector;

    /**
     * 督查人科室
     */
    private Long department;

    /**
     * 督查项目
     */
    private String project;

    /**
     * 被督察企业Id
     */
    private Long enterprise;

    /**
     * 安全巡查人员
     */
    @Column(name = "safety_manager")
    private Long safetyManager;

    /**
     * 安全巡查人员手机号
     */
    @Column(name = "safety_manager_contact")
    private String safetyManagerContact;

    /**
     * 督查视频,只有一个可直接关联File
     */
    private Long video;

    /**
     * 备注
     */
    private String mark;

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
     * 获取督查单序列号
     *
     * @return id - 督查单序列号
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置督查单序列号
     *
     * @param id 督查单序列号
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取督查时间
     *
     * @return inspection_time - 督查时间
     */
    public Date getInspectionTime() {
        return inspectionTime;
    }

    /**
     * 设置督查时间
     *
     * @param inspectionTime 督查时间
     */
    public void setInspectionTime(Date inspectionTime) {
        this.inspectionTime = inspectionTime;
    }

    /**
     * 获取督查人
     *
     * @return inspector - 督查人
     */
    public Long getInspector() {
        return inspector;
    }

    /**
     * 设置督查人
     *
     * @param inspector 督查人
     */
    public void setInspector(Long inspector) {
        this.inspector = inspector;
    }

    /**
     * 获取督查人科室
     *
     * @return department - 督查人科室
     */
    public Long getDepartment() {
        return department;
    }

    /**
     * 设置督查人科室
     *
     * @param department 督查人科室
     */
    public void setDepartment(Long department) {
        this.department = department;
    }

    /**
     * 获取督查项目
     *
     * @return project - 督查项目
     */
    public String getProject() {
        return project;
    }

    /**
     * 设置督查项目
     *
     * @param project 督查项目
     */
    public void setProject(String project) {
        this.project = project == null ? null : project.trim();
    }

    /**
     * 获取被督察企业Id
     *
     * @return enterprise - 被督察企业Id
     */
    public Long getEnterprise() {
        return enterprise;
    }

    /**
     * 设置被督察企业Id
     *
     * @param enterprise 被督察企业Id
     */
    public void setEnterprise(Long enterprise) {
        this.enterprise = enterprise;
    }

    /**
     * 获取安全巡查人员
     *
     * @return safety_manager - 安全巡查人员
     */
    public Long getSafetyManager() {
        return safetyManager;
    }

    /**
     * 设置安全巡查人员
     *
     * @param safetyManager 安全巡查人员
     */
    public void setSafetyManager(Long safetyManager) {
        this.safetyManager = safetyManager;
    }

    /**
     * 获取安全巡查人员手机号
     *
     * @return safety_manager_contact - 安全巡查人员手机号
     */
    public String getSafetyManagerContact() {
        return safetyManagerContact;
    }

    /**
     * 设置安全巡查人员手机号
     *
     * @param safetyManagerContact 安全巡查人员手机号
     */
    public void setSafetyManagerContact(String safetyManagerContact) {
        this.safetyManagerContact = safetyManagerContact == null ? null : safetyManagerContact.trim();
    }

    /**
     * 获取督查视频,只有一个可直接关联File
     *
     * @return video - 督查视频,只有一个可直接关联File
     */
    public Long getVideo() {
        return video;
    }

    /**
     * 设置督查视频,只有一个可直接关联File
     *
     * @param video 督查视频,只有一个可直接关联File
     */
    public void setVideo(Long video) {
        this.video = video;
    }

    /**
     * 获取备注
     *
     * @return mark - 备注
     */
    public String getMark() {
        return mark;
    }

    /**
     * 设置备注
     *
     * @param mark 备注
     */
    public void setMark(String mark) {
        this.mark = mark == null ? null : mark.trim();
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