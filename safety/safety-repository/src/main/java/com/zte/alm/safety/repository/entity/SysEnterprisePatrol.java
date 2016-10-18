package com.zte.alm.safety.repository.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_enterprise_patrol")
public class SysEnterprisePatrol {
    /**
     * 企业巡更隐患表序列Id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 企业序列Id
     */
    @Column(name = "enterprise_id")
    private Long enterpriseId;

    /**
     * 巡更时间
     */
    @Column(name = "patrol_time")
    private Date patrolTime;

    /**
     * 巡更地点经纬度
     */
    @Column(name = "patrol_location")
    private String patrolLocation;

    /**
     * 巡更点
     */
    @Column(name = "patrol_point")
    private Long patrolPoint;

    /**
     * 巡更点自拍照片
     */
    @Column(name = "patrol_photo")
    private String patrolPhoto;

    /**
     * 巡更人
     */
    @Column(name = "patrol_man")
    private Long patrolMan;

    /**
     * 巡更问题情况
     */
    @Column(name = "patrol_problem")
    private String patrolProblem;

    /**
     * 巡更问题图片
     */
    @Column(name = "problem_photo")
    private String problemPhoto;

    /**
     * 问题整改情况
     */
    @Column(name = "problem_handling")
    private String problemHandling;

    /**
     * 问题整改图片
     */
    @Column(name = "handling_photo")
    private String handlingPhoto;

    /**
     * 整改时间
     */
    @Column(name = "handling_time")
    private Date handlingTime;

    /**
     * 巡更单据状态，字典中定义
     */
    private Long status;

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
     * 获取企业巡更隐患表序列Id
     *
     * @return id - 企业巡更隐患表序列Id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置企业巡更隐患表序列Id
     *
     * @param id 企业巡更隐患表序列Id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取企业序列Id
     *
     * @return enterprise_id - 企业序列Id
     */
    public Long getEnterpriseId() {
        return enterpriseId;
    }

    /**
     * 设置企业序列Id
     *
     * @param enterpriseId 企业序列Id
     */
    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    /**
     * 获取巡更时间
     *
     * @return patrol_time - 巡更时间
     */
    public Date getPatrolTime() {
        return patrolTime;
    }

    /**
     * 设置巡更时间
     *
     * @param patrolTime 巡更时间
     */
    public void setPatrolTime(Date patrolTime) {
        this.patrolTime = patrolTime;
    }

    /**
     * 获取巡更地点经纬度
     *
     * @return patrol_location - 巡更地点经纬度
     */
    public String getPatrolLocation() {
        return patrolLocation;
    }

    /**
     * 设置巡更地点经纬度
     *
     * @param patrolLocation 巡更地点经纬度
     */
    public void setPatrolLocation(String patrolLocation) {
        this.patrolLocation = patrolLocation == null ? null : patrolLocation.trim();
    }

    /**
     * 获取巡更点
     *
     * @return patrol_point - 巡更点
     */
    public Long getPatrolPoint() {
        return patrolPoint;
    }

    /**
     * 设置巡更点
     *
     * @param patrolPoint 巡更点
     */
    public void setPatrolPoint(Long patrolPoint) {
        this.patrolPoint = patrolPoint;
    }

    /**
     * 获取巡更点自拍照片
     *
     * @return patrol_photo - 巡更点自拍照片
     */
    public String getPatrolPhoto() {
        return patrolPhoto;
    }

    /**
     * 设置巡更点自拍照片
     *
     * @param patrolPhoto 巡更点自拍照片
     */
    public void setPatrolPhoto(String patrolPhoto) {
        this.patrolPhoto = patrolPhoto == null ? null : patrolPhoto.trim();
    }

    /**
     * 获取巡更人
     *
     * @return patrol_man - 巡更人
     */
    public Long getPatrolMan() {
        return patrolMan;
    }

    /**
     * 设置巡更人
     *
     * @param patrolMan 巡更人
     */
    public void setPatrolMan(Long patrolMan) {
        this.patrolMan = patrolMan;
    }

    /**
     * 获取巡更问题情况
     *
     * @return patrol_problem - 巡更问题情况
     */
    public String getPatrolProblem() {
        return patrolProblem;
    }

    /**
     * 设置巡更问题情况
     *
     * @param patrolProblem 巡更问题情况
     */
    public void setPatrolProblem(String patrolProblem) {
        this.patrolProblem = patrolProblem == null ? null : patrolProblem.trim();
    }

    /**
     * 获取巡更问题图片
     *
     * @return problem_photo - 巡更问题图片
     */
    public String getProblemPhoto() {
        return problemPhoto;
    }

    /**
     * 设置巡更问题图片
     *
     * @param problemPhoto 巡更问题图片
     */
    public void setProblemPhoto(String problemPhoto) {
        this.problemPhoto = problemPhoto == null ? null : problemPhoto.trim();
    }

    /**
     * 获取问题整改情况
     *
     * @return problem_handling - 问题整改情况
     */
    public String getProblemHandling() {
        return problemHandling;
    }

    /**
     * 设置问题整改情况
     *
     * @param problemHandling 问题整改情况
     */
    public void setProblemHandling(String problemHandling) {
        this.problemHandling = problemHandling == null ? null : problemHandling.trim();
    }

    /**
     * 获取问题整改图片
     *
     * @return handling_photo - 问题整改图片
     */
    public String getHandlingPhoto() {
        return handlingPhoto;
    }

    /**
     * 设置问题整改图片
     *
     * @param handlingPhoto 问题整改图片
     */
    public void setHandlingPhoto(String handlingPhoto) {
        this.handlingPhoto = handlingPhoto == null ? null : handlingPhoto.trim();
    }

    /**
     * 获取整改时间
     *
     * @return handling_time - 整改时间
     */
    public Date getHandlingTime() {
        return handlingTime;
    }

    /**
     * 设置整改时间
     *
     * @param handlingTime 整改时间
     */
    public void setHandlingTime(Date handlingTime) {
        this.handlingTime = handlingTime;
    }

    /**
     * 获取巡更单据状态，字典中定义
     *
     * @return status - 巡更单据状态，字典中定义
     */
    public Long getStatus() {
        return status;
    }

    /**
     * 设置巡更单据状态，字典中定义
     *
     * @param status 巡更单据状态，字典中定义
     */
    public void setStatus(Long status) {
        this.status = status;
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