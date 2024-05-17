package org.example;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Rent extends UniqueID{
    Book book;
    User user;
    LocalDateTime currentDateTime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private final String RentalDate;
    public String getRentalDate() { return RentalDate; }
    public Rent(){
        book = new Book();
        user = new User();
        RentalDate = currentDateTime.format(formatter);
    }
    public void RentBook(String name) {
        for (int i = 0; i < book.getTotal().size(); i++)
        {
            String[] list = book.getTotal().get(i).split("/");
            if (Objects.equals(list[1],name) || Objects.equals(list[4],"true"))
            {
                book.getTotal().remove(i);
                System.out.println("The book has been successfully rented.");
                System.out.println("enjoy , Bye.");
                String temp = list[0] + "/" + list[1] + "/" + list[2] + "/" + list[3] + "/" + RentalDate ;
                book.getTotal().add(temp);
                break;
            }
        }
    }
    public void ReturnBook(String name) {
        for (int i = 0; i < book.getTotal().size(); i++)
        {
            String[] list = book.getTotal().get(i).split("/");
            if (Objects.equals(list[1],name))
            {
                book.getTotal().remove(i);
                System.out.println("Thank you for returning the book");
                String temp = list[0] + "/" + list[1] + "/" + list[2] + "/" + list[3] + "/" + "true" ;
                book.getTotal().add(temp);
                break;
            }
        }
    }
}