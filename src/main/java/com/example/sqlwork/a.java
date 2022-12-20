package com.example.sqlwork;

import com.Data.IDnumber;
import com.mapper.IdnumberMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
@WebServlet("/HH")
public class a extends HttpServlet {
    private String resource = "mybatis-config.xml";
    private InputStream inputStream ;
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    @Autowired(required=false)
    private IdnumberMapper IdnumberMapper;

    @Override
    public void init() throws ServletException {
        super.init();
    }


    @RequestMapping("/haha")
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        resource = "mybatis-config.xml";
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession= sqlSessionFactory.openSession();
        IdnumberMapper=sqlSession.getMapper(com.mapper.IdnumberMapper.class);
        IDnumber x=IdnumberMapper.queryAll().get(0);
        System.out.println(x);
        int y=IdnumberMapper.queryone("customer_ID");
        System.out.println(y);
    }

}
