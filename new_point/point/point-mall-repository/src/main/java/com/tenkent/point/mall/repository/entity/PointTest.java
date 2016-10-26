package com.tenkent.point.mall.repository.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "point_test")
public class PointTest {
    @Id
    @Column(name = "test_id")
    private Integer testId;

    @Id
    @Column(name = "user_phone")
    private Long userPhone;

    private Byte state;

    @Column(name = "create_time")
    private Date createTime;

    /**
     * @return test_id
     */
    public Integer getTestId() {
        return testId;
    }

    /**
     * @param testId
     */
    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    /**
     * @return user_phone
     */
    public Long getUserPhone() {
        return userPhone;
    }

    /**
     * @param userPhone
     */
    public void setUserPhone(Long userPhone) {
        this.userPhone = userPhone;
    }

    /**
     * @return state
     */
    public Byte getState() {
        return state;
    }

    /**
     * @param state
     */
    public void setState(Byte state) {
        this.state = state;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	@Override
	public String toString() {
		return "PointTest [testId=" + testId + ", userPhone=" + userPhone + ", state=" + state + ", createTime="
				+ createTime + "]";
	}
}