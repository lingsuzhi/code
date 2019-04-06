package com.lsz.code.code.care.code.java;

import com.lsz.code.code.bo.DtoBO;
import com.lsz.code.code.care.DtoToCode;
import com.lsz.code.code.common.CodeStringBuilder;
import com.lsz.code.code.common.StrUtil;
import com.lsz.code.code.utils.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
@Slf4j
public class ApiCode implements JavaCode {

    public final static String ApiOldFile = "Controller.java";
    public final static String DoFilePath = "D:\\fy\\需求2\\20190328给外包 - 复件\\20190328给外包\\业务源码\\aj_server\\aj-provider-business-8003\\src\\main\\java\\com\\jjkj\\aj\\business\\controller\\superviseV2\\";

    @Override
    public String apply(DtoBO dtoBO) {
        CodeStringBuilder sb = new CodeStringBuilder();
        String fileStr = FileUtil.readFileStr(new File(DtoToCode.OldFilePath + ApiOldFile));
        String upperCase = StrUtil.oneUpperCase(dtoBO.getName());
        sb.put("Uname", upperCase);
        sb.put("Lname", StrUtil.oneLoweCase(dtoBO.getName()));
        sb.put("describe", dtoBO.getDescribe());
        sb.appendln(fileStr);

        File doFile = new File(DoFilePath + upperCase + ApiOldFile);
        if (doFile.exists() && !DtoToCode.isDelete) {
            log.info("{} 已经存在", ApiOldFile);
            return null;
        }
        if (doFile.exists())doFile.delete();
        FileUtil.doFileStr(doFile, sb.toString());
        log.info("{} 执行完成", ApiOldFile);
        return sb.toString();
    }
}
