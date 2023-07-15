package com.fql.orderapp.common.result;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fql.orderapp.common.base.BaseBean;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"totalPage"})
public class Page extends BaseBean {

    private static final long serialVersionUID = -4672066687701280767L;

    /**
     * 当前页,默认为1
     */
    private Long currentPage = 1L;

    /**
     * 单页条数, 默认为10
     */
    private Long pageSize = 10L;

    /**
     * 总条数, 默认为0
     */
    private Long totalCount = 0L;

    /**
     * 总页码
     * @return 总页码
     */
    public Long getTotalPage() {
        return (getTotalCount() - 1) / getPageSize() + 1;
    }

    /**
     * 获取空Page对象, 所有字段为默认值
     *
     * @return
     */
    public static Page of() {
        return emptyPage();
    }

    /**
     * 根据currentPage和pageSize构建Page对象
     *
     * @param currentPage
     * @param pageSize
     * @return
     */
    public static Page of(Long currentPage, Long pageSize) {
        Page page = emptyPage();
        page.setCurrentPage(currentPage);
        page.setPageSize(pageSize);
        return page;
    }

    /**
     * 构建Page对象
     * @param currentPage   当前页
     * @param pageSize      每页条数
     * @param totalCount    总条数
     * @return
     */
    public static Page of(Long currentPage, Long pageSize, Long totalCount) {
        Page page = of(currentPage, pageSize);
        page.setTotalCount(totalCount);
        return page;
    }

    /**
     * 根据当前页信息构建Page对象
     *
     * @param currentPage
     * @return
     */
    public static Page of(Long currentPage) {
        if(null != currentPage && currentPage >= 1) {
            return of(currentPage, 10L);
        }
        return of();
    }

    private static Page emptyPage() {
        return new Page();
    }

}

