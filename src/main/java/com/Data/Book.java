package com.Data;

import com.alibaba.fastjson.JSONObject;

import java.util.Objects;

public class Book {
    private int Book_ID=0;
    private String Book_name ;
    private int cost  ;
    private String roduction;

    public int getBook_ID() {
        return Book_ID;
    }
    public Book(JSONObject x){
        this.Book_ID=Integer.getInteger(x.getString("id"));
    }

    public Book(int book_ID, String book_name, int cost, String roduction) {
        Book_ID = book_ID;
        Book_name = book_name;
        this.cost = cost;
        this.roduction = roduction;
    }

    public void setBook_ID(int Book_ID) {
        this.Book_ID = Book_ID;
    }

    public String getBook_name() {
        return Book_name;
    }

    public void setBook_name(String Book_name) {
        this.Book_name = Book_name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getRoduction() {
        return roduction;
    }

    public void setRoduction(String roduction) {
        this.roduction = roduction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book Book = (Book) o;
        return Book_ID == Book.Book_ID && cost == Book.cost && Objects.equals(Book_name, Book.Book_name) && Objects.equals(roduction, Book.roduction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Book_ID, Book_name, cost, roduction);
    }

    @Override
    public String toString() {
        return "Book{" +
                "Book_ID=" + Book_ID +
                ", Book_name='" + Book_name + '\'' +
                ", cost=" + cost +
                ", roduction='" + roduction + '\'' +
                '}';
    }
}
