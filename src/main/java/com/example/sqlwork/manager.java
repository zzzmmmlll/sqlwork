package com.example.sqlwork;

import com.alibaba.fastjson.JSONObject;
import com.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.test.HttpGetJson.getJson;

@RestController
public class manager {
    @Autowired(required=false)
    private CustomerMapper customerMapper;
    @RequestMapping(value = "/manager/toLogin")
    public void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.addHeader(  "Access-Control-Allow-Origin","*");//允许所有来源访同
        resp.addHeader(  "Access-Control-Allow-Method","POST,GET");//允许访问的方式
        JSONObject jsonObject= getJson(req);
        String password = jsonObject.getString("password");
        System.out.println(password);
        int op;
        if("123456".equals(password)){
            op=0;
            req.getSession().setAttribute("Manager",0);
        }else {
            op=-1;
        }
        resp.getOutputStream().println(op);
        resp.getOutputStream().flush();
        resp.getOutputStream().close();
    }
    @RequestMapping("/manager/toLogout")
    public String logout(HttpServletRequest req){
        req.getSession().removeAttribute("Manager");
        //return R.success("退出成功");
        return "退出成功";
    }
}
