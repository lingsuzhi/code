package com.lsz.code.code.source.fxjk1;

import java.util.Date;

/**
 * 风险单元
 */
public class DangerUnit {

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

    //行政ID，所属城市 <param>
    private String cityId;
    //企业ID <param>
    private String companyId;
    //组织机构ID <param>
    private String orgId;
    //风险管控ID <param>
    private String controlId;

    //单元名称 <param> <addnotnull>
    private String unitName;
    //上级单元ID <param>
    private String parentUnitId;
    //行业类型 引用行业分类表ID <param> <addnotnull>
    private String industryType;
    //单元级别 1:一级（主单元）；2：二级；3：三级；4：四级；5：五级 <param>
    private Integer unitLevel;

    //区域位置 <param>
    private String regionalPosition;
    //引用组织机构表ID <param>
    private String responsibilityDepartment;
    //引用人员表ID <param>
    private String responsibilityUser;
 
}
