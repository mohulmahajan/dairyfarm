package com.example.dairyfarm.ques;

public class Data {
    private int a;
    private String  b;
    private static Data data = new Data();
    private String Delhi,Sonepat,Panipat,Karnal,Ambala,Panchkula;
    private String emailOnLogin;
    private int Milk,paneer,curd,cheese,buttermilk,ghee;
    private String items;
    private Data() {
    }

    public static Data getInstance() {
        return data;
    }

    public String getDelhi() {
        return Delhi;
    }

    public void setDelhi(String delhi) {
        Delhi = delhi;
    }

    public String getSonepat() {
        return Sonepat;
    }

    public void setSonepat(String sonepat) {
        Sonepat = sonepat;
    }

    public String getPanipat() {
        return Panipat;
    }

    public void setPanipat(String panipat) {
        Panipat = panipat;
    }

    public String getKarnal() {
        return Karnal;
    }

    public void setKarnal(String karnal) {
        Karnal = karnal;
    }

    public String getAmbala() {
        return Ambala;
    }

    public void setAmbala(String ambala) {
        Ambala = ambala;
    }

    public String getPanchkula() {
        return Panchkula;
    }

    public void setPanchkula(String panchkula) {
        Panchkula = panchkula;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getEmailOnLogin() {
        return emailOnLogin;
    }

    public void setEmailOnLogin(String emailOnLogin) {
        this.emailOnLogin = emailOnLogin;
    }


    public static Data getData() {
        return data;
    }

    public static void setData(Data data) {
        Data.data = data;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
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

    public int getCheese() {
        return cheese;
    }

    public void setCheese(int cheese) {
        this.cheese = cheese;
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
}
