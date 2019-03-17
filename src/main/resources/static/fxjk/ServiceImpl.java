package com.jjkj.aj.business.service.monitor.impl;

import com.jjkj.aj.business.entity.param.【Uname】Param;
import com.jjkj.aj.business.entity.pojo.【Uname】;
import com.jjkj.aj.business.mapper.monitor.【Uname】Mapper;
import com.jjkj.aj.business.service.monitor.【Uname】Service;
import com.jjkj.aj.util.CommonUtils;
import com.jjkj.aj.util.ResultVOUtil;
import com.jjkj.aj.util.UUIDUtil;
import com.jjkj.aj.vo.ResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * 【describe】
 */
@Service
public class 【Uname】ServiceImpl implements 【Uname】Service {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private 【Uname】Mapper 【Lname】Mapper;

    @Override
    @Transactional
    public ResultVO<【Uname】> add【Uname】(【Uname】Param param) {
        【Uname】 【Lname】 = 【Uname】.getInitObj();
        BeanUtils.copyProperties(param, 【Lname】);
【addnotnull】
        【Lname】.setId(UUIDUtil.getUUID());
        【Lname】.setCreateId(param.getToken());
        【Lname】.setUpdateId(param.getToken());
        【Lname】.setCreateTime(new Date());
        【Lname】.setUpdateTime(new Date());

        Integer count = 【Lname】Mapper.add【Uname】(【Lname】);
        logger.info("upd【Uname】 完成:{} {}", count, 【Lname】.getId());
        return ResultVOUtil.success(【Lname】);
    }

    @Override
    public ResultVO del【Uname】(String id) {

        Map<String, Object> paramMap = new HashMap<>();
        String[] produceIdList = id.split(",");
        List<String> produceIds = new ArrayList<>();
        for (String produceId : produceIdList) {
            String produce_id = "'" + produceId + "'";
            produceIds.add(produce_id);
        }
        paramMap.put("idList", produceIds);

        Integer count = 【Lname】Mapper.del【Uname】(paramMap);
        logger.info("del【Uname】 完成:{} {}", count, id);
        return CommonUtils.successByMsg("删除成功");
    }

    @Override
    @Transactional
    public ResultVO<【Uname】> upd【Uname】(【Uname】Param param) {
        【Uname】 【Lname】 = new 【Uname】();

        BeanUtils.copyProperties(param, 【Lname】);
        if (StringUtils.isEmpty(【Lname】.getId())){
            return ResultVOUtil.error(4070,"修改操作失败 id不能为空！");
        }

        【Lname】.setUpdateId(param.getToken());
        【Lname】.setUpdateTime(new Date());

        Integer count = 【Lname】Mapper.upd【Uname】(【Lname】);
        logger.info("upd【Uname】 完成:{} {}", count, 【Lname】.getId());
        return ResultVOUtil.success(【Lname】);
    }

    @Override
    public ResultVO<Map<String, Object>> get【Uname】List(Map<String, Object> map) {
        List<【Uname】> list = 【Lname】Mapper.get【Uname】List(map);
        if (list != null && list.size() > 0) {
            //处理
        } else {
            list = new ArrayList<>();
        }

        Map<String, Object> returnMap = new HashMap<String, Object>();
        returnMap.put("resultList", list);
        returnMap.put("total", list.size());
        return ResultVOUtil.success(returnMap);
    }

    @Override
    public ResultVO<【Uname】> findById(String id) {
        【Uname】 【Lname】 = 【Lname】Mapper.findById(id);
        return ResultVOUtil.success(【Lname】);
    }

}
