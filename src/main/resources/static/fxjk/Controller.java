package com.jjkj.aj.business.controller.monitor;

import com.jjkj.aj.business.service.monitor.【Uname】Service;
import com.jjkj.aj.util.CommonUtils;
import com.jjkj.aj.util.ResultVOUtil;
import com.jjkj.aj.vo.ResultVO;
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
@RestController
@RequestMapping("/【Lname】")
public class 【Uname】Controller {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private 【Uname】Service serviceImpl;

    /**
     * 添加单个
     */
    @RequestMapping(value = "/add【Uname】", method = RequestMethod.POST)
    public ResultVO<Map<String, Object>> add【Uname】(@RequestBody Map<String, Object> param) {
        try {
            Map<String, Object> resultMap = serviceImpl.add【Uname】(param);
            return ResultVOUtil.success(resultMap);
        } catch (RuntimeException e) {
            logger.error(e.getMessage(), e);
            return CommonUtils.errorByMsg(e.getMessage());
        }
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/del【Uname】", method = RequestMethod.POST)
    public ResultVO<Map<String, Object>> del【Uname】(@RequestBody Map<String, Object> param) {
        try {
            Map<String, Object> resultMap = serviceImpl.del【Uname】(param);
            return ResultVOUtil.success(resultMap);
        } catch (RuntimeException e) {
            logger.error(e.getMessage(), e);
            return CommonUtils.errorByMsg(e.getMessage());
        }
    }

    /**
     * 修改
     */
    @RequestMapping(value = "/upd【Uname】", method = RequestMethod.POST)
    public ResultVO<Map<String, Object>> upd【Uname】(@RequestBody Map<String, Object> param) {
        try {
            Map<String, Object> resultMap = serviceImpl.upd【Uname】(param);
            return ResultVOUtil.success(resultMap);
        } catch (RuntimeException e) {
            logger.error(e.getMessage(), e);
            return CommonUtils.errorByMsg(e.getMessage());
        }
    }

    /**
     * 查询单个
     */
    @RequestMapping(value = "/get【Uname】", method = RequestMethod.POST)
    public ResultVO<Map<String, Object>> get【Uname】(@RequestBody Map<String, Object> param) {
        try {
            Map<String, Object> resultMap = serviceImpl.get【Uname】(param);
            return ResultVOUtil.success(resultMap);
        } catch (RuntimeException e) {
            logger.error(e.getMessage(), e);
            return CommonUtils.errorByMsg(e.getMessage());
        }
    }

    /**
     * 查询列表
     */
    @RequestMapping(value = "/get【Uname】List", method = RequestMethod.POST)
    public ResultVO<Map<String, Object>> get【Uname】List(@RequestBody Map<String, Object> param) {
        try {
            Map<String, Object> resultMap = serviceImpl.get【Uname】List(param);
            return ResultVOUtil.success(resultMap);
        } catch (RuntimeException e) {
            logger.error(e.getMessage(), e);
            return CommonUtils.errorByMsg(e.getMessage());
        }
    }

}
