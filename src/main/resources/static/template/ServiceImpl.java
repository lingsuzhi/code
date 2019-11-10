路径【D:\fy\sfj\sfj\sfj-provider-gw-50007\src\main\java\com\jjkj\gw\main\services】
package com.jjkj.gw.main.services【点包名】.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jjkj.gw.main.common.util.*;
import com.jjkj.gw.main.mappers【点包名】.【Uname】Mapper;
import com.jjkj.gw.main.mappers【点包名】.【Uname】Mapper;
import com.jjkj.gw.main.base.BaseService;
import com.jjkj.gw.main.services【点包名】.I【Uname】Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 【describe】业务功能服务实现类
 *
 * @Author:  lingsuzhi
 * @Date:    【日期】
 * @Version: V1.0
 */
@Service
public class 【Uname】ServiceImpl extends BaseService implements I【Uname】Service {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private 【Uname】Mapper 【Lname】Mapper;

    /**
     * 基础功能：不分页查询数据集合
     *
     * @param paramMap
     * @return
     * @Author: lingsuzhi
     * @Date: 2019-09-05
     * @Version: V1.0
     */
    @Override
    public List<Map<String, Object>> get【Uname】List(Map<String, Object> paramMap) {
        logger.info("[【describe】]不分页查询数据!!!");
        List<Map<String, Object>> dataList = 【Lname】Mapper.selectExtendList(paramMap);
        return dataList;
    }


    /**
     * 基础功能：分页查询数据集合
     *
     * @param paramMap
     * @return
     * @Author: lingsuzhi
     * @Date: 2019-09-05
     * @Version: V1.0
     */
    @Override
    public Map<String, Object> get【Uname】PagingList(Map<String, Object> paramMap) {
        logger.info("[【describe】]分页查询数据!!!");
        if (!paramMap.containsKey("pageNum")) {
            paramMap.put("pageNum", "1");
        }

        if (!paramMap.containsKey("pageSize")) {
            //默认查询10条
            paramMap.put("pageSize", "10");
        }

        //设置分页参数

        //当前页
        Integer pNum = Integer.parseInt(paramMap.get("pageNum").toString());
        //每页显示多少条数据
        Integer pSize = Integer.parseInt(paramMap.get("pageSize").toString());
        PageHelper.startPage(pNum, pSize);
        PageInfo<Map<String, Object>> pageInfo = new PageInfo(【Lname】Mapper.selectExtendList(paramMap));
        return PageInfoUtil.getResultMap(pageInfo);
    }

    /**
     * 基础功能：查询单条数据
     *
     * @param paramMap
     * @return
     * @Author: lingsuzhi
     * @Date: 2019-09-05
     * @Version: V1.0
     */
    @Override
    public Map<String, Object> get【Uname】(Map<String, Object> paramMap) {
        Map<String, Object> resultMap = 【Lname】Mapper.selectOneExtend(paramMap);
        if (resultMap != null) {
            return resultMap;
        } else {
            logger.info("[【describe】]查询结果为空!!!");
            return new HashMap<>();
        }
    }

    /**
     * 基础功能：保存(添加)数据
     *
     * @param paramMap
     * @Author: lingsuzhi
     * @Date: 2019-09-05
     * @Version: V1.0
     */
    @Override
    public int save【Uname】Record(Map<String, Object> paramMap) {
        //设置主键ID
        String newId = UUIDUtil.getUUID();
        paramMap.put("id", newId);
        //设置必要用户参数
        this.setBaseParam(paramMap);
        logger.info("[【describe】]保存数据，newId=" + newId);
        return 【Lname】Mapper.insertRecord(paramMap);
    }

    /**
     * 基础功能：修改数据
     *
     * @param paramMap
     * @Author: lingsuzhi
     * @Date: 2019-09-05
     * @Version: V1.0
     */
    @Override
    public int update【Uname】Record(Map<String, Object> paramMap) {
        //设置必要用户参数
        this.setBaseParam(paramMap);
        logger.info("[【describe】]修改数据，参数=" + paramMap);
        return 【Lname】Mapper.updateRecord(paramMap);
    }

    /**
     * 基础功能：逻辑删除数据
     *
     * @param paramMap
     * @Author: lingsuzhi
     * @Date: 2019-09-05
     * @Version: V1.0
     */
    @Override
    public int delete【Uname】Record(Map<String, Object> paramMap) {
        logger.info("[【describe】]删除数据，参数=" + paramMap);
        return 【Lname】Mapper.deleteLogic(paramMap);
    }

    /**
     * 基础功能：物理删除数据
     *
     * @param paramMap
     * @Author: lingsuzhi
     * @Date: 2019-09-05
     * @Version: V1.0
     */
    @Override
    public int remove【Uname】Record(Map<String, Object> paramMap) {
        logger.info("[【describe】]物理删除数据，参数=" + paramMap);
        return 【Lname】Mapper.deletePhysics(paramMap);
    }

}