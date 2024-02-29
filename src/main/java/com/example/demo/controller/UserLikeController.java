package com.example.demo.controller;

import com.example.demo.model.Game;
import com.example.demo.model.UserLike;
import com.example.demo.service.UserLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userlike")
public class UserLikeController {
    @Autowired
    private UserLikeService userLikeService;
    @PostMapping
    public String add(@RequestBody UserLike userLike){
        return userLikeService.add(userLike);
    }
    @DeleteMapping
    public String delet(@RequestBody UserLike userLike){
        return userLikeService.delet(userLike);
    }
    @GetMapping
    public List<Game> get(@RequestParam Integer userId){
        return userLikeService.get(userId);
    }
}
