package org.example;

public class Admins extends User{
    // Attributes
    private String password;
    // Getters & Setters
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Constructor
    Admins(String name, String uniqueID, String phoneNumber, String password){
        super(name, uniqueID, phoneNumber);
        this.password = password;
    }
    @Override
    public void signUp() {

    }
}
