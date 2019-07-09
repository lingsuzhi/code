package com.lsz.apply.base.service.impl;

import com.github.pagehelper.PageInfo;
import com.lsz.apply.base.mapper.【Uname】Mapper;
import com.lsz.apply.base.service.I【Uname】Service;
import com.lsz.common.BasePage;
import com.lsz.common.PagesParam;
import com.lsz.dto.【Uname】DTO;
import com.lsz.pojo.【Uname】;
import com.lsz.util.BeanUtil;
import com.lsz.util.CommonUtils;
import com.lsz.exception.BusinessException;
import com.lsz.util.TokenUtil;
import com.lsz.util.UuidMd5;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.lsz.apply.datas.DatasUtil;

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
     * @return 【Uname】DTO
     */
    @Override
    public 【Uname】DTO manage【Uname】(【Uname】 【Lname】) {
        if (【Lname】 == null) {
            return null;
        }
        【Uname】DTO 【Lname】DTO = BeanUtil.copyBean(【Lname】, 【Uname】DTO.class);
        //处理DTO
【DatasUtil】
        return 【Lname】DTO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public 【Uname】 add【Uname】(【Uname】 【Lname】) {
【defaultValue】
【notnull】
        【Lname】.setCreateTime(new Date());
        【Lname】.setUpdateTime(new Date());
        【Lname】.setCreateBy(TokenUtil.getCurrentUserId());
        【Lname】.setUpdateBy(【Lname】.getCreateBy());
        【Lname】.setId(UuidMd5.uuidWith22Bit());
        Integer count = 【Lname】Mapper.add【Uname】(【Lname】);
        log.info("add【Uname】 完成:{}", count);
        return 【Lname】;
    }
	
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer delete【Uname】(Map<String, Object> parameterMap) {
        Map<String, Object> map = CommonUtils.idList(parameterMap);
        if (map == null) {
            【Uname】DTO 【Lname】 = this.get【Uname】(parameterMap);
            if (【Lname】 != null) {
                map = CommonUtils.toMap(【Lname】.getId());
            }
        }
        if (map == null) {
            throw new BusinessException("4404", "删除失败，数据不存在");
        }
        Integer count = 【Lname】Mapper.delete【Uname】(CommonUtils.idList(map));
        log.info("delete【Uname】 完成，返回:{}", count);
        return count;
    }
	
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer update【Uname】(【Uname】 【Lname】) {
        if (【Lname】.getId() == null) {
            throw new BusinessException("修改失败,ID不能为空！");
        }

        【Lname】.setUpdateBy(TokenUtil.getCurrentUserId());
        【Lname】.setUpdateTime(new Date());
        Integer count = 【Lname】Mapper.update【Uname】(【Lname】);
        log.info("update【Uname】 完成:{} ID:{}", count, 【Lname】.getId());
        return count;
    }

    @Override
    public BasePage<【Uname】DTO> get【Uname】List(PagesParam pagesParam) {
        PagesParam.startPage(pagesParam);
        List<【Uname】> list = 【Lname】Mapper.get【Uname】List(pagesParam.getQuery());
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

    @Override
    public 【Uname】 findById(String id) {
        return 【Lname】Mapper.get【Uname】(CommonUtils.toMap(id));
    }
}