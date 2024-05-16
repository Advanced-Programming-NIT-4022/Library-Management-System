package org.example;

import java.util.HashMap;

public class User {
    private String name;
    private int ID;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }

    private int phoneNum;
    public User(String name, int ID, int PhoneNum) {
        this.name = name;
        this.ID = ID;
        this.phoneNum = phoneNum;
    }

}

