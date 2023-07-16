package com.fql.orderapp.service;

import com.fql.orderapp.common.result.SimpleResult;
import com.fql.orderapp.controller.notice.response.NoticeDTO;

public interface NoticeService {

    SimpleResult<NoticeDTO> getNotice();
}
