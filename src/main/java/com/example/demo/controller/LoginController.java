package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.LoginService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Resource
    private LoginService loginService;
    @PostMapping
    public Integer login(@RequestBody User user){
        return loginService.login(user);
    }

}
