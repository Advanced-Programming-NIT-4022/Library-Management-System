package org.LMS;

public class Book {
    int id;
    String title, author, description;
    Boolean isAvailable;

    public Book(int id, String title, String author, String description, Boolean isAvailable) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isAvailable = isAvailable;
        this.description = description;
    }

    public Book(String title, String author, String description) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.isAvailable = true;
    }
}
