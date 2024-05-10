package org.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Rent extends UniqueID{
    Book book;
    User user;
    LocalDateTime currentDateTime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private final String RentalDate;
    private final String RentID ;
    public String getRentID() { return RentID; }
    public String getRentalDate() { return RentalDate; }
    public Rent(){
        book = new Book();
        user = new User();
        RentalDate = currentDateTime.format(formatter);
        RentID = getUniqueID();
    }
    public void Rent(String number)
    {
        user.ReadFileBook("Book.txt");
        String temp = "";
        for (int i = 0; i < book.getTotal().size(); i++)
        {
            String[] list = book.getTotal().get(i).split("/");
            if (Objects.equals(list[0], number))
            {
                System.out.println("The book has been successfully rented.");
                System.out.println("enjoy , Bye.");
                book.getTotal().remove(i);
                book.setTotal(book.getTotal());
                temp = list[0] + "/" + list[1] + "/" + list[2] + "/" + list[3] + "/" + RentalDate ;
                break;
            }
            else
            {
                System.out.println("The book is rented.");
            }
        }
        user.WriteFileBook("Book.txt");
        user.ReadFileBook("Rent.txt");
        book.getTotal().add(temp);
        user.WriteFileBook("Rent.txt");
    }
}
