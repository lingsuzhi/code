package com.lsz.code.code.source.fxjk1;

import java.util.Date;

/**
 * 危险源辨识
 */
public class DangerControlMeasures {

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
    //对应危险源事故原因表ID <addnotnull> <param>
    private String accidentCauseId;
    //管控类别 取字典表数据，如：工程技术、人员培训等 <param>
    private String involvedType;
    //管制措施说明 <param>
    private String controlMeasures;
}
