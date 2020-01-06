路径【D:\home\depot\depot-apply\src\main\java\com\lsz\apply\base\service\impl】
package com.lsz.apply.base.service【点包名】.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lsz.apply.base.mapper.【Uname】Mapper;
import com.lsz.apply.base.service.I【Uname】Service;
import com.lsz.common.PagesParam;
import com.lsz.dto.【Uname】DTO;
import com.lsz.exception.BusinessException;
import com.lsz.pojo.【Uname】;
import com.lsz.util.BeanUtil;
import com.lsz.util.CommonUtils;
import com.lsz.util.TokenUtil;
import com.lsz.util.UuidMd5;
import com.lsz.vo.【Uname】VO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Map;

/**
 * 【describe】业务功能服务实现类
 *
 * @Author:  lingsuzhi
 * @Date:    【日期】
 * @Version: V1.0
 */
@Service
@Slf4j
public class 【Uname】ServiceImpl extends ServiceImpl<【Uname】Mapper, 【Uname】> implements I【Uname】Service {

    @Override
    public Page<【Uname】VO> page【Uname】(PagesParam pagesParam) {
        Page<【Uname】VO> 【Lname】VOPage = baseMapper.page【Uname】(pagesParam.getPage(), pagesParam.getQuery());

        return 【Lname】VOPage;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String add【Uname】(【Uname】DTO 【Lname】DTO) {
        【Lname】DTO.setId(UuidMd5.uuidWith22Bit());
        【Uname】 【Lname】 = BeanUtil.copyBean(【Lname】DTO, 【Uname】.class);

        【Lname】.setCreateBy(TokenUtil.getCurrentUserId())
                .setUpdateBy(【Lname】.getCreateBy())
                .setCreateTime(new Date())
                .setUpdateTime(【Lname】.getCreateTime());

        baseMapper.insert(【Lname】);
        return 【Lname】.getId();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean update【Uname】(【Uname】DTO 【Lname】DTO) {
        if (【Lname】DTO.getId() == null) {
            throw new BusinessException("修改失败,ID不能为空！");
        }
        【Uname】 【Lname】 = BeanUtil.copyBean(【Lname】DTO, 【Uname】.class);

        【Lname】.setUpdateBy(TokenUtil.getCurrentUserId());
        【Lname】.setUpdateTime(new Date());
        int result = baseMapper.updateById(【Lname】);
        log.info("修改用户信息完成 返回:{} ID:{}", result, 【Lname】.getId());
        return result > 0;
    }

    @Override
    public 【Uname】VO detail【Uname】(Map<String, Object> param) {
        return baseMapper.detail【Uname】(param);
    }

    @Override
    public Integer delete【Uname】(Map<String, Object> param) {
        return baseMapper.deleteBatchIds(CommonUtils.idList(param));
    }
}
