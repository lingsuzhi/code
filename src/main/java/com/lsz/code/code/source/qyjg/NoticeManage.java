package com.lsz.code.code.source.qyjg;

import java.util.Date;

/**
 * 公告管理
 */
public class NoticeManage {

    //唯一标识 <param>
    private String id;
    //标题 <param>
    private String title;
    //公告类型 1-法律法规;9-其他 <param>
    private Integer type;
    //地域范围id (数据来源t_admin_dictionary表中dictionary_type为"regionRange"的dictionary_id字段值) <param>
    private String regionRangeId;
    //地域范围id (数据来源t_admin_dictionary表中dictionary_type为"regionRange"的dictionary_name字段值) <param>
    private String regionRangeName;
    //接收对象 0-全部,1-企业,2-安监局内部 <param>
    private Integer acceptObject;
    //行业分类id (数据来源t_admin_dictionary表中dictionary_type为"industryType"的dictionary_id字段值) <param>
    private String industryTypeId;
    //行业分类id 数据来源t_admin_dictionary表中dictionary_type为"industryType"的dictionary_name字段值 <param>
    private String industryTypeName;
    //公告内容 <param>
    private String content;
    //附件id <param>
    private String fileId;
    //图片id <param>
    private String imageId;
    //是否回执 0-否,1-是 <param>
    private Integer isReceipt;
}