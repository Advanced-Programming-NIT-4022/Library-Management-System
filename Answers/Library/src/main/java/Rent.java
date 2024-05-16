import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.Period;
import java.util.UUID;

public class Rent implements Serializable {
    @Serial
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
        this.rentalDate = createRentalDate();
        this.returnDate = createReturnDate();
    }

    public String getRentalID() {
        return rentalID;
    }
    public Book getBook(){
        return book;
    }
    public User getUser(){
        return user;
    }

    public String getRentalDate() {
        return rentalDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public static String createRentalDate() {
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        return date.format(formatter);
    }
    public static String createReturnDate() {
        LocalDate date = LocalDate.now();
        Period period = Period.ofDays(21);
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
