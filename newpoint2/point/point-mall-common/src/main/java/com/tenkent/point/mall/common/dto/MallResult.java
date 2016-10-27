package com.tenkent.point.mall.common.dto;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(description = "ModelDTO")
public class MallResult<T>
{
	@ApiModelProperty(required = true, value = "是否成功")
    private boolean success;
	
	@ApiModelProperty(required = true, value = "返回信息")
    private T data;
	
	@ApiModelProperty(required = true, value = "错误信息")
    private String error;
    
    public MallResult(boolean success, T data, String error)
    {
        this.success = success;
        this.data = data;
        this.error = error;
    }
    public MallResult(boolean success, String error)
    {
        this.success = success;
        this.error = error;
    }
    public MallResult(boolean success, T data)
    {
        this.success = success;
        this.data = data;
    }
    public boolean isSuccess()
    {
        return success;
    }
    public void setSuccess(boolean success)
    {
        this.success = success;
    }
    public T getData()
    {
        return data;
    }
    public void setData(T data)
    {
        this.data = data;
    }
    public String getError()
    {
        return error;
    }
    public void setError(String error)
    {
        this.error = error;
    }
}