package com.mapper;

import com.Data.Book;
import com.Data.customer;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Objects;
import java.util.List;

@Mapper
@Repository
public interface BookMapper {
    void addbook(Book x);
    List<Book> queryAll();
    Book query(int x);
}
