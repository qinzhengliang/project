package com.zte.alm.safety.repository.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_permission_data_organize")
public class SysPermissionDataOrganize {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 1：组织，2：企业(叶子)
     */
    private Byte type;

    /**
     * 逗号分割的数据
     */
    @Column(name = "organize_value")
    private String organizeValue;

    @Column(name = "creation_time")
    private Date creationTime;

    @Column(name = "created_by")
    private Long createdBy;

    @Column(name = "last_update_time")
    private Date lastUpdateTime;

    @Column(name = "last_updated_by")
    private Long lastUpdatedBy;

    @Column(name = "enabled_flag")
    private Boolean enabledFlag;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取1：组织，2：企业(叶子)
     *
     * @return type - 1：组织，2：企业(叶子)
     */
    public Byte getType() {
        return type;
    }

    /**
     * 设置1：组织，2：企业(叶子)
     *
     * @param type 1：组织，2：企业(叶子)
     */
    public void setType(Byte type) {
        this.type = type;
    }

    /**
     * 获取逗号分割的数据
     *
     * @return organize_value - 逗号分割的数据
     */
    public String getOrganizeValue() {
        return organizeValue;
    }

    /**
     * 设置逗号分割的数据
     *
     * @param organizeValue 逗号分割的数据
     */
    public void setOrganizeValue(String organizeValue) {
        this.organizeValue = organizeValue == null ? null : organizeValue.trim();
    }

    /**
     * @return creation_time
     */
    public Date getCreationTime() {
        return creationTime;
    }

    /**
     * @param creationTime
     */
    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    /**
     * @return created_by
     */
    public Long getCreatedBy() {
        return createdBy;
    }

    /**
     * @param createdBy
     */
    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * @return last_update_time
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * @param lastUpdateTime
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    /**
     * @return last_updated_by
     */
    public Long getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    /**
     * @param lastUpdatedBy
     */
    public void setLastUpdatedBy(Long lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    /**
     * @return enabled_flag
     */
    public Boolean getEnabledFlag() {
        return enabledFlag;
    }

    /**
     * @param enabledFlag
     */
    public void setEnabledFlag(Boolean enabledFlag) {
        this.enabledFlag = enabledFlag;
    }
}