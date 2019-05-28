package com.lsz.code.code.source.fxjk;

import java.util.Date;

/**
 * 短信发送记录
 */
public class SmsRecord {

    private Integer id;
    //用户ID <param>
    private Long memberId;
    //手机号码 <param>
    private String phone;
    //消息内容 <param>
    private String msg;
    //DistKey <隐藏>
    private String distKey;
    //
    private Date createTime;
    //发送时间
    private Date expireTime;
    //是否删除
    private Integer isDelete;
    //发送状态  <param>  select[0:成功,1:失败]
    private Integer status;
}