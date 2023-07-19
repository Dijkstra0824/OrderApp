package com.fql.orderapp.domain;

import lombok.Data;

import java.util.Date;

@Data
public class NoticeDO {

    private String content;
    private Date dateAdd;
    private int id;
    private boolean isRemind;
    private boolean isShow;
    private int remindUid;
    private String title;
    private int userId;
}
