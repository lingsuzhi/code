package com.jjkj.aj.business.service.monitor.impl;

import com.jjkj.aj.business.mapper.monitor.【Uname】Mapper;
import com.jjkj.aj.business.service.monitor.【Uname】Service;
import com.jjkj.aj.util.CommonUtils;
import com.jjkj.aj.util.UUIDUtil;
import com.jjkj.aj.util.ValidateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 【describe】
 */
@Service("【Lname】ServiceImpl")
public class 【Uname】ServiceImpl implements 【Uname】Service {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private 【Uname】Mapper 【Lname】Mapper;

    @Override
    public Map<String, Object> add【Uname】(Map<String, Object> parameterMap) {
        String token = ValidateUtil.validateParamContainKey("token", parameterMap);//token
        String id = UUIDUtil.getUUID();
【addnotnull】
        parameterMap.put("id", id);
        parameterMap.putIfAbsent("status", 1);
        parameterMap.putIfAbsent("delFlag", 1);
        parameterMap.put("createId", token);
        parameterMap.put("updateId", token);
        parameterMap.put("createTime", new Date());
        parameterMap.put("updateTime", new Date());

        Integer count = 【Lname】Mapper.add【Uname】(parameterMap);
        logger.info("add【Uname】 完成:{} {}", count, id);
        return parameterMap;
    }

    @Override
    public Map<String, Object> del【Uname】(Map<String, Object> parameterMap) {
        String id = ValidateUtil.paramIsEmpty("id", parameterMap);
        Map<String, Object> paramMap = new HashMap<>();
        String[] produceIdList = id.split(",");
        List<String> produceIds = new ArrayList<>();
        for (String produceId : produceIdList) {
            String produce_id = "'" + produceId + "'";
            produceIds.add(produce_id);
        }

        paramMap.put("idList", produceIds);
        Integer count = 【Lname】Mapper.del【Uname】(paramMap);
        logger.info("del【Uname】 完成:{} {}", count, id);
        return CommonUtils.mapByMsg("删除完成！");
    }

    @Override
    public Map<String, Object> upd【Uname】(Map<String, Object> parameterMap) {

        String token = ValidateUtil.validateParamContainKey("token", parameterMap);//token
        String id = ValidateUtil.validateParamContainKey("id", parameterMap);//token

        parameterMap.put("updateId", token);
        parameterMap.put("updateTime", new Date());

        Integer count = 【Lname】Mapper.upd【Uname】(parameterMap);
        logger.info("upd【Uname】 完成:{} {}", count, id);
        return parameterMap;
    }

    @Override
    public Map<String, Object> get【Uname】List(Map<String, Object> map) {
        CommonUtils.spliceMap(map);
        List<Map<String, Object>> list = 【Lname】Mapper.get【Uname】List(map);
        Map<String, Object> returnMap = new HashMap<>();

        if (list != null && list.size() > 0) {
            Map<String, Object> 【Lname】Count = 【Lname】Mapper.get【Uname】Count(map);//处理
            returnMap.put("total", 【Lname】Count.get("total"));
        } else {
            returnMap.put("total", 0);
            list = new ArrayList<>();
        }

        returnMap.put("resultList", list);
        return returnMap;
    }

    @Override
    public Map<String, Object> findById(Map<String, Object> parameterMap) {
        return 【Lname】Mapper.findById(parameterMap);
    }

}
