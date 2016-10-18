package com.zte.alm.safety.repository.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_log")
public class SysLog {
    /**
     * 系统日志表序列
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 操作
     */
    private String action;

    /**
     * 操作时间
     */
    @Column(name = "action_time")
    private Date actionTime;

    /**
     * 操作结果，1为成功，0为失败
     */
    @Column(name = "action_result")
    private Boolean actionResult;

    /**
     * 日志等级，DEBUG，INFO，EXCEPTION，FATAL
     */
    private String level;

    /**
     * 日志消息
     */
    private String message;

    /**
     * 操作人
     */
    @Column(name = "action_user")
    private Long actionUser;

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
     * 失败具体异常信息
     */
    private String exception;

    /**
     * 获取系统日志表序列
     *
     * @return id - 系统日志表序列
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置系统日志表序列
     *
     * @param id 系统日志表序列
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取操作
     *
     * @return action - 操作
     */
    public String getAction() {
        return action;
    }

    /**
     * 设置操作
     *
     * @param action 操作
     */
    public void setAction(String action) {
        this.action = action == null ? null : action.trim();
    }

    /**
     * 获取操作时间
     *
     * @return action_time - 操作时间
     */
    public Date getActionTime() {
        return actionTime;
    }

    /**
     * 设置操作时间
     *
     * @param actionTime 操作时间
     */
    public void setActionTime(Date actionTime) {
        this.actionTime = actionTime;
    }

    /**
     * 获取操作结果，1为成功，0为失败
     *
     * @return action_result - 操作结果，1为成功，0为失败
     */
    public Boolean getActionResult() {
        return actionResult;
    }

    /**
     * 设置操作结果，1为成功，0为失败
     *
     * @param actionResult 操作结果，1为成功，0为失败
     */
    public void setActionResult(Boolean actionResult) {
        this.actionResult = actionResult;
    }

    /**
     * 获取日志等级，DEBUG，INFO，EXCEPTION，FATAL
     *
     * @return level - 日志等级，DEBUG，INFO，EXCEPTION，FATAL
     */
    public String getLevel() {
        return level;
    }

    /**
     * 设置日志等级，DEBUG，INFO，EXCEPTION，FATAL
     *
     * @param level 日志等级，DEBUG，INFO，EXCEPTION，FATAL
     */
    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    /**
     * 获取日志消息
     *
     * @return message - 日志消息
     */
    public String getMessage() {
        return message;
    }

    /**
     * 设置日志消息
     *
     * @param message 日志消息
     */
    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    /**
     * 获取操作人
     *
     * @return action_user - 操作人
     */
    public Long getActionUser() {
        return actionUser;
    }

    /**
     * 设置操作人
     *
     * @param actionUser 操作人
     */
    public void setActionUser(Long actionUser) {
        this.actionUser = actionUser;
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

    /**
     * 获取失败具体异常信息
     *
     * @return exception - 失败具体异常信息
     */
    public String getException() {
        return exception;
    }

    /**
     * 设置失败具体异常信息
     *
     * @param exception 失败具体异常信息
     */
    public void setException(String exception) {
        this.exception = exception == null ? null : exception.trim();
    }
}