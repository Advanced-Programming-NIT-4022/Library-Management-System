package org.example;

import java.util.ArrayList;

public class NormalUser extends User{
    private int date;

    public NormalUser(String name, int uniqueID, char[] phone, int date) {
        super(name, uniqueID, phone);
        this.date = date;
    }

    public void showInfo() {

    }

}
