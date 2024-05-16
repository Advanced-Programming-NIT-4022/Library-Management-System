public class Rent {
    private int RentalID=1;
    private String RentalDate;
    private Book book;
    private NormalUser normalUser;
    public Rent (String RentalDate,Book book, NormalUser normalUser){
        this.RentalID=RentalID+1;
        this.RentalDate=RentalDate;
        this.book=book;
        this.normalUser=normalUser;
    }

    public int getRentalID() {
        return RentalID;
    }

    public Book getBook() {
        return book;
    }

    public String getRentalDate() {
        return RentalDate;
    }

    public NormalUser getNormalUser() {
        return normalUser;
    }
}
