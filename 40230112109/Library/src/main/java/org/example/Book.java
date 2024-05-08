package org.example;

import java.util.UUID;
// Attributes
public class Book {
    private UUID bookID;
    private String title;
    private String author;
    private boolean availabilityStatus;
    private String description;
    // Constructor
    Book(String title, String author, boolean availabilityStatus, String description){
        this.bookID = UUID.randomUUID();
        this.title = title;
        this.author = author;
        this.description = description;
    }
    // Getters and Setters
    public UUID getBookID() { return bookID; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isAvailable() { return availabilityStatus; }
    public void setAvailabilityStatus(boolean availabilityStatus) { this.availabilityStatus = availabilityStatus; }
}
