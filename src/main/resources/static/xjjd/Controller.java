package com.yl.lmdm.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yl.common.base.controller.BaseController;
import com.yl.common.base.model.vo.Result;
import com.yl.lmdm.service.I【Uname】Service;
import com.yl.model.lmdm.dto.【Uname】DTO;
import com.yl.model.lmdm.dto.【Uname】QueryDTO;
import com.yl.model.lmdm.vo.【Uname】VO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 * 【describe】
 * </p>
 *
 * @author lingsuzhi
 * @since 【日期】
 */
@Slf4j
@RestController
@RequestMapping("/【Lname】")
@Api(value = "【describe】", tags = {"【describe】接口"})
public class 【Uname】Controller extends BaseController {

    @Autowired
    private I【Uname】Service 【Lname】Service;

    @RequestMapping(value = "/getPages", method = RequestMethod.GET)
    @ApiOperation(value = "分页查询", notes = "根据条件分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页", dataType = "int"),
            @ApiImplicitParam(name = "size", value = "页条数", dataType = "int")
    })
    public Result<IPage<【Uname】VO>> page【Uname】(【Uname】QueryDTO dto) {
        return Result.success(【Lname】Service.page【Uname】(dto, getPage()));
    }

    @GetMapping("/delete")
    @ApiOperation(value = "删除【describe】", notes = "逻辑删除")
    public Result<Boolean> removeById(@RequestParam("id") Integer id) {
        return Result.success(【Lname】Service.removeById(id));
    }

    @PostMapping("/add")
    @ApiOperation(value = "新增【describe】", notes = "新增【describe】")
    public Result<Boolean> save(@Valid @RequestBody 【Uname】DTO area) {
        return Result.success(【Lname】Service.save(area));
    }

    @PostMapping("/update")
    @ApiOperation(value = "修改【describe】", notes = "通过id修改指定【describe】")
    public Result<Boolean> updateById(@RequestBody 【Uname】DTO area) {
        return Result.success(【Lname】Service.updateById(area));
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "查询【describe】", notes = "查询指定【describe】")
    public Result<【Uname】VO> getById(@PathVariable("id") Integer id) {
        return Result.success(【Lname】Service.getDetailById(id));
    }
}
