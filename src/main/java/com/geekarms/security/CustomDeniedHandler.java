package com.geekarms.security;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by kaywer on 2016/12/29.
 */
@Service("customDeniedHandler")
public class CustomDeniedHandler implements AccessDeniedHandler {
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        httpServletResponse.setCharacterEncoding("UTF-8");
        try(PrintWriter writer = httpServletResponse.getWriter()){
            if (wantJson(httpServletRequest)){
                httpServletResponse.setContentType("application/json");
                writer.write("{\"msg\":\"你没有权限访问该接口\"}");
            }else {
                httpServletRequest.setAttribute("msg", "你没有权限访问该接口");
                httpServletRequest.getRequestDispatcher("/error").forward(httpServletRequest, httpServletResponse);
            }
        }
    }

    private boolean wantJson(HttpServletRequest request){
        String accept = request.getHeader("accept");
        return accept.contains("application/json");
    }
}
