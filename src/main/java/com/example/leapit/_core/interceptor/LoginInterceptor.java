package com.example.leapit._core.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;
import com.example.leapit._core.error.ex.ExceptionApi401;
import com.example.leapit.user.User;

@Deprecated
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        // localhost:8080/s/api/board
        System.out.println("uri: " + uri); // /s/api/board

        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("sessionUser");

        if (uri.startsWith("/s")) {
            if (sessionUser == null) throw new ExceptionApi401("인증이 필요합니다");
        }

        return true;
    }
}