package com.lsz.code.code.source.fxjk1;

import java.util.Date;

/**
 * 危险源
 */
public class DangerSource {

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

    //风险管控ID
    private String controlId;
    //对应风险单元表ID <addnotnull>
    private String dangerUnitId;
    //风险单元名称
    private String dangerUnitName;
    //危险源名称
    private String dangerName;
    //危险源位置描述
    private String dangerPosition;
    //是否重大危险源 1：是；0：否
    private Integer importantFlag;
    //重大危险源等级 1级、2级、3级
    private Integer importantLevel;
    //是否有多个同类危险源 1：是；0：否
    private Integer sameFlag;
    //同类危险源数量
    private Integer sameCount;
    //危险源坐标X
    private String positionX;
    //危险源坐标Y
    private String positionY;
    //危险源坐标Z
    private String positionZ;
    //责任部门 引用组织机构ID
    private String responsibilityDepartment;
    //责任人 引用人员表ID
    private String responsibilityUser;

}
