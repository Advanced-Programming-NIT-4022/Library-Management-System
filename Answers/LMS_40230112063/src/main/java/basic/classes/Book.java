package basic.classes;

class Book {
    protected int book_id;
    protected String title, author, description;
    protected boolean availability_status;

    public Book(int book_id, boolean availability_status) {
        this.book_id = book_id;
        this.availability_status = availability_status;
    }
}
