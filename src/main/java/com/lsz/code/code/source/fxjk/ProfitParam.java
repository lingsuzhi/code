package com.lsz.code.code.source.fxjk;

import com.lsz.code.code.source.Table;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 分佣配置
 */
@Table(name = "m_profit_param")
public class ProfitParam {

    private Integer id;
    //计算模型 如 百分比和固定金额 <param> select[百分比,固定金额]
    private String calModel;
    //是否删除
    private Integer isDelete;
    //
    private Date updateTime;
    //
    private Date createTime;
    //交易方式 (分润或者提现) <param> select[分润,提现]
    private String tradeMode;
    //级别— 二级 <param> select[—级,二级]
    private String leve;
    //人数
    private String conditions;
    //分佣值 如：40%
    private BigDecimal profitAmount;
}