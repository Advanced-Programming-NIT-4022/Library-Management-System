import java.util.Date;

public class Rent {
    private static int idCounter = 1;
    private int rentalID;
    private Book book;
    private NormalUser user;
    private Date rentalDate;

    public Rent(Book book, NormalUser user) {
        this.rentalID = idCounter++;
        this.book = book;
        this.user = user;
        this.rentalDate = new Date();
    }

    public int getRentalID() {
        return rentalID;
    }

    public Book getBook() {
        return book;
    }

    public NormalUser getUser() {
        return user;
    }

    public Date getRentalDate() {
        return rentalDate;
    }
}