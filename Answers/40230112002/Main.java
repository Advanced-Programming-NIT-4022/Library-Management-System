import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        User user = new User("Sadra" , "3984579235");
        System.out.println(user.toString());
        NormalUser user1 = new NormalUser("solda" , "83479475");
        System.out.println(user1.toString());
        Admin user2 = new Admin("Gar" , "r37478df");
        System.out.println(user2.toString());

        Book book = new Book("kjsdgn" ,"kjdfgh" , "dskfghjdshg");

    }
}
