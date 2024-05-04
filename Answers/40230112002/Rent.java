import java.util.*;

public class Rent {



    private User UserObject;
    private Book BookObject;
    private int RentalID;
    private Date RentalDate;
    private static int Unique_LogID = 0;


    public Rent(User UserObject , Book BookObject , Date RentalDate) {
        this.UserObject = UserObject;
        this.BookObject = BookObject;
        this.RentalDate = new Date();

    }

    public Book getBookObject() {
        return BookObject;
    }


    public User getUserObject() {
        return UserObject;
    }
    private static int generateUniqueLogID() {
        return ++Unique_LogID;
    }
}
