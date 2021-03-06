package com.lsz.code.code.care;

import com.lsz.code.code.bo.DtoBO;
import com.lsz.code.code.care.code.SqlCode;
import com.lsz.code.code.care.code.java.JavaCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class DtoToCode {
    public static final String OldFilePath = "D:\\fy\\code\\src\\main\\resources\\static\\fxjk\\";

    public static final String ProjectName = "depot";

    public static boolean isDelete = true;

    @Autowired
    private List<JavaCode> javaCodeList;

    public Map<String, String> chuli(DtoBO dtoBO, Boolean killold) {
        if (dtoBO == null) return null;
        Map<String, String> map = new HashMap<>();
        isDelete = killold == null ? false : killold;
        map.put("sql", SqlCode.apply(dtoBO));
//        daoDo(dtoBO);
//        serviceDo(dtoBO);
//        apiDo(dtoBO);
//        paramDo(dtoBO);
//        xmlDo(dtoBO);
        for (JavaCode javaCode : javaCodeList) {
            javaCode.apply(dtoBO);
        }
        return map;
    }


}
