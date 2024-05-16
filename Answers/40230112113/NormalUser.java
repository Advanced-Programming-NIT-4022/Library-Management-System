import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class NormalUser extends User
{
    private String Userdate;
    //converting to a known format in form of String

    public NormalUser(String name , int ID , String number)
    {
        super(name, ID, number);
        DateTimeFormatter CUSTOM_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime userdate = LocalDateTime.now();
        this.Userdate=userdate.format(CUSTOM_FORMATTER);
    }
    public String getUserDate()
    {
        return Userdate;
    }
}
