package com.Data;

import java.util.Objects;

public class Shoppingorder {
    private int Shoppingorder_ID ;
    private int customer_ID ;
    private int  cost_tot ;
    private String detail  ;

    public void setShoppingorder_ID(int Shoppingorder_ID) {
        this.Shoppingorder_ID = Shoppingorder_ID;
    }

    public void setCustomer_ID(int customer_ID) {
        this.customer_ID = customer_ID;
    }

    public void setCost_tot(int cost_tot) {
        this.cost_tot = cost_tot;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getShoppingorder_ID() {
        return Shoppingorder_ID;
    }

    public int getCustomer_ID() {
        return customer_ID;
    }

    public int getCost_tot() {
        return cost_tot;
    }

    public String getDetail() {
        return detail;
    }

    public Shoppingorder(int Shoppingorder_ID, int customer_ID, int cost_tot, String detail) {
        this.Shoppingorder_ID = Shoppingorder_ID;
        this.customer_ID = customer_ID;
        this.cost_tot = cost_tot;
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "Shoppingorder{" +
                "Shoppingorder_ID=" + Shoppingorder_ID +
                ", customer_ID=" + customer_ID +
                ", cost_tot=" + cost_tot +
                ", detail='" + detail + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shoppingorder that = (Shoppingorder) o;
        return Shoppingorder_ID == that.Shoppingorder_ID && customer_ID == that.customer_ID && cost_tot == that.cost_tot && Objects.equals(detail, that.detail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Shoppingorder_ID, customer_ID, cost_tot, detail);
    }
}
