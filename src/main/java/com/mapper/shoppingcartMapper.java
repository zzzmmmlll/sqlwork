package com.mapper;

import com.Data.Shoppingcart;

import java.util.Objects;

public interface shoppingcartMapper {
    void add(Shoppingcart x);
    int queryID(int x);
}
