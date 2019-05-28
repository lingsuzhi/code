package com.lsz.code.code.source.fxjk;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 分润记录
 */
public class DistributionRecord {

    private Long id;
    //用户ID <param>
    private Long memberId;
    //矿机序列号 <param>
    private String serialNumber;
    //分润币种 <param>
    private String currency;
    //一级用户ID
    private Long oneLeveId;
    //二级用户ID
    private Long twoLeveId;
    //一级分润金额
    private BigDecimal oneLeveAmount;
    //二级用户分润金额
    private BigDecimal twoLeveAmount;
    //
    private Date createTime;
    //分润状态 <param>  select[0:未发放,1:已发放,3:发放异常]
    private Integer status;
    //支付时间
    private Date paymentTime;
    //一级用户分销比例
    private BigDecimal oneLevePercentage;
    //二级用户分销比例
    private BigDecimal twoLevePercentage;

    //
    private Integer isDelete;
    //
    private Date updateTime;
}