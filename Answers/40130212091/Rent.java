import java.util.Date;
import java.util.HashMap;

public class Rent extends Library {
    private NormalUser normalUserObject;
    private Book bookObject;
    private long rentalDate;
    private int RentalID;
    Date date = new Date();

    HashMap<String, String> rent = new HashMap<>();
    private int c = 1;

    public Rent(NormalUser normalUser, Book book){
        this.normalUserObject = normalUser;
        this.bookObject = book;
        this.rentalDate = date.getTime();
        RentalID = ++c;
    }

    public User getnormalUserObject(){
        return normalUserObject;
    }

    public Book getBookObject(){
        return bookObject;
    }

}
