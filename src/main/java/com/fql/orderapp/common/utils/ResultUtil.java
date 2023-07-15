package com.fql.orderapp.common.utils;

import com.fql.orderapp.common.base.WebResponse;

public class ResultUtil {

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