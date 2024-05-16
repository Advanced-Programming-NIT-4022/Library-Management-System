import java.util.Date;
class Rent {
    private Book book;
    private NormalUser normalUser;
    private int rentalID;
    private Date rentalDate;
    public Rent(Book book, NormalUser normalUser, int rentalID, Date rentalDate) {
        this.book = book;
        this.normalUser = normalUser;
        this.rentalID = rentalID;
        this.rentalDate = rentalDate;
    }

}
