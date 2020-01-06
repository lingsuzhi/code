路径【D:\home\depot\depot-model\src\main\java\com\lsz\model\po】
package com.lsz.model.po【点包名】;

import lombok.Data;
import lombok.experimental.Accessors;
import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.util.Date;

/**
 * 【describe】 PO
 * @Author:  lingsuzhi
 * @Date:    【日期】
 * @Version: V1.0
 */
@Data
@Accessors(chain = true)
public class 【Uname】 implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id",type = IdType.INPUT)
    private String id;

【attribute空行NoId】

}
