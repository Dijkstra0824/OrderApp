package com.fql.orderapp.common.result;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fql.orderapp.common.base.BaseBean;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"notSuccess", "exceptionStack"})
public abstract class BaseResult<T, Result extends BaseResult<T, Result>>  extends BaseBean {


    private static final long serialVersionUID = -6477389120810763869L;

    /**
     * 是否调用成功
     */
    private boolean success = Boolean.FALSE;

    /**
     * 成功消息
     */
    private String msg = "";

    /**
     * 错误消息
     */
    private String errorMsg = "";

    /**
     * 错误码
     */
    private String errorCode = "0000";

    /**
     * 错误堆栈, debug模式时使用
     */
    private String exceptionStack = "";

    /**
     * 返回结果
     */
    private T data;

    /**
     * 是否失败, 方便后端调用处理时使用
     * @return
     */
    public boolean isNotSuccess() {
        return !success;
    }

    /**
     * 根据数据对象创建Result
     *
     * @param data
     * @return
     */
    public Result ofSuccess(T data) {
        this.setData(data);
        this.setSuccess(Boolean.TRUE);
        return (Result) this;
    }

    /**
     * 创建一个空的成功的Result
     *
     * @return
     */
    public Result ofSuccess() {
        return ofSuccess(null);
    }

    /**
     * 根据对象和成功消息创建Result
     *
     * @param data
     * @param msg
     * @return
     */
    public Result ofSuccess(T data, String msg) {
        Result result = ofSuccess(data);
        result.setMsg(msg);
        return result;
    }

    /**
     * 创建一个空的失败Result
     *
     * @return
     */
    public Result ofError() {
        this.setSuccess(Boolean.FALSE);
        this.setErrorCode("system error");
        this.setErrorMsg("system error");
        return (Result) this;
    }

    /**
     * 根据错误码和错误消息生成Result
     *
     * @param errorCode     错误码
     * @param errorMsg      错误消息
     * @return
     */
    public Result ofError(String errorCode, String errorMsg) {
        Result result = ofError();
        result.setErrorCode(errorCode);
        result.setErrorMsg(errorMsg);
        return result;
    }

    /**
     * 根据错误消息创建错误Result
     *
     * @param errorMsg
     * @return
     */
    public Result ofError(String errorMsg) {
        Result result = ofError();
        result.setErrorMsg(errorMsg);
        return result;
    }
}