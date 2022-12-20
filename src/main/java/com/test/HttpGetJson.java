package com.test;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Stack;

@EnableSwagger2
@WebServlet(urlPatterns = "/myServlet")
public class HttpGetJson {
    @RequestMapping("/hello")
    public static JSONObject getJson(HttpServletRequest request){
        System.out.println("hello world");
        StringBuilder result = new StringBuilder();
        BufferedReader in = null;
        try{
            in = new BufferedReader(new InputStreamReader(request.getInputStream(),StandardCharsets.UTF_8));
            String line;
            while((line = in.readLine()) != null){
                System.out.println(line);
                result.append(line);
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                if(in != null){
                    in.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        String ans=formatJson(result.toString());
        System.out.println(ans);
        return (JSONObject) JSONObject.parse(ans);
    }
    /**
     * 格式化JSON字符串
     */
    public static String formatJson(String originStr) {
        if (originStr == null) {
            return null;
        }
        char[] charArray = originStr.toCharArray();
        StringBuilder sb = new StringBuilder();

        sb.append("{\"");
        for(char x:charArray){
            if(x=='='){
                sb.append("\":\"");
            }else if(x=='&'){
                sb.append("\",\"");
            }else{
                sb.append(x);
            }
        }
        sb.append("\"}");
        return sb.toString();
    }

    /**
     * 回车与制表符
     *
     * @param sb StringBuilder
     * @param tabCount 多少个制表符
     */
    private static void enterAndTabs(StringBuilder sb, int tabCount) {
        sb.append("\n");
        while (tabCount-- > 0) {
            sb.append("    ");
        }
    }
}

