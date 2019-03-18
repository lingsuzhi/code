package com.jjkj.aj.business.service.monitor;

import java.util.Map;

/**
 * 【describe】
 */
public interface 【Uname】Service {

    Map<String, Object> add【Uname】(Map<String, Object> parameterMap);

    Map<String, Object> del【Uname】(Map<String, Object> parameterMap);

    Map<String, Object> upd【Uname】(Map<String, Object> parameterMap);

    Map<String, Object> get【Uname】List(Map<String, Object> parameterMap);

    Map<String, Object> findById(Map<String, Object> parameterMap);
}
