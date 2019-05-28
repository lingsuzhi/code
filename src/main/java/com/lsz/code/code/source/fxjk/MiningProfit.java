package com.lsz.code.code.source.fxjk;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 挖矿收益
 */
public class MiningProfit {

    private Long id;
    //会员ID <param>
    private Long memberId;
    //收益金额 <param>
    private BigDecimal amount;
    //币种 <param>
    private String currency;
    //创建时间
    private Date createTime;
    //
    private Integer isDelete;
    //发放状态 select[0:未发放,1:已发放,2:异常]  <param>
    private Integer status;
    //发放时间
    private Date paymentTime;
    //矿机序列号
    private String serialNumber;
}