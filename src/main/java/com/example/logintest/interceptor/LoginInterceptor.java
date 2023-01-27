package com.example.logintest.interceptor;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception arg3) {
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView arg3) {
        // TODO Auto-generated method stub
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws ServletException, IOException {
        // TODO Auto-generated method stub
        HttpSession session = request.getSession();
        Object obj = session.getAttribute("id");
        if(obj == null){
            request.getRequestDispatcher("/boards/index.do").forward(request, response);
            return false;
        }else{
            return true;
        }

    }

}
