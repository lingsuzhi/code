package com.lsz.code.code.source.fxjk;

import java.util.Date;

/**
 * 字典定义
 */
public class Dict {

    //UUID
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

    //备注说明
    private String bak;

    //字典名称 <param>
    private String dictName;

    //字典标识 <param>
    private String dictLabel;
}
