package com.lsz.code.code.care.code.java;

import com.lsz.code.code.bo.DtoAttrBO;
import com.lsz.code.code.bo.DtoBO;
import com.lsz.code.code.care.DtoToCode;
import com.lsz.code.code.common.CodeStringBuilder;
import com.lsz.code.code.common.StrUtil;
import com.lsz.code.code.utils.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.io.File;
import java.util.List;

@Component
@Slf4j
public class MapperXmlCode implements JavaCode {

    public final static String ApiOldFile = "Mapper.xml";
    public final static String DoFilePath = "D:\\fy\\projectCode-安监局\\projectCode\\aj-provider-business-8003\\src\\main\\resources\\mapper\\monitor" + "\\";

    @Override
    public String apply(DtoBO dtoBO) {
        CodeStringBuilder sb = new CodeStringBuilder();
        String fileStr = FileUtil.readFileStr(new File(DtoToCode.OldFilePath + ApiOldFile));
        String upperCase = StrUtil.oneUpperCase(dtoBO.getName());
        sb.put("Uname", upperCase);
        sb.put("Lname", StrUtil.oneLoweCase(dtoBO.getName()));
        sb.put("describe", dtoBO.getDescribe());

        sb.put("select_column", select_column(dtoBO));
        sb.put("tableName", "t_" + StrUtil.strLowDo(dtoBO.getName()));

        sb.put("base_column", base_column(dtoBO));
        sb.put("updateSet", updateSet(dtoBO));
        sb.put("value_column", value_column(dtoBO));
        sb.put("selectWhere", selectWhere(dtoBO));

        sb.appendln(fileStr);

        File doFile = new File(DoFilePath + upperCase + ApiOldFile);
        if (doFile.exists() && !DtoToCode.isDelete) {
            log.info("{} 已经存在", ApiOldFile);
            return null;
        }
        if (doFile.exists()) {
            doFile.delete();
        }
        FileUtil.doFileStr(doFile, sb.toString());
        log.info("{} 执行完成", ApiOldFile);
        return sb.toString();
    }

    private String base_column(DtoBO dtoBO) {
        CodeStringBuilder stringBuilder = new CodeStringBuilder();
        stringBuilder.addTab();
        List<DtoAttrBO> attrList = dtoBO.getAttrList();
        if (CollectionUtils.isEmpty(attrList)) {
            return null;
        }
        for (DtoAttrBO dtoAttrBO : attrList) {
            if (dtoAttrBO.getRemStr().contains("<隐藏>")) {
                continue;
            }
            String nameStr = dtoAttrBO.getNameStr();
            if (stringBuilder.toString().length() > 0) {
                stringBuilder.appendNoTab(",");
            }
            String lowDo = StrUtil.strLowDo(nameStr);

            stringBuilder.appendNoTab(lowDo);

        }
        return stringBuilder.toString();
    }

    public String selectWhere(DtoBO dtoBO) {
        CodeStringBuilder stringBuilder = new CodeStringBuilder();
        stringBuilder.addTab();
        List<DtoAttrBO> attrList = dtoBO.getAttrList();
        if (CollectionUtils.isEmpty(attrList)) {
            return null;
        }
        for (DtoAttrBO dtoAttrBO : attrList) {
            if (!dtoAttrBO.getRemStr().contains("<param>")) {
                continue;
            }
            String rem = dtoAttrBO.getRemStr();
            stringBuilder.newLine();
            stringBuilder.appendln("<if test=\"null != 【】\">", dtoAttrBO.getNameStr());
            stringBuilder.appendln("AND tar.【】 = #{【】}", StrUtil.strLowDo(dtoAttrBO.getNameStr()), dtoAttrBO.getNameStr());
            stringBuilder.appendln("</if>");
        }
        return stringBuilder.toString();
    }

    private String updateSet(DtoBO dtoBO) {
        CodeStringBuilder stringBuilder = new CodeStringBuilder();
        stringBuilder.addTab();
        List<DtoAttrBO> attrList = dtoBO.getAttrList();
        if (CollectionUtils.isEmpty(attrList)) {
            return null;
        }
        for (DtoAttrBO dtoAttrBO : attrList) {
            if (dtoAttrBO.getRemStr().contains("<隐藏>")) {
                continue;
            }
            String nameStr = dtoAttrBO.getNameStr();
//            if (stringBuilder.toString().length() > 0) {
//                stringBuilder.appendNoTab(",");
//            }
            String lowDo = StrUtil.strLowDo(nameStr);

            String str = "<if test=\"【】 != null\">【】=#{【】},</if>";
            stringBuilder.appendln(str, nameStr, lowDo, nameStr);
        }
        return stringBuilder.toString();
    }

    private String value_column(DtoBO dtoBO) {
        CodeStringBuilder stringBuilder = new CodeStringBuilder();
        stringBuilder.addTab();
        List<DtoAttrBO> attrList = dtoBO.getAttrList();
        if (CollectionUtils.isEmpty(attrList)) {
            return null;
        }
        for (DtoAttrBO dtoAttrBO : attrList) {
            if (dtoAttrBO.getRemStr().contains("<隐藏>")) {
                continue;
            }
            String nameStr = dtoAttrBO.getNameStr();
            if (stringBuilder.toString().length() > 0) {
                stringBuilder.appendNoTab(",");
            }

            stringBuilder.appendNoTab("#{" + nameStr + "}");

        }
        return stringBuilder.toString();
    }


    private String select_column(DtoBO dtoBO) {
        CodeStringBuilder stringBuilder = new CodeStringBuilder();
//        stringBuilder.addTab();
        List<DtoAttrBO> attrList = dtoBO.getAttrList();
        if (CollectionUtils.isEmpty(attrList)) {
            return null;
        }
        for (DtoAttrBO dtoAttrBO : attrList) {
            if (dtoAttrBO.getRemStr().contains("<隐藏>")) {
                continue;
            }
            String nameStr = dtoAttrBO.getNameStr();
            if (stringBuilder.toString().length() > 0) {
                stringBuilder.appendNoTab(",");
            }
            String lowDo = StrUtil.strLowDo(nameStr);
            if (!lowDo.equals(nameStr)) {
                stringBuilder.appendln("【】 as 【】", lowDo, nameStr);
            } else {
                stringBuilder.appendNoTab(nameStr);
            }
        }
        return stringBuilder.toString();
    }
}
