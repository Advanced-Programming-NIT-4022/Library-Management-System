package basic.classes;

import java.util.ArrayList;
import java.util.Objects;

class Book {
    protected String title, author, description;
    protected boolean availability_status;
    protected Integer book_id;

    public Book(Integer book_id, boolean availability_status) {
        this.book_id = book_id;
        this.availability_status = availability_status;
    }

}
