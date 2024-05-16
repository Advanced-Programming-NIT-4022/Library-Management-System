import java.time.LocalDate;

public class Rent {
    private static int count=0;
    private final String rentID ;
    private LocalDate rentalDate;
    private LocalDate dueDate; 
    
    private Book book;
    private User user;
    public Rent(String rentalID,LocalDate rentalDate,LocalDate dueDate, Book book, User user) {
        this.rentalDate = rentalDate;
        this.book = book;
        this.user = user;
        this.rentID=String.valueOf(++count);
    }
    public static int getCount() {
        return count;
    }
    public static void setCount(int count) {
        Rent.count = count;
    }
    public String getRentID() {
        return rentID;
    }
    public LocalDate getRentalDate() {
        return rentalDate;
    }
    public void setRentalDate(LocalDate rentalDate) {
        this.rentalDate = rentalDate;
    }
    public Book getBook() {
        return book;
    }
    public void setBook(Book book) {
        this.book = book;
    }
    public User getUser() {
        return user;
    }
    public void setUser(NormalUser user) {
        this.user = user;
    }
   
    

}
