package com.lsz.code.code.care;

import com.lsz.code.code.bo.DtoBO;
import com.lsz.code.code.care.code.BaseCode;
import com.lsz.code.code.care.code.SqlCode;
import com.lsz.code.code.care.code.java.JavaCode;
import com.lsz.code.code.common.CodeStringBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

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
            OldFilePath = ResourceUtils.getFile("classpath:static/template").getPath() + "\\";
            BaseVuePath = OldFilePath + "vue\\";
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Autowired
    private List<JavaCode> javaCodeList;

    @Autowired
    private BaseCode baseCode;

    public Map<String, String> chuli(DtoBO dtoBO, Boolean killold) {
        if (dtoBO == null) return null;
        Map<String, String> map = new HashMap<>();
        isDelete = killold == null ? false : killold;
        map.put("sql", SqlCode.apply(dtoBO));

        CodeStringBuilder sb = baseCode.init();
        for (JavaCode javaCode : javaCodeList) {
//            javaCode.apply(dtoBO);
        }
        baseCode.apply(dtoBO);
        return map;
    }

}
