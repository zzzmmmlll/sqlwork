package com.example.sqlwork;

import com.Data.IDnumber;
import com.mapper.IdnumberMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class SqlworkApplicationTests {

    @Autowired(required=false)
    private IdnumberMapper IdnumberMapper;
    @Test
    public void contextLoads() {
        List<IDnumber> list=IdnumberMapper.queryAll();
        System.out.println(list);
    }

}
