package com.library;

public class Book {
    private String title;
    private String author;
    private boolean available;

    public Book(String title, String author, String subtitle) {
        this.title = title;
        this.author = author;
        this.available = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + (available ? " (Available)" : " (Borrowed)");
    }

    public boolean isBorrowed() {
        boolean borrowed = false;
        return borrowed;
    }
    public void borrow() {
        boolean borrowed = false;
        if (!borrowed) {
            borrowed = true;
            System.out.println("Book \"" + title + "\" borrowed successfully.");
        } else {
            System.out.println("Book \"" + title + "\" is already borrowed.");
        }
    }

    public void returnBook() {
        boolean borrowed = false;
        if (borrowed) {
            borrowed = false;
            System.out.println("Book \"" + title + "\" returned successfully.");
        } else {
            System.out.println("Book \"" + title + "\" is already available.");
        }
    }
}
