package com.vuelearn.pro.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Gronbu1
 * @since 2019-05-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("vlearnprod")
public class Vlearnprod implements Serializable {

private static final long serialVersionUID=1L;
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private String name;

    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date date;

    private Date birthday;

}
