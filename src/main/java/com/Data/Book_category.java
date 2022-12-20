package com.Data;

import java.util.Objects;

public class Book_category {
    private String Book_category_name;
    private int Book_category_id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book_category that = (Book_category) o;
        return Book_category_id == that.Book_category_id && Objects.equals(Book_category_name, that.Book_category_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Book_category_name, Book_category_id);
    }

    public String getBook_category_name() {
        return Book_category_name;
    }

    public void setBook_category_name(String Book_category_name) {
        this.Book_category_name = Book_category_name;
    }

    public Book_category(String Book_category_name, int Book_category_id) {
        this.Book_category_name = Book_category_name;
        this.Book_category_id = Book_category_id;
    }

    public int getBook_category_id() {
        return Book_category_id;
    }

    public void setBook_category_id(int Book_category_id) {
        this.Book_category_id = Book_category_id;
    }

    @Override
    public String toString() {
        return "Book_category{" +
                "Book_category_name='" + Book_category_name + '\'' +
                ", Book_category_id=" + Book_category_id +
                '}';
    }
}
