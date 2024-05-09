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
}