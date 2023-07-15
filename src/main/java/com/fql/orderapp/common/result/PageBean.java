package com.fql.orderapp.common.result;

import com.fql.orderapp.common.base.BaseBean;
import com.fql.orderapp.common.request.PageRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author keji:vanny.wjp@alibaba-inc.com
 * @time 2022-03-30 10:45:05
 * @desc 分页对象(强制模型) 包含分页信息和数据对象等
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PageBean<T> extends BaseBean {

    private static final long serialVersionUID = -4372378148264503915L;

    /**
     * 持有的类型为T的数据对象列表
     */
    private List<T> list;

    /**
     * 分页信息, 可以为空;默认值为Page.of()
     */
    private Page paging;

    /**
     * 创建一个空的分页对象
     * 对象列表为空列表, 分页信息对象取默认值
     *
     * @param <T>
     * @return
     */
    public static <T> PageBean<T> of () {
        return new PageBean<>(new ArrayList<>(), Page.of());
    }

    /**
     * 根据数据列表和分页信息对象创建 分页对象
     *
     * @param dataList  数据列表
     * @param paging    分页信息
     * @param <T>
     * @return
     */
    public static <T> PageBean<T> of(List<T> dataList, Page paging) {
        return new PageBean<>(dataList, paging);
    }

    /**
     * 根据数据列表创建 分页对象; 分页信息取默认值
     *
     * @param dataList  数据列表
     * @param <T>
     * @return
     */
    public static <T> PageBean<T> of(List<T> dataList) {
        return of(dataList, 1L);
    }

    /**
     * 根据数据列表和 当前页 构建 分页对象
     *
     * @param list          数据列表
     * @param currentPage   当前页码
     * @param <T>
     * @return
     */
    public static <T> PageBean<T> of(List<T> list, Long currentPage) {
        Page page = Page.of(currentPage);
        if(CollectionUtils.isNotEmpty(list)) {
            page.setTotalCount((long) list.size());
        }
        return PageBean.of(list, page);
    }

    /**
     * 根据数据列表 当前页面 和 单页条数 构建分页对象
     *
     * @param list          数据列表
     * @param currentPage   当前页码
     * @param pageSize      单页条数
     * @param <T>
     * @return
     */
    public static <T> PageBean<T> of(List<T> list, Long currentPage, Long pageSize) {
        Page page = Page.of(currentPage, pageSize);
        if(CollectionUtils.isNotEmpty(list)) {
            page.setTotalCount((long) list.size());
        }
        return PageBean.of(list, page);
    }

    /**
     * 根据 数据列表 通用分页请求 和 数据总条数 构建分页对象
     *
     * @param list
     * @param pageRequest
     * @param totalCount
     * @param <T>
     * @return
     */
    public static <T> PageBean<T> of(List<T> list, PageRequest pageRequest, Long totalCount) {
        if(null == pageRequest) {
            pageRequest = new PageRequest();
        }
        return PageBean.of(list, pageRequest.getCurrentPage(), pageRequest.getPageSize(), totalCount);
    }

    /**
     * 根据 数据列表 当前页面 单页条数 和 数据总条数 构建分页对象
     *
     * @param list
     * @param currentPage
     * @param pageSize
     * @param totalCount
     * @param <T>
     * @return
     */
    public static <T> PageBean<T> of(List<T> list, Long currentPage, Long pageSize, Long totalCount) {
        Page page = Page.of(currentPage, pageSize, totalCount);
        return PageBean.of(list, page);
    }

}

