package com.fql.orderapp.convert;

import com.fql.orderapp.controller.notice.response.NoticeDTO;
import com.fql.orderapp.domain.NoticeDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface NoticeConvert {

    NoticeConvert CONVERT = Mappers.getMapper(NoticeConvert.class);
    NoticeDTO toDTO(NoticeDO noticeDO);
}
