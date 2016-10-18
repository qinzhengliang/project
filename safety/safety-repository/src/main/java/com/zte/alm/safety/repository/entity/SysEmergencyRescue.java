package com.zte.alm.safety.repository.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_emergency_rescue")
public class SysEmergencyRescue {
    /**
     * 紧急救援序列号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 事故时间
     */
    @Column(name = "accident_time")
    private Date accidentTime;

    /**
     * 事故地点
     */
    @Column(name = "accident_location")
    private String accidentLocation;

    /**
     * 救援视频
     */
    private String video;

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
     * 获取紧急救援序列号
     *
     * @return id - 紧急救援序列号
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置紧急救援序列号
     *
     * @param id 紧急救援序列号
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取事故时间
     *
     * @return accident_time - 事故时间
     */
    public Date getAccidentTime() {
        return accidentTime;
    }

    /**
     * 设置事故时间
     *
     * @param accidentTime 事故时间
     */
    public void setAccidentTime(Date accidentTime) {
        this.accidentTime = accidentTime;
    }

    /**
     * 获取事故地点
     *
     * @return accident_location - 事故地点
     */
    public String getAccidentLocation() {
        return accidentLocation;
    }

    /**
     * 设置事故地点
     *
     * @param accidentLocation 事故地点
     */
    public void setAccidentLocation(String accidentLocation) {
        this.accidentLocation = accidentLocation == null ? null : accidentLocation.trim();
    }

    /**
     * 获取救援视频
     *
     * @return video - 救援视频
     */
    public String getVideo() {
        return video;
    }

    /**
     * 设置救援视频
     *
     * @param video 救援视频
     */
    public void setVideo(String video) {
        this.video = video == null ? null : video.trim();
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