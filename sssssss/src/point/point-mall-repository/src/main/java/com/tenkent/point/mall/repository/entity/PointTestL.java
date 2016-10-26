package com.tenkent.point.mall.repository.entity;

import java.util.Date;

public class PointTestL {

	private int testId;

	private Long userPhone;

	private int state;

	private Date createTime;

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public Long getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(Long userPhone) {
		this.userPhone = userPhone;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "PointTestL{" +
				"testId=" + testId +
				", userPhone=" + userPhone +
				", state=" + state +
				", createTime=" + createTime +
				'}';
	}
}
