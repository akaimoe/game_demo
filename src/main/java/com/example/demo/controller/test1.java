package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class test1 {
    @GetMapping("/hello")
    public String hello(){
        return "Ciallo~";
    }
}
