package com.example.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LoginService {
    @Resource
    private UserMapper userMapper;
    private static final long EXPIRE_TIME=180*24*60*60*1000; // 过期时间
    private static final String KEY = "Akaimoe";     // 密钥
    public Integer login(User user){
        LambdaQueryWrapper<User> qw = new LambdaQueryWrapper<>();

        qw.eq(User::getUsername, user.getUsername())
                .eq(User::getPassword, user.getPassword());
        List<User> user_list = userMapper.selectList(qw);
        if(user_list.isEmpty())
            return 0;
        String token = createToken(user_list.get(0).getId().toString(), user_list.get(0).getUsername());
        user_list.get(0).setToken(token);
        userMapper.updateById(user_list.get(0));
        return 1;
    }

    public String createToken(String id, String username){
        Map<String,Object> header = new HashMap();
        header.put("typ", "JWT");
        header.put("alg", "HS256");
        JwtBuilder builder = Jwts.builder().setHeader(header)
                .setId(id)
                .setExpiration(new Date(System.currentTimeMillis()+EXPIRE_TIME))
                .setSubject(username)
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, KEY);
        return builder.compact();
    }

    public int verify(String token){
        if(token == null){
            System.out.println("token is null");
            return 3;
        }
        Claims claims = null;
        try {
            claims = Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody();
        }catch (ExpiredJwtException e){
            System.out.println("token has expired");
            return 2;   // token过期
        }
        String id = claims.getId();
        User user = userMapper.selectById(id);
        if(user == null){
            System.out.println("User not found");
            return 1;   // 用户不存在
        }
        return 0;
    }
}
