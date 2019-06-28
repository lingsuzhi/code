package com.lsz.apply.base.controller;

import com.lsz.apply.base.service.【Uname】Service;
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
    private 【Uname】Service 【Lname】Service;

    /**
     * 添加单个
     */
    @RequestMapping(value = "/add【Uname】", method = RequestMethod.POST)
    public ResponseInfo<【Uname】> add【Uname】(@RequestBody 【Uname】 【Lname】) {
        return ResponseInfo.success(【Lname】Service.add【Uname】(【Lname】));
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/delete【Uname】", method = RequestMethod.POST)
    public ResponseInfo<Map<String, Object>> del【Uname】(@RequestBody Map<String, Object> param) {

        Map<String, Object> resultMap = 【Lname】Service.del【Uname】(param);
        return ResponseInfo.success(resultMap);
    }

    /**
     * 修改
     */
    @RequestMapping(value = "/update【Uname】", method = RequestMethod.POST)
    public ResponseInfo<【Uname】> upd【Uname】(@RequestBody 【Uname】 【Lname】) {
        return ResponseInfo.success(【Lname】Service.upd【Uname】(【Lname】));
    }

    /**
     * 查询单个
     */
    @RequestMapping(value = "/get【Uname】", method = RequestMethod.POST)
    public ResponseInfo<【Uname】DTO> get【Uname】(@RequestBody Map<String, Object> param) {
        return ResponseInfo.success(【Lname】Service.get【Uname】(param));
    }

    /**
     * 查询列表
     */
    @RequestMapping(value = "/get【Uname】List", method = RequestMethod.POST)
    public ResponseInfo<BasePage<【Uname】DTO>> get【Uname】List(@RequestBody PagesParam param) {

        BasePage<【Uname】DTO> resultMap = 【Lname】Service.get【Uname】List(param);
        return ResponseInfo.success(resultMap);
    }
}
