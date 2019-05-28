package com.lsz.code.code.source.fxjk;

import com.lsz.code.code.source.Table;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 会员资产信息
 */
@Table(name = "m_assets")
public class Assets {

    private Long id;
    //用户ID <param>
    private Long memberId;
    //币种 <param>
    private String coin;
    //可用余额 <param>
    private BigDecimal balance;
    //冻结余额
    private BigDecimal frozenBalance;
    //
    private Date createTime;
    //
    private Integer isDelete;
    //
    private Date updateTime;
}