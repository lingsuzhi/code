package com.lsz.code.code.source.qyjg;

import java.util.Date;

/**
 * 公告企业信息
 */
public class NoticeEnterprise {

    //唯一标识 <param>
    private String id;
    //企业id <param>
    private String enterpriseId;
    //企业名称 <param>
    private String enterpriseName;
    //企业联系电话 <param>
    private String enterpriseTel;
    //推送日期 <param>
    private Date pushTime;
    //阅读状态 0-未阅读;1-已阅读 <param>
    private Integer readStatus;
    //企业是否回执 0-未回执;1-回执 <param>
    private Integer isReceipt;
    //公告id <param>
    private String noticeId;
}
