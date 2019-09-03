package com.lsz.apply.base.controller;

import com.lsz.apply.base.service.I【Uname】Service;
import com.lsz.common.BasePage;
import com.lsz.common.PagesParam;
import com.lsz.common.ResponseInfo;
import com.lsz.dto.【Uname】DTO;
import com.lsz.vo.【Uname】VO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;
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
@Api(value = "【describe】", tags = {"【describe】管理"})
public class 【Uname】Controller {

    @Autowired
    private I【Uname】Service 【Lname】Service;

    /**
     * 添加
     * @author lingsuzhi
     * @date: 【日期】
     * @return 成功 返回ID
     */
    @ApiOperation(value = "添加【describe】", notes = "添加", httpMethod = "POST")
    @PostMapping(value = "/add【Uname】")
    public ResponseInfo<String> add【Uname】(@RequestBody 【Uname】DTO 【Lname】DTO) {
        return ResponseInfo.success(【Lname】Service.add【Uname】(【Lname】DTO));
    }

    /**
     * 删除
     * @author lingsuzhi
     * @date: 【日期】
     */
    @ApiOperation(value = "删除【describe】", notes = "删除", httpMethod = "POST")
    @PostMapping(value = "/delete【Uname】")
    public ResponseInfo<Integer> delete【Uname】(@RequestBody Map<String, Object> param) {
        return ResponseInfo.success(【Lname】Service.delete【Uname】(param));
    }

    /**
     * 修改
     * @author lingsuzhi
     * @date: 【日期】
     */
    @ApiOperation(value = "修改【describe】", notes = "修改", httpMethod = "POST")
    @PostMapping(value = "/update【Uname】")
    public ResponseInfo<Integer> update【Uname】(@RequestBody 【Uname】DTO 【Lname】DTO) {
        return ResponseInfo.success(【Lname】Service.update【Uname】(【Lname】DTO));
    }

    /**
     * 批量修改
     * @author lingsuzhi
     * @date: 【日期】
     */
    @ApiOperation(value = "批量修改【describe】", notes = "批量修改", httpMethod = "POST")
    @PostMapping(value = "/update【Uname】List")
    public ResponseInfo<Integer> update【Uname】List(@RequestBody List<【Uname】DTO> paramList) {
        return ResponseInfo.success(【Lname】Service.updateList(paramList));
    }

    /**
     * 查询
     * @author lingsuzhi
     * @date: 【日期】
     */
    @ApiOperation(value = "查询【describe】", notes = "查询", httpMethod = "POST")
    @PostMapping(value = "/get【Uname】")
    public ResponseInfo<【Uname】VO> get【Uname】(@RequestBody Map<String, Object> param) {
        return ResponseInfo.success(【Lname】Service.get【Uname】(param));
    }

    /**
     * 分页查询
     * @author lingsuzhi
     * @date: 【日期】
     */
    @ApiOperation(value = "分页查询【describe】", notes = "分页条件查询", httpMethod = "POST")
    @PostMapping(value = "/get【Uname】List")
    public ResponseInfo<BasePage<【Uname】VO>> get【Uname】List(@RequestBody PagesParam param) {
        return ResponseInfo.success(【Lname】Service.get【Uname】List(param));
    }

    /**
    * 启用禁用
    * @author lingsuzhi
    * @date: 【日期】
    */
    @ApiOperation(value = "启用禁用【describe】", notes = "启用禁用", httpMethod = "POST")
    @PostMapping(value = "/enable【Uname】")
    public ResponseInfo<Integer> enable【Uname】(@RequestBody Map<String,Object> param) {
        return ResponseInfo.success(【Lname】Service.enable(param));
    }

}
