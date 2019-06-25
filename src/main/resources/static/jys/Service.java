package com.lsz.jys.apply.base.service;

import com.lsz.jys.common.BasePage;
import com.lsz.jys.common.PagesParam;
import com.lsz.jys.pojo.【Uname】;

import java.util.Map;

/**
 * 【describe】
 */
public interface 【Uname】Service {

    【Uname】 add【Uname】(【Uname】 【Lname】);

    Map<String, Object> del【Uname】(Map<String, Object> parameterMap);

    【Uname】 upd【Uname】(【Uname】 【Lname】);

    BasePage<【Uname】> get【Uname】List(PagesParam parameterMap);

    【Uname】 get【Uname】(Map<String, Object> parameterMap);
}


