package com.xjjd.lease.apply.api.base.service.impl;


import com.xjjd.lease.apply.api.base.mapper.【Uname】Mapper;
import com.xjjd.lease.apply.api.base.service.【Uname】Service;
import com.xjjd.lease.apply.api.base.util.CommonUtils;
import com.xjjd.lease.apply.api.base.util.ValidateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

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
    @Transactional
    public Map<String, Object> add【Uname】(Map<String, Object> parameterMap) {
        parameterMap.put("createTime", new Date());
        parameterMap.put("updateTime", new Date());
        【addnotnull】
        【defaultValue】
        Integer count = 【Lname】Mapper.add【Uname】(parameterMap);
        logger.info("add【Uname】 完成:{} {}", count);
        return parameterMap;
    }

    @Override
    @Transactional
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
    @Transactional
    public Map<String, Object> upd【Uname】(Map<String, Object> parameterMap) {

        String id = ValidateUtil.validateParamContainKey("id", parameterMap);

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
            //处理
            for (Map<String, Object> objectMap : list) {
                manage【Uname】(objectMap);
            }
            Map<String, Object> 【Lname】Count = 【Lname】Mapper.get【Uname】Count(map);
            returnMap.put("total", 【Lname】Count.get("total"));
        } else {
            returnMap.put("total", 0);
            list = new ArrayList<>();
        }

        returnMap.put("rows", list);
        return returnMap;
    }

    private Map<String, Object> manage【Uname】(Map<String, Object> map) {
        CommonUtils.timestampToStr(map, "createTime", true);
        CommonUtils.timestampToStr(map, "updateTime", true);
【formatDo】
        return map;
    }

    @Override
    public Map<String, Object> get【Uname】(Map<String, Object> parameterMap) {
        return manage【Uname】(【Lname】Mapper.get【Uname】(parameterMap));
    }
}

