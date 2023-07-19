package com.fql.orderapp.common.exception;

import java.io.Serializable;

public interface CommonError extends Serializable {

    /**
     * 获取错误码
     * @return
     */
    String getErrorCode();

    /**
     * 获取错误信息
     * @return
     */
    String getErrorMsg();

    default String getErrorInfo() {
        return this.getErrorCode() + this.getErrorMsg();
    }

}

