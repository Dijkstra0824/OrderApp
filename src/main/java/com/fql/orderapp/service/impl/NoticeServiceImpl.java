package com.fql.orderapp.service.impl;

import com.fql.orderapp.common.result.SimpleResult;
import com.fql.orderapp.controller.notice.response.NoticeDTO;
import com.fql.orderapp.convert.NoticeConvert;
import com.fql.orderapp.domain.NoticeDO;
import com.fql.orderapp.mapper.NoticeMapper;
import com.fql.orderapp.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public SimpleResult<NoticeDTO> getNotice() {
        NoticeDO noticeDO = noticeMapper.selectNoticeLastOne();
        NoticeDTO noticeDTO = NoticeConvert.CONVERT.toDTO(noticeDO);
        return SimpleResult.success(noticeDTO);
    }

    @Override
    public SimpleResult<String> getNoticeDetailById(int id) {
        String noticeDetail = noticeMapper.selectNoticeDetailById(id);
        return SimpleResult.success(noticeDetail);
    }
}
