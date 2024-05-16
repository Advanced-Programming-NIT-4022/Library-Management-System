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

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    private String phoneNum;
    public User(String name, int ID, String PhoneNum) {
        this.name = name;
        this.ID = ID;
        this.phoneNum = phoneNum;
    }

}

