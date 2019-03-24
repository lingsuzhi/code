package com.lsz.code.code.source.fxjk;

import java.util.Date;

/**
 * 危险源事故原因
 */
public class DangerControlProcess {

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
    //管控ID <param> <addnotnull>
    private String controlId;
    //风险单元ID <param> 
    private String controlUnitId ;
    //引用风险管控流转表ID <param> 
    private String controlFlowId ;
    //流转阶段 1:上报；2：下发 ；3：回执 ；4：提交成果物；5：其他<param> 
    private Integer flowStage;
    //确认时间 <param> 
    private Date verifyTime ;
    //确认人ID <param> 
    private String verifyUser;
    //确认人签名(图片目录) <param> 
    private String verifySignature;
    //工作流中处理的taskid <param>
    private String taskId;
    //流程ID <param>
    private String instanceId;

}
