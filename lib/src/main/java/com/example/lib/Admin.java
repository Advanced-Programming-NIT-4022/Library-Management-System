package com.example.lib;

public class Admin extends User{
    public String getPassword() {
        return Password;
    }
    private String Password;
    Admin(String name,String number,String Id,String Password){
        super(name,number,Id);
        this.Password=Password;
    }
}
