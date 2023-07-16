package com.fql.orderapp.common.result;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fql.orderapp.common.base.SimpleBean;
import com.fql.orderapp.common.exception.CommonError;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import java.util.Objects;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties({"value", "notSuccess", "exceptionStack"})
public class SimpleResult<T> extends BaseResult<SimpleBean<T>, SimpleResult<T>> {

    private static final long serialVersionUID = 3104068223977866861L;

    public SimpleResult() {
        super();
    }

    public SimpleResult(boolean success, String msg, String errorMsg, String errorCode, String exceptionStack, SimpleBean<T> data) {
        super(success, msg, errorMsg, errorCode, exceptionStack, data);
    }

    /**
     * 返回一个成功的空对象
     *
     * @param <T>
     * @return
     */
    public static <T> SimpleResult<T> success() {
        SimpleResult<T> simpleResult = emptySimpleResult();
        return simpleResult.ofSuccess();
    }

    /**
     * 根据输入对象构建Result
     *
     * @param data  返回的数据对象
     * @param <T>
     * @return
     */
    public static <T> SimpleResult<T> success(T data) {
        SimpleBean<T> simpleBean = SimpleBean.of(data);
        return success(simpleBean);
    }


    /**
     * 根据输入的对象和成功信息构建Result
     *
     * @param data      返回的数据对象
     * @param message   成功信息,供前端显示用
     * @param <T>
     * @return
     */
    public static <T> SimpleResult<T> success(T data, String message) {
        SimpleResult<T> simpleResult = success(data);
        simpleResult.setMsg(message);
        return simpleResult;
    }

    /**
     * 根据错误code和错误信息构建Result
     *
     * @param errorCode     错误码
     * @param errorMsg      错误消息
     * @param <T>
     * @return
     */
    public static <T> SimpleResult<T> failed(String errorCode, String errorMsg) {
        SimpleResult<T> failedResult = new SimpleResult<>();
        return failedResult.ofError(errorCode, errorMsg);
    }

    /**
     * 根据错误信息构建Result
     *
     * @param xlError 错误枚举对象:包含错误码和错误消息
     * @param <T>
     * @return
     */
    public static <T> SimpleResult<T> failed(CommonError xlError) {
        return failed(xlError.getErrorCode(), xlError.getErrorMsg());
    }


    /**
     * 根据错误消息构建Result
     *
     * @param errorMsg  错误消息
     * @param <T>
     * @return
     */
    public static <T> SimpleResult<T> failed(String errorMsg) {
        return failed("system error", errorMsg);
    }

    /**
     * 根据错误对象枚举和错误消息构建Result
     *
     * @param xlError      错误枚举对象:包含错误码和错误消息
     * @param errorMsg       如果有传errorMsg,以它为准,不传取errorCode.getErrorMsg
     * @param <T>
     * @return
     */
    public static <T> SimpleResult<T> failed(CommonError xlError, String errorMsg) {
        String usefulErrorMsg = StringUtils.isBlank(errorMsg) ? xlError.getErrorMsg() : errorMsg;
        return failed(xlError.getErrorCode(), usefulErrorMsg);
    }

    /**
     * 获取存储的实际对象
     *
     * @return
     */
    public T getValue() {
        if(null == this.getData()) {
            return null;
        }
        SimpleBean<T> simpleBean = this.getData();
        return simpleBean.getValue();
    }

    /**
     * 设置存储的实际对象
     *
     * @param data
     */
    public void setValue(T data) {
        SimpleBean<T> simpleBean = SimpleBean.of(data);
        this.setData(simpleBean);
    }

    /**
     * 从一个Result对象深度copy出一个新的Result对象
     *
     * @param source
     * @param <T>
     * @return
     */
    public static <T> SimpleResult<T> of (SimpleResult<T> source) {
        if(Objects.isNull(source)) {
            return SimpleResult.failed("system error");
        }
        SimpleResult<T> result = new SimpleResult<>();
        result.setMsg(source.getMsg());
        result.setSuccess(source.isSuccess());
        result.setErrorCode(source.getErrorCode());
        result.setErrorMsg(source.getErrorMsg());
        result.setData(source.getData());
        return result;
    }

    /**
     * 复制一个错误的对象
     */
    public <R> SimpleResult<R> copyError() {
        return SimpleResult.failed(this.getErrorCode(), this.getErrorMsg());
    }

    private static <T> SimpleResult<T> emptySimpleResult() {
        return new SimpleResult<>();
    }

    private static <T> SimpleResult<T> success(SimpleBean<T> simpleBean) {
        SimpleResult<T> simpleResult = success();
        simpleResult.setData(simpleBean);
        return simpleResult;
    }

}