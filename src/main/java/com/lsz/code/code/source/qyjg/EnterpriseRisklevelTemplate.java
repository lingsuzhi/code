package com.lsz.code.code.source.qyjg;

import java.util.Date;

/**
 * 企业风险分级题目模板
 */
public class EnterpriseRisklevelTemplate {

    //id <param>
    private String id;
    //上级id <param>
    private String pid;
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
    //组件初始值 <param>
    private String componentValue;
    //类别,对应t_enterprise_risklevel_classfiyproject表type为1的id值 <param>
    private String classfiyId;
    //类别,对应t_enterprise_risklevel_classfiyproject表type为2的id值 <param>
    private String projectId;
    //级次 <param>
    private Integer level;
    //是否启用;0-启用;1-停用 <param>
    private Integer isenable;
}