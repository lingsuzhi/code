package com.lsz.code.code.care.code.java.vue;


import com.lsz.code.code.bo.DtoAttrBO;
import com.lsz.code.code.bo.DtoBO;
import com.lsz.code.code.common.CodeStringBuilder;
import com.lsz.code.code.common.KeyStr;
import com.lsz.code.code.common.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

@Slf4j
public class VueCode {
    private CodeStringBuilder sb = new CodeStringBuilder();


    public VueCode(DtoBO dtoBO, String fileStr) {
//        //把第2个 大写字母小写
//        for (DtoAttrBO dtoAttrBO : dtoBO.getAttrList()) {
//            String nameStr = dtoAttrBO.getNameStr();
//            String s1 = nameStr.substring(1,2);
//            if (!StringUtils.isEmpty(s1) && s1.equals(s1.toUpperCase())){
//                nameStr = nameStr.substring(0,1) + s1.toLowerCase() + nameStr.substring(2);
//                dtoAttrBO.setNameStr(nameStr);
//            }
//        }


        sb.put("Uname", StrUtil.oneUpperCase(dtoBO.getName()));
        sb.put("Lname", StrUtil.oneLoweCase(dtoBO.getName()));
        sb.put("describe", dtoBO.getDescribe());
        sb.put("paramSearch", getParamSearch(dtoBO));
        sb.put("tableColumn", getTableColumn(dtoBO));
        sb.put("editForm", getEditForm(dtoBO));
        sb.put("addInit", getAddInit(dtoBO));
        sb.appendln(fileStr);
    }

    private String getAddInit(DtoBO dtoBO) {
        CodeStringBuilder csb = new CodeStringBuilder();
        for (DtoAttrBO dtoAttrBO : dtoBO.getAttrList()) {
            String rem = dtoAttrBO.getRemStr();
            if (StringUtils.isEmpty(rem) || rem.contains(KeyStr.getHide()) || isContinue(dtoAttrBO)) {
                continue;
            }
            String s = StrUtil.kuohaoStr(rem, "default[", "]");
            if (!StringUtils.isEmpty(s)) {

                csb.appendln("    【】: '【】',", dtoAttrBO.getNameStr(), s);
            }
        }
        return csb.toString();
    }

    private Boolean isRowColor(DtoBO dtoBO) {
        for (DtoAttrBO dtoAttrBO : dtoBO.getAttrList()) {
            String rem = dtoAttrBO.getRemStr();
            if (rem.contains("<rowcolor>")) {
                return true;
            }
        }
        return false;
    }

    private boolean isContinue(DtoAttrBO dtoAttrBO) {
        switch (dtoAttrBO.getNameStr()) {
            case "isDelete":
                return true;
            case "createTime":
                return true;
            case "updateTime":
                return true;
            case "createBy":
                return true;
            case "updateBy":
                return true;
        }
        return false;
    }

    private String getTableColumn(DtoBO dtoBO) {

        CodeStringBuilder csb = new CodeStringBuilder();
        for (DtoAttrBO dtoAttrBO : dtoBO.getAttrList()) {
            String rem = dtoAttrBO.getRemStr();
            if (StringUtils.isEmpty(rem) || rem.contains(KeyStr.getHide()) || isContinue(dtoAttrBO)) {
                continue;
            }

            String remName = StrUtil.getRemName(rem);
            csb.newLine();
            if ("LocalDateTime".endsWith(dtoAttrBO.getTypeStr()) || "Date".endsWith(dtoAttrBO.getTypeStr())) {
                String tmpStr = "<el-table-column prop=\"【】\" label=\"【】\" width=\"200\" align=\"center\" sortable=\"sortable\" ";
                csb.appendln(tmpStr, dtoAttrBO.getNameStr(), remName);
                csb.appendln(":show-overflow-tooltip=\"true\">");
                csb.appendln("<template slot-scope=\"scope\">");
                csb.appendln("<el-icon name=\"time\"></el-icon>");
                String tmpStr2 = "";
                if (rem.contains("<日期>")) {
                    tmpStr2 = ",'YYYY-MM-DD'";
                }
                csb.appendln("<span style=\"margin-left: 10px\">{{ formatDate(scope.row.【】【】) }}</span>", dtoAttrBO.getNameStr(), tmpStr2);
                csb.appendln("</template>");
                csb.appendln("</el-table-column>");
            } else if (rem.contains("<rowcolor>")) {
//颜色列不要
            } else if ("Boolean".endsWith(dtoAttrBO.getTypeStr())) {
                appendSwitch(csb, dtoAttrBO.getNameStr(), remName, "启用", "禁用", "true");
            } else {
                String radioStr = StrUtil.kuohaoStr(rem, "radio[", "]");
                String selectStr = StrUtil.kuohaoStr(rem, "select[", "]");

                if (!StringUtils.isEmpty(radioStr)) {
                    String[] split = radioStr.split(",");
                    if (split != null && split.length == 2) {
                        appendSwitch(csb, dtoAttrBO.getNameStr(), remName, split[0], split[1], "'" + split[0] + "'");
                    }
                } else if (!StringUtils.isEmpty(selectStr)) {
                    String[] split = selectStr.split(",");
                    if (split != null) {
                        appendSelect(csb, dtoAttrBO.getNameStr(), remName, split);
                    }
                } else {
                    String tmpStr = "<el-table-column prop=\"【】\" label=\"【】\" min-width=\"150\" sortable=\"sortable\" :show-overflow-tooltip=\"true\" header-align=\"center\"/>";
                    csb.appendln(tmpStr, dtoAttrBO.getNameStr(), remName);
                }
            }


        }
        return csb.toString();
    }

