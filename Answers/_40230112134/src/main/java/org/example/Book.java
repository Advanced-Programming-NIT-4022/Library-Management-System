package org.example;

import java.util.*;

public class Book extends UniqueID {
    private String ID ;
    private String Title , Author , Description;
    ArrayList<String> Total = new ArrayList<>();
    private boolean AvailabilityStatus;

    public Book()
    {
        this.Title = getTitle();
        this.Description = getDescription();
        this.Author = getAuthor();
        this.AvailabilityStatus = true;
        this.ID = getUniqueID();
    }

    public String getID() {return ID;}
    public boolean getAvailabilityStatus(){return AvailabilityStatus;}
    public void setAvailabilityStatus(boolean availabilityStatus) {AvailabilityStatus = availabilityStatus;}
    public void setAuthor(String author) { Author = author; }
    public String getAuthor() { return Author; }
    public String getDescription() { return Description; }
    public void setDescription(String description) { Description = description; }
    public void setTitle(String title) { Title = title; }
    public String getTitle() { return Title; }

//    public void Rent(String number)
//    {
//        ReadFileBook("Book.txt");
//        for (int i = 0; i < Total.size(); i++)
//        {
//            String line1 = Total.get(i);
//            String[] list = line1.split("/");
//            if (Objects.equals(list[0], number))
//            {
//                System.out.println("please read");
//                Total.remove(i);
//                String temp = list[0] + "/" + list[1] + "/" + list[2] + "/" + list[3] + "/" + "false" ;
//                Total.add(temp);
//            }
//            else
//            {
//                System.out.println("The book is rented.");
//            }
//        }
//        WriteFileBook("Book.txt");
//    }
}