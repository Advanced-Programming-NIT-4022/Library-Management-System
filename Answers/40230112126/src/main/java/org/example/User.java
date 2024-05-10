package org.example;

import java.util.Scanner;

public class User {
    static String  phoneNumber, userId;
    static String userName;
    static String registerDate;

    public User(String name, String Id, String phoneNumber, String registerDate) {
        userName = name;
        this.userId = Id;
        this.phoneNumber = phoneNumber;
        this.registerDate = registerDate;
    }
    public String getuserName() {
        return userName;
    }

    public void setUserName(String name) {
        userName = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setID(String ID) {
        userId = ID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        phoneNumber = phoneNumber;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setregisterDate(String registerDate) {
        registerDate = registerDate;
    }



}