package com.lsz.code.code.service;

import com.lsz.code.code.bo.DtoBO;
import com.lsz.code.code.care.ChuliDtoFile;
import com.lsz.code.code.care.DtoToCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class FxjkService {

    public static final String DirPath = "D:\\fy\\code\\src\\main\\java\\com\\lsz\\code\\code\\source\\fxjk\\";
//    public static final String DirPath = "D:\\fy\\code\\src\\main\\java\\com\\lsz\\code\\code\\source\\fxjk\\";

    @Autowired
    private DtoToCode dtoToCode;

    public Map code() {
        Map<String, Object> map = new HashMap<>();
        File fileDir = new File(DirPath);
        if (!fileDir.isDirectory()) {
            return null;
        }
        File[] files = fileDir.listFiles();
        StringBuffer liSb = new StringBuffer();
        for (File file : files) {
            String name = file.getName();
            liSb.append("<li><a href='javascript:void(0)'>" + name + "</a></li>" + "\r\n");

        }
        map.put("fileList", liSb.toString());
        return map;
    }

    public Map<String, String> fileDo(String fileName,Boolean killold) {
        File file = new File(DirPath + fileName);
        DtoBO dtoBO = ChuliDtoFile.chuli(file);
        if (dtoBO == null) {
            log.error("处理失败！ChuliDtoFile");
            return null;
        }

        return dtoToCode.chuli(dtoBO,killold);
    }
}
