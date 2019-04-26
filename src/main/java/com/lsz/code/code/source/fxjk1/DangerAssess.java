package com.lsz.code.code.source.fxjk1;

import java.util.Date;

/**
 * 风险评估
 */
public class DangerAssess {

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
    //对应危险源表ID <param> <addnotnull>
    private String dangerId;
    //取事故类型表ID <param> <addnotnull>
    private String accidentType;

    // lecL值 <param>
    private Integer  lecL;
    // lecE值 <param>
    private Integer  lecE;
    // lecC值 <param>
    private Integer  lecC;
    // lecD值 <param>
    private Integer  lecD;
    //LS_L值 <param>
    private Integer lsL;
    //LS_S值 <param>
    private Integer lsS;
    //LS_R值 <param>
    private Integer lsR;
    //风险等级 取字曲表数据 <param>
    private String dangerLevel;
    //评估类型 1：固有风险；2：残余风险 <def=1> <param>
    private Integer assessType;

}
