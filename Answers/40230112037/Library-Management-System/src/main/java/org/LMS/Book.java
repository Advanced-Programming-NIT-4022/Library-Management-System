package org.LMS;

public class Book {
    int id;
    String title, author, description;

    public Book(int id, String title, String author, String description) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.description = description;
    }

    public Book(String title, String author, String description) {
        this.title = title;
        this.author = author;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Id:" + id + "\tTitle: " + title + "\tAuthor: " + author + "\tDescription: " + description;
    }


}
