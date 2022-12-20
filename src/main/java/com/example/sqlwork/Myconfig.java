package com.example.sqlwork;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServlet;

@Configuration
public class Myconfig {
    @Bean
    public ServletRegistrationBean<HttpServlet> registrationBean(){
        ServletRegistrationBean bean = new ServletRegistrationBean<>(new BeginServlet());
        bean.setName("my");
        bean.setServlet(new BeginServlet());
        bean.addUrlMappings("/user");
        return bean;
    }
}
