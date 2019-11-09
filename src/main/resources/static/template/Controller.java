路径【D:\fy\sfj\sfj\sfj-provider-gw-50007\src\main\java\com\jjkj\gw\main\controllers】
package com.jjkj.gw.main.controllers【点包名】;

import com.jjkj.gw.main.common.util.ResultUtil;
import com.jjkj.gw.main.common.util.ResultVO;
import com.jjkj.gw.main.common.util.ValidateUtil;
import com.jjkj.gw.main.services【点包名】.I【Uname】Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


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

    @RequestMapping(value = "/get【Uname】List", method = RequestMethod.POST)
    public ResultVO get【Uname】List(@RequestBody Map<String, Object> paramMap) {
        return ResultUtil.getSuccessResult(【Lname】ServiceImpl.get【Uname】PagingList(paramMap));
    }

}
