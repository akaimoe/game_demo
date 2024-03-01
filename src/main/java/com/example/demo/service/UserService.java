package com.example.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {
    @Resource
    private UserMapper userMapper;
    public String add(User user){
        QueryWrapper<User> qw = new QueryWrapper();
        String username = user.getUsername();
        qw.eq("username", username);
        if(userMapper.selectList(qw).size() != 0){
            return "Username is already taken!";
        }
        int insert = userMapper.insert(user);
        return String.valueOf(insert);
    }
    public String delet(Integer id){
        int delete = userMapper.deleteById(id);
        return String.valueOf(delete);
    }
    public String update(User user){
        if (user.getId() == null){
            return "id is non!";
        }
        int update = userMapper.updateById(user);
        return String.valueOf(update);
    }
    public User get(Integer id){
        return userMapper.selectById(id);
    }

}

