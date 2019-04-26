package com.xjjd.lease.apply.api.base.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
@Component("【Lname】Dao")
public interface 【Uname】Mapper {

    Integer add【Uname】(Map<String, Object> paramMap);

    Integer del【Uname】(Map<String, Object> paramMap);

    Integer kill【Uname】(Map<String, Object> paramMap);

    Map<String, Object> get【Uname】(Map<String, Object> paramMap);

    Integer upd【Uname】(Map<String, Object> paramMap);

    List<Map<String, Object>> get【Uname】List(Map<String, Object> paramMap);

    Map<String, Object> get【Uname】Count(Map<String, Object> paramMap);
}

