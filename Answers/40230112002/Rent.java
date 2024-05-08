import java.util.*;

public class Rent {

    private User UserObject;
    private Book BookObject;
    private int RentalID;
    private Date RentalDate;
    private int RentalLogID;
    private static int LastRentalLogID = 0;

    public Rent(User UserObject, Book BookObject, Date RentalDate) {

        this.UserObject = UserObject;
        this.BookObject = BookObject;
        this.RentalDate = new Date();
        this.RentalLogID = ++LastRentalLogID;

    }

    public Book getBookObject() {
        return BookObject;
    }


    public User getUserObject() {
        return UserObject;
    }
}
