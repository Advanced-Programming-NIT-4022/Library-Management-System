import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.Period;
import java.util.UUID;

public class Rent implements Serializable {
    private static final long serialVersionUID = 1L;
    private Book book;
    private User user;
    private String rentalID;
    private String rentalDate;
    private String returnDate;
    public Rent(Book book,User user){
        this.book = book;
        this.user = user;
        this.rentalID = UUID.randomUUID().toString();
        this.rentalDate = getRentalDate();
        this.returnDate = getReturnDate();
    }
    public static String getRentalDate() {
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        return date.format(formatter);
    }
    public static String getReturnDate() {
        LocalDate date = LocalDate.now();
        Period period = Period.ofDays(20);
        LocalDate rentalDate = date.plus(period);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        return rentalDate.format(formatter);
    }

    @Override
    public String toString() {
        return "Rent{" +
                "BookName='" + book.getTitle() + '\'' +
                ", UserName='" + user.getFullName() + '\'' +
                ", userID='" + user.getID() + '\'' +
                ", rentalDate=" + rentalDate +
                ", returnDate=" + returnDate +
                ", rentalID=" + rentalID +
                '}';
    }

}
