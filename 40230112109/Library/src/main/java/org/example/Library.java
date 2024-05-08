package org.example;

import java.util.ArrayList;
import java.util.List;

public class Library {
    // Attributes
    private String libraryName;
    private int capacity;
    private String operatingHours;
    private List<Book> books;
    private List<User> users;
    private List<Rent> rentals;
    // Getters & Setters

    public String getLibraryName() {
        return libraryName;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getOperatingHours() {
        return operatingHours;
    }

    public void setOperatingHours(String operatingHours) {
        this.operatingHours = operatingHours;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Rent> getRentals() {
        return rentals;
    }

    public void setRentals(List<Rent> rentals) {
        this.rentals = rentals;
    }
    // Constructor
    Library(String libraryName, int capacity, String operatingHours){
        this.libraryName = libraryName;
        this.capacity = capacity;
        this.operatingHours = operatingHours;
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
        this.rentals = new ArrayList<>();

    }
}
