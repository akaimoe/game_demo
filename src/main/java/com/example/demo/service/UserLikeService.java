package com.example.demo.service;

import com.alibaba.druid.support.ibatis.SqlMapClientImplWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.mapper.GameMapper;
import com.example.demo.mapper.UserLikeMapper;
import com.example.demo.model.Game;
import com.example.demo.model.UserLike;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserLikeService {
    @Resource
    private UserLikeMapper userLikeMapper;
    @Resource
    private GameMapper gameMapper;

    public String add(UserLike userLike){
        int insert = userLikeMapper.insert(userLike);
        return String.valueOf(insert);
    }
    public String delet(UserLike userLike){
        QueryWrapper<UserLike> qw = new QueryWrapper();
        qw.eq("user_id", userLike.getUserId());
        qw.eq("game_id", userLike.getGameId());
        int delete = userLikeMapper.delete(qw);
        return String.valueOf(delete);
    }
    public List<Game> get(Integer userId){
        QueryWrapper<UserLike> qw = new QueryWrapper();
        qw.eq("user_id", userId);
        List<Game> list_game = new ArrayList<Game>();
        List<UserLike> list_userLike = userLikeMapper.selectList(qw);
        for (UserLike ul : list_userLike){
            list_game.add(gameMapper.selectById(ul.getGameId()));
        }
        return list_game;
    }

}
