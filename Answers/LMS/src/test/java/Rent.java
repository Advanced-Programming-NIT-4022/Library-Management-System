import java.util.Date;

public class Rent {
    private Book BookObject;
    private User UserObject;
    private int RentalID;
    private Date RentalDate;
    public Rent (Book BookObject , User UserObject , int RentalID , Date RentalDate){
        this.BookObject = BookObject;
        this.UserObject = UserObject;
        this.RentalDate = new Date();
        this.RentalID = RentalID;
    }
    public int getRentalID(){

        return RentalID;
    }
    public Book getBookObject(){

        return BookObject;
    }
    public User getUserObject(){

        return UserObject;
    }
    public Date getRentelDate(){

        return RentalDate;
    }
}
