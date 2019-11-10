路径【D:\fy\sfj\sfj\sfj-provider-gw-50007\src\main\java\com\jjkj\gw\main\controllers】
package com.jjkj.gw.main.controllers【点包名】;

import com.jjkj.gw.main.common.util.ResultUtil;
import com.jjkj.gw.main.common.util.ResultVO;
import com.jjkj.gw.main.common.util.ValidateUtil;
import com.jjkj.gw.main.common.util.ResultVOUtil;
import com.jjkj.gw.main.services【点包名】.I【Uname】Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.List;

/**
 * 实现接口(组) 【describe】 功能业务Controller
 *
 * @Author: lingsuzhi
 * @Date: 【日期】
 * @Version: V1.0
 */
@RestController
@RequestMapping("/【Lname】Controller")
public class 【Uname】Controller {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //【describe】Service
    @Autowired
    private I【Uname】Service 【Lname】ServiceImpl;

    /**
    * 基础功能：查询数据列表
    */
    @RequestMapping(value = "/get【Uname】List", method = RequestMethod.POST)
    public ResultVO<List<Map<String, Object>>> get【Uname】List(Map<String, Object> paramMap){
        return  ResultVOUtil.success(【Lname】ServiceImpl.get【Uname】List(paramMap));
    }

    /**
    * 基础功能：分页查询数据列表
    */
    @RequestMapping(value = "/get【Uname】PagingList", method = RequestMethod.POST)
    public ResultVO<Map<String, Object>> get【Uname】PagingList(Map<String, Object> paramMap){
        return  ResultVOUtil.success(【Lname】ServiceImpl.get【Uname】PagingList(paramMap));
    }

    /**
    * 基础功能：查询单条数据
    */
    @RequestMapping(value = "/get【Uname】", method = RequestMethod.POST)
    public ResultVO<Map<String, Object>> get【Uname】(Map<String, Object> paramMap){
        return  ResultVOUtil.success(【Lname】ServiceImpl.get【Uname】(paramMap));
    }

    /**
    * 基础功能：保存数据
    */
    @RequestMapping(value = "/save【Uname】Record", method = RequestMethod.POST)
    public ResultVO save【Uname】Record(Map<String, Object> paramMap){
        return  ResultVOUtil.success(【Lname】ServiceImpl.save【Uname】Record(paramMap));
    }

    /**
    * 基础功能：修改数据
    */
    @RequestMapping(value = "/update【Uname】Record", method = RequestMethod.POST)
    public ResultVO update【Uname】Record(Map<String, Object> paramMap){
        return  ResultVOUtil.success(【Lname】ServiceImpl.update【Uname】Record(paramMap));
    }

    /**
    * 基础功能：逻辑删除数据
    */
    @RequestMapping(value = "/delete【Uname】Record", method = RequestMethod.POST)
    public ResultVO delete【Uname】Record(Map<String, Object> paramMap){
        return  ResultVOUtil.success(【Lname】ServiceImpl.delete【Uname】Record(paramMap));
    }

    /**
    * 基础功能：物理删除数据
    */
    @RequestMapping(value = "/remove【Uname】Record", method = RequestMethod.POST)
    public ResultVO remove【Uname】Record(Map<String, Object> paramMap){
        return  ResultVOUtil.success(【Lname】ServiceImpl.remove【Uname】Record(paramMap));
    }
}
