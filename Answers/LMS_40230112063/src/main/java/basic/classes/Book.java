package basic.classes;

import java.sql.*;
import java.util.ArrayList;


class Book {
    protected String title, author, description, book_id;
    protected boolean availability_status;

    public Book(String title, String author, String description, String book_id, boolean availability_status) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.book_id = book_id;
        this.availability_status = availability_status;
    }

}
