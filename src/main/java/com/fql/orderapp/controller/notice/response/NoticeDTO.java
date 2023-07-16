package com.fql.orderapp.controller.notice.response;

import lombok.Data;

import java.util.Date;

@Data
public class NoticeDTO {

    private String content;
    private Date dateAdd;
    private int id;
    private boolean isRemind;
    private boolean isShow;
    private int remindUid;
    private String title;
    private int userId;
}
