import java.util.*;

public class Cli {
    public static void start() {
        System.out.println(
                "**********************\nHello to library\nWhat is your role?\n1.Admin\n2.Normaluser\n3.I want to register.\n4.exit");
    }

    public static void adps() {
        System.out.println("***********************\nPlease enter admins password");
    }

    public static void edame() {
        System.out.println("*****************************\nDo you want to continue\n1.yes\n2.no");
    }

    public static void adminList() {
        System.out.println("*********************************\n");
        System.out.println("1.add book\n2.see all books");
        System.out.println("3.see all users\n4.rent book");
        System.out.println("5.return book");
        System.out.println("6.del user");
        System.out.println("7.del book\n");
    }

    public static Book getBook() {
        
           @SuppressWarnings("resource")
        Scanner s = new Scanner(System.in);
            System.out.println("please enter title:");
            String title = s.nextLine();
            System.out.println("please enter author:");
            String author = s.nextLine();
            System.out.println("please enter description:");
            String description = s.nextLine();
            Book book = new Book(title, author, description);
            return book;
        }
}
