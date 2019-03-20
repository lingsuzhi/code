package com.lsz.code.code.source.fxjk;

import java.util.Date;

/**
 * 危险源事故原因
 */
public class DangerControlFlow {

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
    //组织机构ID <param>
    private String orgId;

    //回执状态 1：未回执；2：已回执； <param> <def=1>
    private Integer receiptStatus;
    //回执时间 <param> <Date>
    private Date receiptTime;
    //返回成果物状态 1：未返回；2：已返回 <param><def=1>
    private Integer resultStatus;
    //返回成果物时间 <param><Date>
    private Date resultTime;
    //上报状态 1：未上报；2：已上报； <param><def=1>
    private Integer reportedFlag;
    //上报时间 <param><Date>
    private Date reportedTime;
    //工作流中处理的taskid <param>
    private String taskId;
    //流程ID
    private String instanceId;

}
