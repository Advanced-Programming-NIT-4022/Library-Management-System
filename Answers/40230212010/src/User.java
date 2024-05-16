import java.util.*;

public class User {
    private static int count = 0;
    public static String name;
    private final String UniqueID;
    private String phoneNumber;
    
    public static  String password;

    public User(String name, String phoneNumber) {
        this.UniqueID = String.valueOf( ++count);
        this.phoneNumber = phoneNumber;

    }

    public String getUniqueID() {
        return UniqueID;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        User.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        User.password = password;
    }
    

}
