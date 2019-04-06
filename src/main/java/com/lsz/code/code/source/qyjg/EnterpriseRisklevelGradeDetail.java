package com.lsz.code.code.source.qyjg;

import java.util.Date;

/**
 * 企业风险等级分值明细
 */
public class EnterpriseRisklevelGradeDetail {

    // <param>
    private String id;
    //企业id <param>
    private String enterpriseId;
    //类别,对应t_enterprise_risklevel_classfiyproject表type为0的id值 <param>
    private String classfiyId;
    //得分 <param>
    private Integer score;
}