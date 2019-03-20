package com.lsz.code.code.source.fxjk;

import java.util.Date;

/**
 * 危险源事故原因
 */
public class DangerAssessContent {

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
    //评估方式 1：作业条件危险性评价法；2：风险矩阵法； <param>
    private Integer assessType;
    //危险源发生的可能性(L) <param>
    private String occurL;
    //危险环境频率(E) <param>
    private String frequencyE;
    //危险严重程度(C) <param>
    private String degreeC;
    //类似风险事故发生概率Q1 <param>
    private String similarHappenQ1;
    //企业安全管理水平 Q2 <param>
    private String managementLevelQ2;
    //风险评估单元是否存在隐患Q3 <param>
    private String hiddenDangerQ3;
    //死亡人数 <param>
    private String deathToll;
    //受伤人数 <param>
    private String injuryNumber;
    //经济损失 <param>
    private String economicLosses;

}
