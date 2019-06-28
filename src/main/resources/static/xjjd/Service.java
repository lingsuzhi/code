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
     * @param 【Uname】 实体
     * @return 【Uname】 实体
     * @author lingsuzhi
     * @date: 【日期】
     */
    【Uname】 add【Uname】(【Uname】 adminInfo);

    /**
     * 删除【describe】
     *
     * @param Map id
     * @return Map msg
     * @author lingsuzhi
     * @date: 【日期】
     */
    Map<String, Object> del【Uname】(Map<String, Object> parameterMap);

    /**
     * 修改【describe】
     *
     * @param 【Uname】 实体
     * @return 【Uname】 实体
     * @author lingsuzhi
     * @date: 【日期】
     */
    【Uname】 upd【Uname】(【Uname】 adminInfo);

    /**
     * 分页查询【describe】
     *
     * @param PagesParam 查询条件
     * @return BasePage<【Uname】DTO> 分页对象
     * @author lingsuzhi
     * @date: 【日期】
     */
    BasePage<【Uname】DTO> get【Uname】List(PagesParam parameterMap);

    /**
     * 查询【describe】
     *
     * @param Map 查询条件
     * @return 【Uname】DTO 实体
     * @author lingsuzhi
     * @date: 【日期】
     */
    【Uname】DTO get【Uname】(Map<String, Object> parameterMap);
}


