package com.mapper;

import com.Data.customer;
import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Objects;

import java.util.List;

@Mapper
@Repository
public interface CustomerMapper {
    void add(customer x);
    customer queryCustomer1(String id,String password);
    customer queryCustomer2(String telephone,String password);
    customer queryCustomer(customer x);
    customer queryExist(customer x);
    List<customer> queryAll();
}
