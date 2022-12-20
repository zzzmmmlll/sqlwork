package com.Data;

import java.util.Objects;

public class Opinions {
    private int Opinions_id;
    private int customer_ID;
    private String content;
    private String result;

    @Override
    public String toString() {
        return "Opinions{" +
                "Opinions_id=" + Opinions_id +
                ", customer_ID=" + customer_ID +
                ", content='" + content + '\'' +
                ", result='" + result + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Opinions Opinions = (Opinions) o;
        return Opinions_id == Opinions.Opinions_id && customer_ID == Opinions.customer_ID && Objects.equals(content, Opinions.content) && Objects.equals(result, Opinions.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Opinions_id, customer_ID, content, result);
    }

    public int getOpinions_id() {
        return Opinions_id;
    }

    public void setOpinions_id(int Opinions_id) {
        this.Opinions_id = Opinions_id;
    }

    public int getCustomer_ID() {
        return customer_ID;
    }

    public void setCustomer_ID(int customer_ID) {
        this.customer_ID = customer_ID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Opinions(int Opinions_id, int customer_ID, String content, String result) {
        this.Opinions_id = Opinions_id;
        this.customer_ID = customer_ID;
        this.content = content;
        this.result = result;
    }
}
