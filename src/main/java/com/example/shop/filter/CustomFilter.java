package com.example.shop.filter;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Slf4j
@Component
public class CustomFilter implements Filter {

    public static String targetPage = "";
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession();
        String loginStatus = (String) session.getAttribute("loginStatus");
        String contextPath = httpRequest.getContextPath();
        String uri = httpRequest.getRequestURI();

        if (uri.contains("/js/") || uri.contains("/css/") || uri.contains("/img/") || uri.contains("/static/")) {
            filterChain.doFilter(request, response);
            return;
        }

        if ("true".equals(loginStatus)) {
            // 已登入，放行
            filterChain.doFilter(request, response);
        } else if (uri.contains("login") || uri.contains("isCheckUser")||uri.contains("logout")) {
            // 是登入頁或登入驗證，放行
            filterChain.doFilter(request, response);
        } else {
//            targetPage = uri.substring(uri.lastIndexOf("/", uri.length()));
//            if(!uri.contains("index")) {
//               httpResponse.sendRedirect(contextPath + "/shop/login");
//            }
            filterChain.doFilter(request, response);
        }
    }
}
