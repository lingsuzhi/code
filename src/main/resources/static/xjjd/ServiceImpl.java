package com.yl.lmdm.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yl.common.base.enums.ResultCodeEnum;
import com.yl.common.base.exception.ServiceException;
import com.yl.lmdm.entity.【Uname】;
import com.yl.lmdm.mapper.【Uname】Mapper;
import com.yl.lmdm.service.I【Uname】Service;
import com.yl.model.lmdm.dto.【Uname】DTO;
import com.yl.model.lmdm.dto.【Uname】QueryDTO;
import com.yl.model.lmdm.enums.DeleteEnum;
import com.yl.model.lmdm.enums.EnableEnum;
import com.yl.model.lmdm.vo.【Uname】VO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * 【describe】
 *
 * @author lingsuzhi
 * @since 【日期】
 */
@Service
@Slf4j
public class 【Uname】ServiceImpl extends ServiceImpl<【Uname】Mapper, 【Uname】> implements I【Uname】Service {

    @Autowired
    private 【Uname】Mapper 【Lname】Mapper;


    @Override
    public IPage<【Uname】VO> page【Uname】(【Uname】QueryDTO dto, Page<【Uname】VO> page) {
        return 【Lname】Mapper.selectByPageVO(new Page<>(page.getCurrent(), page.getSize()), dto);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean removeById(Integer id) {
        【Uname】 area = this.getById(id);
        if (area == null) {
            return false;
        }
        log.info("【Uname】#### 删除【describe】 {}", area);

        return this.removeById(area);
    }

    @Override
    public 【Uname】VO getDetailById(Integer id) {
        return 【Lname】Mapper.getDetail(id);
    }

    @Override
    public 【Uname】 getById(Integer id) {
        return Optional.ofNullable(super.getById(id)).orElseThrow(() -> new ServiceException(ResultCodeEnum.DATA_NOT_FOUND));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean save(【Uname】DTO dto) {
        【Uname】 【Lname】 = new 【Uname】();
        BeanUtils.copyProperties(dto, 【Lname】);
        【Lname】.setCreateTime(LocalDateTime.now())
                .setUpdateTime(LocalDateTime.now())
                .setIsDelete(DeleteEnum.VALID.getCode())
                .setIsEnable(EnableEnum.NORMAL.getCode())
                .setCreateBy(1)
                .setUpdateBy(1)
                .setCreateByName("")
                .setUpdateByName("")
                .setVersion("1.0.0")
                .setSort(0)
        ;
        return this.save(【Lname】);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean updateById(【Uname】DTO dto) {
        if (dto.getId() == null) {
            throw new ServiceException(ResultCodeEnum.PARAMS_NOT_COMPLETE);
        }
        【Uname】 【Lname】 = new 【Uname】();
        BeanUtils.copyProperties(dto, 【Lname】);
        【Lname】.setUpdateTime(LocalDateTime.now())
                .setUpdateBy(1)
                .setUpdateByName("")
                .setVersion("1.0.0")
                .setSort(0)
        ;
        return this.updateById(【Lname】);
    }
}
