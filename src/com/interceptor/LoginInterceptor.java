package com.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception {
        if (request.getSession().getAttribute("student")!=null||request.getSession().getAttribute("student")!=null)
            return true;
        else
            response.sendRedirect("/");
        return true;
    }

}
