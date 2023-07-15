package com.fql.orderapp.common.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author keji:vanny.wjp@alibaba-inc.com
 * @time 2022-04-05 11:07:56
 * @desc 后端给前端的返回值必须是个JSON或者null;
 *       因此,为避免对于类型为基础类型/包装类型/String的返回值需要进行包装, 这里进行统一处理
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SimpleBean<T> extends BaseBean {

    private static final long serialVersionUID = 2899996861031911866L;

    private T value;


    public static <T> SimpleBean<T> of(T data) {
        // 如果data为null, 则不做封装
        if(null == data) {
            return null;
        }
        SimpleBean<T> simpleBean = new SimpleBean<>();
        simpleBean.setValue(data);
        return simpleBean;
    }

}

