package com.lsz.code.code.source.fxjk;

import java.util.Date;

/**
 * 危险源事故原因
 */
public class DangerControl {

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
    //管控名称 <param> <addnotnull>
    private String controlName;

    //行业类型 引用行业分类表ID <param> 
    private String industryType;

    //是否必须回执 1：是；2：否 <param>
    private Integer receiptFlag;
    //回执期限 单位：小时 如果页面选天要计算成小时 <param>
    private Integer receiptLimit;
    //是否返回成果物 1：是；2：否 <param>
    private Integer resultFlag;
    //返回成果物期限 单位：天 <param>
    private Integer resultLimit;
    //是否要求上报 1：是；2：否 <param>
    private Integer reportedFlag;
    //上报期限 单位：小时 如果页面选天要计算成小时 <param>
    private Integer reportedLimit;
    //发布状态  1：已保存；2：未发部；3：已发布 <param>
    private Integer publishStatus;
    //发布时间 <param> <Date>
    private Date publishDate;
    //发布级别 1：省级；2：市级；3：区级；4：公司级；5：部门级；6：班组级；7：其他级 <param>
    private Integer publishLevel;
    //流程ID
    private String instanceId;

}
