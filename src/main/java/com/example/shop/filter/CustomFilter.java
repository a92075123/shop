package com.example.shop.filter;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Slf4j
@Component
public class CustomFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession();
        String loginStatus = (String) session.getAttribute("loginStatus");
        if (loginStatus != null && !"".equals(loginStatus)) {
            log.info("有Session");
            filterChain.doFilter(request, servletResponse);
        }else{
            log.info("無Session");
            filterChain.doFilter(request, servletResponse);
        }
    }
}
