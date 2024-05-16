package org.example;

import java.util.ArrayList;

public class NormalUser extends User{
    private int date;

    public NormalUser(String name, int uniqueID, char[] phone, int date) {
        super(name, uniqueID, phone);
        this.date = date;
    }
    public NormalUser() {
        User u = new User();
        this.date = -1;
    }

}
