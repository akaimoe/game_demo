package com.example.demo.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Getter;

import java.lang.reflect.Type;

@TableName("game")
@Data
@Getter
public class Game {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String name;

    private String company;

}
