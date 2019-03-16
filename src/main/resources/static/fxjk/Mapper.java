package com.jjkj.aj.business.mapper.monitor;

import com.jjkj.aj.business.entity.pojo.【Uname】;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Mapper
public interface 【Uname】Mapper {

    Integer add【Uname】(【Uname】 param);

    Integer del【Uname】(Map<String, Object> paramMap);

    【Uname】 findById(String  id);

    Integer upd【Uname】(【Uname】 param);

    List<【Uname】> get【Uname】List(Map<String, Object> paramMap);
}