    private Boolean appendSelect(CodeStringBuilder csb, String nameStr, String remStr, String[] split) {
        csb.appendln("<el-table-column prop = \"【】\" label = \"【】\" width = \"120\" align = \"center\" >", nameStr, remStr);
        csb.appendln("  <template slot-scope = \"scope\" >");

        if (split[0].contains(":")) {
            String s0 = splitByIndex(split, 0);
            String s1 = splitByIndex(split, 1);
            csb.appendln("    <el-tag :type = \"['','success','info','warning','danger'][【】.indexOf(scope.row.【】+ '')%5]\" > {{【】[【】.indexOf(scope.row.【】+ '')]}} </el-tag>",
                    s0, nameStr, s1, s0, nameStr);
        } else {
            csb.appendln("    <el-tag :type = \"['','success','info','warning','danger'][【】.indexOf(scope.row.【】+ '')%5]\" > {{scope.row.【】}} </el-tag>",
                    splitToJsArr(split), nameStr, nameStr);

        }


        csb.appendln("  </template >");
        csb.appendln("</el-table-column>");
        return true;
    }

    private String splitToJsArr(String[] split) {
        String appendStr = "[";
        for (String str : split) {
            if (appendStr.length() != 1) {
                appendStr += ",";
            }
            appendStr += "'" + str + "'";
        }
        return appendStr + "]";
    }

    private String splitByIndex(String[] split, int index) {
        String appendStr = "[";
        for (String str : split) {
            str = str.split(":")[index];
            if (appendStr.length() != 1) {
                appendStr += ",";
            }
            appendStr += "'" + str + "'";
        }
        return appendStr + "]";
    }

    private Boolean appendSwitch(CodeStringBuilder csb, String nameStr, String remStr, String key1, String key2, String val1) {
        csb.appendln("<el-table-column prop = \"【】\" label = \"【】\" width = \"120\" align = \"center\" >", nameStr, remStr);
        csb.appendln("  <template slot-scope = \"scope\" >");
        csb.appendln("    <el-tag :type = \"scope.row.【】==【】?'success':'info'\" > {{scope.row.【】==【】 ? '【】' : '【】'}} </el-tag>",
                nameStr, val1, nameStr, val1, key1, key2);
        csb.appendln("  </template >");
        csb.appendln("</el-table-column>");
        return true;
    }

