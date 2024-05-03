package com.library;

import com.library.Rent;

import java.security.MessageDigest;
import java.util.List;

public class Admin {
    private String username;
    private String password;

    public Admin(String username, String password) {
        this.username = username;
        this.password = hashPassword(password);
    }

    public boolean verifyPassword(String password) {
        String hashedInput = hashPassword(password);
        return hashedInput.equals(this.password);
    }

    public void addUser(Library library, User user) throws IllegalArgumentException {
        if (!isAdminAuthorized()) {
            throw new IllegalStateException("Unauthorized action");
        }
        library.addUser(user);
    }

    public void removeUser(Library library, int memberID) throws IllegalArgumentException {
        if (!isAdminAuthorized()) {
            throw new IllegalStateException("Unauthorized action");
        }
        library.removeUser(memberID);
    }

    public List<Rent> viewRentals(Library library) {
        if (!isAdminAuthorized()) {
            throw new IllegalStateException("Unauthorized action");
        }
        return List.of((Rent) library.getRentals());
    }

    private String hashPassword(String password) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hash = messageDigest.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hash) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private boolean isAdminAuthorized() {
        return true;
    }
}


