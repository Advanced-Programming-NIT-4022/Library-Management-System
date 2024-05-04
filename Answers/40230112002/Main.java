import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        User user = new User("sadra" , "46453");
        User user1 = new User("ldkg" , "03954");
        NormalUser user2 = new NormalUser("sol" , "65654");
        Admin admin = new Admin("dfjl" , "5854" , "dihfgiods");
        Admin admin1 = new Admin("lks" , "23423" , "kjdffgh");

        System.out.println(user.toString());
        System.out.println(user1.toString());
        System.out.println(user2.toString());
        System.out.println(admin1.toString());
        System.out.println(admin.toString());
    }
}
