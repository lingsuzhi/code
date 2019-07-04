package com.lsz.apply.base.controller;

import com.lsz.apply.base.service.I【Uname】Service;
import com.lsz.common.BasePage;
import com.lsz.common.PagesParam;
import com.lsz.common.ResponseInfo;
import com.lsz.dto.【Uname】DTO;
import com.lsz.pojo.【Uname】;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

/**
 * ClassName: 【Uname】Controller
 * Description: 【describe】
 * Date: 【日期】
 *
 * @author: lingsuzhi
 * @version: 1.0
 * @since: JDK 1.8
 * @see
 */
@RestController("【Lname】ControllerBase")
@RequestMapping("/【Lname】Controller")
public class 【Uname】Controller {

    @Autowired
    private I【Uname】Service 【Lname】Service;

    /**
     * 添加
     */
    @PostMapping(value = "/add【Uname】")
    public ResponseInfo<【Uname】> add【Uname】(@RequestBody 【Uname】 【Lname】) {
        return ResponseInfo.success(【Lname】Service.add【Uname】(【Lname】));
    }

    /**
     * 删除
     */
    @PostMapping(value = "/delete【Uname】")
    public ResponseInfo<Integer> delete【Uname】(@RequestBody Map<String, Object> param) {
        return ResponseInfo.success(【Lname】Service.delete【Uname】(param));
    }

    /**
     * 修改
     */
    @PostMapping(value = "/update【Uname】")
    public ResponseInfo<Integer> update【Uname】(@RequestBody 【Uname】 【Lname】) {
        return ResponseInfo.success(【Lname】Service.update【Uname】(【Lname】));
    }

    /**
     * 查询
     */
    @PostMapping(value = "/get【Uname】")
    public ResponseInfo<【Uname】DTO> get【Uname】(@RequestBody Map<String, Object> param) {
        return ResponseInfo.success(【Lname】Service.get【Uname】(param));
    }

    /**
     * 分页查询
     */
    @PostMapping(value = "/get【Uname】List")
    public ResponseInfo<BasePage<【Uname】DTO>> get【Uname】List(@RequestBody PagesParam param) {
        BasePage<【Uname】DTO> resultMap = 【Lname】Service.get【Uname】List(param);
        return ResponseInfo.success(resultMap);
    }
}
