package com.xjjd.lease.apply.api.base.controller;


import com.xjjd.lease.apply.api.base.pojo.【Uname】;
import com.xjjd.lease.apply.api.base.service.【Uname】Service;
import com.xjjd.lease.apply.api.base.util.BasePage;
import com.xjjd.lease.apply.api.base.util.PagesParam;
import com.xjjd.lease.common.ResponseInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private 【Uname】Service serviceImpl;

    /**
     * 添加单个
     */
    @RequestMapping(value = "/add【Uname】", method = RequestMethod.POST)
    public ResponseInfo<Map<String, Object>> add【Uname】(@RequestBody Map<String, Object> param) {
        try {
            Map<String, Object> resultMap = serviceImpl.add【Uname】(param);

            return ResponseInfo.success(resultMap);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return ResponseInfo.error(e.getMessage());
        }
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/delete【Uname】", method = RequestMethod.POST)
    public ResponseInfo<Map<String, Object>> del【Uname】(@RequestBody Map<String, Object> param) {
        try {
            Map<String, Object> resultMap = serviceImpl.del【Uname】(param);
            return ResponseInfo.success(resultMap);
        } catch (RuntimeException e) {
            logger.error(e.getMessage(), e);
            return ResponseInfo.error(e.getMessage());
        }
    }

    /**
     * 修改
     */
    @RequestMapping(value = "/update【Uname】", method = RequestMethod.POST)
    public ResponseInfo<Map<String, Object>> upd【Uname】(@RequestBody Map<String, Object> param) {
        try {
            Map<String, Object> resultMap = serviceImpl.upd【Uname】(param);
            return ResponseInfo.success(resultMap);
        } catch (RuntimeException e) {
            logger.error(e.getMessage(), e);
            return ResponseInfo.error(e.getMessage());
        }
    }

    /**
     * 查询单个
     */
    @RequestMapping(value = "/get【Uname】", method = RequestMethod.POST)
    public ResponseInfo<【Uname】> get【Uname】(@RequestBody Map<String, Object> param) {
        try {
            【Uname】 resultMap = serviceImpl.get【Uname】(param);
            return ResponseInfo.success(resultMap);
        } catch (RuntimeException e) {
            logger.error(e.getMessage(), e);
            return ResponseInfo.error(e.getMessage());
        }
    }

    /**
     * 查询列表
     */
    @RequestMapping(value = "/get【Uname】List", method = RequestMethod.POST)
    public ResponseInfo<BasePage<【Uname】>> get【Uname】List(@RequestBody PagesParam param) {
        try {
            BasePage<【Uname】> resultMap = serviceImpl.get【Uname】List(param);
            return ResponseInfo.success(resultMap);
        } catch (RuntimeException e) {
            logger.error(e.getMessage(), e);
            return ResponseInfo.error(e.getMessage());
        }
    }
}