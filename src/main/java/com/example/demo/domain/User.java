package com.example.demo.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@TableName(value = "USER")
public class User extends BaseDomain {

    @TableField(value = "user_name")
    private String userName;
    @TableField(value = "pass_word")
    private String passWord;
}
