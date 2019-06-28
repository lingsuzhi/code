package com.lsz.apply.base.service;

import com.lsz.common.BasePage;
import com.lsz.common.PagesParam;
import com.lsz.dto.【Uname】DTO;
import com.lsz.pojo.【Uname】;

import java.util.Map;

/**
 * ClassName: 【Uname】Service
 * Description: 【describe】
 * Date: 【日期】
 *
 * @author: lingsuzhi
 * @version: 1.0
 * @since: JDK 1.8
 * @see
 */
public interface 【Uname】Service {

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
    Map<String, Object> delete【Uname】(Map<String, Object> parameterMap);

    /**
     * 修改【describe】
     *
     * @param 【Lname】 实体
     * @return 【Uname】 实体
     * @author lingsuzhi
     * @date: 【日期】
     */
    【Uname】 update【Uname】(【Uname】 【Lname】);

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
}


