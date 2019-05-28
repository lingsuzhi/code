package com.lsz.code.code.source.fxjk;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 矿机租赁
 */
public class MachineLease {

    private Integer id;
    //用户ID <param>
    private Long memberId;
    //租赁时间
    private Date createTime;
    //租赁费用
    private BigDecimal cost;
    //过期时间
    private Date expirationTime;
    //
    private Integer isDelete;
    //创建人 <param>
    private String creater;
    //修改人 <param>
    private String modifier;
    //矿机序列号 <param>
    private String serialNumber;
    //是否已过期 <param> select[0:未过期,1:已过期]
    private Integer isExpired;
}