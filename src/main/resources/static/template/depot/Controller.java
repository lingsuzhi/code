路径【D:\home\depot\depot-apply\src\main\java\com\lsz\apply\base\controller】
package com.lsz.apply.base.controller【点包名】;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lsz.apply.base.service【点包名】.I【Uname】Service;
import com.lsz.core.common.BaseController;
import com.lsz.core.common.PagesParam;
import com.lsz.core.common.ResponseInfo;
import com.lsz.model.dto【点包名】.【Uname】DTO;
import com.lsz.model.vo【点包名】.【Uname】VO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


/**
 * 【describe】 功能业务Controller
 *
 * @Author: lingsuzhi
 * @Date: 【日期】
 * @Version: V1.0
 */
@RestController
@RequestMapping("/【Lname】Controller")
public class 【Uname】Controller extends BaseController {

    @Autowired
    private I【Uname】Service 【Lname】Service;

    /**
     * 分页查询【describe】
     *
     * @param pagesParam 查询条件
     * @return 分页数据
     */
    @PostMapping("/page【Uname】")
    public ResponseInfo<Page<【Uname】VO>> page【Uname】(@RequestBody PagesParam pagesParam) {
        return ResponseInfo.success(【Lname】Service.page【Uname】(pagesParam));
    }

    /**
     * 新增【describe】
     *
     * @return 成功返回id
     */
    @PostMapping("/add【Uname】")
    public ResponseInfo<String> add【Uname】(@RequestBody 【Uname】DTO 【Lname】DTO) {
        return ResponseInfo.success(【Lname】Service.add【Uname】(【Lname】DTO));
    }

    /**
     * 修改【describe】
     *
     * @return 成功返回true
     */
    @PostMapping("/update【Uname】")
    public ResponseInfo<Boolean> update【Uname】(@RequestBody 【Uname】DTO 【Lname】DTO) {
        return ResponseInfo.success(【Lname】Service.update【Uname】(【Lname】DTO));
    }

    /**
     * 查询【describe】
     *
     * @param param 查询条件id
     * @return 【describe】VO
     */
    @PostMapping("/detail【Uname】")
    public ResponseInfo<【Uname】VO> detail【Uname】(@RequestBody Map<String, Object> param) {
        return ResponseInfo.success(【Lname】Service.detail【Uname】(param));
    }

    /**
     * 删除【describe】
     *
     * @param param 删除id 多选逗号分隔
     * @return 返回删除数量
     */
    @PostMapping("/delete【Uname】")
    public ResponseInfo<Integer> delete【Uname】(@RequestBody Map<String, Object> param) {
        return ResponseInfo.success(【Lname】Service.delete【Uname】(param));
    }
}
