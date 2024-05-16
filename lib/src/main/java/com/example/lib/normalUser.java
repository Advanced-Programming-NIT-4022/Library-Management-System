package com.example.lib;

import java.time.LocalDate;
import java.util.Random;

public class normalUser extends User{
    private LocalDate registration;

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    private String Password;


    public normalUser(String name, String phoneNumber,String Password){
        super(name,phoneNumber);
        super.setNumber(phoneNumber);
        super.setId(String.valueOf(rand.nextInt(999999)));
        this.Password=Password;
    }
    normalUser(String name, String phoneNumber,String Password,String Id){
        super(name,phoneNumber);
        super.setNumber(phoneNumber);
        super.setId(Id);
        this.Password=Password;
    }
}
