package com.library;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User {
    private final int studentID;
    private final String password;
    private int id;
    private String username;
    private int borrowLimit;
    private List<Book> borrowedBooks;
    private String name;

    public User(int studentID, String password1, int id, String username, String password, int borrowLimit, String name) {
        this.studentID = studentID;
        this.password = password1;
        this.id = id;
        this.username = username;
        this.hashedPassword = hashPassword(password);
        this.borrowLimit = borrowLimit;
        this.borrowedBooks = new ArrayList<Book>();
        this.name = name;
    }

    public User(int studentID, String password) {
        this.studentID = studentID;
        this.password = hashPassword(password);
    }
    public User(int studentID, String password, String name) {
        this(studentID, password);
        this.name = name;
    }

    public Integer getID() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public boolean verifyPassword(String password) {
        String hashedInput = hashPassword(password);
        return hashedInput.equals(hashedPassword);
    }

    public boolean canRentBook(Library library) {
        if (borrowLimit <= 0) {
            return false;
        }
        int borrowedCount = borrowedBooks.size();
        return borrowedCount < borrowLimit;
    }

    public List<Book> getBorrowedBooks() {
        return Collections.unmodifiableList(borrowedBooks);
    }

    public String getName() {
        return name;
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

    public void borrowBook(Book book) {
        if (!canBorrowMoreBooks()) {
            throw new IllegalStateException("Borrow limit reached.");
        }

        borrowedBooks.add(book);
    }
    boolean canBorrowMoreBooks() {
        return borrowLimit == -1 || borrowedBooks.size() < borrowLimit;
    }

    public int getStudentID() {
        return studentID;
    }
}

