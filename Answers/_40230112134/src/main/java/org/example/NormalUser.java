package org.example;

import java.io.*;
import java.util.ArrayList;

public class NormalUser extends Book{
    private String Name;
    private String IDUser ;
    private int PhoneNumber;
    public NormalUser(String name,int phonenumber)
    {
        this.Name = name;
        this.PhoneNumber = phonenumber;
        this.IDUser = getID();
    }
    public int getPhoneNumber() {
        return PhoneNumber;
    }
    public void setPhoneNumber(int phoneNumber) {
        PhoneNumber = phoneNumber;
    }
    public String getIDUser() {
        return IDUser;
    }
    public void setIDUser(String IDUser) {
        this.IDUser = IDUser;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    ArrayList<Book> books = new ArrayList<>();
}

class Admin extends NormalUser{
    private final String Password = "8488";
    public Admin(String name, int phonenumber)
    {
        super(name, phonenumber);
    }

}