package com.example.demo.controller;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserMapper userMapper;
    @PostMapping
    public String addUser(@RequestBody User user){
        int insert = userMapper.insert(user);
        return String.valueOf(insert);
    }
    @DeleteMapping
    public String deletUser(@RequestBody Integer id){
        int delete = userMapper.deleteById(id);
        return String.valueOf(delete);
    }
    @PutMapping
    public String updateUser(@RequestBody User user){
        System.out.println("test2");
        if (user.getId() == null){
            return "id is no found!";
        }
        int update = userMapper.updateById(user);
        return String.valueOf(update);
    }
    @GetMapping
    public User getUser(@RequestBody Integer id){
        System.out.println(" ");
        System.out.println("数据已收到，为："+id);
        System.out.println(" ");
        return userMapper.selectById(id);
    }
}
