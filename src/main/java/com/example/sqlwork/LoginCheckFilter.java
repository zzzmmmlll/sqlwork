package com.example.sqlwork;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "loginCheckFilter", urlPatterns = "/*")
@Slf4j
public class LoginCheckFilter implements Filter {

    public static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {


        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //获取本次请求地址
        String requestURI = request.getRequestURI();
        System.out.println(requestURI);
        log.info("拦截到路径{}", request);
        //配置不需要拦截的地址
        String[] url = new String[]{
                "/user/toLogin",
                "/user/Rigester",
                "/user/tologout",
                "/queryAllBook",
                "/backend/**",
                "/front/**",
                "/swagger-ui/**",
                "/swagger-resources/**",
                "/v2/api-docs",
                "/webjars/**",
                "/swagger-ui.html/**",
        };
        //比较
        boolean check = this.check(url, requestURI);
        if (check) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        if (request.getSession().getAttribute("customer") != null) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        response.getWriter().write(JSON.toJSONString("NOTLOGIN"));
        return;
    }

    public boolean check(String[] urls, String requestURI) {
        for (String url : urls) {
            if (PATH_MATCHER.match(url, requestURI)) {
                return true;
            }
        }
        return false;
    }
}