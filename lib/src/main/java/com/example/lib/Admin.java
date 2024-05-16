package com.example.lib;

public class Admin extends User{
    public String getPassword() {
        return Password;
    }
    private String Password;
    Admin(String name,String number,String Password){
        super(name,number);
        super.setId(String.valueOf(rand.nextInt(99999)));
        this.Password=Password;
    }
    Admin(String name,String number,String Password,String Id){
        super(name,number);
        super.setId(Id);
        this.Password=Password;
    }
}
