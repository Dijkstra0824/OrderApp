package com.fql.orderapp.controller.notice.response;

import com.fql.orderapp.common.base.BaseBean;
import lombok.Data;

import java.util.Date;

@Data
public class NoticeDTO extends BaseBean {

    public String content;
    public Date dateAdd;
    public int id;
    public boolean isRemind;
    public boolean isShow;
    public int remindUid;
    public String title;
    public int userId;
}
