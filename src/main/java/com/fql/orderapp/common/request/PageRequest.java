package com.fql.orderapp.common.request;

import com.fql.orderapp.common.base.BaseBean;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PageRequest extends BaseBean {

    private static final long serialVersionUID = 4182427077633688288L;

    /**
     * 当前页, 默认为1
     */
    private Long currentPage = 1L;

    /**
     * 每页查询条数, 默认为10
     */
    private Long pageSize = 10L;

    public void setCurrentPage(Long currentPage) {
        if (Objects.nonNull(currentPage) && currentPage >= 1L) {
            this.currentPage = currentPage;
        }
    }

    public void setPageSize(Long pageSize) {
        if (Objects.nonNull(pageSize) && pageSize >= 0) {
            this.pageSize = pageSize;
        }
    }

}
