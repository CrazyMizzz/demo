package com.example.demo.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
public class BaseDomain {

    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField(value = "create_date",fill = FieldFill.INSERT)
    private Date createDate;
    @TableField(value = "create_user",fill = FieldFill.INSERT)
    private String createUser;
    @TableField(value = "update_date",fill = FieldFill.INSERT_UPDATE)
    private Date updateDate;
    @TableField(value = "update_user",fill = FieldFill.INSERT_UPDATE)
    private String updateUser;
    @TableField(value = "comment")
    private String comment;

}
