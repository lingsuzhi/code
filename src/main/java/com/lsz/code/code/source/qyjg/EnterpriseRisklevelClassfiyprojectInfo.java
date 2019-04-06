package com.lsz.code.code.source.qyjg;

import java.util.Date;

/**
 * 企业风险等级类别与项目信息
 */
public class EnterpriseRisklevelClassfiyprojectInfo {

    //id <param>
    private String id;
    //上级id <param>
    private String pid;
    //内容 <param>
    private String content;
    //类型:1-类别;2-项目 <param>
    private Integer type;
    //企业所属行业code,对应t_admin_dictionary表dictionary_type字段为\ <param>
    private String industryField;
    //判定准则:L-L准则;S-准则;T-特殊情况 <param>
    private String judgeRule;
    //分值(只针对制造行业有用,其它行业不需要分值) <param>
    private Integer score;
}