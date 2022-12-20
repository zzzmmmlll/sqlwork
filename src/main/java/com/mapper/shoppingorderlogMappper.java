package com.mapper;

import com.Data.Shoppingcartlog;
import com.Data.Shoppingorderlog;

import java.util.List;
import java.util.Objects;

public interface shoppingorderlogMappper {
    void add(Shoppingorderlog x);
    void update(Shoppingorderlog x);
    void delete(Shoppingorderlog x);
    List<Shoppingorderlog> query(int x);
}