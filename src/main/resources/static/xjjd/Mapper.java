package com.xjjd.lease.apply.api.base.mapper;

import com.xjjd.lease.apply.api.base.pojo.【Uname】;
import io.swagger.models.auth.In;
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

    【Uname】 get【Uname】(Map<String, Object> paramMap);

    Integer upd【Uname】(Map<String, Object> paramMap);

    List<【Uname】> get【Uname】List(Map<String, Object> paramMap);

    Integer get【Uname】Count(Map<String, Object> paramMap);
}


