package com.lsz.code.code.source.fxjk;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 矿机保证金
 */
public class MachineDeposit {

    private Long id;
    //
    private Integer isDelete;
    //
    private Date createTime;
    //
    private Date updateTime;
    //用户ID <param>
    private Long memberId;
    //币种 FN <param>
    private String currency;
    //保证金
    private BigDecimal depositMoney;
    //矿机序列号
    private String serialNumber;
    //是否提取 <param> select[0:已缴纳,1:已提取]
    private Integer isExtract;

}