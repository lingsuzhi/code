package com.lsz.code.code.source.qyjg;

import java.util.Date;

/**
 * 网格区域信息
 */
public class GridArea {

    //id <param>
    private String id;
    //上级id <param>
    private String pid;
    //编码 <param>
    private String code;
    //名称 <param>
    private String name;
    //级次 <param>
    private Integer level;
    //pc端坐标位置 <param>
    private String point;
    //市编码 <param>
    private String cityCode;
    //市名称 <param>
    private String cityName;
    //区编码 <param>
    private String areaCode;
    //区名称 <param>
    private String areaName;
    //县编码 <param>
    private String townCode;
    //县名称 <param>
    private String townName;
    //村(小区)编码 <param>
    private String villageCode;
    //村(小区)名称 <param>
    private String villageName;
    //是否启用 :0-否;1-是 <param>
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