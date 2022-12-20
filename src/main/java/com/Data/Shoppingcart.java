package com.Data;

import java.util.Objects;

public class Shoppingcart {
    private int Shoppingcart_ID ;
    private int customer_ID ;
    private int cost_tot;

    public Shoppingcart(int Shoppingcart_ID, int customer_ID, int cost_tot) {
        this.Shoppingcart_ID = Shoppingcart_ID;
        this.customer_ID = customer_ID;
        this.cost_tot = cost_tot;
    }

    public int getShoppingcart_ID() {
        return Shoppingcart_ID;
    }

    public int getCustomer_ID() {
        return customer_ID;
    }

    public int getCost_tot() {
        return cost_tot;
    }

    public void setShoppingcart_ID(int Shoppingcart_ID) {
        this.Shoppingcart_ID = Shoppingcart_ID;
    }

    public void setCustomer_ID(int customer_ID) {
        this.customer_ID = customer_ID;
    }

    public void setCost_tot(int cost_tot) {
        this.cost_tot = cost_tot;
    }

    @Override
    public String toString() {
        return "Shoppingcart{" +
                "Shoppingcart_ID=" + Shoppingcart_ID +
                ", customer_ID=" + customer_ID +
                ", cost_tot=" + cost_tot +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shoppingcart that = (Shoppingcart) o;
        return Shoppingcart_ID == that.Shoppingcart_ID && customer_ID == that.customer_ID && cost_tot == that.cost_tot;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Shoppingcart_ID, customer_ID, cost_tot);
    }

}
