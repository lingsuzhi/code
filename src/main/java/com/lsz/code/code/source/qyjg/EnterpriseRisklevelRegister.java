package com.lsz.code.code.source.qyjg;

import java.util.Date;

/**
 * 企业风险分级登记
 */
public class EnterpriseRisklevelRegister {

    // <param>
    private String id;
    //上级id <param>
    private String pid;
    //企业id <param>
    private String enterpriseId;
    //题目编码 <param>
    private String code;
    //企业所属行业code,对应t_admin_dictionary表dictionary_type字段为\ <param>
    private String industryField;
    //判定准则:L-L准则;S-准则;T-特殊情况 <param>
    private String judgeRule;
    //内容 <param>
    private String content;
    //选项类型:none-无;input-文本输入框;inputnum-数字文本输入框;select-下拉框;radio-单选框;checkbox-复选框;table-表格;file-文件 <param>
    private String component;
    //组件初始化值 <param>
    private String componentValue;
    //类别,对应t_enterprise_risklevel_classfiyproject表type为0的id值 <param>
    private String classfiyId;
    //类别,对应t_enterprise_risklevel_classfiyproject表type为1的id值 <param>
    private String projectId;
    //级次 <param>
    private Integer level;
    //登记值，例如:input组件保存输入的值，select组件保存下拉选中的值,radio和checkbox保存选中值 <param>
    private String value;
    //得分(安监岗复评用) <param>
    private String valueAj;
    //是否启用;1-启用;0-停用 <param>
    private Integer isenable;
    //创建时间
    private Date createTime;
    //创建人
    private String createUser;
    //更新时间
    private Date updateTime;
    //更新用户
    private String updateUser;
    //创建时间(安监复评用) <param>
    private Date createTimeAj;
    //创建人(安监复评用) <param>
    private String createUserAj;
    //更新时间(安监复评用) <param>
    private Date updateTimeAj;
    //更新用户(安监复评用) <param>
    private String updateUserAj;
}