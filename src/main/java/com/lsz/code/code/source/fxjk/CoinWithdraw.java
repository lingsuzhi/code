package com.lsz.code.code.source.fxjk;

import com.lsz.code.code.source.Table;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 提现记录
 */
@Table(name = "m_coin_withdraw")
public class CoinWithdraw {

    private Integer id;
    //用户ID <param>
    private Long memberId;
    //提现ADD
    private Integer withdrawAddId;
    //币种 <param>
    private String coin;
    //提现数量
    private BigDecimal amount;
    //手续费
    private String fee;
    //
    private Date createTime;
    //IP地址
    private String operIp;
    //平台币种
    private String platformCoinMemo;
    //状态  <param> select[0:待处理,1:已完成,2:已取消,3:处理中]
    private Integer status;
    //拒绝原因
    private String rejectReason;
    //区块ID
    private Integer txid;
    //处理人账号
    private String auditor;
    //处理时间
    private Date auditTime;
    //
    private Integer isDelete;
}