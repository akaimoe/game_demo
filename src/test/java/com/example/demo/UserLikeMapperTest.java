package com.example.demo;

import com.example.demo.mapper.UserLikeMapper;
import com.example.demo.model.UserLike;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class UserLikeMapperTest {


    @Resource
    UserLikeMapper userLikeMapper;

    @Test
    public void test() {
        UserLike e = new UserLike();
        e.setUserId(1);
        e.setGameId(2);
        userLikeMapper.insert(e);
    }

}
