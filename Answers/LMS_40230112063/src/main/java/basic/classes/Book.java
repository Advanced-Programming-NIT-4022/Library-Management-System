package basic.classes;

class Book {
    protected String title, author, description, book_id;
    protected boolean availability_status;

    public Book(Integer book_id, boolean availability_status) {
        this.book_id = book_id.toString();
        this.availability_status = availability_status;
    }
}
