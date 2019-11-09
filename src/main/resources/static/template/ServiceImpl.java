package com.lsz.apply.base.service.impl;

import com.github.pagehelper.PageInfo;
import com.lsz.apply.base.mapper.【Uname】Mapper;
import com.lsz.apply.base.service.I【Uname】Service;
import com.lsz.common.BasePage;
import com.lsz.common.PagesParam;
import com.lsz.dto.【Uname】DTO;
import com.lsz.vo.【Uname】VO;
import com.lsz.pojo.【Uname】;
import com.lsz.util.*;
import com.lsz.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.lsz.apply.datas.DatasUtil;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * ClassName: 【Uname】ServiceImpl
 * Description: 【describe】
 * Date: 【日期】
 *
 * @author: lingsuzhi
 * @version: 1.0
 * @since: JDK 1.8
 * @see
 */
@Service("【Lname】ServiceBase")
@Slf4j
public class 【Uname】ServiceImpl implements I【Uname】Service {

    @Autowired
    private 【Uname】Mapper 【Lname】Mapper;

    /**
     * 处理对象
     * @param 【Lname】 【describe】
     * @return 【Uname】VO
     */
    @Override
    public 【Uname】VO manage【Uname】(【Uname】 【Lname】, Map<String, Object> parameterMap) {
        if (【Lname】 == null) {
            return null;
        }
        【Uname】VO 【Lname】VO = BeanUtil.copyBean(【Lname】, 【Uname】VO.class);
        //处理VO
【DatasUtil】
        return 【Lname】VO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String add【Uname】(【Uname】DTO 【Lname】DTO) {
        【Lname】DTO.setId(UuidMd5.uuidWith22Bit());
        【Uname】 【Lname】 = BeanUtil.copyBean(【Lname】DTO, 【Uname】.class);
【defaultValue】
【notnull】
        【Lname】.setCreateTime(new Date());
        【Lname】.setUpdateTime(new Date());
        【Lname】.setCreateBy(TokenUtil.getCurrentUserId());
        【Lname】.setUpdateBy(【Lname】.getCreateBy());
        Integer count = 【Lname】Mapper.add【Uname】(【Lname】);
        log.info("add【Uname】 完成:{}", count);
        if (count == 1) {
            manage【Uname】(【Lname】DTO);
        }
        return 【Lname】.getId();
    }

    private void manage【Uname】(【Uname】DTO 【Lname】DTO) {
        String id = 【Lname】DTO.getId();
        if (StringUtils.isEmpty(id)) {
            return;
        }
        //增删改操作

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer delete【Uname】(Map<String, Object> parameterMap) {
        Integer count = 【Lname】Mapper.delete【Uname】(CommonUtils.idListEx(parameterMap));
        log.info("delete【Uname】 完成，返回:{}", count);
        if (count == 1) {
            manage【Uname】(new 【Uname】DTO().setId(ValidateUtil.paramIsEmpty("id", parameterMap)));
        }
        return count;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer update【Uname】(【Uname】DTO 【Lname】DTO) {
        if (【Lname】DTO.getId() == null) {
            throw new BusinessException("修改失败,ID不能为空！");
        }
        【Uname】 【Lname】 = BeanUtil.copyBean(【Lname】DTO, 【Uname】.class);

        【Lname】.setUpdateBy(TokenUtil.getCurrentUserId());
        【Lname】.setUpdateTime(new Date());
        Integer count = 【Lname】Mapper.update【Uname】(【Lname】);
        log.info("update【Uname】 完成:{} ID:{}", count, 【Lname】.getId());
        if (count == 1) {
            manage【Uname】(【Lname】DTO);
        }
        return count;
    }

    @Override
    public BasePage<【Uname】VO> get【Uname】List(PagesParam pagesParam) {
        PagesParam.startPage(pagesParam);
        List<【Uname】> list = 【Lname】Mapper.get【Uname】List(pagesParam.getQuery());
        PageInfo<【Uname】> pageInfo = new PageInfo<>(list);
        BasePage<【Uname】VO> returnMap = new BasePage<>();
        returnMap.setContent(new ArrayList<>());
        if (list.size() > 0) {
            //处理
            for (【Uname】 objectMap : list) {
                returnMap.getContent().add(manage【Uname】(objectMap, pagesParam.getQuery()));
            }
            returnMap.setTotal(pageInfo.getTotal());
        } else {
            returnMap.setTotal(0L);
        }

        return returnMap;
    }

    @Override
    public 【Uname】VO get【Uname】(Map<String, Object> parameterMap) {
        return manage【Uname】(【Lname】Mapper.get【Uname】(parameterMap), parameterMap);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer updateList(List<【Uname】DTO> param) {
        if (CollectionUtils.isEmpty(param)) {
            return 0;
        }
        int count = 0;
        for (【Uname】DTO item : param) {
            count += this.update【Uname】(item);
        }
        return count;
    }

    @Override
    public 【Uname】 findById(String id) {
        return 【Lname】Mapper.get【Uname】(CommonUtils.toMap(id));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer enable(Map<String, Object> parameterMap) {
        Integer count = 【Lname】Mapper.updateByIds(CommonUtils.idListEx(parameterMap, "is_enable", ValidateUtil.validateParamContainKey("value", parameterMap)));
        log.info("updateByIds 完成，返回:{}", count);
        return count;
    }
}