package com.lsz.code.code.source.fxjk;

import com.lsz.code.code.source.Table;

import java.util.Date;

/**
 * 提币地址
 */
@Table(name = "m_withdraw_addr")
public class WithdrawAddr {

    private Integer id;
    //用户ID <param>
    private Long memberId;
    //币种 <param>
    private String coin;
    //地址
    private String addr;
    //状态 <param> select[0:启用,1:禁用]
    private Integer status;
    //是否删除
    private Integer isDelete;
    //创建时间
    private Date createTime;
}