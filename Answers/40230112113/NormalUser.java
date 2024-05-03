import java.time.LocalDateTime;

public class NormalUser extends User
{
    LocalDateTime date = LocalDateTime.now();

    public NormalUser(String name , int ID , int number , LocalDateTime date)
    {
        super(name, ID, number);
        this.date=date;
    }
}
