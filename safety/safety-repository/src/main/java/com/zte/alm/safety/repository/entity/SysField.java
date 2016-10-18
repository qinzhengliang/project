package com.zte.alm.safety.repository.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_field")
public class SysField {
    /**
     * 扩展字段表序列Id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 业务实体代码
     */
    @Column(name = "business_code")
    private String businessCode;

    /**
     * 所属表名称
     */
    @Column(name = "table_name")
    private String tableName;

    /**
     * 字段类型，默认为1，标识附件类型
     */
    private Boolean type;

    /**
     * 字段名称,要保证同一个code和table下唯一
     */
    private String name;

    /**
     * 字段显示名称，一般与name相同
     */
    @Column(name = "display_name")
    private String displayName;

    /**
     * 字段输出Map中名称，一般与name相同
     */
    @Column(name = "map_name")
    private String mapName;

    /**
     * 描述
     */
    private String description;

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
     * 获取扩展字段表序列Id
     *
     * @return id - 扩展字段表序列Id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置扩展字段表序列Id
     *
     * @param id 扩展字段表序列Id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取业务实体代码
     *
     * @return business_code - 业务实体代码
     */
    public String getBusinessCode() {
        return businessCode;
    }

    /**
     * 设置业务实体代码
     *
     * @param businessCode 业务实体代码
     */
    public void setBusinessCode(String businessCode) {
        this.businessCode = businessCode == null ? null : businessCode.trim();
    }

    /**
     * 获取所属表名称
     *
     * @return table_name - 所属表名称
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * 设置所属表名称
     *
     * @param tableName 所属表名称
     */
    public void setTableName(String tableName) {
        this.tableName = tableName == null ? null : tableName.trim();
    }

    /**
     * 获取字段类型，默认为1，标识附件类型
     *
     * @return type - 字段类型，默认为1，标识附件类型
     */
    public Boolean getType() {
        return type;
    }

    /**
     * 设置字段类型，默认为1，标识附件类型
     *
     * @param type 字段类型，默认为1，标识附件类型
     */
    public void setType(Boolean type) {
        this.type = type;
    }

    /**
     * 获取字段名称,要保证同一个code和table下唯一
     *
     * @return name - 字段名称,要保证同一个code和table下唯一
     */
    public String getName() {
        return name;
    }

    /**
     * 设置字段名称,要保证同一个code和table下唯一
     *
     * @param name 字段名称,要保证同一个code和table下唯一
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取字段显示名称，一般与name相同
     *
     * @return display_name - 字段显示名称，一般与name相同
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * 设置字段显示名称，一般与name相同
     *
     * @param displayName 字段显示名称，一般与name相同
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName == null ? null : displayName.trim();
    }

    /**
     * 获取字段输出Map中名称，一般与name相同
     *
     * @return map_name - 字段输出Map中名称，一般与name相同
     */
    public String getMapName() {
        return mapName;
    }

    /**
     * 设置字段输出Map中名称，一般与name相同
     *
     * @param mapName 字段输出Map中名称，一般与name相同
     */
    public void setMapName(String mapName) {
        this.mapName = mapName == null ? null : mapName.trim();
    }

    /**
     * 获取描述
     *
     * @return description - 描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置描述
     *
     * @param description 描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
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