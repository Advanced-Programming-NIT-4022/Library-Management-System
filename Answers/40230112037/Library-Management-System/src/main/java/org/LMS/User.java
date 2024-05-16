package org.LMS;

import java.util.Date;

public class User {
    Integer id;
    String username;
    String fullName;
    String phoneNumber;
}

final class NormalUser extends User {
    Date registrationDate;

    NormalUser(String username, String fullName, String phoneNumber) {
        this.username = username;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
    }

    NormalUser(int id, String username, String fullName, String phoneNumber, Date registrationDate) {
        this.id = id;
        this.username = username;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.registrationDate = registrationDate;
    }
}

final class AdminUser extends User {
    Password password;

    AdminUser(int id, String username, String fullName, String phoneNumber, String hashedPassword) {
        this.id = id;
        this.username = username;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.password = Password.passwordByHash(hashedPassword);
    }

    AdminUser(String username, String fullName, String phoneNumber, Password password) {
        this.username = username;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

}