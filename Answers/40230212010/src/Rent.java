public class Rent {
    private static int count=0;
    private final int rentID ;
    private String rentalDate;
    private Book book;
    private NormalUser user;
    public Rent(String rentalDate, Book book, NormalUser user) {
        this.rentalDate = rentalDate;
        this.book = book;
        this.user = user;
        this.rentID=++count;
    }
    

}
