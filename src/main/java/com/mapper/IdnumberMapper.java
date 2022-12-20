package com.mapper;

import com.Data.IDnumber;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface IdnumberMapper {

    public List<IDnumber> queryAll();
    public int queryone(String typeid);
    public void update(String id,int x);
}
