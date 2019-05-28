package com.lsz.code.code.source.fxjk;

import com.lsz.code.code.source.Table;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 充值
 */
@Table(name = "m_coin_recharge")
public class CoinRecharge {

    private Integer id;
    //会员id <param>
    private Integer memberId;
    //币种 <param>
    private String coin;
    //数量
    private BigDecimal amount;
    //创建时间
    private Date createTime;
    //地址 如果是人工充值，则等于=SYSCOIN,否则为 <param>
    private String address;
    //区块ID
    private String txid;
    //确认
    private Integer confirmations;
    //状态 <param> select[0:执行中,1:成功,2:失败]
    private Integer status;
    //from地址
    private String fromAddress;
    //修改时间
    private Date updateTime;

    //
    private Integer isDelete;
}