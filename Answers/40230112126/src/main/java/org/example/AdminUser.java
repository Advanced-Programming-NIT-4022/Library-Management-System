package org.example;

import java.util.Scanner;

public class AdminUser extends User {
    String password;

    AdminUser(String password){
        super(userName, userId, phoneNumber, registerDate);
        this.password = password;
    }
}
