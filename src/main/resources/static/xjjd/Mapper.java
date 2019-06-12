package com.yl.lmdm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yl.lmdm.entity.【Uname】;
import com.yl.model.lmdm.dto.【Uname】QueryDTO;
import com.yl.model.lmdm.vo.【Uname】VO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 【describe】
 * </p>
 *
 * @author lingsuzhi
 * @since 【日期】
 */
@Mapper
public interface 【Uname】Mapper extends BaseMapper<【Uname】> {

    /**
     * 分页查询
     */
    IPage<【Uname】VO> selectByPageVO(Page<【Uname】VO> page, @Param("dto") 【Uname】QueryDTO dto);

    /**
     * 查询明细
     */
    【Uname】VO getDetail(@Param("id") Integer id);
}
