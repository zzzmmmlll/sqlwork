package com.example.sqlwork;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@SpringBootApplication
@ServletComponentScan
@EnableSwagger2
public class SqlworkApplication {
    public static void main(String[] args) throws IOException {

        SpringApplication.run(SqlworkApplication.class, args);

    }
}
