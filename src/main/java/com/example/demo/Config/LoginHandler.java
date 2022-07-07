package com.example.demo.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
public class LoginHandler implements HandlerInterceptor {



    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object loginUser=request.getSession().getAttribute("userName");
        System.out.println("user"+loginUser);
        Object loginMember=request.getSession().getAttribute("memberName");
        System.out.println("member"+loginMember);
        String way = request.getServletPath().replace(".html","");

        if (loginUser == null && loginMember == null ) {
            response.sendRedirect("/mgsc/log.html");
            return false;
        } else{
            if("/userspace".equals(way) && loginUser ==null){
                response.sendRedirect("/mgsc/memberspace.html");
                return false;
            }
            if("/memberspace".equals(way) && loginMember == null){
                response.sendRedirect("/mgsc/userspace.html");
                return false;
            }
            if("/log".equals(way)){
                if(loginUser!=null){
                    response.sendRedirect("/mgsc/userspace.html");
                    return false;
                }
                else{
                    response.sendRedirect("/mgsc/memberspace.html");
                    return false;
                }
            }
        }
        return true;

    }
}
