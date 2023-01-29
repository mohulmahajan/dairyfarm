package com.example.dairyfarm.model;

import java.io.Serializable;

public class ProductModel implements Serializable {
    private String Milk,paneer,curd,cheese,buttermilk,ghee;


    public ProductModel() {
    }

    public ProductModel(String milk, String paneer, String curd, String cheese, String buttermilk, String ghee) {
        Milk = milk;
        this.paneer = paneer;
        this.curd = curd;
        this.cheese = cheese;
        this.buttermilk = buttermilk;
        this.ghee = ghee;
    }

    public String getMilk() {
        return Milk;
    }

    public void setMilk(String milk) {
        Milk = milk;
    }

    public String getPaneer() {
        return paneer;
    }

    public void setPaneer(String paneer) {
        this.paneer = paneer;
    }

    public String getCurd() {
        return curd;
    }

    public void setCurd(String curd) {
        this.curd = curd;
    }

    public String getCheese() {
        return cheese;
    }

    public void setCheese(String cheese) {
        this.cheese = cheese;
    }

    public String getButtermilk() {
        return buttermilk;
    }

    public void setButtermilk(String buttermilk) {
        this.buttermilk = buttermilk;
    }

    public String getGhee() {
        return ghee;
    }

    public void setGhee(String ghee) {
        this.ghee = ghee;
    }
}