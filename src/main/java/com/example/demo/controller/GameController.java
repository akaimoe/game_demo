package com.example.demo.controller;

import com.example.demo.model.Game;
import com.example.demo.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/game")
public class GameController {
    @Autowired
    private GameService gameService;
    @PostMapping
    public String add(@RequestBody Game game){
        return gameService.add(game);
    }
    @DeleteMapping
    public String delet(@RequestParam Integer id){
        return gameService.delet(id);
    }
    @PutMapping
    public String update(@RequestBody Game game){
        return gameService.update(game);
    }
    @GetMapping
    public Game get(@RequestParam Integer id){
        return gameService.get(id);
    }
}
