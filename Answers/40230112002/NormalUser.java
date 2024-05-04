
import java.util.Date;

public class NormalUser extends User {

    private static final String RegisterDate = CurrentDateTime();
    private int UserID;
    private static int lastNormalUserID = LastUserID;
    public NormalUser(String name , String phoneNumber){
        super(name , phoneNumber);
        this.UserID = ++lastNormalUserID;
    }


    public static String CurrentDateTime(){
        Date date = new Date();
        return String.valueOf(date);
    }


    public String toString(){
        return super.toString() +" " + RegisterDate;
    }
}
