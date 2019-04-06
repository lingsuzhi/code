package com.lsz.code.code.source.qyjg;
import java.util.Date;

/**
 * 企业风险等级分值
 */
public class EnterpriseRisklevelGrade {

    // <param>
    private String id;
    //企业id <param>
    private String enterpriseId;
    //企业所属行业code,对应t_admin_dictionary表dictionary_type字段为\ <param>
    private String industryField;
    //登记联系人 <param>
    private String registerUser;
    //登记联系电话 <param>
    private String reregisterTelephone;
    //风险等级:Y-黄色;B-蓝色:O-橙色;R-红色 <param>
    private String riskLevel;
    //风险名称 <param>
    private String riskName;
    //得分(r=l*s) <param>
    private Integer rScore;
    //L类型的得分 <param>
    private Integer lScore;
    //S类型的得分 <param>
    private Integer sScore;
    //是否存在特殊情况(危化行业和烟火行业会有):1-是;0-否 <param>
    private Integer isspecial;
    //风险等级(安监复评使用):Y-黄色;B-蓝色:O-橙色;R-红色 <param>
    private String riskLevelAj;
    //风险名称(安监复评使用 <param>
    private String riskNameAj;
    //得分(r=l*s,安监复评使用) <param>
    private Integer rScoreAj;
    //L类型的得分(安监复评使用) <param>
    private Integer lScoreAj;
    //S类型的得分(安监复评使用) <param>
    private Integer sScoreAj;
    //是否存在特殊情况(危化行业和烟火行业会有并在安监岗使用):1-是;0-否 <param>
    private Integer isspecialAj;
    //任务id <param>
    private String taskId;
    //流程id <param>
    private String instanceId;
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
    //生产、储存的主或者许可经营范围 <param>
    private String chemicals;
    //文件id <param>
    private String fileId;
}
