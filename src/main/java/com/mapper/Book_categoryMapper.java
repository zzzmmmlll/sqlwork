package com.mapper;

import com.Data.Book_category;
import com.Data.IDnumber;

import java.util.List;
import java.util.Objects;

public interface Book_categoryMapper {
    List<Book_category> queryAll();
    void add(Book_category x);

}
