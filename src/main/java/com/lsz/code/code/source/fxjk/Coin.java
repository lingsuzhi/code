package com.lsz.code.code.source.fxjk;

import com.lsz.code.code.source.Table;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 货币基本信息
 */
@Table(name = "d_coin")
public class Coin {

    private Integer id;
    //币种 <param>
    private String currency;
    //币种名称 <param>
    private String currencyName;
    //小数位
    private Integer precisions;
    //最小充值 小于此额度不认
    private BigDecimal minRecharge;
    //最小提现 小于此额度不让提现
    private BigDecimal minWithdraw;
    //提现手续费
    private BigDecimal withdrawFee;
    //提现是否百分比 0表示否
    private Boolean withdrawFeePercent;
    //最低提现手续费
    private BigDecimal withdrawFeeMin;
    //最高提现手续费
    private BigDecimal withdrawFeeMax;
    //是否数字货币 目前除CNY之外，都是数字货币
    private Boolean isCoin;
    //是否太坊架构
    private Boolean isInEth;
    //是否可充值
    private Boolean canRecharge;
    //是否可提现
    private Boolean canWithdraw;
    //是否显示
    private Boolean isShow;
    //排序
    private Integer orderBy;
    //
    private Integer isDelete;
    //
    private Date createTime;
    //
    private Date updateTime;
}