    private String getEditForm(DtoBO dtoBO) {
        CodeStringBuilder csb = new CodeStringBuilder();
        for (DtoAttrBO dtoAttrBO : dtoBO.getAttrList()) {
            String rem = dtoAttrBO.getRemStr();
            if (StringUtils.isEmpty(rem) || rem.contains(KeyStr.getHide()) || isContinue(dtoAttrBO)) {
                continue;
            }
            if (rem.contains(KeyStr.getHideEdit()) || "id".equals(dtoAttrBO.getNameStr())) {
                continue;
            }
            String remName = StrUtil.getRemName(rem);
            csb.newLine();
            String selectStr = StrUtil.kuohaoStr(rem, "select[", "]");

            String radioStr = StrUtil.kuohaoStr(rem, "radio[", "]");
            if (!StringUtils.isEmpty(selectStr)) {
                String[] split = selectStr.split(",");
                csb.appendln("<el-form-item label=\"【】\">", remName);
                csb.appendln("<el-select v-model=\"row.【】\">", dtoAttrBO.getNameStr());



                    for (String s1 : split) {
                        csb.appendln("<el-option");
                        if (s1.contains(":")) {
                            String[] split1 = s1.split(":");
                            csb.appendln(":label=\"'【】'\"", split1[1]);
                            csb.appendln(":value=\"'【】'\">", split1[0]);
                        } else {
                            csb.appendln(":value=\"'【】'\">", s1);
                        }
                        csb.appendln("</el-option>");
                    }

                csb.appendln("</el-select>");
                csb.appendln("</el-form-item>");
            } else if (!StringUtils.isEmpty(radioStr)) {
                String[] split = radioStr.split(",");

                csb.appendln("<el-form-item label=\"【】\">", remName);
                csb.appendln("<el-radio-group v-model=\"row.【】\">", dtoAttrBO.getNameStr());

                for (String s1 : split) {
                    csb.appendln("<el-radio :label=\"'【】'\" >【】</el-radio>", s1, s1);
                }


                csb.appendln("</el-radio-group>");
                csb.appendln("</el-form-item>");
            } else if ("Boolean".endsWith(dtoAttrBO.getTypeStr())) {
                csb.appendln("<el-form-item label=\"【】\">", remName);
                csb.appendln("<el-radio-group v-model=\"row.【】\">", dtoAttrBO.getNameStr());

                csb.appendln("<el-radio :label=\"【】\" >【】</el-radio>", "true", "启用");
                csb.appendln("<el-radio :label=\"【】\" >【】</el-radio>", "false", "禁用");

                csb.appendln("</el-radio-group>");
                csb.appendln("</el-form-item>");
            } else {
                csb.appendln("<el-form-item label=\"【】\"", remName);
                if (rem.contains("<required>")) {
                    csb.appendln("prop=\"【】\"", dtoAttrBO.getNameStr());
                    csb.appendln(":rules=\"[{ required: true, message: '请输入', trigger: 'blur' }]\">");
                } else {
                    csb.killEntry();
                    csb.appendln(">");
                }

                if (rem.contains("<key>")) {
                    csb.appendln("<el-input v-model=\"row.【】\" :disabled=\"!isAdd\"/>", dtoAttrBO.getNameStr());
                } else if (rem.contains("<rowcolor>")) {
                    csb.appendln("<el-color-picker");
                    csb.appendln("v-model=\"row.color\"");
                    csb.appendln("show-alpha");
                    csb.appendln(":predefine=\" [");
                    csb.appendln("'#ff4500',");
                    csb.appendln("'#ff8c00',");
                    csb.appendln("'#ffd700',");
                    csb.appendln("'#90ee90',");
                    csb.appendln("'#00ced1',");
                    csb.appendln("'#1e90ff',");
                    csb.appendln("'#c71585',");
                    csb.appendln("'rgba(255, 69, 0, 0.68)',");
                    csb.appendln("'rgb(0, 0, 0)',");
                    csb.appendln("'#eeeeee',");
                    csb.appendln("]\">");
                    csb.appendln("</el-color-picker>");
                } else if (rem.contains("<textarea>")) {
                    csb.appendln("      <el-input v-model=\"row.【】\" placeholder=\"请输入\"  type=\"textarea\"/>", dtoAttrBO.getNameStr());
                } else if ("BigDecimal".endsWith(dtoAttrBO.getTypeStr())) {
                    csb.appendln("      <el-input-number v-model=\"row.【】\" placeholder=\"请输入\"/>", dtoAttrBO.getNameStr());
                } else if ("Double".endsWith(dtoAttrBO.getTypeStr())) {
                    csb.appendln("      <el-input-number v-model=\"row.【】\" placeholder=\"请输入\"/>", dtoAttrBO.getNameStr());
                } else if ("Integer".endsWith(dtoAttrBO.getTypeStr())) {
                    csb.appendln("      <el-input-number v-model=\"row.【】\" placeholder=\"请输入\"/>", dtoAttrBO.getNameStr());
                } else {
                    csb.appendln("      <el-input v-model=\"row.【】\" placeholder=\"请输入\"/>", dtoAttrBO.getNameStr());
                }

                csb.appendln("</el-form-item>");
            }
        }
        return csb.toString();
    }

    private String getParamSearch(DtoBO dtoBO) {
        CodeStringBuilder csb = new CodeStringBuilder();
        for (DtoAttrBO dtoAttrBO : dtoBO.getAttrList()) {
            String rem = dtoAttrBO.getRemStr();
            if (StringUtils.isEmpty(rem) || rem.contains(KeyStr.getHide()) || isContinue(dtoAttrBO)) {
                continue;
            }
            if (rem.contains(KeyStr.getParam())) {
                String remName = StrUtil.getRemName(rem);
                csb.newLine();
                String selectStr = StrUtil.kuohaoStr(rem, "select[", "]");
                if (StringUtils.isEmpty(selectStr)) {
                    selectStr = StrUtil.kuohaoStr(rem, "radio[", "]");
                }
                if (!StringUtils.isEmpty(selectStr)) {
                    String[] split = selectStr.split(",");

                    csb.appendln("<el-form-item>");
                    csb.appendln("<el-select v-model=\"filters.【】\" placeholder=\"【】\">", dtoAttrBO.getNameStr(), remName);
                    csb.appendln("<el-option");
                    csb.appendln(":label=\"''\"");
                    csb.appendln(":value=\"null\">");
                    csb.appendln("</el-option>");
                    for (String s1 : split) {
                        csb.appendln("<el-option");
                        if (s1.contains(":")) {
                            String[] split1 = s1.split(":");
                            csb.appendln(":label=\"'【】'\"", split1[1]);
                            csb.appendln(":value=\"'【】'\">", split1[0]);
                        } else {
                            csb.appendln(":value=\"'【】'\">", s1);
                        }
                        csb.appendln("</el-option>");
                    }
                    csb.appendln("</el-select>");
                    csb.appendln("</el-form-item>");
                } else {
                    csb.appendln("<el-form-item>");
                    csb.appendln("  <el-input v-model=\"filters.【】\" placeholder=\"【】\" clearable></el-input>", dtoAttrBO.getNameStr(), remName);
                    csb.appendln("</el-form-item>");
                }


            }
        }
        return csb.toString();
    }

    public String apply() {
        return sb.toString();
    }
}
