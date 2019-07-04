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
import org.springframework.util.StringUtils;

import java.io.File;
import java.util.List;

@Component
@Slf4j
public class DtoCode implements JavaCode {

    public final static String ApiOldFile = "DTO.java";
    public final static String DoFilePath = JavaCode.CommonPath + "\\dto\\";

    public static boolean isBase(String str) {
        if ("isDelete".equalsIgnoreCase(str)) return true;
        if ("createBy".equalsIgnoreCase(str)) return true;
        if ("updateBy".equalsIgnoreCase(str)) return true;
        if ("createByName".equalsIgnoreCase(str)) return true;
        if ("updateByName".equalsIgnoreCase(str)) return true;
//        if ("createTime".equalsIgnoreCase(str)) return true;
        if ("updateTime".equalsIgnoreCase(str)) return true;
        if ("version".equalsIgnoreCase(str)) return true;

        if ("sort".equalsIgnoreCase(str)) return true;
        return false;
    }

    @Override
    public String apply(DtoBO dtoBO) {
        CodeStringBuilder sb = new CodeStringBuilder();
        String fileStr = FileUtil.readFileStr(new File(DtoToCode.OldFilePath + ApiOldFile));
        String upperCase = StrUtil.oneUpperCase(dtoBO.getName());
        sb.put("Uname", upperCase);
        sb.put("Lname", StrUtil.oneLoweCase(dtoBO.getName()));
        sb.put("describe", dtoBO.getDescribe());
        sb.put("attributeDTO", attribute(dtoBO));
        sb.appendln(fileStr);

        File doFile = new File(DoFilePath + upperCase + ApiOldFile);
        if (doFile.exists() && !DtoToCode.isDelete) {
            log.info("{} 已经存在", ApiOldFile);
            return null;
        }
        if (doFile.exists()) doFile.delete();
        FileUtil.doFileStr(doFile, sb.toString());
        log.info("{} 执行完成", ApiOldFile);
        return sb.toString();
    }

    //attributeDTO
    public String attribute(DtoBO dtoBO) {
        CodeStringBuilder stringBuilder = new CodeStringBuilder();
        stringBuilder.addTab();
        List<DtoAttrBO> attrList = dtoBO.getAttrList();
        if (CollectionUtils.isEmpty(attrList)) {
            return null;
        }
        for (DtoAttrBO dtoAttrBO : attrList) {
            if (dtoAttrBO.getRemStr().contains("<隐藏>") || isBase(dtoAttrBO.getNameStr())) {
                continue;
            }
            String rem = dtoAttrBO.getRemStr();
//            stringBuilder.newLine();

            if (!StringUtils.isEmpty(rem)) {
                stringBuilder.appendln("@ApiModelProperty(value=\"【】\",name=\"【】\")"
                        , StrUtil.getRemName(rem), dtoAttrBO.getNameStr());
            }
//            if ("LocalDateTime".equalsIgnoreCase(dtoAttrBO.getTypeStr())) {
//                stringBuilder.appendln("@DateTimeFormat(pattern = \"yyyy-MM-dd HH:mm:ss\")");
//            }
            String str = "private " + dtoAttrBO.getTypeStr() + " " + dtoAttrBO.getNameStr() + ";";
            stringBuilder.appendln(str);
            stringBuilder.newLine();
        }


        for (DtoAttrBO dtoAttrBO : attrList) {
            String key = ":{";
            String remStr = dtoAttrBO.getRemStr();
            int pos = remStr.indexOf(key);
            if (pos != -1) {
                int i = remStr.lastIndexOf(" ", pos);
                if (i != -1) {
                    String s = remStr.substring(i + 1, pos);
                    if (!StringUtils.isEmpty(remStr)) {
                        stringBuilder.appendln("@ApiModelProperty(value=\"【】\",name=\"【】\")"
                                , StrUtil.getRemName(remStr) + " " + s, dtoAttrBO.getNameStr());
                    }
                    String str = "private " + "String" + " " + dtoAttrBO.getNameStr() + "Name;";
                    stringBuilder.appendln(str);
                    stringBuilder.newLine();
                }
            }
        }
        return stringBuilder.toString();
    }
}
