package com.lsz.code.code.source.fxjk;

import java.util.Date;

/**
 * 矿机
 */
public class MiningMachine {

    private Integer id;
    //用户ID <param>
    private Long memberId;
    //序列号
    private String serialNumber;
    //矿机状态 <param>  select[0:未运行,1:运行中,2:配置中]
    private Integer status;
    //
    private Date createTime;
    //
    private Date updateTime;
    //
    private Integer isDelete;
    //创建人
    private String creater;
    //修改人
    private String modifier;
}