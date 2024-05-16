package org.example;

import java.util.*;

public class Book extends UniqueID {
    private String IDBook ;
    private String Title , Author , Description;
    private ArrayList<String> Total = new ArrayList<>();
    private boolean AvailabilityStatus;
    public Book()
    {
        this.AvailabilityStatus = true;
        this.IDBook = getUniqueIDString();
    }
    public ArrayList<String> getTotal() { return Total; }
    public void setTotal(ArrayList<String> total) { Total = total; }
    public String getIDBook() { return IDBook; }
    public void setIDBook(String IDBook) { this.IDBook = IDBook; }
    public boolean getAvailabilityStatus(){ return AvailabilityStatus; }
    public void setAvailabilityStatus(boolean availabilityStatus) { AvailabilityStatus = availabilityStatus; }
    public void setAuthor(String author) { Author = author; }
    public String getAuthor() { return Author; }
    public String getDescription() { return Description; }
    public void setDescription(String description) { Description = description; }
    public void setTitle(String title) { Title = title; }
    public String getTitle() { return Title; }
}