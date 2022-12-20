package com.example.sqlwork;

import com.Data.Book;
import com.Data.Shoppingcartlog;
import com.Data.customer;
import com.alibaba.fastjson.JSON;
import com.mapper.CustomerMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
@EnableSwagger2
public class CustomerMethod {
    @Autowired(required=false)
    private CustomerMapper customerMapper;
    @RequestMapping("/manager/queryAllcustomer")
    public void queryAllcustomer(HttpServletResponse resp) throws IOException {
        resp.addHeader(  "Access-Control-Allow-Origin","*");//允许所有来源访同
        resp.addHeader(  "Access-Control-Allow-Method","POST,GET");//允许访问的方式
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession= sqlSessionFactory.openSession();
        customerMapper=sqlSession.getMapper(com.mapper.CustomerMapper.class);

        List<customer> dat = customerMapper.queryAll();
        String jsonString = JSON.toJSONString(dat);
        resp.getOutputStream().println(jsonString);
        resp.getOutputStream().flush();
        resp.getOutputStream().close();
//        byte[] ans = com.alibaba.fastjson.JSONArray.parseObject(jsonString,byte[].class);
//        System.out.println(ans);
//        OutputStream out = resp.getOutputStream();
//        out.write(ans);
//        out.flush();
//        out.close();
    }

}
