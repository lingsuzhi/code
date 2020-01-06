路径【D:\home\depot\depot-apply\src\main\java\com\lsz\apply\base\mapper】
package com.lsz.apply.base.mapper【点包名】;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lsz.pojo.【Uname】;
import com.lsz.vo.【Uname】VO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * 【describe】 mapper功能定义类
 * @Author:  lingsuzhi
 * @Date:    【日期】
 * @Version: V1.0
 */
@Mapper
public interface 【Uname】Mapper extends BaseMapper<【Uname】> {

    Page<【Uname】VO> page【Uname】(Page page, @Param("dto") Map<String, Object> query);

    【Uname】VO detail【Uname】(@Param("dto") Map<String, Object> paramMap);
}
