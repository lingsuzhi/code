路径【D:\home\depot\depot-apply\src\main\java\com\lsz\apply\base\service】
package com.lsz.apply.base.service【点包名】;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lsz.common.PagesParam;
import com.lsz.dto.【Uname】DTO;
import com.lsz.pojo.【Uname】;
import com.lsz.vo.【Uname】VO;

import java.util.Map;

/**
 * 【describe】Service服务接口定义
 * @Author:  lingsuzhi
 * @Date:    【日期】
 * @Version: V1.0
 */
public interface I【Uname】Service extends IService<【Uname】> {

    Page<【Uname】VO> page【Uname】(PagesParam pagesParam);

    String add【Uname】(【Uname】DTO 【Lname】DTO);

    Boolean update【Uname】(【Uname】DTO 【Lname】DTO);

    【Uname】VO detail【Uname】(Map<String, Object> param);

    Integer delete【Uname】(Map<String, Object> param);
}