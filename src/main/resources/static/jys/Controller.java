package com.lsz.jys.apply.base.controller;


import com.lsz.jys.apply.base.service.【Uname】Service;
import com.lsz.jys.common.BasePage;
import com.lsz.jys.common.PagesParam;
import com.lsz.jys.common.ResponseInfo;
import com.lsz.jys.pojo.【Uname】;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


/**
 * 【describe】
 */
@RestController("base【Uname】Controller")
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
    public ResponseInfo<【Uname】> get【Uname】(@RequestBody Map<String, Object> param) {

        【Uname】 resultMap = 【Lname】Service.get【Uname】(param);
        return ResponseInfo.success(resultMap);
    }

    /**
     * 查询列表
     */
    @RequestMapping(value = "/get【Uname】List", method = RequestMethod.POST)
    public ResponseInfo<BasePage<【Uname】>> get【Uname】List(@RequestBody PagesParam param) {

        BasePage<【Uname】> resultMap = 【Lname】Service.get【Uname】List(param);
        return ResponseInfo.success(resultMap);
    }
}
