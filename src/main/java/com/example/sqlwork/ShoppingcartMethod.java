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
public class ShoppingcartMethod {
    @Autowired(required=false)
    private com.mapper.BookMapper bookMapper;
    @Autowired(required=false)
    private com.mapper.shoppingcartMapper shoppingcartMapper;
    @Autowired(required=false)
    private com.mapper.shoppingcartlogMapper shoppingcartlogMapper;
    @RequestMapping(name = "BeginServlet",value ="/user/queryshoppingcart")
    public void queryshoppingcart(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.addHeader(  "Access-Control-Allow-Origin","*");//允许所有来源访同
        resp.addHeader(  "Access-Control-Allow-Method","POST,GET");//允许访问的方式
        System.out.println(req.getSession());
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession= sqlSessionFactory.openSession();
        shoppingcartMapper=sqlSession.getMapper(com.mapper.shoppingcartMapper.class);
        shoppingcartlogMapper=sqlSession.getMapper(com.mapper.shoppingcartlogMapper.class);

        int costumerID=(Integer)req.getSession().getAttribute("Customer");
        int shoppingcartID=shoppingcartMapper.queryID(costumerID);

        List<Shoppingcartlog> dat = shoppingcartlogMapper.query(shoppingcartID);
        System.out.println(dat);
        String jsonString = JSON.toJSONString(dat);
        System.out.println(jsonString);
        resp.getOutputStream().println(jsonString);
        resp.getOutputStream().flush();
        resp.getOutputStream().close();
    }
    @RequestMapping(name = "BeginServlet",value ="/user/addshoppingcart")
    public void addshoppingcart(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.addHeader(  "Access-Control-Allow-Origin","*");//允许所有来源访同
        resp.addHeader(  "Access-Control-Allow-Method","POST,GET");//允许访问的方式
        JSONObject jsonObject= getJson(req);
        int bookID=jsonObject.getInteger("id");
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession= sqlSessionFactory.openSession();
        shoppingcartMapper=sqlSession.getMapper(com.mapper.shoppingcartMapper.class);
        shoppingcartlogMapper=sqlSession.getMapper(com.mapper.shoppingcartlogMapper.class);
        bookMapper=sqlSession.getMapper(com.mapper.BookMapper.class);

        int costumerID=(Integer)req.getSession().getAttribute("Customer");
        int shoppingcartID=shoppingcartMapper.queryID(costumerID);
        int cost=bookMapper.query(bookID).getCost();
        Shoppingcartlog dat= shoppingcartlogMapper.getsize(shoppingcartID,bookID) ;
        if(dat==null){
            dat=new Shoppingcartlog(shoppingcartID,bookID,1,cost);
            shoppingcartlogMapper.add(dat);
            sqlSession.commit();
        }else{
            dat.setSize(dat.getSize()+1);
            dat.setCost(dat.getCost()+cost);
            shoppingcartlogMapper.update(dat);
            sqlSession.commit();
        }
    }
    @RequestMapping(name = "BeginServlet",value ="/user/subtractshoppingcart")
    public String subtractshoppingcart(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.addHeader(  "Access-Control-Allow-Origin","*");//允许所有来源访同
        resp.addHeader(  "Access-Control-Allow-Method","POST,GET");//允许访问的方式
        JSONObject jsonObject= getJson(req);
        int bookID=jsonObject.getInteger("ID");
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession= sqlSessionFactory.openSession();
        shoppingcartMapper=sqlSession.getMapper(com.mapper.shoppingcartMapper.class);
        shoppingcartlogMapper=sqlSession.getMapper(com.mapper.shoppingcartlogMapper.class);
        bookMapper=sqlSession.getMapper(com.mapper.BookMapper.class);

        int costumerID=(Integer)req.getSession().getAttribute("Customer");
        int shoppingcartID=shoppingcartMapper.queryID(costumerID);
        int cost=bookMapper.query(bookID).getCost();
        Shoppingcartlog dat= shoppingcartlogMapper.getsize(shoppingcartID,bookID) ;
        if(dat==null){
            return "error";
        }else{
            dat.setSize(dat.getSize()-1);
            dat.setCost(dat.getCost()-cost);
            if(dat.getSize()==0){
                shoppingcartlogMapper.delete(dat);
            }else{
                shoppingcartlogMapper.update(dat);
            }
            sqlSession.commit();
            return "sucess";
        }
    }
}
