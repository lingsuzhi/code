package com.lsz.apply.base.mapper;

import com.lsz.pojo.【Uname】;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * ClassName: 【Uname】Mapper
 * Description: 【describe】
 * Date: 【日期】
 *
 * @author: lingsuzhi
 * @version: 1.0
 * @since: JDK 1.8
 * @see
 */
@Mapper
@Component("【Lname】MapperBase")
public interface 【Uname】Mapper {

    //新增
    Integer add【Uname】(【Uname】 【Lname】);

    //删除
    Integer delete【Uname】(Map<String, Object> paramMap);

    //查询
    【Uname】 get【Uname】(Map<String, Object> paramMap);

    //修改
    Integer update【Uname】(【Uname】 【Lname】);

    //分页查询
    List<【Uname】> get【Uname】List(Map<String, Object> paramMap);

    //汇总
    Integer get【Uname】Count(Map<String, Object> paramMap);
}



