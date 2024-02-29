package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping
    public String add(@RequestBody User user){
        return userService.add(user);
    }
    @DeleteMapping
    public String delet(@RequestParam Integer id){
        return userService.delet(id);
    }
    @PutMapping
    public String update(@RequestBody User user){
        return userService.update(user);
    }
    @GetMapping
    public User get(@RequestParam Integer id){
        return userService.get(id);
    }
}
