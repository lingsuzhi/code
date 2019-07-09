package com.lsz.code.code.care;

import com.lsz.code.code.bo.DtoBO;
import com.lsz.code.code.care.code.SqlCode;
import com.lsz.code.code.care.code.java.JavaCode;
import com.lsz.code.code.care.code.java.vue.VueCode;
import com.lsz.code.code.common.CodeStringBuilder;
import com.lsz.code.code.common.StrUtil;
import com.lsz.code.code.utils.FileUtil;
import com.lsz.code.code.utils.FileUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class DtoToCode {
    public static final String ProjectName = "depot";
    public static String OldFilePath = "";
    public static String BaseVuePath = "";


    public static boolean isDelete = true;

    static {
        try {
            OldFilePath = ResourceUtils.getFile("classpath:static/xjjd").getPath() + "\\";
            BaseVuePath = OldFilePath + "vue\\";
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Autowired
    private List<JavaCode> javaCodeList;

    private static void vueDo(DtoBO dtoBO) {
        String dirPath = JavaCode.vuePath + File.separator + dtoBO.getName();
        File dirFile = new File(dirPath);
        if (dirFile.exists()) {
            if (isDelete) {
                FileUtils.deleteFile(dirFile);
            } else {
                log.info("文件已经存在 不往下执行");
                return;
            }
        }
        dirFile.mkdir();
        File baseFile = new File(BaseVuePath);
        if (!baseFile.exists() || !baseFile.isDirectory()) {
            return;
        }
        File[] files = baseFile.listFiles();
        if (files == null || files.length == 0) {
            return;
        }
        String clsName = StrUtil.oneUpperCase(dtoBO.getName());
        for (File file : files) {
            String fileStr = FileUtil.readFileStr(file);

            String newFileStr = new VueCode(dtoBO, fileStr).apply();
            String fileName = file.getName().replace("Name", clsName);
            File newFile = new File(dirFile.getPath() + File.separator + fileName);
            FileUtil.doFileStr(newFile, newFileStr);
        }
        if (!isDelete) {
            File jsFile = new File(JavaCode.vueRouterPath);
            if (jsFile.exists()) {
                String fileStr = FileUtil.readFileStr(jsFile);
                CodeStringBuilder sb = new CodeStringBuilder();
                sb.newLine();
                sb.newLine();
                sb.appendln("import 【】App from '@/view/base/【】/【】App'", clsName, clsName, clsName);
                sb.appendln("baseRouter.children.push({");
                sb.appendln("        path: '/base/【】',",clsName);
                sb.appendln("        component: 【】App,",clsName);
                sb.appendln("        name: '【】'",dtoBO.getDescribe());
                sb.appendln("})");
                FileUtil.doFileStr(jsFile,fileStr + sb.toString());
            }
        }
    }

    public Map<String, String> chuli(DtoBO dtoBO, Boolean killold) {
        if (dtoBO == null) return null;
        Map<String, String> map = new HashMap<>();
        isDelete = killold == null ? false : killold;
        map.put("sql", SqlCode.apply(dtoBO));
        for (JavaCode javaCode : javaCodeList) {
            javaCode.apply(dtoBO);
        }
        vueDo(dtoBO);
        return map;
    }

}
