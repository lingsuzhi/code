package com.lsz.code.code.care.code;


import com.lsz.code.code.bo.DtoAttrBO;
import com.lsz.code.code.bo.DtoBO;
import com.lsz.code.code.care.DtoToCode;
import com.lsz.code.code.common.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.util.List;

@Slf4j
public class SqlCode {
    public static String apply(DtoBO dtoBO) {
        String sqlStr = "CREATE TABLE `" + StrUtil.strLowDo(dtoBO.getName()) + "` (\n" +
                "  `id` bigint(20) NOT NULL AUTO_INCREMENT,\n" +
                "  `uuid` char(22) DEFAULT NULL,\n";
        List<DtoAttrBO> attrList = dtoBO.getAttrList();
        String UNIQUE_key = "";
        for (DtoAttrBO dtoAttrBO : attrList) {
            String typeStr = "varchar(66)  CHARACTER SET utf8mb4 ";
            String type = dtoAttrBO.getTypeStr();
            if ("Integer".equals(type)) {
                typeStr = "int(11)";
            } else if ("Long".equals(type)) {
                typeStr = "bigint(20)";
            } else if ("LocalDateTime".equals(type)) {
                typeStr = "datetime";
            } else if ("Boolean".equals(type)) {
                typeStr = "TINYINT(1)";
            } else if ("BigDecimal".equals(type)) {
                typeStr = "decimal(18,0)";
            }


            sqlStr += "  `" + StrUtil.strLowDo(dtoAttrBO.getNameStr()) + "` " + typeStr;
            if ("true".equals(dtoAttrBO.getParameRequired())) {
                sqlStr += " NOT NULL ";
            } else {
                sqlStr += " DEFAULT NULL ";
            }
            sqlStr += " COMMENT '" + dtoAttrBO.getRemStr() + "',\n";

            if (!StringUtils.isEmpty(dtoAttrBO.getRemStr())) {
                if (dtoAttrBO.getRemStr().contains("<key>")) {
                    //UNIQUE INDEX `uuid` (`user_id`)
                    if (!StringUtils.isEmpty(UNIQUE_key)) {
                        UNIQUE_key = UNIQUE_key + ",";
                    }
                    UNIQUE_key = UNIQUE_key + "`" + dtoAttrBO.getNameStr() + "`";
                }
            }
        }
        sqlStr += "\n" +
//                "  `create_by` varchar(45) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '创建人',\n" +
//                "  `create_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',\n" +
//                "  `update_by` varchar(45) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '修改人',\n" +
//                "  `update_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',\n" +
                "  PRIMARY KEY (`id`),\n" +
                "  KEY `uuid` (`uuid`)\n";
        if (!StringUtils.isEmpty(UNIQUE_key)) {
            sqlStr += ",UNIQUE INDEX `unique_key` (" + UNIQUE_key + ")\n";
        }

        sqlStr += ")COMMENT='" + dtoBO.getDescribe() + "'\n";
        sqlStr += "COLLATE='utf8_general_ci'\n";
        sqlStr += "ENGINE=InnoDB\n";
        sqlStr += "AUTO_INCREMENT=1000000000;";

        return sqlStr;
    }
}
