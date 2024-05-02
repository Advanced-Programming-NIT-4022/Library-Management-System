import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        User user = new User("Sadra" , "3984579235");

        User useruser = new User("name" , "number");

        User user1 = new NormalUser("solda" , "83479475");

        User user2 = new Admin("Gar" , "r37478df");
        System.out.println(user2.toString());
        System.out.println(user.toString());
        System.out.println(useruser.toString());
        System.out.println(user1.toString());
//        Book book = new Book("kjsdgn" ,"kjdfgh" , "dskfghjdshg");
//        Book book1 = new Book("ex" , "xe" , "not");
//
//        System.out.println(book.toString());
//        System.out.println(book1.toString());

    }
}
