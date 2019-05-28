package com.lsz.code.code.source.fxjk;
import com.lsz.code.code.source.Table;

import java.util.Date;

import java.util.Date;

/**
 * 会员资料
 */
@Table(name = "m_member")
public class Member {

    private Integer id;
    //国家代码 目前默认均为 86 表示中国
    private Integer areaCode;
    //用户名 暂定邮箱，使用varchar类型 <param>
    private String name;
    //用户昵称 <param>
    private String nickName;
    //验证码 邮箱验证码，同时作为注册和找回密码的验证码
    private String smsCode;
    //邮箱验证码 邮箱验证码发送时间，做验证码过期
    private Date smsCodeTime;
    //注册时间
    private Date regTime;
    //登录ip
    private String lastLoginIp;
    //状态 0：手机/邮箱未验证，1：正常，2：冻结 <param> select[未验证,正常,冻结]
    private Integer status;
    //
    private Integer apiStatus;
    //头像
    private String headImg;
    //
    private Integer isDelete;
    //最后登录时间
    private Date lastLoginTime;
    //邀请码
    private String invitationCode;
    //上级id <param>
    private Integer parentId;
    //创建时间
    private Date createTime;
    //修改时间
    private Date updateTime;
}