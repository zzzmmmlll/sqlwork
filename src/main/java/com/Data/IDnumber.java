package com.Data;

public class IDnumber {
    private int customer_ID,book_ID,shoppingcart_ID,shoppingorder_ID,book_category_id;

    @Override
    public String toString() {
        return "IDnumber{" +
                "customer_ID=" + customer_ID +
                ", book_ID=" + book_ID +
                ", shoppingcart_ID=" + shoppingcart_ID +
                ", shoppingorder_ID=" + shoppingorder_ID +
                ", book_category_id=" + book_category_id +
                '}';
    }

    public int getCustomer_ID() {
        return customer_ID;
    }

    public void setCustomer_ID(int customer_ID) {
        this.customer_ID = customer_ID;
    }

    public void setBook_ID(int book_ID) {
        this.book_ID = book_ID;
    }

    public IDnumber(int customer_ID, int book_ID, int shoppingcart_ID, int shoppingorder_ID, int book_category_id) {
        this.customer_ID = customer_ID;
        this.book_ID = book_ID;
        this.shoppingcart_ID = shoppingcart_ID;
        this.shoppingorder_ID = shoppingorder_ID;
        this.book_category_id = book_category_id;
    }

    public IDnumber() {
    }

    public void setShoppingcart_ID(int shoppingcart_ID) {
        this.shoppingcart_ID = shoppingcart_ID;
    }

    public void setShoppingorder_ID(int shoppingorder_ID) {
        this.shoppingorder_ID = shoppingorder_ID;
    }

    public void setBook_category_id(int book_category_id) {
        this.book_category_id = book_category_id;
    }

    public int getBook_ID() {
        return book_ID;
    }

    public int getShoppingcart_ID() {
        return shoppingcart_ID;
    }

    public int getShoppingorder_ID() {
        return shoppingorder_ID;
    }

    public int getBook_category_id() {
        return book_category_id;
    }

}
