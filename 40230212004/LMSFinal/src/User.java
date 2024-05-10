import java.time.LocalDateTime;
import java.util.HashMap;

public class User {
    public static HashMap<Integer,String> userID_NameList = new HashMap<>();
    public static HashMap<Integer,String> userID_PhoneNum = new HashMap<>();
    public static HashMap<Integer, LocalDateTime> userID_date = new HashMap<>();
    public void view_Users() {
        System.out.println("Users :");
        System.out.println("Name | phone number | date");
        System.out.println("--------------------------");
        for (int id : userID_NameList.keySet()) {
            System.out.println(userID_NameList.get(id) + " | " + userID_PhoneNum.get(id) + " | " + userID_date.get(id));
            System.out.println("--------------------------");
        }
    }
}
