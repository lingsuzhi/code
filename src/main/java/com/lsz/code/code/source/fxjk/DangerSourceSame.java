package com.lsz.code.code.source.fxjk;

import java.util.Date;

/**
 * 同类危险源
 */
public class DangerSourceSame {

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

    //危险源ID  <addnotnull> <param>
    private String dangerId;
    //对应风险单元表Id <addnotnull> <param>
    private String dangerUnitId;
    //危险源位置描述 <param>
    private String regionalPosition;
    //危险源坐标X <param>
    private String positionX;
    //危险源坐标Y <param>
    private String positionY;
    //危险源坐标Z <param>
    private String positionZ;
    //责任部门 引用ID <param>
    private String responsibilityDepartment;
    //责任人 引用ID <param>
    private String responsibilityUser;

}
