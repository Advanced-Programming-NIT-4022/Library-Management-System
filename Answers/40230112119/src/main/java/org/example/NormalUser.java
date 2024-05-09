package org.example;

import java.util.ArrayList;

public class NormalUser extends User{
    private int date;

    public NormalUser(String name, int ID, char[] phone, int date, String password) {
        super(name, ID, phone, password);
        this.date = date;
    }

    public void showInfo() {

    }

}
