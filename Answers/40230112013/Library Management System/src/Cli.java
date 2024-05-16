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
        System.out.println("7.del book\n8.get hours and capacity\n9.exit\n");
    }

    public static void userList() {
        System.out.println("*********************************\n");
        System.out.println("1.add book\n2.search books");
        System.out.println("3.rent book\n4.return book\n5.get hours and capacity\n6.exit\n");
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

    public static void bfind() {
        System.out.println("Please enter info from book:");
    }

    public static void gh() {
        System.out.println("Lotfan shomare vard konid");
    }

    public static User rgistr() {
        boolean xj = false;
        @SuppressWarnings("resource")
        Scanner s = new Scanner(System.in);
        String name = "";
        while (!xj) {
            System.out.println("please enter name:");
            name = s.nextLine();
            xj = !name.chars().anyMatch(ch -> !Character.isAlphabetic(ch));
        }
        String familyname = "";
        xj = false;
        while (!xj) {
            System.out.println("please enter family name:");
            familyname = s.nextLine();
            xj = !familyname.chars().anyMatch(ch -> !Character.isAlphabetic(ch));
        }
        xj = false;
        String pn = "";
        while (!xj) {
            System.out.println("please enter Phone number:");
            pn = s.nextLine();
            if (pn.length() ==11 && (pn.chars().anyMatch(ch -> !Character.isAlphabetic(ch)) && pn.charAt(0) == '0') )
                xj = true;
        }

        System.out.println("please enter password:");
        String pass = s.nextLine();
        xj = false;
        String lid = "";
        while (!xj) {
            xj = true;
            System.out.println("please enter Lib id:");
            lid = s.nextLine();
            for (User cj : Library.getuser()) {
                if (cj.getId().equals(lid)) {
                    System.out.println("vozod dard dobare lotfan");
                    xj = false;
                    break;
                }
            }
        }
        User x = new User(name, familyname, pn, lid, pass);
        return x;
    }

    public static User avardanuser() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        System.out.println("please enter name or id or phone number:");
        String userInfo = scanner.nextLine();
        System.out.println("Please Enter your password");
        String password = scanner.nextLine();
        List<User> users = Library.getuser();
        for (User user : users) {
            if ((user.getPassword().equals(password)) && (userInfo.equalsIgnoreCase(user.getName())
                    || userInfo.equalsIgnoreCase(user.getPhoneNumber()) || userInfo.equalsIgnoreCase(user.getId()))) {
                return user;
            }
        }
        return null;
    }

    public static void rentday() {
        System.out.println("How many days to rent?");
    }

    public static void getHours() {
        System.out.println("Library hours is 8 am to 6pm");
    }

    public static void getCapacity() {
        System.out.println("Library capacity is 100 members");
    }
}
