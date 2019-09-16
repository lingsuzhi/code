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
public class PojoCode implements JavaCode {

    public final static String ApiOldFile = "Pojo.java";
    public final static String DoFilePath = JavaCode.CommonPath + "\\pojo\\";

    @Override
    public String apply(DtoBO dtoBO) {
        CodeStringBuilder sb = new CodeStringBuilder();
        String fileStr = FileUtil.readFileStr(new File(DtoToCode.OldFilePath + ApiOldFile));
        String upperCase = StrUtil.oneUpperCase(dtoBO.getName());
        sb.put("Uname", upperCase);
        sb.put("Lname", StrUtil.oneLoweCase(dtoBO.getName()));
        sb.put("describe", dtoBO.getDescribe());

        sb.put("attribute", attribute(dtoBO));
        sb.put("attribute空行NoId", attribute2(dtoBO));
        sb.put("getset", getset(dtoBO));
        sb.appendln(fileStr);
        File doFile = new File(DoFilePath + upperCase + ".java");
        if (doFile.exists() && !DtoToCode.isDelete) {
            log.info("{} 已经存在", ApiOldFile);
            return null;
        }
        if (doFile.exists()) doFile.delete();
        FileUtil.doFileStr(doFile, sb.toString());
        log.info("{} 执行完成", ApiOldFile);
        return sb.toString();
    }

    public String getset(DtoBO dtoBO) {
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
            String rem = dtoAttrBO.getRemStr();
            stringBuilder.newLine();

            stringBuilder.appendln("public 【】 get【】() {", dtoAttrBO.getTypeStr(), StrUtil.oneUpperCase(dtoAttrBO.getNameStr()));
            stringBuilder.appendln("    return 【】;", dtoAttrBO.getNameStr());
            stringBuilder.appendln("}");
            stringBuilder.newLine();

            stringBuilder.appendln("public void set【】(【】 【】) {", StrUtil.oneUpperCase(dtoAttrBO.getNameStr()), dtoAttrBO.getTypeStr(), dtoAttrBO.getNameStr());
            stringBuilder.appendln("    this.【】 = 【】;", dtoAttrBO.getNameStr(), dtoAttrBO.getNameStr());
            stringBuilder.appendln("}");
        }
        return stringBuilder.toString();
    }

    public String attribute(DtoBO dtoBO) {
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
            String rem = dtoAttrBO.getRemStr();
            stringBuilder.newLine();
            if (!StringUtils.isEmpty(rem)) {
                stringBuilder.appendln("//" + StrUtil.getRemName(rem));
            }

            if ("LocalDateTime".endsWith(dtoAttrBO.getTypeStr())) {
                stringBuilder.appendln("@JSONField(format = \"yyyy-MM-dd HH:mm:ss\")");
            }
            String str = "private " + dtoAttrBO.getTypeStr() + " " + dtoAttrBO.getNameStr() + ";";
            stringBuilder.appendln(str);
        }
        return stringBuilder.toString();
    }

    public String attribute2(DtoBO dtoBO) {
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
            String rem = dtoAttrBO.getRemStr();
//            stringBuilder.newLine();

            if (!StringUtils.isEmpty(rem)) {
//                stringBuilder.appendln("//" + StrUtil.getRemName(rem));
                stringBuilder.appendln("/**");
                stringBuilder.appendln(" * " + StrUtil.getRemName(rem));
                stringBuilder.appendln(" */");
            }
            String str = "private " + dtoAttrBO.getTypeStr() + " " + dtoAttrBO.getNameStr() + ";";
            stringBuilder.appendln(str);
            stringBuilder.newLine();
        }
        return stringBuilder.toString();
    }
}
