package basic.classes;

import java.util.ArrayList;
import java.util.Objects;

class Book {
    protected String title, author, description,book_id;
    protected boolean availability_status;

    public Book(String book_id, boolean availability_status) {
        this.book_id = book_id;
        this.availability_status = availability_status;
    }

}
