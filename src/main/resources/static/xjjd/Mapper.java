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

    /**
     * 新增
     *
     * @param 【Lname】 对象
     * @return 新增数量
     */
    Integer add【Uname】(【Uname】 【Lname】);

    /**
     * 删除
     *
     * @param paramMap ids
     * @return 删除数量
     */
    Integer delete【Uname】(Map<String, Object> paramMap);

    /**
     * 查询
     *
     * @param paramMap 查询条件
     * @return 对象
     */
    【Uname】 get【Uname】(Map<String, Object> paramMap);

    /**
     * 修改
     *
     * @param 【Lname】 对象
     * @return 修改数量
     */
    Integer update【Uname】(【Uname】 【Lname】);

    /**
     * 分页查询
     *
     * @param paramMap 查询条件
     * @return 查询列表
     */
    List<【Uname】> get【Uname】List(Map<String, Object> paramMap);
}



