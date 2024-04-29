import java.util.Date;

public class Rent {
    private Book BookObject;
    private User UserObject;
    private int RentalID;
    private Date RentalDate;
    public Rent (Book BookObject , User UserObject){
        this.BookObject = BookObject;
        this.UserObject = UserObject;
        this.RentalDate = new Date();
        this.RentalID = RentalID;
    }
    public int getRentalID(){

        return RentalID;
    }
    public Book BookObject(){

        return BookObject;
    }
    public User UserObject(){

        return UserObject;
    }
    public Date RentelDate(){

        return RentalDate;
    }
}
