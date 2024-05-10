import java.util.Date;
import java.util.HashMap;

public class Rent extends Library {
    String bookObject, normaluserObject;
    long rentalDate;
    int RentalID;
    Date date = new Date();

    HashMap<String, String> rent = new HashMap<>();
    private int c = 1;

    public Rent(String book){
        this.bookObject = book;
        this.rentalDate = date.getTime();
        RentalID = c;
        c++;
    }

}
