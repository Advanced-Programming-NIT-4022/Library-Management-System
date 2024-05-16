package org.example;

import java.util.Date;

public abstract class User {
    protected String userName;
    protected String uniqueID;
    protected String phoneNumber;
    //***** Constructor *****//
    User(String name, String uniqueID, String phoneNumber){
        this.userName = name;
        this.uniqueID = uniqueID;
        this.phoneNumber = phoneNumber;
    }
    //***** Getters & Setters *****//
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(String uniqueID) {
        this.uniqueID = uniqueID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    //***** Methods *****//
    public abstract void register(Date registrationDate);
}
