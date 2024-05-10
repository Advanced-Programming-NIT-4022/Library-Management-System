import java.time.LocalDate;

public class Rent {
    private Book book;
    private User user;
    private LocalDate dueDate;

    public Rent(Book book, User user, int rentDays) {
        this.book = book;
        this.user = user;
        this.dueDate = LocalDate.now().plusDays(rentDays);
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
    public void printRentInfo() {
        System.out.println("ketab" + book.getTitle() + "\" from" + user.getName() + " date " + dueDate);
}
}
