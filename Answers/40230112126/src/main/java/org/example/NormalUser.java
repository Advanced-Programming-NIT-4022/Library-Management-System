package org.example;

public class NormalUser extends User{
    String registrationDate;

    NormalUser(String userName, String userId, String phoneNumber, String registrationDate){
        super(userName, userId, phoneNumber, null);
        this.registrationDate = registrationDate;
    }
}
