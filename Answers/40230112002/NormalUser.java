import java.text.SimpleDateFormat;
import java.util.Date;

public class NormalUser extends User  {
    private String regDate;

    public NormalUser(String regDate) {
        this.regDate = CurrentDateTime();
    }


    public String CurrentDateTime(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        System.out.println(formatter.format(date));
        return formatter.format(date);
    }
}
