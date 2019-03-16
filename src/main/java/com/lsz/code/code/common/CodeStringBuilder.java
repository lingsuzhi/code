package com.lsz.code.code.common;

import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class CodeStringBuilder {
    StringBuilder sb = new StringBuilder();
    private String leftStr = "";

    private Map<String, String> map = new HashMap<>();

    public void clean() {
        sb = new StringBuilder();
    }

    public void put(String key, String val) {
        map.put("【" + key + "】", val);
    }

    public CodeStringBuilder append(String s) {
        sb.append(leftStr + s);
        return this;
    }

    public CodeStringBuilder appendNoTab(String s) {
        sb.append(s);
        return this;
    }

    public String mapDo(String str) {
        String rStr = str;
        for (String s : map.keySet()) {
            String val = map.get(s);
            if (!StringUtils.isEmpty(val)) {
                rStr = rStr.replace(s, map.get(s));
            }
        }
        return rStr;
    }

    public CodeStringBuilder killEntry() {
        sb.setLength(sb.length() - 2);
        return this;
    }

    public CodeStringBuilder appendln(String str, String... repStr) {
        str = mapDo(str);
        str = StrUtil.replaceDo(str, repStr);
        sb.append(leftStr + str + "\r\n");
        return this;
    }

    public void setLeftStr(String s) {
        this.leftStr = s;
    }

    public void addTab() {
        if (leftStr == null) {
            leftStr = "";
        }
        this.leftStr += "    ";
    }

    public void subTab() {
        if (leftStr == null) {
            leftStr = "";
        }
        if (leftStr.length() >= 4) {
            this.leftStr = this.leftStr.substring(0, leftStr.length() - 4);
        }

    }


    public CodeStringBuilder newLine() {
        appendln("");
        return this;
    }

    @Override
    public String toString() {
        return sb.toString();
    }
}
