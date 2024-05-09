import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Rent
{
    private Book book;
    private NormalUser normaluser;
    private int RentID=5000;
    DateTimeFormatter CUSTOM_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    final static LocalDateTime rentdate = LocalDateTime.now();
    private String Rentdate = rentdate.format(CUSTOM_FORMATTER);

    public Rent(Book book , NormalUser normaluser , int RentID , String Rentdate)
    {
        this.RentID=RentID++;
        this.book=book;
        this.normaluser=normaluser;
        this.Rentdate=Rentdate;
    }
    public Book getBook()
    {
        return book;
    }
    public NormalUser getNormaluser()
    {
        return normaluser;
    }
    public int getRentID()
    {
        return RentID;
    }
    public String getRentdate()
    {
        return Rentdate;
    }
}
