package com.tenkent.point.mall.repository.entity;

import java.util.Date;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(description = "测试模型")
public class PointTestL {

	@ApiModelProperty(required = true, value = "模型Id")
	private int testId;

	@ApiModelProperty(required = true, value = "手机号")
	private Long userPhone;

	@ApiModelProperty(required = true, value = "状态")
	private int state;

	@ApiModelProperty(required = true, value = "创建时间")
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
