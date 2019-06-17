package com.yl.lmdm.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.time.LocalDateTime;

/**
 * 【describe】
 * @author lingsuzhi
 * @since 【日期】
 */
@Data
@Accessors(chain = true)
public class 【Uname】  implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

【attribute空行NoId】


}
