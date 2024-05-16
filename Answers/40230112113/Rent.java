import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Rent
{
    private Book book;
    private NormalUser normaluser;
    private int RentID;
    
    private String Rentdate;

    public Rent(Book book , NormalUser normaluser , int RentID)
    {
        this.RentID=RentID;
        this.setBook(book);
        this.setNormaluser(normaluser);
        
        DateTimeFormatter CUSTOM_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime rentdate = LocalDateTime.now();

        this.Rentdate = rentdate.format(CUSTOM_FORMATTER);
    }
    public Book getBook()
    {
        return book;
    }
    public void setBook(Book book)
    {
        this.book=book;
    }
    public NormalUser getNormaluser()
    {
        return normaluser;
    }
    public void setNormaluser(NormalUser normaluser)
    {
        this.normaluser=normaluser;
    }
    public int getRentID()
    {
        return RentID;
    }
    public String getRentdate()
    {
        return Rentdate;
    }

    /*public String toString()
    {
        return RentID+Rentdate;
    }*/
}
