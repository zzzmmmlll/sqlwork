package com.Data;

import java.util.Objects;

public class Book_categorylog {
    private int book_ID;
    private int book_category_id;

    @Override
    public String toString() {
        return "Book_categorylogy{" +
                "book_ID=" + book_ID +
                ", book_category_id=" + book_category_id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book_categorylog that = (Book_categorylog) o;
        return book_ID == that.book_ID && book_category_id == that.book_category_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(book_ID, book_category_id);
    }

    public int getBook_ID() {
        return book_ID;
    }

    public void setBook_ID(int book_ID) {
        this.book_ID = book_ID;
    }

    public int getBook_category_id() {
        return book_category_id;
    }

    public void setBook_category_id(int book_category_id) {
        this.book_category_id = book_category_id;
    }

    public Book_categorylog(int book_ID, int book_category_id) {
        this.book_ID = book_ID;
        this.book_category_id = book_category_id;
    }
}
