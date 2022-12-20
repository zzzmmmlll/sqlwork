package com.Data;

import java.util.Objects;

public class Shoppingcartlog {
    private int shoppingcart_ID ;
    private int book_ID;
    private int size;
    private int  cost ;

    public Shoppingcartlog(int shoppingcart_ID, int book_ID, int size, int cost) {
        this.shoppingcart_ID = shoppingcart_ID;
        this.book_ID = book_ID;
        this.size = size;
        this.cost = cost;
    }
    public Shoppingcartlog(Shoppingorderlog x){
        this.book_ID = x.getBook_ID();
        this.size = x.getSize();
        this.cost = x.getCost();
    }

    @Override
    public String toString() {
        return "Shoppingcartlog{" +
                "shoppingcart_ID=" + shoppingcart_ID +
                ", book_ID=" + book_ID +
                ", size=" + size +
                ", cost=" + cost +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shoppingcartlog that = (Shoppingcartlog) o;
        return shoppingcart_ID == that.shoppingcart_ID && book_ID == that.book_ID && size == that.size && cost == that.cost;
    }

    @Override
    public int hashCode() {
        return Objects.hash(shoppingcart_ID, book_ID, size, cost);
    }

    public void setShoppingcart_ID(int shoppingcart_ID) {
        this.shoppingcart_ID = shoppingcart_ID;
    }

    public void setBook_ID(int book_ID) {
        this.book_ID = book_ID;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getShoppingcart_ID() {
        return shoppingcart_ID;
    }

    public int getBook_ID() {
        return book_ID;
    }

    public int getSize() {
        return size;
    }

    public int getCost() {
        return cost;
    }
}
