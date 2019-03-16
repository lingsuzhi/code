package com.lsz.code.code.common;

import org.springframework.util.StringUtils;

public class StrUtil {
    public static String replaceDo (String str,String... repStr){
        if (repStr==null){
            return str;
        }
        String keyStr = "【";
        String keyStr2 = "】";
        for (String s : repStr){
            int indexOf = str.indexOf(keyStr);
            if (indexOf==-1){
                break;
            }
            int indexOf2 = str.indexOf(keyStr2,indexOf);
            if (indexOf2==-1){
                break;
            }
            str = str.substring(0,indexOf) + s + str.substring(indexOf2+keyStr.length()) ;

        }
        return str;
    }
    public static String kuohaoStr(String str,String key1,String key2){
        int i = str.indexOf(key1);
        if (i == -1)return "";
        int ii = str.indexOf(key2,i+ key1.length());
        if (ii == -1)return "";
        return str.substring(i + key1.length(),ii);

    }
    public static String getRemName(String str){
        int i = str.indexOf(" ");
        if (i==-1){
            return str;
        }
        return str.substring(0,i);
    }

    //首字母大写
    public static  String oneUpperCase(String str){
        return str.substring(0,1).toUpperCase() + str.substring(1);
    }
    public static  String oneLoweCase(String str){
        return str.substring(0,1).toLowerCase() + str.substring(1);
    }

    //首字母小写，然后其他大写改成小写，用下划线连接
    public static String strLowDo(String str) {
        if (StringUtils.isEmpty(str)) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            String ch = str.substring(i, i + 1);
            if (i == 0) {
                sb.append(ch.toLowerCase());
            } else {
                if (!ch.equals(ch.toLowerCase())) {
                    sb.append("_");
                }

                sb.append(ch.toLowerCase());
            }

        }
        return sb.toString();
    }
    //把 下划线转换成 首字母大写形式
    public static String  xhxToJavaStr(String key){
        if (StringUtils.isEmpty(key)){
            return key;
        }
        if (!key.contains("_")){
            return key;
        }
        String returnStr = "";
        boolean b = false;
        for (char c :key.toCharArray()){
            if (c == '_'){
                b = true;
                continue;
            }
            String tmpStr = c + "";
            if (b){
                b = false;
                tmpStr = tmpStr.toUpperCase();
            }
            returnStr += tmpStr;

        }
        return returnStr;
    }
}
