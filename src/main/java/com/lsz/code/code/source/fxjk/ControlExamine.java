package com.lsz.code.code.source.fxjk;

import java.util.Date;

/**
 * 危险源事故原因
 */
public class ControlExamine {

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

    //行政ID 所属城市 <param>
    private String cityId;
    //企业ID <param>
    private String companyId;

    //风险单元ID
    private String dangerUnitId;
    //'审核状态 0：未审核；1：审核通过；2：驳回'
    private Integer examineStatus;
    //'审核意见'
    private String examineOpinion;
    //'审核内容'
    private String examineContent;
    //'审核时间'
    private Date examineTime;
    //'审核人'
    private String examineUser;
    //'审核人签名(签名图片目录)'
    private String examineSignature;


    //工作流中处理的taskid <param>
    private String taskId;
    //流程ID <param>
    private String instanceId;

}
