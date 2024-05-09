package org.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Rent extends UniqueID{
    Book book;
    User user;
    LocalDateTime currentDateTime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private final String RentalDate = currentDateTime.format(formatter);
    private final String RentID = getUniqueID();
    public String getRentID() { return RentID; }
    public String getRentalDate() { return RentalDate; }
    public void Rent(String number , String filepath)
    {
        user.ReadFileBook(filepath);
        for (int i = 0; i < book.Total.size(); i++)
        {
            String line1 = book.Total.get(i);
            String[] list = line1.split("/");
            if (Objects.equals(list[0], number))
            {
                System.out.println("please read");
                book.Total.remove(i);
                String temp = list[0] + "/" + list[1] + "/" + list[2] + "/" + list[3] + "/" + "false" ;
                book.Total.add(temp);
            }
            else
            {
                System.out.println("The book is rented.");
            }
        }
        user.WriteFileBook(filepath);
    }
}
