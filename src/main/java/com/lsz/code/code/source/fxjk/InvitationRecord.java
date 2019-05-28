package com.lsz.code.code.source.fxjk;

import java.util.Date;

/**
 * 邀请记录
 */
public class InvitationRecord {

    private Integer id;
    //邀请人ID <param>
    private Integer invitationId;
    //被邀请人Id <param>
    private Integer inviteeId;
    //
    private Date createTime;
    //
    private Date updateTime;
    //
    private Integer isDelete;
    //邀请码 <param>
    private String invitationCode;
    //被邀请人手机号码 <param>
    private String inviteePhone;
    //邀请人的父级ID <param>
    private Integer parentId;
}