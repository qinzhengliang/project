package com.zte.alm.safety.repository.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_patrol_point")
public class SysPatrolPoint {
    /**
     * 巡更点序列号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 巡更点名称
     */
    private String name;

    /**
     * 巡更点编号
     */
    private String code;

    /**
     * 巡更点位置
     */
    private String location;

    /**
     * 巡更内容
     */
    private String content;

    /**
     * 描述信息
     */
    private String description;

    /**
     * 经度
     */
    private String longitude;

    /**
     * 维度
     */
    private String lantitute;

    /**
     * 所属企业Id
     */
    @Column(name = "enterprise_id")
    private Long enterpriseId;

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
     * 获取巡更点序列号
     *
     * @return id - 巡更点序列号
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置巡更点序列号
     *
     * @param id 巡更点序列号
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取巡更点名称
     *
     * @return name - 巡更点名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置巡更点名称
     *
     * @param name 巡更点名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取巡更点编号
     *
     * @return code - 巡更点编号
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置巡更点编号
     *
     * @param code 巡更点编号
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 获取巡更点位置
     *
     * @return location - 巡更点位置
     */
    public String getLocation() {
        return location;
    }

    /**
     * 设置巡更点位置
     *
     * @param location 巡更点位置
     */
    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    /**
     * 获取巡更内容
     *
     * @return content - 巡更内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置巡更内容
     *
     * @param content 巡更内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 获取描述信息
     *
     * @return description - 描述信息
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置描述信息
     *
     * @param description 描述信息
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
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
     * @return lantitute - 维度
     */
    public String getLantitute() {
        return lantitute;
    }

    /**
     * 设置维度
     *
     * @param lantitute 维度
     */
    public void setLantitute(String lantitute) {
        this.lantitute = lantitute == null ? null : lantitute.trim();
    }

    /**
     * 获取所属企业Id
     *
     * @return enterprise_id - 所属企业Id
     */
    public Long getEnterpriseId() {
        return enterpriseId;
    }

    /**
     * 设置所属企业Id
     *
     * @param enterpriseId 所属企业Id
     */
    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
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