package com.lsz.code.code.source.fxjk;

import java.util.Date;

/**
 * 用户资料
 */
public class AdminInfo {

    private Long id;
    //用户名 <param>
    private String userId;
    //用户昵称 <param>
    private String nickName;
    //角色 <param> select[0:管理员,1:来宾,2:其他]
    private Integer role;
    //手机号码 <param>
    private String cellPhone;
    //密码 <隐藏>
    private String password;
    //加密类型 <隐藏>
    private String pwdType;
    //注册时间 <隐藏>
    private Date date;
    //创建人 <param>
    private String createBy;
    //创建时间
    private Date createTime;
    //修改人 <隐藏>
    private String updateBy;
    //修改时间
    private Date updateTime;
    // <隐藏>
    private String uuid;
    private Integer isDelete;
}