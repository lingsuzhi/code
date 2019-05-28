package com.lsz.code.code.source.fxjk;

import com.lsz.code.code.source.Table;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 会员资产流水
 */
@Table(name = "m_assets_log")
public class AssetsLog {

    //
    private Long id;
    //会员ID <param>
    private Long memberId;
    //币种 <param>
    private String coin;
    //业务类型 <param> select[0:保证金,1:佣金,2:挖矿,3:充值,4:提现,5:兑换]
    private Integer businessType;
    //金额数量
    private BigDecimal amount;
    //是否删除
    private Integer isDelete;
    //
    private Date createTime;
    //扩展字段 <隐藏>
    private String extField;
    //扩展字段 <隐藏>
    private String extFiled2;
}