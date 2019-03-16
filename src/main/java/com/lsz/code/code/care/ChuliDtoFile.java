package com.lsz.code.code.care;

import com.lsz.code.code.bo.DtoAttrBO;
import com.lsz.code.code.bo.DtoBO;
import com.lsz.code.code.utils.FileUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.io.File;

@Slf4j
public class ChuliDtoFile {
    /**
     *
     * @param file java代码文件
     * @return
     */
    public static DtoBO chuli (File file){
        if(file == null || !file.exists()){
            log.error("文件不存在啊，请检查");
            return null;
        }
        //1、读取文件内容
        String fileStr = FileUtils.FileUTF8ToStr(file);
        if (StringUtils.isEmpty(fileStr)) return null;

        final String classStr = " class ";
        int classPos = fileStr.indexOf(classStr);
        if (classPos == -1) return null;
        int classdkhPos = fileStr.indexOf("{", classPos);
        if (classdkhPos == -1) return null;
        //private
        int mapPos = classdkhPos;
        String keyVal = "private ";
        DtoBO dtoBO = new DtoBO();

        final String packStr ="package ";
        int packPos = fileStr.indexOf(packStr);
        if(packPos != -1){
            int fhPos = fileStr.indexOf(";", packPos);
            if(fhPos != -1){
                dtoBO.setPackageStr(fileStr.substring(packPos + packStr.length(),fhPos));
                if (dtoBO.getPackageStr().endsWith(".po")){
                    dtoBO.setPackageStr(dtoBO.getPackageStr().replace(".po",""));
                }
            }
        }

        while (true) {
            //循环往下找 mapping
            int tmpMapPos = fileStr.indexOf(keyVal, mapPos);
            if (tmpMapPos == -1) {
                //找不到 说明没了
                break;
            }
            //找到了 private 同时行内有分号
            int fenhaoPos = fileStr.indexOf(";", tmpMapPos);
            int rowPos = fileStr.indexOf("\n", tmpMapPos);
            if (rowPos == -1) {
                break;
            }
            if (fenhaoPos != -1 && fenhaoPos < rowPos) {
                String tmpStr = fileStr.substring(tmpMapPos + keyVal.length(), fenhaoPos).trim();
                if (!StringUtils.isEmpty(tmpStr) && -1 == tmpStr.indexOf("static ") && -1 == tmpStr.indexOf("final ")) {
                    int kgPos = tmpStr.indexOf(" ");
                    if (kgPos != -1) {
                        String typeStr = tmpStr.substring(0, kgPos);
                        String nameStr = tmpStr.substring(kgPos + 1);
                        String remStr = getRemStr(fileStr, mapPos, tmpMapPos);

                        DtoAttrBO dtoAttrBO = new DtoAttrBO();
                        int notNullPos = fileStr.indexOf("@NotNull", mapPos);
                        if (notNullPos != -1 && notNullPos < tmpMapPos) {
                            dtoAttrBO.setParameRequired("true");
                        } else {
                            dtoAttrBO.setParameRequired("false");
                        }
                        dtoAttrBO.setTypeStr(typeStr);
                        dtoAttrBO.setNameStr(nameStr);
                        dtoAttrBO.setRemStr(remStr);
                        dtoBO.getAttrList().add(dtoAttrBO);
                    }
                }

            }
            mapPos = tmpMapPos + keyVal.length();
        }//end while
        dtoBO.setName(file.getName().replace(".java", ""));
        if (dtoBO != null && !StringUtils.isEmpty(dtoBO.getName())) {

            dtoBO.setProjectName(DtoToCode.ProjectName);

            dtoBO.setDescribe(getRemStr(fileStr, 0, classPos));
        }
        return dtoBO;
    }
    private static int findStrLast(String str, int pos, String findStr) {
        return str.substring(0, pos).lastIndexOf(findStr);
    }
    private static String getRemStr(String codeStr, int leftPos, int rightPos) {
        int pos1 = findStrLast(codeStr, rightPos, "/*");
        int pos2 = findStrLast(codeStr, rightPos, "*/");
        String returnStr = "";
        if (pos1 != -1 && pos2 != -1 && pos1 > leftPos) {
            if (pos1 > pos2) return null;
            String zhujieStr = codeStr.substring(pos1, pos2);
            String[] sArr = zhujieStr.split("\n");

            if (sArr != null) {
                for (int i = 1; i < sArr.length - 1; i++) {
                    //第一行 最后一行 不要
                    String tmpS = sArr[i].trim();
                    if (tmpS.length() > 1 && "*".equals(tmpS.substring(0, 1))) {
                        tmpS = tmpS.substring(1).trim();
                    }
                    returnStr += tmpS;
                }
            }
        }
        //如果没有，就找双斜杠 //
        if (StringUtils.isEmpty(returnStr)) {
            int pos3 = findStrLast(codeStr, rightPos, "//");
            if (pos3 != -1 && pos3 > leftPos) {
                int endPos = codeStr.indexOf("\n", pos3);
                if (endPos > pos3 + 3) {
                    returnStr = codeStr.substring(pos3 + 2, endPos - 1);
                }
            }
        }
        return returnStr;
    }
}
