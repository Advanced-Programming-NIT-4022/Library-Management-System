package org.example;

import java.util.ArrayList;

public class NormalUser extends User{
    private String date;

    public NormalUser(String name, int uniqueID, String phone, String date) {
        super(name, uniqueID, phone);
        this.date = date;
    }
    public NormalUser() {
        User u = new User();
        this.date = null;
    }

}
