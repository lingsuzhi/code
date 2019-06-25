package com.lsz.code.code.source.fxjk;

import java.util.Date;

/**
 * 商品信息
 */
public class ProductInfo {

    //ID <key>
    private Long id;
    //名称 <param>
    private String name;
    //上架时间
    private Date pushTime;
    //类型 select[pt:普通商品,gj:高级商品,qt:其他商品] <param>
    private String type;
    //创建时间
    private Date createTime;
    //修改时间
    private Date updateTime;
}