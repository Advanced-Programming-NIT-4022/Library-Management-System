class Rent {
    // Attributes
    private final long rentID;
    private User user;
    private Book book;

    // Constructor
    public Rent(long rentID_a, User user_a, Book book_a) {
        rentID = rentID_a;
        user = user_a;
        book = book_a;
    }

    // Getter/Setter(s)
    public long getRentID() {
        return rentID;
    }

    public User getUser() {
        return user;
    }

    public Book getBook() {
        return book;
    }
}
