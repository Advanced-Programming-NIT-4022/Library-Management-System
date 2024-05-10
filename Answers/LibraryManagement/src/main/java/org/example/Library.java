package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.ArrayList;

public class Library {

    private static String name;
    private static int capacity;
    private static String OperatingHours;
    private static ArrayList<Book> bookRepository;
    private static HashMap<String, NormalUser> UserRegistery;
    private static ArrayList<Rent> RentalRegistery;

    public Library(String name, int capacity, String OperatingHours) {
        this.name = name;
        this.capacity = capacity;
        this.OperatingHours = OperatingHours;
        this.bookRepository = new ArrayList<>();
        this.UserRegistery = new HashMap<>();
        this.RentalRegistery = new ArrayList<>();
    }
    public void addbook(Book book){
        if (bookRepository.size() > capacity){
            bookRepository.add(book);
            System.out.println("The book: " + Book.getTitle() + "added to book repository.");
        }
        else {
            System.out.println("the book repository is full.");
        }
    }
    public void adduser(NormalUser normalUser){
        UserRegistery.put(NormalUser.getId(), normalUser);
        System.out.println("The user " + NormalUser.getName() + "has been added to the library.");
    }
    public void removebook(Book book){
        if (bookRepository.contains(book)){
            bookRepository.remove(book);
            System.out.println("book has been removed sucssesfully.");
        }
        else {
            System.out.println("we didnt find the book.");
        }
    }
    public void removeuser(NormalUser normalUser){
        if (UserRegistery.containsValue(normalUser)){
            UserRegistery.remove(normalUser);
            System.out.println("User removed from the library.");
        }
        else{
            System.out.println("user not found.");
        }
    }
    public void rentbook(NormalUser normalUser, Book book, String RentalId){
        Rent newrent = new Rent(book, normalUser, RentalId, Rent.getRentalDate());
        RentalRegistery.add(newrent);
        System.out.println("book added sucssesfully.");
    }
    public void returnbook(NormalUser normalUser, Book book){
        for (int i = 0; i<RentalRegistery.size(); i++){
            Rent r = RentalRegistery.get(i);
            if (r.getBook().equals(book) && r.getNormalUser().equals(normalUser)){
                RentalRegistery.remove(r);
                System.out.println("Book has been returned sucssesfully.");
            }
            else {
                System.out.println("you have not rented this book.");
            }
        }
    }
    public static String getname(){
        return name;
    }
    public static int getcapacity(){
        return capacity;
    }
    public static ArrayList<Book> getbookRepository(){
        return bookRepository;
    }
    public static String getOperatingHours(){
        return OperatingHours;
    }
    public static HashMap<String, NormalUser> getUserRegistery(){
        return UserRegistery;
    }
    public static ArrayList<Rent> getRentalRegistery(){
        return RentalRegistery;
    }
}







