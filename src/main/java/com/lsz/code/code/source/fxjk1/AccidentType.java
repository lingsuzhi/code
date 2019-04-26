package com.lsz.code.code.source.fxjk1;

import java.util.Date;

/**
 * 危险源事故类型
 */
public class AccidentType {

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
    //事故类型 <addnotnull> <param>
    private String accidentType;
    //类型名称 <param>
    private String accidentName;
}
