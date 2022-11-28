package com.example.dairyfarm.ques;

public class Data {
    private int a;
    private String  b;
    private static Data data = new Data();
    private String Delhi,Sonepat,Panipat,Karnal,Ambala,Panchkula;
    private String emailOnLogin;

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
}


