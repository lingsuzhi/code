package com.lsz.code.code.source.fxjk;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 兑换记录
 */
public class CoinExchange {

    private Long id;
    //用户ID <param>
    private Long memberId;
    //目标币种 <param>
    private String targetCurrency;
    //源币种 <param>
    private String sourceCurrency;
    //订单编号
    private String orderNo;
    //源币种数量
    private BigDecimal sourceAmount;
    //目标币种数量
    private BigDecimal targetAmount;
    //状态 <param>  select[0:成功,1:失败]
    private Integer status;
    //是否删除
    private Integer isDelete;
    //创建时间
    private Date createTime;

}