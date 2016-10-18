package com.zte.alm.safety.repository.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_permission_menu")
public class SysPermissionMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * show：显示
     */
    private String sn;

    /**
     * sys_menu表id
     */
    @Column(name = "menu_id")
    private Long menuId;

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
     * 获取show：显示
     *
     * @return sn - show：显示
     */
    public String getSn() {
        return sn;
    }

    /**
     * 设置show：显示
     *
     * @param sn show：显示
     */
    public void setSn(String sn) {
        this.sn = sn == null ? null : sn.trim();
    }

    /**
     * 获取sys_menu表id
     *
     * @return menu_id - sys_menu表id
     */
    public Long getMenuId() {
        return menuId;
    }

    /**
     * 设置sys_menu表id
     *
     * @param menuId sys_menu表id
     */
    public void setMenuId(Long menuId) {
        this.menuId = menuId;
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