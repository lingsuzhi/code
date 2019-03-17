package com.lsz.code.code.source.fxjk;

import java.util.Date;

/**
 * 危险源事故原因
 */
public class AccidentCause {

    //UUID   <param>
    private String id;

    //状态标识(备用) 1：有效；0：无效
    private Integer status;

    //删除标识 1：未删除；0：已删除
    private Integer delFlag;

    //创建时间
    private Date createTime;

    //创建人ID
    private String createId;

    //修改时间
    private Date updateTime;

    //修改人ID
    private String updateId;

    //备注说明 <param>
    private String bak;

    //对应危险源表ID <addnotnull> <param>
    private String dangerId;
    //事故类型表 <param>
    private String accidentType;
    //原因类型 引用字典数据，如：人的、物的、环境的等 <param>
    private String causeType;
    //事故原因 <param>
    private String accidentCause;
    //原因说明 <param>
    private String causeExplain;
}
