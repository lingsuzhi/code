package com.lsz.jys.apply.base.service.impl;

import com.github.pagehelper.PageInfo;
import com.lsz.jys.apply.base.mapper.【Uname】Mapper;
import com.lsz.jys.apply.base.service.【Uname】Service;
import com.lsz.jys.common.BasePage;
import com.lsz.jys.common.PagesParam;
import com.lsz.jys.pojo.【Uname】;
import com.lsz.jys.util.CommonUtils;
import com.lsz.jys.util.ValidateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * 【describe】
 */
@Service("【Lname】ServiceImpl")
public class 【Uname】ServiceImpl implements 【Uname】Service {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private 【Uname】Mapper 【Lname】Mapper;

    //处理对象
    private static 【Uname】 manage【Uname】(【Uname】 【Lname】) {
        if (【Lname】 == null) return null;
【formatDo】
        return 【Lname】;
    }

    @Override
    @Transactional
    public 【Uname】 add【Uname】(【Uname】 【Lname】) {
        【Lname】.setCreateTime(new Date());
        【Lname】.setUpdateTime(new Date());
        【Lname】.setId(null);
【addnotnull】
【defaultValue】
        Integer count = 【Lname】Mapper.add【Uname】(【Lname】);
        logger.info("add【Uname】 完成:{}", count);
        return 【Lname】;
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
    public 【Uname】 upd【Uname】(【Uname】 【Lname】) {

        Long id = 【Lname】.getId();
        【Lname】.setUpdateTime(new Date());
        Integer count = 【Lname】Mapper.upd【Uname】(【Lname】);
        logger.info("upd【Uname】 完成:{} {}", count, id);
        return 【Lname】;
    }

    @Override
    public BasePage<【Uname】> get【Uname】List(PagesParam pageParam) {
        PagesParam.startPage(pageParam);
        List<【Uname】> list = 【Lname】Mapper.get【Uname】List(pageParam.getQuery());
        PageInfo<【Uname】> pageInfo = new PageInfo<>(list);
        BasePage<【Uname】> returnMap = new BasePage<>();

        if (list.size() > 0) {
            //处理
            for (【Uname】 objectMap : list) {
                manage【Uname】(objectMap);
            }

            returnMap.setTotal(pageInfo.getTotal());
        } else {
            returnMap.setTotal(0L);
            list = new ArrayList<>();
        }

        returnMap.setContent(list);
        return returnMap;
    }

    @Override
    public 【Uname】 get【Uname】(Map<String, Object> parameterMap) {
        return manage【Uname】(【Lname】Mapper.get【Uname】(parameterMap));
    }
}





