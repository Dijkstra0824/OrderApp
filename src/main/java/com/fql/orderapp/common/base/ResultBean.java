package com.fql.orderapp.common.base;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ResultBean<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private Boolean success;
    private String code;
    private String msg;
    private T data;

    public static <T> ResultBean<T> create(Boolean isSuccess, String msg, String code, T data) {
        ResultBean<T> resultBean = new ResultBean<>();
        resultBean.setSuccess(isSuccess);
        resultBean.setCode(code);
        resultBean.setMsg(msg);
        resultBean.setData(data);
        return resultBean;
    }

}
