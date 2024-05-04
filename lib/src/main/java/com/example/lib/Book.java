package com.example.lib;

public class Book {
    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public boolean isAvailabilityStatus() {
        return AvailabilityStatus;
    }

    public void setAvailabilityStatus(boolean availabilityStatus) {
        AvailabilityStatus = availabilityStatus;
    }

    private String Title;
    private String Author;
    private String bookId;
    private String Description;
    private boolean AvailabilityStatus;
}
