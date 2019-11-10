package com.lsz.code.code.care.code;

import com.lsz.code.code.bo.DtoAttrBO;
import com.lsz.code.code.bo.DtoBO;
import com.lsz.code.code.care.DtoToCode;
import com.lsz.code.code.care.code.java.JavaCode;
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
public class BaseCode {

    public final static String DoFilePath = JavaCode.BaseXmlPath + File.separator;
    public static CodeStringBuilder sb = null;

    public String apply(DtoBO dtoBO) {
        String upperCase = StrUtil.oneUpperCase(dtoBO.getName());
        sb.put("Uname", upperCase);
        sb.put("Lname", StrUtil.oneLoweCase(dtoBO.getName()));
        sb.put("describe", dtoBO.getDescribe());

        sb.put("select_column", select_column(dtoBO));
        sb.put("resultMap", resultMap(dtoBO));

        sb.put("tableName", StringUtils.isEmpty(dtoBO.getTableName()) ? StrUtil.strLowDo(dtoBO.getName()) : dtoBO.getTableName());

        sb.put("base_column", base_column(dtoBO));
        sb.put("updateSet", updateSet(dtoBO));
        sb.put("value_column", value_column(dtoBO));


        sb.put("selectWhere", selectWhere(dtoBO));

        File dir = new File(DtoToCode.OldFilePath);
        File[] files = dir.listFiles();
        for (File file : files) {
            apply(file);
        }

        return sb.toString();
    }

    private String manageFileStr(File file) {
        String fileStr = FileUtil.readFileStr(file);
        String key1 = "路径";
        int pos = fileStr.indexOf(key1);
        if (pos > -1) {
            int posEnd = fileStr.indexOf("\r\n", pos);
            if (posEnd > -1) {
                sb.putKey(key1, StrUtil.zhongkuohaoStr(fileStr, key1));

                fileStr = fileStr.substring(0, pos) + fileStr.substring(posEnd + 2);
            }
        }


        String tableName = sb.get("tableName");
        String[] split = tableName.split("_");
        if (split.length > 1) {
            sb.putKey("包名", split[1]);
            sb.put("点包名", "." + split[1]);
        }
        return fileStr;
    }

    private String apply(File file) {
        sb.clean();
        String fileStr = manageFileStr(file);

        sb.appendln(fileStr);
        String filePath = getFilePath();
        if (fileStr.contains("public interface I")) {
            filePath += "I";
        } else if (fileStr.contains(".impl;")) {
            filePath += "impl" + File.separator;


            File tmpFile = new File(filePath);
            if (!tmpFile.exists()) {
                tmpFile.mkdir();
            }
        }
        File doFile = new File(filePath + sb.get("Uname") + file.getName());
        if (doFile.exists() && !DtoToCode.isDelete) {
            log.info("{} 已经存在", file.getName());
            return null;
        }
        if (doFile.exists()) {
            doFile.delete();
        }
        FileUtil.doFileStr(doFile, sb.toString());
        log.info("{} 执行完成", file.getName());
        return "成功";
    }

    private String getFilePath() {
        String str = sb.getKey("路径");
        if (StringUtils.isEmpty(str)) {
            str = JavaCode.BaseXmlPath;
        }
        str = str + File.separator;

        String baoming = sb.getKey("包名");
        if (!StringUtils.isEmpty(baoming)) {
            str = str + baoming;

            File tmpFile = new File(str);
            if (!tmpFile.exists()) {
                tmpFile.mkdir();
            }
            str = str + File.separator;
        }
        return str;
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
        stringBuilder.addTab();
        List<DtoAttrBO> attrList = dtoBO.getAttrList();
        if (CollectionUtils.isEmpty(attrList)) {
            return null;
        }
        for (DtoAttrBO dtoAttrBO : attrList) {
            if (dtoAttrBO.getRemStr().contains("<隐藏>") || dtoAttrBO.getRemStr().contains("<hide>")) {
                continue;
            }
            String rem = dtoAttrBO.getRemStr();
            stringBuilder.newLine();
            String nameStr = dtoAttrBO.getNameStr();
            if ("String".equalsIgnoreCase(dtoAttrBO.getTypeStr())) {
                String str = "<if test=\"【】 != null and 【】 != ''\">";
                stringBuilder.appendln(str, nameStr, nameStr);
            } else {
                String str = "<if test=\"【】 != null \">";
                stringBuilder.appendln(str, nameStr);

            }
            if ("name".equals(nameStr)) {
                stringBuilder.appendln("    AND ta.【】 LIKE concat(concat('%',#{【】}),'%')", StrUtil.strLowDo(dtoAttrBO.getNameStr()), dtoAttrBO.getNameStr());
            } else {
                stringBuilder.appendln("    AND ta.【】 = #{【】}", StrUtil.strLowDo(dtoAttrBO.getNameStr()), dtoAttrBO.getNameStr());
            }
            stringBuilder.appendln("</if>");
        }
        return stringBuilder.toString();
    }

    private String updateSet(DtoBO dtoBO) {
        CodeStringBuilder stringBuilder = new CodeStringBuilder();
        stringBuilder.addTab();
        stringBuilder.addTab();
        stringBuilder.addTab();
        List<DtoAttrBO> attrList = dtoBO.getAttrList();
        if (CollectionUtils.isEmpty(attrList)) {
            return null;
        }
        for (DtoAttrBO dtoAttrBO : attrList) {
//            dtoAttrBO.getRemStr().contains("<hide>") ||
            if (dtoAttrBO.getRemStr().contains("<隐藏>") || "id".equals(dtoAttrBO.getNameStr())
                    || "createTime".equals(dtoAttrBO.getNameStr())) {
                continue;
            }
            String nameStr = dtoAttrBO.getNameStr();
//            if (stringBuilder.toString().length() > 0) {
//                stringBuilder.appendNoTab(",");
//            }
            String lowDo = StrUtil.strLowDo(nameStr);
            if ("String---".equalsIgnoreCase(dtoAttrBO.getTypeStr())) {
                String str = "<if test=\"【】 != null and 【】 != ''\">";
                stringBuilder.appendln(str, nameStr, nameStr);
            } else {
                String str = "<if test=\"【】 != null \">";
                stringBuilder.appendln(str, nameStr);

            }
            stringBuilder.appendln("    【】 = #{【】},", lowDo, nameStr);
            stringBuilder.appendln("</if>");
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
            if ("isHistory".equals(nameStr) || "isDelete".equals(nameStr)) {
                stringBuilder.appendNoTab("0");
                continue;
            }
            if ("delFlag".equals(nameStr)) {
                stringBuilder.appendNoTab("1");
                continue;
            }
            stringBuilder.appendNoTab("#{" + nameStr + "}");

        }
        return stringBuilder.toString();
    }


    private String resultMap(DtoBO dtoBO) {
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
//            if (!lowDo.equals(nameStr)) {
//                stringBuilder.appendln("ta.【】 as 【】", lowDo, nameStr);
//            } else {
            stringBuilder.appendln("<id column=\"【】\" property=\"【】\"/>", lowDo, nameStr);
//            }
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
                stringBuilder.appendln("ta.【】 as 【】", lowDo, nameStr);
            } else {
                stringBuilder.appendln("ta.【】", lowDo);
            }
        }
        return stringBuilder.toString();
    }

    public CodeStringBuilder init() {
        sb = new CodeStringBuilder();
        return sb;
    }
}
