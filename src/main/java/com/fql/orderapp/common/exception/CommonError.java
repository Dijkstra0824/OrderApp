package com.fql.orderapp.common.exception;

import java.io.Serializable;

/**
 * @author keji:vanny.wjp@alibaba-inc.com
 * @time 2022-03-29 14:09:25
 * @desc XL系统错误码基础类
 */
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

