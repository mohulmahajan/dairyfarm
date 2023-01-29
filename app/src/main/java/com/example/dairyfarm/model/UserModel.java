package com.example.dairyfarm.model;

import android.text.Editable;
import android.widget.ImageView;

import java.io.Serializable;

public class UserModel implements Serializable {
    private  String Name;
    private  String Email;
    private  int Pc;
    private  String Loc;
    private String phn;
    private String Delhi,Sonepat,Panipat,Karnal,Ambala,Panchkula;
    //    private String password;
    private ImageView image;



//    public UserModel(String name, String email,   String phn, String password,int pc,String loc) {
//        Name = name;
//        Email = email;
//        Pc = pc;
//        Loc = loc;
//        this.phn = phn;
//        this.password = password;
//    }


    public UserModel(String name, String email,  String phn,int pc,String loc, String delhi, String sonepat, String panipat, String karnal, String ambala, String panchkula) {
        Name = name;
        Email = email;
        Pc = pc;
        loc=loc;
        this.phn = phn;
        Delhi = delhi;
        Sonepat = sonepat;
        Panipat = panipat;
        Karnal = karnal;
        Ambala = ambala;
        Panchkula = panchkula;
    }

    public UserModel(String name, String email, String phn, int pc, String loc ) {
        Name = name;
        Email = email;
        Pc = pc;
        Loc = loc;
        this.phn = phn;
    }

    public UserModel() {
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

    public int getPc() {
        return Pc;
    }

    public void setPc(int pc) {
        Pc = pc;
    }

    public String getLoc() {
        return Loc;
    }

    public void setLoc(String loc) {
        Loc = loc;
    }

    public String getPhn() {
        return phn;
    }

    public void setPhn(String phn) {
        this.phn = phn;
    }

//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
}