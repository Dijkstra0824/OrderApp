package com.fql.orderapp.common.result;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fql.orderapp.common.exception.CommonError;
import com.fql.orderapp.common.request.PageRequest;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * @author keji:vanny.wjp@alibaba-inc.com
 * @time 2022-03-28 17:50:46
 * @desc 返回分页数据
 */
@JsonIgnoreProperties({"notSuccess", "exceptionStack", "list", "pageSize", "currentPage"})
public class PageResult<T> extends BaseResult<PageBean<T>, PageResult<T>> {

    private static final long serialVersionUID = 7837573254198017134L;

    /**
     * 返回一个空的成功的PageResult,数据对象和分页信息都取默认值
     *
     * @param <T>
     * @return
     */
    public static <T> PageResult<T> success() {
        return emptySuccessPageResult();
    }

    /**
     * 根据数据对象列表构建PageResult
     *
     * @param dataList  数据列表
     * @param <T>
     * @return          返回的分页信息都是默认值
     */
    public static <T> PageResult<T> success(List<T> dataList) {
        PageBean<T> pageBean = PageBean.of(dataList);
        return success(pageBean);
    }

    /**
     * 根据数据对象列表和Page对象构建PageResult
     *
     * @param dataList  数据列表
     * @param page      分页信息
     * @param <T>
     * @return
     */
    public static <T> PageResult<T> success(List<T> dataList, Page page) {
        PageBean<T> pageBean = PageBean.of(dataList, page);
        return success(pageBean);
    }

    /**
     * 根据数据列表 和 当前页构建PageResult
     *
     * @param dataList      数据列表
     * @param currentPage   当前页
     * @param <T>
     * @return
     */
    public static<T> PageResult<T> success(List<T> dataList, Long currentPage) {
        PageBean<T> pageBean = PageBean.of(dataList, currentPage);
        return success(pageBean);
    }

    /**
     * 根据数据列表 当前页 和 单页条数构建PageResult
     *
     * @param dataList      数据列表
     * @param currentPage   当前页
     * @param pageSize      单页条数
     * @param <T>
     * @return
     */
    public static<T> PageResult<T> success(List<T> dataList, Long currentPage, Long pageSize) {
        PageBean<T> pageBean = PageBean.of(dataList, currentPage, pageSize);
        return success(pageBean);
    }

    /**
     * 根据数据列表 通用分页请求对象 总条数构建PageResult
     *
     * @param dataList      当前页数据列表
     * @param pageRequest   分页请求对象
     * @param totalCount    符合条件的数据总条数
     * @param <T>
     * @return
     */
    public static<T> PageResult<T> success(List<T> dataList, PageRequest pageRequest, Long totalCount) {
        PageBean<T> pageBean = PageBean.of(dataList, pageRequest, totalCount);
        return success(pageBean);
    }

    /**
     * 根据数据列表 当前页 单页条数 和 数据总条数 构建PageResult
     *
     * @param dataList
     * @param currentPage
     * @param pageSize
     * @param totalCount
     * @param <T>
     * @return
     */
    public static<T> PageResult<T> success(List<T> dataList, Long currentPage, Long pageSize, Long totalCount) {
        PageBean<T> pageBean = PageBean.of(dataList, currentPage, pageSize, totalCount);
        return success(pageBean);
    }

    /**
     * 根据错误码和错误消息构建PageResult
     *
     * @param errorCode     错误码
     * @param errorMsg  错误消息
     * @param <T>
     * @return
     */
    public static<T> PageResult<T> failed(String errorCode, String errorMsg) {
        PageResult<T> failedPageResult = new PageResult<>();
        return failedPageResult.ofError(errorCode, errorMsg);
    }

    /**
     * 根据错误消息构建Result
     *
     * @param errorMsg  错误消息
     * @param <T>
     * @return
     */
    public static <T> PageResult<T> failed(String errorMsg) {
        return failed("system error", errorMsg);
    }

    /**
     * 根据错误对象枚举和错误消息构建Result
     *
     * @param CommonError      错误枚举对象:包含错误码和错误消息
     * @param errorMsg       如果有传errorMsg,以它为准,不传取errorCode.getErrorMsg
     * @param <T>
     * @return
     */
    public static <T> PageResult<T> failed(CommonError error, String errorMsg) {
        String usefulErrorMsg = StringUtils.isBlank(errorMsg) ? error.getErrorMsg() : errorMsg;
        return failed(error.getErrorCode(), usefulErrorMsg);
    }

    /**
     * 根据错误码和错误消息构建PageResult
     *
     * @param Error   错误枚举对象
     * @param <T>
     * @return
     */
    public static<T> PageResult<T> failed(CommonError error) {
        PageResult<T> failedPageResult = new PageResult<>();
        return failedPageResult.ofError(error.getErrorCode(), error.getErrorMsg());
    }

    /**
     * 获取实际对象列表
     *
     * @return
     */
    public List<T> getList() {
        PageBean<T> pageBean = this.getData();
        if(null == pageBean) {
            return Lists.newArrayList();
        }
        return pageBean.getList();
    }

    /**
     * 获取当前 每页条数信息
     *
     * @return
     */
    public Long getPageSize() {
        PageBean<T> pageBean = this.getData();
        if(null == pageBean || null == pageBean.getPaging()) {
            return 10L;
        }
        return pageBean.getPaging().getPageSize();
    }

    /**
     * 获取当前 页码
     *
     * @return
     */
    public Long getCurrentPage() {
        PageBean<T> pageBean = this.getData();
        if(null == pageBean || null == pageBean.getPaging()) {
            return 1L;
        }
        return pageBean.getPaging().getCurrentPage();
    }

    public Long getTotalCount() {
        PageBean<T> pageBean = this.getData();
        if(null == pageBean || null == pageBean.getPaging()) {
            return 0L;
        }
        return pageBean.getPaging().getTotalCount();
    }

    /**
     * 创建一个空的PageResult, 没有分页信息
     *
     * @param <T>
     * @return
     */
    private static <T> PageResult<T> emptySuccessPageResult() {
        PageResult<T> pageResult =  new PageResult<>();
        pageResult.setSuccess(Boolean.TRUE);
        pageResult.setData(PageBean.of());
        return pageResult;
    }

    /**
     * 根据PageBean构建PageResult
     *
     * @param pageBean
     * @param <T>
     * @return
     */
    private static <T> PageResult<T> success(PageBean<T> pageBean) {
        PageResult<T> successPageResult = emptySuccessPageResult();
        if(null != pageBean) {
            return successPageResult.ofSuccess(pageBean);
        } else {
            return successPageResult;
        }
    }

    /**
     * 复制一个错误的对象
     */
    public <R> PageResult<R> copyError() {
        return PageResult.failed(this.getErrorCode(), this.getErrorMsg());
    }

}


