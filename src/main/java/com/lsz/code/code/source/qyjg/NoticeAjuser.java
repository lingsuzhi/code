package com.lsz.code.code.source.qyjg;

import java.util.Date;

/**
 * 公告安监局人
 */
public class NoticeAjuser {

    //唯一标识 <param>
    private String id;
    //用户id <param>
    private String userId;
    //用户名称 <param>
    private String userName;
    //用户联系电话 <param>
    private String userTel;
    //推送日期 <param>
    private Date pushTime;
    //阅读状态 0-未阅读;1-已阅读 <param>
    private Integer readStatus;
    //个人是否回执 0-未回执;1-回执 <param>
    private Integer isReceipt;
    //公告id <param>
    private String noticeId;
}