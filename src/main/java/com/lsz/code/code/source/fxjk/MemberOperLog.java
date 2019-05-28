package com.lsz.code.code.source.fxjk;

import com.lsz.code.code.source.Table;

import java.util.Date;

/**
 * 会员行为记录
 */
@Table(name = "m_member_oper_log")
public class MemberOperLog {

    private Long id;
    //会员ID <param>
    private Long memberId;
    //会员账号 <param>
    private String userName;
    //操作类型 <param> select[1:登录,2:其他]
    private Integer operType;
    //操作时间
    private Date operTime;
    //操作内容
    private String operMemo;
    //操作IP
    private String operIp;
    //
    private Integer isDelete;
    //
    private Date createTime;
}