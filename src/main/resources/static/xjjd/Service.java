package com.yl.lmdm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yl.lmdm.entity.【Uname】;
import com.yl.model.lmdm.dto.【Uname】DTO;
import com.yl.model.lmdm.dto.【Uname】QueryDTO;
import com.yl.model.lmdm.vo.【Uname】VO;

/**
 * <p>
 * 【describe】 服务类
 * </p>
 *
 * @author lingsuzhi
 * @since 【日期】
 */
public interface I【Uname】Service extends IService<【Uname】> {

    /**
     * 查询列表并分页
     *
     * @param dto 查询条件
     */
    IPage<【Uname】VO> page【Uname】(【Uname】QueryDTO dto, Page<【Uname】VO> pageDTO);

    /**
     * 通过id删除
     */
    Boolean removeById(Integer id);

    /**
     * 详细信息
     */
    【Uname】VO getDetailById(Integer id);

    【Uname】 getById(Integer id);

    /**
     * 添加
     */
    Boolean save(【Uname】DTO dto);

    /**
     * 修改
     */
    Boolean updateById(【Uname】DTO dto);
}
