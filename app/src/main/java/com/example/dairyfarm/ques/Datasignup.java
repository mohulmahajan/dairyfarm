package com.example.dairyfarm.ques;

import android.text.Editable;

public class Datasignup {
    String Name,Email,Password;
    String phn;
    private static Datasignup data = new Datasignup();

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getPhn() {
        return phn;
    }

    public void setPhn(String phn) {
        this.phn = phn;
    }

    private Datasignup() {}
    public static Datasignup getInstance() {
        return data;
    }
}