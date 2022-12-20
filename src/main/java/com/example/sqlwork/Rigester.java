package com.example.sqlwork;

import com.Data.Shoppingcart;
import com.Data.customer;
import com.Data.IDnumber;
import com.alibaba.fastjson.JSONObject;
import static com.test.HttpGetJson.getJson;

import com.mapper.BookMapper;
import com.mapper.CustomerMapper;
import com.mapper.shoppingcartMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;


import com.mapper.IdnumberMapper;

@RestController
@EnableSwagger2
@Mapper
public class Rigester {

    @Autowired(required=false)
    private CustomerMapper customerMapper;
    @Autowired(required=false)
    private IdnumberMapper IdnumberMapper;
    @Autowired(required=false)
    private com.mapper.shoppingcartMapper shoppingcartMapper;
    @RequestMapping("/user/Rigester")
    public int Rigester(HttpServletRequest req, HttpServletResponse resp) throws  IOException {

        resp.addHeader(  "Access-Control-Allow-Origin","*");//允许所有来源访同
        resp.addHeader(  "Access-Control-Allow-Method","POST,GET");//允许访问的方式
        JSONObject jsonObject= getJson(req);
        customer Customer =new customer(jsonObject,1);
        String resource = "mybatis-config.xml";

        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession= sqlSessionFactory.openSession();
        customerMapper=sqlSession.getMapper(com.mapper.CustomerMapper.class);
        IdnumberMapper=sqlSession.getMapper(com.mapper.IdnumberMapper.class);
        shoppingcartMapper=sqlSession.getMapper(com.mapper.shoppingcartMapper.class);
        customer em=customerMapper.queryCustomer2(Customer.getTelephone(),Customer.getPasswordtext());
        if(em!=null){
            return -1;
        }
        int y=IdnumberMapper.queryone("customer_ID");
        System.out.println(y);
        Customer.setId(y);

        y++;
        IdnumberMapper.update("customer_ID",y);
        //System.out.println(y);
        y=IdnumberMapper.queryone("customer_ID");
        //System.out.println(y);
        customerMapper.add(Customer);

        y=IdnumberMapper.queryone("shoppingcart_ID");
        Shoppingcart dat = new Shoppingcart(y,Customer.getId(),0);
        y++;
        IdnumberMapper.update("shoppingcart_ID",y);
        shoppingcartMapper.add(dat);
        sqlSession.commit();
        return Customer.getId();
    }
}