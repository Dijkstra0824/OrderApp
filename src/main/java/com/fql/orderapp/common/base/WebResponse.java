package com.fql.orderapp.common.base;

public class WebResponse <T> extends BaseBean {

    private boolean success;

    /**
     * 成功消息
     */
    private String msg;

    /**
     * 失败code
     */
    private String errorCode;

    /**
     * 失败消息
     */
    private String errorMsg;

    private T data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    public static <O> WebResponse<O> success() {
        WebResponse<O> result = new WebResponse<>();
        result.setSuccess(true);
        return result;
    }

    public static <O> WebResponse<O> success(O data) {
        WebResponse<O> result = new WebResponse<>();
        result.setSuccess(true);
        result.setData(data);
        return result;
    }

    public static <O> WebResponse<O> error(String code, String msg) {
        WebResponse<O> result = new WebResponse<>();
        result.setErrorCode(code);
        result.setErrorMsg(msg);
        return result;
    }
}