package com.jjkj.aj.business.service.monitor;

import com.jjkj.aj.business.entity.param.【Uname】Param;
import com.jjkj.aj.business.entity.pojo.【Uname】;
import com.jjkj.aj.vo.ResultVO;

import java.util.Map;

/**
 * 【describe】
 */
public interface 【Uname】Service {

    ResultVO add【Uname】(【Uname】Param param);

    ResultVO del【Uname】(String id);

    ResultVO<【Uname】> upd【Uname】(【Uname】Param param);

    ResultVO<Map<String, Object>> get【Uname】List(Map<String, Object> map);

    ResultVO<【Uname】> findById(String id);
}
