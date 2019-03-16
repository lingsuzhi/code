package com.jjkj.aj.business.controller.monitor;

import com.jjkj.aj.business.entity.param.【Uname】Param;
import com.jjkj.aj.business.entity.pojo.【Uname】;
import com.jjkj.aj.business.service.monitor.【Uname】Service;
import com.jjkj.aj.util.ValidateUtil;
import com.jjkj.aj.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;


/**
 * 【describe】
 */
@RestController
@RequestMapping("/【Lname】")
public class 【Uname】Controller {

    @Autowired
    private 【Uname】Service serviceImpl;

    /**
     * 添加单个
     */
    @RequestMapping(value = "/add【Uname】", method = RequestMethod.POST)
    public ResultVO<【Uname】> add【Uname】(@Valid @RequestBody 【Uname】Param param) {
        return serviceImpl.add【Uname】(param);
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/del【Uname】", method = RequestMethod.POST)
    public ResultVO<Map<String, Object>> del【Uname】(@RequestBody Map<String, Object> map) {
        ValidateUtil.validateParamContainKey("token", map);
        String id = ValidateUtil.validateParamContainKey("id", map);
        return serviceImpl.del【Uname】(id);
    }

    /**
     * 修改
     */
    @RequestMapping(value = "/upd【Uname】", method = RequestMethod.POST)
    public ResultVO<【Uname】> upd【Uname】(@Valid @RequestBody 【Uname】Param param) {
        return serviceImpl.upd【Uname】(param);
    }

    /**
     * 查询单个
     */
    @RequestMapping(value = "/findById")
    public ResultVO<【Uname】> findById(@RequestParam String id) {
        return serviceImpl.findById(id);
    }

    /**
     * 查询列表
     */
    @RequestMapping(value = "/get【Uname】List", method = RequestMethod.POST)
    public ResultVO<Map<String, Object>> get【Uname】List(@RequestBody Map<String, Object> map) {
        ValidateUtil.validateParamContainKey("token", map);
        return serviceImpl.get【Uname】List(map);
    }

}
