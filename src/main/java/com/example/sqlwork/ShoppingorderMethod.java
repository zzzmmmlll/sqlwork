package com.example.sqlwork;

import com.Data.Shoppingcartlog;
import com.Data.Shoppingorder;
import com.Data.Shoppingorderlog;
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
import java.util.ArrayList;
import java.util.List;

import static com.test.HttpGetJson.getJson;


@RestController
@EnableSwagger2
public class ShoppingorderMethod {
    @Autowired(required=false)
    private com.mapper.BookMapper bookMapper;
    @Autowired(required=false)
    private com.mapper.shoppingcartMapper shoppingcartMapper;
    @Autowired(required=false)
    private com.mapper.shoppingcartlogMapper shoppingcartlogMapper;
    @Autowired(required=false)
    private com.mapper.shoppingorderMapper shoppingorderMapper;
    @Autowired(required=false)
    private com.mapper.shoppingorderlogMappper shoppingorderlogMappper;
    @Autowired(required=false)
    private com.mapper.IdnumberMapper IdnumberMapper;
    @RequestMapping("/user/queryAllshoppingorder")
    public void queryAllshoppingorder(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.addHeader(  "Access-Control-Allow-Origin","*");//允许所有来源访同
        resp.addHeader(  "Access-Control-Allow-Method","POST,GET");//允许访问的方式
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession= sqlSessionFactory.openSession();
        shoppingorderMapper=sqlSession.getMapper(com.mapper.shoppingorderMapper.class);

        int costumerID=(Integer)req.getSession().getAttribute("Customer");
        List<Integer> shoppingorderID=shoppingorderMapper.queryID(costumerID);
        String jsonString = JSON.toJSONString(shoppingorderID);
        resp.getOutputStream().println(jsonString);
    }
    @RequestMapping("/user/queryOneshoppingorder")
    public void queryOneshoppingorder(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.addHeader(  "Access-Control-Allow-Origin","*");//允许所有来源访同
        resp.addHeader(  "Access-Control-Allow-Method","POST,GET");//允许访问的方式
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession= sqlSessionFactory.openSession();
        shoppingorderlogMappper=sqlSession.getMapper(com.mapper.shoppingorderlogMappper.class);

        JSONObject jsonObject= getJson(req);
        int shoppingorderID= jsonObject.getInteger("id");

        List<com.Data.Shoppingorderlog> dat = shoppingorderlogMappper.query(shoppingorderID);
        System.out.println(dat);
        String jsonString = JSON.toJSONString(dat);
        resp.getOutputStream().println(jsonString);
    }

    @RequestMapping("/user/addshoppingorder")
    public void addshoppingcart(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.addHeader(  "Access-Control-Allow-Origin","*");//允许所有来源访同
        resp.addHeader(  "Access-Control-Allow-Method","POST,GET");//允许访问的方式
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession= sqlSessionFactory.openSession();
        shoppingorderMapper=sqlSession.getMapper(com.mapper.shoppingorderMapper.class);
        shoppingorderlogMappper=sqlSession.getMapper(com.mapper.shoppingorderlogMappper.class);
        IdnumberMapper=sqlSession.getMapper(com.mapper.IdnumberMapper.class);
        shoppingcartMapper=sqlSession.getMapper(com.mapper.shoppingcartMapper.class);
        shoppingcartlogMapper =sqlSession.getMapper(com.mapper.shoppingcartlogMapper.class);

        int costumerID=(Integer)req.getSession().getAttribute("Customer");
        int shoppingcartID=shoppingcartMapper.queryID(costumerID);
        List<Shoppingcartlog> em = shoppingcartlogMapper.query(shoppingcartID);
        if(em.isEmpty()){
            resp.getOutputStream().println(-1);
            resp.getOutputStream().flush();
            resp.getOutputStream().close();
            return;
        }

        int y=IdnumberMapper.queryone("shoppingorder_ID");
        System.out.println(y);

        Shoppingorder dat=new Shoppingorder(y,costumerID,0,"等待管理员审批");
        List<Shoppingorderlog> dats = new ArrayList<Shoppingorderlog>();
        for(Shoppingcartlog x:em){
            Shoppingorderlog z = new Shoppingorderlog(x);
            z.setShoppingorder_ID(dat.getShoppingorder_ID());
            dats.add(z);
            dat.setCost_tot(dat.getCost_tot()+z.getCost());
        }

        shoppingcartlogMapper.clear(shoppingcartID);
        for (Shoppingorderlog x:dats){
            shoppingorderlogMappper.add(x);
        }
        shoppingorderMapper.add(dat);
        resp.getOutputStream().println(0);
        resp.getOutputStream().flush();
        resp.getOutputStream().close();

    }

}
