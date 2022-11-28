package com.example.dairyfarm.model;

public class ProfileModel {

    String name,email,phn;


    public ProfileModel() {
    }

    public ProfileModel(String name, String email, String phn) {
        this.name = name;
        this.email = email;
        this.phn = phn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhn() {
        return phn;
    }

    public void setPhn(String phn) {
        this.phn = phn;
    }
}
