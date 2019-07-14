package com.lsz.apply.base.service;

import com.lsz.common.BasePage;
import com.lsz.common.PagesParam;
import com.lsz.dto.【Uname】DTO;
import com.lsz.pojo.【Uname】;

import java.util.List;
import java.util.Map;

/**
 * ClassName: I【Uname】Service
 * Description: 【describe】
 * Date: 【日期】
 *
 * @author: lingsuzhi
 * @version: 1.0
 * @since: JDK 1.8
 * @see
 */
public interface I【Uname】Service {

    /**
     * 新增【describe】
     *
     * @param 【Lname】 实体
     * @return 【Uname】 实体
     * @author lingsuzhi
     * @date: 【日期】
     */
    【Uname】 add【Uname】(【Uname】 【Lname】);

    /**
     * 删除【describe】
     *
     * @param parameterMap ID
     * @return Map msg
     * @author lingsuzhi
     * @date: 【日期】
     */
    Integer delete【Uname】(Map<String, Object> parameterMap);

    /**
     * 修改【describe】
     *
     * @param 【Lname】 实体
     * @return 【Uname】 实体
     * @author lingsuzhi
     * @date: 【日期】
     */
    Integer update【Uname】(【Uname】 【Lname】);

    /**
     * 分页查询【describe】
     *
     * @param pagesParam 查询条件
     * @return BasePage<【Uname】DTO> 分页对象
     * @author lingsuzhi
     * @date: 【日期】
     */
    BasePage<【Uname】DTO> get【Uname】List(PagesParam pagesParam);

    /**
     * 查询【describe】
     *
     * @param parameterMap 查询条件
     * @return 【Uname】DTO 实体
     * @author lingsuzhi
     * @date: 【日期】
     */
    【Uname】DTO get【Uname】(Map<String, Object> parameterMap);

    /**
     * 查询单个
     *
     * @param id ID
     * @return 【Uname】 实体
     * @author lingsuzhi
     * @date: 【日期】
     */
    【Uname】 findById(String id);

    /**
     * 转换为DTO
     *
     * @param 【Lname】 实体
     * @return 【Uname】DTO DTO实体
     * @author lingsuzhi
     * @date: 【日期】
     */
    【Uname】DTO manage【Uname】(【Uname】 【Lname】);

    /**
     * 批量修改
     *
     * @param param 实体列表
     * @return Integer 数量
     * @author lingsuzhi
     * @date: 【日期】
     */
    Integer updateList(List<【Uname】> param);
}


