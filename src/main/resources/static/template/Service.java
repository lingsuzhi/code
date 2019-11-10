路径【D:\fy\sfj\sfj\sfj-provider-gw-50007\src\main\java\com\jjkj\gw\main\services】
package com.jjkj.gw.main.services【点包名】;

import java.util.Map;
import java.util.List;

/**
 * 【describe】Service服务接口定义
 * @Author:  lingsuzhi
 * @Date:    【日期】
 * @Version: V1.0
 */
public interface I【Uname】Service{

    /**
     * 基础功能：查询数据列表
     */
    List<Map<String, Object>> get【Uname】List(Map<String, Object> paramMap);

    /**
     * 基础功能：分页查询数据列表
     */
    Map<String, Object> get【Uname】PagingList(Map<String, Object> paramMap);

    /**
     * 基础功能：查询单条数据
     */
    Map<String, Object> get【Uname】(Map<String, Object> paramMap);

    /**
     * 基础功能：保存数据
     */
    int save【Uname】Record(Map<String, Object> paramMap);

    /**
     * 基础功能：修改数据
     */
    int update【Uname】Record(Map<String, Object> paramMap);

    /**
     * 基础功能：逻辑删除数据
     */
    int delete【Uname】Record(Map<String, Object> paramMap);

    /**
     * 基础功能：物理删除数据
     */
    int remove【Uname】Record(Map<String, Object> paramMap);

}