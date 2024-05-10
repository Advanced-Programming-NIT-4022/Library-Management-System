import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class NormalUser extends User
{
    DateTimeFormatter CUSTOM_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    final static LocalDateTime userdate = LocalDateTime.now();
    private String Userdate = userdate.format(CUSTOM_FORMATTER);
    //converting to a known format in form of String

    Boolean IsAdmin=false;

    public NormalUser(String name , int ID , int number , String Userdate)
    {
        super(name, ID, number);
        this.Userdate=Userdate;
    }
    public String gerUserDate()
    {
        return Userdate;
    }
}
