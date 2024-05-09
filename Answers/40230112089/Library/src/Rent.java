import java.io.Serializable;
public class Rent implements Serializable{
    int rentId;
    Book book;
    User user;
    String rentDate;
    public Rent(int rentId , String rentDate , User user , Book book ){
        this.book = book;
        this.rentDate = rentDate;
        this.rentId = rentId;
        this.user = user;
    }
}
