package com.Data;

import com.alibaba.fastjson.JSONObject;

import java.util.Objects;

public class customer {
    private String Passwordtext;
    private String Telephone;
    private int Id;
    private String Name;

    public String getName() {
        return Name;
    }

    public String getPasswordtext() {
        return Passwordtext;
    }

    public String getTelephone() {
        return Telephone;
    }

    public int getId() {
        return Id;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setPasswordtext(String Passwordtext) {
        this.Passwordtext = Passwordtext;
    }

    public void setTelephone(String Telephone) {
        this.Telephone = Telephone;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public customer(String Passwordtext, String Telephone, int Id, String Name) {
        this.Passwordtext = Passwordtext;
        this.Telephone = Telephone;
        this.Id = Id;
        this.Name = Name;
    }
    public customer(JSONObject x,int y){
        if(y==1){

            this.Passwordtext=x.getString("password");
            this.Name=x.getString("name");
            this.Telephone=x.getString("telephone");
        }
        else{

            this.Passwordtext=x.getString("password");
            this.Name=x.getString("number");
            this.Telephone=x.getString("number");
        }
    }

    @Override
    public String toString() {
        return "customer{" +
                "Passwordtext='" + Passwordtext + '\'' +
                ", Telephone='" + Telephone + '\'' +
                ", Id=" + Id +
                ", Name='" + Name + '\'' +
                '}';
    }

    public customer() { }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        customer customer = (customer) o;
        return Id == customer.Id && Objects.equals(Passwordtext, customer.Passwordtext) && Objects.equals(Telephone, customer.Telephone) && Objects.equals(Name, customer.Name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Passwordtext, Telephone, Id, Name);
    }

}
