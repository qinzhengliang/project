package com.zte.alm.safety.repository.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_credit_change_log")
public class SysCreditChangeLog {
    /**
     * 安全生产信用分更改日志序列号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 安全生产信用Id
     */
    @Column(name = "creadit_id")
    private Long creaditId;

    /**
     * 变化时间
     */
    @Column(name = "change_time")
    private Date changeTime;

    /**
     * 变更人
     */
    @Column(name = "changed_by")
    private Long changedBy;

    /**
     * 更改原因
     */
    @Column(name = "change_reson")
    private String changeReson;

    /**
     * 原信用分
     */
    @Column(name = "old_credit")
    private Integer oldCredit;

    /**
     * 新信用分
     */
    @Column(name = "new_credit")
    private Integer newCredit;

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
     * 获取安全生产信用分更改日志序列号
     *
     * @return id - 安全生产信用分更改日志序列号
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置安全生产信用分更改日志序列号
     *
     * @param id 安全生产信用分更改日志序列号
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取安全生产信用Id
     *
     * @return creadit_id - 安全生产信用Id
     */
    public Long getCreaditId() {
        return creaditId;
    }

    /**
     * 设置安全生产信用Id
     *
     * @param creaditId 安全生产信用Id
     */
    public void setCreaditId(Long creaditId) {
        this.creaditId = creaditId;
    }

    /**
     * 获取变化时间
     *
     * @return change_time - 变化时间
     */
    public Date getChangeTime() {
        return changeTime;
    }

    /**
     * 设置变化时间
     *
     * @param changeTime 变化时间
     */
    public void setChangeTime(Date changeTime) {
        this.changeTime = changeTime;
    }

    /**
     * 获取变更人
     *
     * @return changed_by - 变更人
     */
    public Long getChangedBy() {
        return changedBy;
    }

    /**
     * 设置变更人
     *
     * @param changedBy 变更人
     */
    public void setChangedBy(Long changedBy) {
        this.changedBy = changedBy;
    }

    /**
     * 获取更改原因
     *
     * @return change_reson - 更改原因
     */
    public String getChangeReson() {
        return changeReson;
    }

    /**
     * 设置更改原因
     *
     * @param changeReson 更改原因
     */
    public void setChangeReson(String changeReson) {
        this.changeReson = changeReson == null ? null : changeReson.trim();
    }

    /**
     * 获取原信用分
     *
     * @return old_credit - 原信用分
     */
    public Integer getOldCredit() {
        return oldCredit;
    }

    /**
     * 设置原信用分
     *
     * @param oldCredit 原信用分
     */
    public void setOldCredit(Integer oldCredit) {
        this.oldCredit = oldCredit;
    }

    /**
     * 获取新信用分
     *
     * @return new_credit - 新信用分
     */
    public Integer getNewCredit() {
        return newCredit;
    }

    /**
     * 设置新信用分
     *
     * @param newCredit 新信用分
     */
    public void setNewCredit(Integer newCredit) {
        this.newCredit = newCredit;
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