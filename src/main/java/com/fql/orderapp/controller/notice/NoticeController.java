package com.fql.orderapp.controller.notice;

import com.fql.orderapp.common.base.WebResponse;
import com.fql.orderapp.common.result.SimpleResult;
import com.fql.orderapp.common.utils.ResultUtil;
import com.fql.orderapp.controller.notice.response.NoticeDTO;
import com.fql.orderapp.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @GetMapping("/notice/last-one")
    public WebResponse<NoticeDTO> getNotice() {
        SimpleResult<NoticeDTO> result = noticeService.getNotice();
        if (result.isSuccess() && Objects.nonNull(result.getValue())) {
            return ResultUtil.success(result.getValue());
        }
        return ResultUtil.error("500", "get bulletins failed!");

    }
}
