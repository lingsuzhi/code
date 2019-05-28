package com.xjjd.lease.apply.api.base.service;

import com.xjjd.lease.apply.api.base.pojo.【Uname】;
import com.xjjd.lease.apply.api.base.util.BasePage;
import com.xjjd.lease.apply.api.base.util.PagesParam;

import java.util.Map;

/**
 * 【describe】
 */
public interface 【Uname】Service {

    Map<String, Object> add【Uname】(Map<String, Object> parameterMap);

    Map<String, Object> del【Uname】(Map<String, Object> parameterMap);

    Map<String, Object> upd【Uname】(Map<String, Object> parameterMap);

    BasePage<【Uname】> get【Uname】List(PagesParam parameterMap);

    【Uname】 get【Uname】(Map<String, Object> parameterMap);
}

