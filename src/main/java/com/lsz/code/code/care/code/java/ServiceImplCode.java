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
public class ServiceImplCode implements JavaCode {

    public final static String ApiOldFile = "ServiceImpl.java";
    public final static String DoFilePath =  ServiceCode.DoFilePath +  "impl" + "\\";

    @Override
    public String apply(DtoBO dtoBO) {
        CodeStringBuilder sb = new CodeStringBuilder();
        String fileStr = FileUtil.readFileStr(new File(DtoToCode.OldFilePath + ApiOldFile));
        String upperCase = StrUtil.oneUpperCase(dtoBO.getName());
        sb.put("Uname", upperCase);
        sb.put("Lname", StrUtil.oneLoweCase(dtoBO.getName()));
        sb.put("describe", dtoBO.getDescribe());

        sb.put("addnotnull", addnotnull(dtoBO));
        sb.put("formatDo", formatDo(dtoBO));

        sb.put("defaultValue", defaultValue(dtoBO));
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

    private String defaultValue(DtoBO dtoBO) {


        CodeStringBuilder stringBuilder = new CodeStringBuilder();
        stringBuilder.addTab();
        stringBuilder.addTab();
        List<DtoAttrBO> attrList = dtoBO.getAttrList();
        if (CollectionUtils.isEmpty(attrList)) {
            return null;
        }

        for (DtoAttrBO dtoAttrBO : attrList) {
            String key = "<def=";
            if (dtoAttrBO.getRemStr().contains(key)) {
                String val = StrUtil.kuohaoStr(dtoAttrBO.getRemStr(), key, ">");
                stringBuilder.appendln("parameterMap.putIfAbsent(\"【】\", 【】);", StrUtil.oneLoweCase(dtoAttrBO.getNameStr()), val);
            }
        }
        return stringBuilder.toString();
    }

    private String formatDo(DtoBO dtoBO) {
        CodeStringBuilder stringBuilder = new CodeStringBuilder();
        stringBuilder.addTab();
        stringBuilder.addTab();
        List<DtoAttrBO> attrList = dtoBO.getAttrList();
        if (CollectionUtils.isEmpty(attrList)) {
            return null;
        }

        for (DtoAttrBO dtoAttrBO : attrList) {
            if (dtoAttrBO.getRemStr().contains("<Date>")) {

                stringBuilder.appendln("CommonUtils.timestampToStr(map, \"【】\", false);", StrUtil.oneLoweCase(dtoAttrBO.getNameStr()));
            } else if (dtoAttrBO.getRemStr().contains("<DateDay>")) {

                stringBuilder.appendln("CommonUtils.timestampToStr(map, \"【】\", true);", StrUtil.oneLoweCase(dtoAttrBO.getNameStr()));
            }
        }
        return stringBuilder.toString();
    }

    private String addnotnull(DtoBO dtoBO) {
        CodeStringBuilder stringBuilder = new CodeStringBuilder();
        stringBuilder.addTab();
        stringBuilder.addTab();
        List<DtoAttrBO> attrList = dtoBO.getAttrList();
        if (CollectionUtils.isEmpty(attrList)) {
            return null;
        }

        for (DtoAttrBO dtoAttrBO : attrList) {
            if (!dtoAttrBO.getRemStr().contains("<addnotnull>")) {
                continue;
            }
            String rem = StrUtil.getRemName(dtoAttrBO.getRemStr());
            stringBuilder.appendln("if (StringUtils.isEmpty(ValidateUtil.paramIsEmpty(\"【】\", parameterMap))) {", StrUtil.oneLoweCase(dtoAttrBO.getNameStr()));

            stringBuilder.appendln("    throw new RuntimeException(\"新增操作失败,【】 不能为空！\");", rem);
            stringBuilder.appendln("}");
        }
        return stringBuilder.toString();
    }
}
