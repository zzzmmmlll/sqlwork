package com.example.sqlwork;

import com.Data.Book;
import com.Data.Shoppingcartlog;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mapper.IdnumberMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static com.test.HttpGetJson.getJson;

@RestController
@EnableSwagger2
public class books {
    @Autowired(required=false)
    private com.mapper.BookMapper bookMapper;
    @Autowired(required=false)
    private com.mapper.shoppingcartMapper shoppingcartMapper;
    @Autowired(required=false)
    private com.mapper.shoppingcartlogMapper shoppingcartlogMapper;
    @Autowired(required=false)
    private IdnumberMapper IdnumberMapper;
    @RequestMapping("/queryAllBook")
    public void queryAllBook(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        resp.addHeader(  "Access-Control-Allow-Origin","*");//允许所有来源访同
        resp.addHeader(  "Access-Control-Allow-Method","POST,GET");//允许访问的方式
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession= sqlSessionFactory.openSession();
        bookMapper=sqlSession.getMapper(com.mapper.BookMapper.class);
        List<Book> dat = bookMapper.queryAll();
        System.out.println(dat);
        String jsonString = JSON.toJSONString(dat);
        resp.getOutputStream().println(jsonString);
        resp.getOutputStream().flush();
        resp.getOutputStream().close();
    }

    @RequestMapping("/manager/addbook")
    public void addBook(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        resp.addHeader(  "Access-Control-Allow-Origin","*");//允许所有来源访同
        resp.addHeader(  "Access-Control-Allow-Method","POST,GET");//允许访问的方式
        JSONObject jsonObject= getJson(req);
        Book x=new Book(jsonObject);
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession= sqlSessionFactory.openSession();
        IdnumberMapper=sqlSession.getMapper(com.mapper.IdnumberMapper.class);
        bookMapper=sqlSession.getMapper(com.mapper.BookMapper.class);

        int y=IdnumberMapper.queryone("book_ID");
        System.out.println("book_ID :"+y);
        x.setBook_ID(y);
        y++;
        bookMapper.addbook(x);
        sqlSession.commit();
    }
    @RequestMapping("/manager/updatebook")
    public String updatebook(Book x) throws IOException {
        return "success";
    }
    @RequestMapping("/manager/subtratebook")
    public String subtratebook(Book x) throws IOException {
        return "success";
    }
    @RequestMapping("/queryOneBook")
    public String queryOneBook(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        resp.addHeader(  "Access-Control-Allow-Origin","*");//允许所有来源访同
        resp.addHeader(  "Access-Control-Allow-Method","POST,GET");//允许访问的方式
        JSONObject jsonObject= getJson(req);
        Book x=new Book(jsonObject);
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession= sqlSessionFactory.openSession();
        bookMapper=sqlSession.getMapper(com.mapper.BookMapper.class);
        Book dat = bookMapper.query(x.getBook_ID());
        System.out.println(dat);
        String jsonString = JSON.toJSONString(dat);
        //out=resp.getOutputStream();
        resp.getOutputStream().println(jsonString);
        return "seccess";
    }
}
