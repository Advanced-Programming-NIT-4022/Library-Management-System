import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Scanner;

public class Admin {
    public static HashMap<Integer,String> userID_NameList = new HashMap<>();
    public static HashMap<Integer,String> userID_PhoneNum = new HashMap<>();
    public static HashMap<Integer, LocalDateTime> userID_date = new HashMap<>();
    private HashMap<Integer, String> adminID_password = new HashMap<>();

    public void setAdminID_password(int id, String password) {
        if (adminID_password.containsKey(id)) {
            adminID_password.replace(id, password);
        } else {
            adminID_password.put(id, password);
        }
    }

    public void delete_password(int userID) {
        adminID_password.remove(userID);
    }

    public int sign_in_admin() {
        Scanner sc = new Scanner(System.in);
        Scanner bc = new Scanner(System.in);
        String password = "";
        int id = 0;
        do {
            try {
                System.out.println("Please enter your ID :");
                id = sc.nextInt();
                System.out.println("Please enter your password :");
                password = bc.nextLine();
            } catch (Exception e) {
                System.out.println("Please enter your ID and password correctly.");
            }
        } while (!adminID_password.containsKey(id) || !adminID_password.containsValue(password) || !password.equals(adminID_password.get(id)));
        System.out.println("You signed in successfully.");
        System.out.println("You have signed up successfully");
        System.out.println("ID | Name | Phone number | Date");
        System.out.println(id + " | " + userID_NameList.get(id) + " | " + userID_PhoneNum.get(id) + " | " + userID_date.get(id));
        return id;
    }

    public void firstPassword() {
        adminID_password.put(1000, "password!");
    }
}
