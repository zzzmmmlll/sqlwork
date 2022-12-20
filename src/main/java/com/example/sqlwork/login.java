package com.example.sqlwork;

import com.Data.customer;
import com.Data.IDnumber;
import com.alibaba.fastjson.JSONObject;
import com.mapper.CustomerMapper;
import com.mapper.IdnumberMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

import static com.test.HttpGetJson.getJson;

@RestController
@EnableSwagger2
@Mapper
public class login {
    @Autowired(required=false)
    private CustomerMapper customerMapper;
    @RequestMapping(value = "/user/toLogin")
    public void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.addHeader(  "Access-Control-Allow-Origin","*");//允许所有来源访同
        resp.addHeader(  "Access-Control-Allow-Method","POST,GET");//允许访问的方式
        //①. 将页面提交的密码password进行md5加密处理, 得到加密后的字符串
        JSONObject jsonObject= getJson(req);
        customer Customer =new customer(jsonObject,0);
        String password =Customer.getPasswordtext();
        //②. 根据页面提交的用户名username查询数据库中员工数据信息
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession= sqlSessionFactory.openSession();
        customerMapper=sqlSession.getMapper(com.mapper.CustomerMapper.class);

        customer em=customerMapper.queryCustomer(Customer);
        //③. 如果没有查询到, 则返回登录失败结果
        if(em == null){
            System.out.println("default");
            resp.getOutputStream().println(-1);
            resp.getOutputStream().flush();
            resp.getOutputStream().close();
            return;
        }
        //④. 密码比对，如果不一致, 则返回登录失败结果
        if(!password.equals(em.getPasswordtext())){
            System.out.println("default");
            resp.getOutputStream().println(-1);
            resp.getOutputStream().flush();
            resp.getOutputStream().close();
            return ;
        }
        //⑥. 登录成功，将员工id存入Session, 并返回登录成功结果
        req.getSession().setAttribute("Customer",em.getId());
        System.out.println(req.getSession().getAttribute("Customer"));
        System.out.println(Customer);
        resp.getOutputStream().println(0);
        resp.getOutputStream().flush();
        resp.getOutputStream().close();
    }


    /**
     * @ClassName CustomerController
     * @Description :退出登录
     * @Return : com.itheima.reggie.common.R<java.lang.String>
     * @Author : xmc
     * @Date : 2022/5/21 14:09
     */
    @RequestMapping("/user/tologout")
    public String logout(HttpServletRequest req, HttpServletResponse resp){
        resp.addHeader(  "Access-Control-Allow-Origin","*");//允许所有来源访同
        resp.addHeader(  "Access-Control-Allow-Method","POST,GET");//允许访问的方式
        req.getSession().removeAttribute("Customer");
        //return R.success("退出成功");
        return "success";
    }
}
