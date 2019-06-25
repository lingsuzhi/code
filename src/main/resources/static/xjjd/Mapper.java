package com.lsz.apply.base.mapper;

import com.lsz.pojo.【Uname】;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
@Component("【Lname】MapperBase")
public interface 【Uname】Mapper {

    Integer add【Uname】(【Uname】 【Lname】);

    Integer del【Uname】(Map<String, Object> paramMap);

    【Uname】 get【Uname】(Map<String, Object> paramMap);

    Integer upd【Uname】(【Uname】 【Lname】);

    List<【Uname】> get【Uname】List(Map<String, Object> paramMap);

    Integer get【Uname】Count(Map<String, Object> paramMap);
}



