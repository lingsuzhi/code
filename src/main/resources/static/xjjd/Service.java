package com.lsz.apply.base.service;

import com.lsz.common.BasePage;
import com.lsz.common.PagesParam;
import com.lsz.dto.【Uname】DTO;
import com.lsz.pojo.【Uname】;

import java.util.Map;

/**
 * 【describe】
 * @author lingsuzhi
 * @since 【日期】
 */
public interface 【Uname】Service {

    【Uname】 add【Uname】(【Uname】 adminInfo);

    Map<String, Object> del【Uname】(Map<String, Object> parameterMap);

    【Uname】 upd【Uname】(【Uname】 adminInfo);

    BasePage<【Uname】DTO> get【Uname】List(PagesParam parameterMap);

    【Uname】DTO get【Uname】(Map<String, Object> parameterMap);
}


