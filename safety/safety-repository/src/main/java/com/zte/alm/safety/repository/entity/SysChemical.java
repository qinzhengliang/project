package com.zte.alm.safety.repository.entity;

import javax.persistence.*;

@Table(name = "sys_chemical")
public class SysChemical {
    /**
     * 危化品序列号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 危化品中文名称
     */
    @Column(name = "cn_name")
    private String cnName;

    /**
     * 危化品英文名称
     */
    @Column(name = "en_name")
    private String enName;

    /**
     * 获取危化品序列号
     *
     * @return id - 危化品序列号
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置危化品序列号
     *
     * @param id 危化品序列号
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取危化品中文名称
     *
     * @return cn_name - 危化品中文名称
     */
    public String getCnName() {
        return cnName;
    }

    /**
     * 设置危化品中文名称
     *
     * @param cnName 危化品中文名称
     */
    public void setCnName(String cnName) {
        this.cnName = cnName == null ? null : cnName.trim();
    }

    /**
     * 获取危化品英文名称
     *
     * @return en_name - 危化品英文名称
     */
    public String getEnName() {
        return enName;
    }

    /**
     * 设置危化品英文名称
     *
     * @param enName 危化品英文名称
     */
    public void setEnName(String enName) {
        this.enName = enName == null ? null : enName.trim();
    }
}