package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Library {
    public String getLibraryName() {
        return LibraryName;
    }

    public void setLibraryName(String libraryName) {
        LibraryName = libraryName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getOperatingHours() {
        return operatingHours;
    }

    public void setOperatingHours(int operatingHours) {
        this.operatingHours = operatingHours;
    }

    private String LibraryName;
    private int capacity;
    private int operatingHours;
    private ArrayList<Book>bookRepo;
    private List<User>userRegistries;
    private List<Rent>rentalRegistries;
    public Library (String LibraryName,int capacity, int operatingHours)
    {
        this.LibraryName= LibraryName;
        this.capacity= capacity;
        this.operatingHours= operatingHours;
        this.bookRepo= new ArrayList<>();
        this.userRegistries= new ArrayList<>();
        this.rentalRegistries= new ArrayList<>();
    }
    public void addBook(Book book)
    {
        bookRepo.add(book);
    }
    public void addUser(User user)
    {
        userRegistries.add(user);
    }
    public void rentBook(Book book, NormalUser user, int rentalID, Date rentalDate)
    {
        Rent rent = new Rent(book, user, rentalID, rentalDate);
        rentalRegistries.add(rent);
        book.setAvailability_status(false);
    }
    public void returnBook(Book book)
    {
        book.setAvailability_status(true);
    }
    public void removeUser (User user)
    {
        userRegistries.remove(user);
    }

}
