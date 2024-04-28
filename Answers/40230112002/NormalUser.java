import java.text.SimpleDateFormat;
import java.util.Date;

public class NormalUser extends User  {
    private String regDate;

    public NormalUser(String name , int Unique_UserID , String Phone_Number) {
        super(name , Unique_UserID , Phone_Number);
        this.regDate = CurrentDateTime();
    }


    public String CurrentDateTime(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        System.out.println(formatter.format(date));
        return formatter.format(date);
    }
}
