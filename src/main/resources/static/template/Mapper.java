路径【D:\fy\sfj\sfj\sfj-provider-gw-50007\src\main\java\com\jjkj\gw\main\mappers】
package com.jjkj.gw.main.mappers【点包名】;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * 【describe】 mapper功能定义类
 * @Author:  lingsuzhi
 * @Date:    【日期】
 * @Version: V1.0
 */
@Mapper
@Component(value = "【Lname】Mapper")
public interface 【Uname】Mapper{

    /**
     * 基础功能：查询单条记录(基础查询)
     */
    Map<String, Object> selectOne(Map<String, Object> paramMap);

    /**
     * 基础功能：查询单条记录(扩展查询)
     */
    Map<String, Object> selectOneExtend(Map<String, Object> paramMap);

    /**
     * 基础功能：查询数据列表(基础查询)
     */
    List<Map<String, Object>> selectList(Map<String, Object> paramMap);

    /**
     * 基础功能：查询数据列表(扩展查询)
     */
    List<Map<String, Object>> selectExtendList(Map<String, Object> paramMap);

    /**
     * 基础功能：添加记录
     */
    int insertRecord(Map<String, Object> paramMap);


    /**
     * 基础功能：修改记录
     */
    int updateRecord(Map<String, Object> paramMap);

    /**
     * 基础功能：物理删除
     */
    int deletePhysics(Map<String, Object> paramMap);

    /**
     * 基础功能：逻辑删除
     */
    int deleteLogic(Map<String, Object> paramMap);

}