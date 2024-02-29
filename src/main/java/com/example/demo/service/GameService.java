package com.example.demo.service;

import com.example.demo.mapper.GameMapper;
import com.example.demo.model.Game;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class GameService {
    @Resource
    private GameMapper gameMapper;

    public String add(Game game){
        int insert = gameMapper.insert(game);
        return String.valueOf(insert);
    }
    public String delet(Integer id){
        int delete = gameMapper.deleteById(id);
        return String.valueOf(delete);
    }
    public String update(Game game){
        System.out.println("test2");
        if (game.getId() == null){
            return "id is no found!";
        }
        int update = gameMapper.updateById(game);
        return String.valueOf(update);
    }
    public Game get(Integer id){

        return gameMapper.selectById(id);
    }
}
