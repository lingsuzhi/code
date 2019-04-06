package com.lsz.code.code.source.qyjg;

import java.util.Date;

/**
 * 网格化信息
 */
public class GridInfo {

    //id <param>
    private String id;
    //网格区域编码 (t_grid_area表) <param>
    private String gridAreaCode;
    //网格区域名称 (t_grid_area表) <param>
    private String gridAreaName;
    //类别 1-网格负责人;2-网格管理员;3-其它 <param>
    private Integer type;
    //等级 <param>
    private Integer level;
    //网格人id <param>
    private String userId;
    //网格人名称 <param>
    private String userName;
    //所属部门id <param>
    private String deptId;
    //所属部门名称 <param>
    private String deptName;
    //职务id <param>
    private String posId;
    //职务名称 <param>
    private String posName;
    //联系电话 <param>
    private String telephone;
    //是否启用 0-否;1-是 <param>
    private Integer isenable;
    //创建用户
    private String createUser;
    //创建时间
    private Date createTime;
    //更新用户
    private String updateUser;
    //更新时间
    private Date updateTime;
}