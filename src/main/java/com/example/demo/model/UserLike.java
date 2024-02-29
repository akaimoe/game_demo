package com.example.demo.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Getter;

@TableName("user_like")
@Data
@Getter
public class UserLike {

    @TableId(type = IdType.AUTO)
    private Integer id;
    
    private Integer userId;

    private Integer gameId;

}
