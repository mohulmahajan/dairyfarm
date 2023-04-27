package com.example.dairyfarm.model;

import java.io.Serializable;

public class ProductModel implements Serializable {
    private String email = "";
    private int Milk, paneer, curd, buttermilk, ghee,cheese;
    private String items="";

    public ProductModel() {
    }

    public ProductModel(String email, int milk, int paneer, int curd, int buttermilk, int ghee, int cheese,String items) {
        this.email = email;
        Milk = milk;
        this.paneer = paneer;
        this.curd = curd;
        this.buttermilk = buttermilk;
        this.ghee = ghee;
        this.cheese = cheese;
        this.items = items;
    }

    public ProductModel(String email, int milk, int paneer, int curd, int buttermilk, int ghee, int cheese) {
        this.email = email;
        Milk = milk;
        this.paneer = paneer;
        this.curd = curd;
        this.buttermilk = buttermilk;
        this.ghee = ghee;
        this.cheese = cheese;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMilk() {
        return Milk;
    }

    public void setMilk(int milk) {
        Milk = milk;
    }

    public int getPaneer() {
        return paneer;
    }

    public void setPaneer(int paneer) {
        this.paneer = paneer;
    }

    public int getCurd() {
        return curd;
    }

    public void setCurd(int curd) {
        this.curd = curd;
    }

    public int getButtermilk() {
        return buttermilk;
    }

    public void setButtermilk(int buttermilk) {
        this.buttermilk = buttermilk;
    }

    public int getGhee() {
        return ghee;
    }

    public void setGhee(int ghee) {
        this.ghee = ghee;
    }

    public int getCheese() {
        return cheese;
    }

    public void setCheese(int cheese) {
        this.cheese = cheese;
    }
}