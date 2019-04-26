package com.lsz.code.code.source.fxjk1;

import java.util.Date;

/**
 * 风险等级评估
 */
public class DangerAssessLevel {

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


    //风险等级 <param> <addnotnull>
    private String dangerLevel;
    //管控层级 <param> <addnotnull>
    private String controlLevel;
    //辩识部门ID <param>
    private String identifyDeptment;
    //辨识人ID 取人员表ID <param>
    private String identifyUser;

    //评估类型 1：固有风险；2：残余风险 <def=1> <param>  <addnotnull>
    private Integer assessType;

}
