package com.tenkent.point.infrastructure.base;

/**
 * Created by 6418000384 on 2016/7/15.
 */
public class Response {
    private String status = Global.SUCCESS;
    private String errorMessage;
    private Object output;

    public Response() {
        this.setStatus(status);
        this.setErrorMessage(errorMessage);
        this.setOutput(output);

    }

    public Response(Object output) {
        this.setOutput(output);
    }

    public Response(String errorCode, String errorMsg) {
        this.setStatus(errorCode);
        this.setErrorMessage(errorMsg);
    }

    public Response(String errorCode, String errorMsg, Object entity) {
        this.setStatus(errorCode);
        this.setErrorMessage(errorMsg);
        this.setOutput(entity);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Object getOutput() {
        return output;
    }

    public void setOutput(Object output) {
        this.output = output;
    }
}
