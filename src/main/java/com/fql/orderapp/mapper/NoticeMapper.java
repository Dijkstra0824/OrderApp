package com.fql.orderapp.mapper;

import com.fql.orderapp.domain.NoticeDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NoticeMapper {

    NoticeDO selectNoticeLastOne();

    String selectNoticeDetailById(int id);
}
