package org.example;

public class Book {
    private int bookID;
    private String title;
    private String author;
    private boolean status;
    private String desc;
    public Book(int bookID, String title, String author, String desc) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.status = true;
        this.desc = desc;
    }
    public Book() {
        this.bookID = -1;
        this.title = null;
        this.author = null;
        this.status = true;
        this.desc = null;
    }
    public void setBookID(int bookID) {
        this.bookID = bookID;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public int getBookID() { return bookID; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean getStatus() { return status; }
    public String getDesc() { return desc; }
}
