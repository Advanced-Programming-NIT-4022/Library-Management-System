// this class for simulates renting
import java.time.LocalDate;
import java.time.LocalTime;

public class Rent {
    private Book book;
    private NormalUser person;
    private String rentalID;
    private LocalDate rentalDate;
    private LocalTime rentalTime;

    public Rent(Book book, NormalUser person) {
        this.book = book;
        this.person = person;
        this.rentalDate = LocalDate.now();
        this.rentalTime = LocalTime.now();
        this.rentalID = CreateID();
    }

    private String CreateID() {
        String result = String.valueOf(rentalTime.getSecond());
        result += String.valueOf(rentalTime.getMinute());
        result += String.valueOf(rentalTime.getHour());
        result += String.valueOf(rentalDate.getDayOfYear());
        result += String.valueOf(rentalDate.getYear());
        return result;
    }

    public Book getBook() {
        return book;
    }

    public NormalUser getPerson() {
        return person;
    }

    public String getRentalID() {
        return rentalID;
    }

    public LocalDate getRentalDate() {
        return rentalDate;
    }

    public LocalTime getRentalTime() {
        return rentalTime;
    }
}