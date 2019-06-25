package com.lsz.apply.base.service.impl;

import com.github.pagehelper.PageInfo;
import com.lsz.apply.base.mapper.【Uname】Mapper;
import com.lsz.apply.base.service.【Uname】Service;
import com.lsz.common.BasePage;
import com.lsz.common.PagesParam;
import com.lsz.dto.【Uname】DTO;
import com.lsz.pojo.【Uname】;
import com.lsz.util.BeanUtil;
import com.lsz.util.CommonUtils;
import com.lsz.util.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 【describe】
 * @author lingsuzhi
 * @since 【日期】
 */
@Service("【Lname】ServiceBase")
@Slf4j
public class 【Uname】ServiceImpl implements 【Uname】Service {

    @Autowired
    private 【Uname】Mapper 【Lname】Mapper;

    //处理对象
    private static 【Uname】DTO manage【Uname】(【Uname】 【Lname】) {
        if (【Lname】 == null) return null;
        return BeanUtil.copyBean(【Lname】, 【Uname】DTO.class);
    }

    @Override
    @Transactional
    public 【Uname】 add【Uname】(【Uname】 【Lname】) {
        【Lname】.setCreateTime(new Date());
        【Lname】.setUpdateTime(new Date());
        【Lname】.setCreateBy(TokenUtil.getCurrentUserId());
        【Lname】.setUpdateBy(【Lname】.getCreateBy());
        【Lname】.setId(null);
        Integer count = 【Lname】Mapper.add【Uname】(【Lname】);
        log.info("add【Uname】 完成:{}", count);
        return 【Lname】;
    }

    @Override
    @Transactional
    public Map<String, Object> del【Uname】(Map<String, Object> parameterMap) {
        Integer count = 【Lname】Mapper.del【Uname】(CommonUtils.idList(parameterMap));
        log.info("del【Uname】 完成:{} {}", count);
        return CommonUtils.mapByMsg("删除完成！");
    }

    @Override
    @Transactional
    public 【Uname】 upd【Uname】(【Uname】 【Lname】) {

        Long id = 【Lname】.getId();
        【Lname】.setUpdateBy(TokenUtil.getCurrentUserId());
        【Lname】.setUpdateTime(new Date());
        Integer count = 【Lname】Mapper.upd【Uname】(【Lname】);
        log.info("upd【Uname】 完成:{} {}", count, id);
        return 【Lname】;
    }

    @Override
    public BasePage<【Uname】DTO> get【Uname】List(PagesParam pageParam) {
        PagesParam.startPage(pageParam);
        List<【Uname】> list = 【Lname】Mapper.get【Uname】List(pageParam.getQuery());
        PageInfo<【Uname】> pageInfo = new PageInfo<>(list);
        BasePage<【Uname】DTO> returnMap = new BasePage<>();
        returnMap.setContent(new ArrayList<>());
        if (list.size() > 0) {
            //处理
            for (【Uname】 objectMap : list) {
                returnMap.getContent().add(manage【Uname】(objectMap));
            }
            returnMap.setTotal(pageInfo.getTotal());
        } else {
            returnMap.setTotal(0L);
        }

        return returnMap;
    }

    @Override
    public 【Uname】DTO get【Uname】(Map<String, Object> parameterMap) {
        return manage【Uname】(【Lname】Mapper.get【Uname】(parameterMap));
    }
}