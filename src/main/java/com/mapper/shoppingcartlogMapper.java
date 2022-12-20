package com.mapper;

import com.Data.Shoppingcartlog;

import java.util.List;
import java.util.Objects;

public interface shoppingcartlogMapper {
    Shoppingcartlog getsize(int x, int y);
    void add(Shoppingcartlog x);
    void update(Shoppingcartlog x);
    void delete(Shoppingcartlog x);
    List<Shoppingcartlog>query(int x);
    void clear(int x);
}
