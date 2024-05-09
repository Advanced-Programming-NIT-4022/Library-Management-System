package com.Library;
import java.util.UUID;

public class Book {
    private String bookID;
    private String title;
    private String author;
    private boolean exist;
    private String description;
    public Book(){}//برای ساخت object بدون نیاز به اطلاعات قبلی
    public Book(String title,String author,String description){
        this.title = title;
        this.author = author;
        this.exist = true;
        this.description = description;
        this.bookID = String.valueOf(BookID());// این متد مقدار را به رشته تبدیل میکند
    }
// برای گرفتن مقادیر ازgetter
// برای تغیر ویژگی ها از setter
public String getBookID(){
        return bookID;
}
public String getTitle(){
        return title;
}
    public String getAuthor() {
        return author;
    }
    public String getDescription() {
        return description;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public boolean isExist() {
        return exist;
    }

    public void setExist(boolean exist) {
        this.exist = exist;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public UUID BookID() {
        return UUID.randomUUID(); //  تولید یک ID یکتا به صورت تصادفی

    }
}

