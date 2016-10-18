package com.zte.alm.safety.repository.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_production_safety_credit")
public class SysProductionSafetyCredit {
    /**
     * 安全生产诚信序列号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 类型，企业和个人
     */
    private Boolean type;

    /**
     * 用户Id
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 企业Id
     */
    @Column(name = "enterprise_id")
    private Long enterpriseId;

    /**
     * 信用分
     */
    @Column(name = "credit_score")
    private Integer creditScore;

    /**
     * 是否约谈，1为约谈,0为非约谈
     */
    @Column(name = "touch_round")
    private Boolean touchRound;

    /**
     * 一票否决，1为否决,0为非否决
     */
    @Column(name = "one_vote")
    private Boolean oneVote;

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
     * 获取安全生产诚信序列号
     *
     * @return id - 安全生产诚信序列号
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置安全生产诚信序列号
     *
     * @param id 安全生产诚信序列号
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取类型，企业和个人
     *
     * @return type - 类型，企业和个人
     */
    public Boolean getType() {
        return type;
    }

    /**
     * 设置类型，企业和个人
     *
     * @param type 类型，企业和个人
     */
    public void setType(Boolean type) {
        this.type = type;
    }

    /**
     * 获取用户Id
     *
     * @return user_id - 用户Id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置用户Id
     *
     * @param userId 用户Id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取企业Id
     *
     * @return enterprise_id - 企业Id
     */
    public Long getEnterpriseId() {
        return enterpriseId;
    }

    /**
     * 设置企业Id
     *
     * @param enterpriseId 企业Id
     */
    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    /**
     * 获取信用分
     *
     * @return credit_score - 信用分
     */
    public Integer getCreditScore() {
        return creditScore;
    }

    /**
     * 设置信用分
     *
     * @param creditScore 信用分
     */
    public void setCreditScore(Integer creditScore) {
        this.creditScore = creditScore;
    }

    /**
     * 获取是否约谈，1为约谈,0为非约谈
     *
     * @return touch_round - 是否约谈，1为约谈,0为非约谈
     */
    public Boolean getTouchRound() {
        return touchRound;
    }

    /**
     * 设置是否约谈，1为约谈,0为非约谈
     *
     * @param touchRound 是否约谈，1为约谈,0为非约谈
     */
    public void setTouchRound(Boolean touchRound) {
        this.touchRound = touchRound;
    }

    /**
     * 获取一票否决，1为否决,0为非否决
     *
     * @return one_vote - 一票否决，1为否决,0为非否决
     */
    public Boolean getOneVote() {
        return oneVote;
    }

    /**
     * 设置一票否决，1为否决,0为非否决
     *
     * @param oneVote 一票否决，1为否决,0为非否决
     */
    public void setOneVote(Boolean oneVote) {
        this.oneVote = oneVote;
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