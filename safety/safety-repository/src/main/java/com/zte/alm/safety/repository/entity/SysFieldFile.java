package com.zte.alm.safety.repository.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_field_file")
public class SysFieldFile {
    /**
     * 文件引用表序列Id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 字段Id
     */
    @Column(name = "field_id")
    private Long fieldId;

    /**
     * 文件Id
     */
    @Column(name = "file_id")
    private Long fileId;

    /**
     * 单据Id
     */
    @Column(name = "bill_id")
    private Long billId;

    /**
     * 文件名称，冗余字段
     */
    @Column(name = "file_name")
    private String fileName;

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
     * 获取文件引用表序列Id
     *
     * @return id - 文件引用表序列Id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置文件引用表序列Id
     *
     * @param id 文件引用表序列Id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取字段Id
     *
     * @return field_id - 字段Id
     */
    public Long getFieldId() {
        return fieldId;
    }

    /**
     * 设置字段Id
     *
     * @param fieldId 字段Id
     */
    public void setFieldId(Long fieldId) {
        this.fieldId = fieldId;
    }

    /**
     * 获取文件Id
     *
     * @return file_id - 文件Id
     */
    public Long getFileId() {
        return fileId;
    }

    /**
     * 设置文件Id
     *
     * @param fileId 文件Id
     */
    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    /**
     * 获取单据Id
     *
     * @return bill_id - 单据Id
     */
    public Long getBillId() {
        return billId;
    }

    /**
     * 设置单据Id
     *
     * @param billId 单据Id
     */
    public void setBillId(Long billId) {
        this.billId = billId;
    }

    /**
     * 获取文件名称，冗余字段
     *
     * @return file_name - 文件名称，冗余字段
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * 设置文件名称，冗余字段
     *
     * @param fileName 文件名称，冗余字段
     */
    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
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