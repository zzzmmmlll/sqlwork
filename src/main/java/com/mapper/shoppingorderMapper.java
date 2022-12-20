package com.mapper;

import com.Data.Shoppingcart;
import com.Data.Shoppingorder;

import java.util.List;
import java.util.Objects;

public interface shoppingorderMapper {
    void add(Shoppingorder x);
    List<Integer> queryID(int x);
    void delete(Shoppingorder x);
}