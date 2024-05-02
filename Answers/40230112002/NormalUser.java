
import java.util.Date;

public class NormalUser extends User {

    private static final String RegisterDate = CurrentDateTime();
    private int userID;

    public NormalUser(String name , String phoneNumber){
        super(name , phoneNumber);
        this.userID = getUserID();
    }


    public static String CurrentDateTime(){
        Date date = new Date();
        return String.valueOf(date);
    }


    public String toString(){
        return super.toString() +" " + RegisterDate;
    }
}
