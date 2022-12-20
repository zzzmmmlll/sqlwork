package com.Data;

import java.util.Objects;

public class Shoppingorderlog {
    private int shoppingorder_ID ;
    private int book_ID ;
    private int cost ;
    private int size ;

    public Shoppingorderlog(Shoppingcartlog x){
        this.book_ID = x.getBook_ID();
        this.size = x.getSize();
        this.cost = x.getCost();
    }

    @Override
    public String toString() {
        return "Shoppingorderlog{" +
                "shoppingorder_ID=" + shoppingorder_ID +
                ", book_ID=" + book_ID +
                ", cost=" + cost +
                ", size=" + size +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shoppingorderlog that = (Shoppingorderlog) o;
        return shoppingorder_ID == that.shoppingorder_ID && book_ID == that.book_ID && cost == that.cost && size == that.size;
    }

    @Override
    public int hashCode() {
        return Objects.hash(shoppingorder_ID, book_ID, cost, size);
    }

    public int getShoppingorder_ID() {
        return shoppingorder_ID;
    }

    public void setShoppingorder_ID(int shoppingorder_ID) {
        this.shoppingorder_ID = shoppingorder_ID;
    }

    public int getBook_ID() {
        return book_ID;
    }

    public void setBook_ID(int book_ID) {
        this.book_ID = book_ID;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Shoppingorderlog(int shoppingorder_ID, int book_ID, int cost, int size) {
        this.shoppingorder_ID = shoppingorder_ID;
        this.book_ID = book_ID;
        this.cost = cost;
        this.size = size;
    }
}
