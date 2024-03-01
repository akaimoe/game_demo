package com.example.demo.interceptor;

import com.example.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    @Resource
    private LoginService loginService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        String ip = request.getRemoteAddr();
//        HttpSession session = request.getSession();
//        Integer count = (Integer) session.getAttribute("count");
//        count = Objects.isNull(count)?1:++count;
//        System.out.println("ip:"+ip+" count:"+count);
//        session.setAttribute("count", count);
        String token = request.getHeader("token");
        System.out.println(token);
        System.out.println(" ");
        if(loginService.verify(token)!=0){
            return false;
        }
        return true;
    }
}
