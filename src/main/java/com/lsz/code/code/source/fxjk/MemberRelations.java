package com.lsz.code.code.source.fxjk;

import java.util.Date;

/**
 * 邀请记录
 */
public class MemberRelations {

    private Long id;
    //会员ID <param>
    private Long memberId;
    //层级 1,2,3....n <param>
    private Integer fxLevel;
    //父id <param>
    private Long parentId;
    //
    private Date createTime;
    //
    private Integer isDelete;
    //订单序号
    private Integer orderNo;
}