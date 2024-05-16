import java.util.Scanner;
public class MyApp {
    static Library library = new Library();
    static Scanner scanner = new Scanner(System.in);
    public static void start(){
        if (library.isAdminEmpty())
            library.addAdmin("Arshia mohammadzade","09031241172","1384");
        getROLE();
    }

    public static void getROLE(){
        String role;
        while (true){
            System.out.println("Please write your role:");
            System.out.println("lib::Admin::<fullName>::<ID>::<password>");
            System.out.println("lib::User::<fullName>::<ID>");
            System.out.println("Exit");
            role =scanner.nextLine();
            if (role.equalsIgnoreCase("exit")){
                System.out.println("exiting program...");
                break;
            }
            roleCommand(role);
        }
    }
    public static void roleCommand(String command){
        String[] parts = command.split("::");
        String operation = parts[1];
        switch (operation.toLowerCase()){
            case "admin" :
                if (library.checkAdmin(parts[2],parts[3],parts[4])){
                    AdminsMainMenu();
                }else {
                    System.out.println("wrong information!");
                }
                break;
            case "user" :
                if (library.checkUser(parts[2],parts[3])) {
                    UsersMainMenu();
                }else {
                    System.out.println("wrong information!");
                }
                break;
            default:
                System.out.println("invalid input! please try again.");
        }
    }
    public static void UsersMainMenu(){
        System.out.println("Welcome to" + library.getLibName());
        String input;
        while (true) {
            System.out.println("Please write your operation:");
            System.out.println("lib::getHour");
            System.out.println("lib::rent::<BookName>");
            System.out.println("lib::specificRent::<bookName>::<memberName>::<memberID>");
            System.out.println("lib::getAvailableBooks");
            System.out.println("lib::return::<bookName>");
            System.out.println("back");
            input = scanner.nextLine();
            if ("back".equalsIgnoreCase(input)) {
                break;
            }
            UserprocessCommand(input);
        }
    }
    public static void UserprocessCommand(String command){
        String[] parts = command.split("::");
        String operation = parts[1];
        switch (operation.toLowerCase()){
            case "gethour":
                System.out.println(library.getOperatinghours());
                break;
            case "rent":
                library.rentBook(parts[2]);
                break;
            case "specificrent":
                library.rentSpecificBook(parts[2],parts[3],parts[4]);
                break;
            case "getavailablebooks":
                library.getAvailableBooks();
                break;
            case "return":
                library.returnBook(parts[2]);
                break;
            default:
                System.out.println("Invalid input! Please try again.");

        }
    }
    public static void AdminsMainMenu(){
        System.out.println("Welcome to" + library.getLibName());
        String input;
        while (true) {
            System.out.println("Please write your operation:");
            System.out.println("lib::addBook::<Title>::<Author>::<Description>");
            System.out.println("lib::getHour");
            System.out.println("lib::rent::<BookName>");
            System.out.println("lib::addMember::<fullName>::<phoneNumber>");
            System.out.println("lib::specificRent::<bookName>::<memberName>::<memberID>");
            System.out.println("lib::getAvailableBooks");
            System.out.println("lib::removeMember::<memberID>");
            System.out.println("lib::return::<bookName>");
            System.out.println("lib::showRents");
            System.out.println("lib::showUsers");
            System.out.println("lib::showAdmins");
            System.out.println("back");
            input = scanner.nextLine();
            if ("back".equalsIgnoreCase(input)) {
                break;
            }
            AdminsProcessCommand(input);
        }
    }
    public static void AdminsProcessCommand(String command){
        String[] parts = command.split("::");
        String operation = parts[1];
        switch (operation.toLowerCase()){
            case "addbook":
                library.addBook(parts[2],parts[3],parts[4]);
                break;
            case "gethour":
                System.out.println(library.getOperatinghours());
                break;
            case "rent":
                library.rentBook(parts[2]);
                break;
            case "addmember":
                library.addUser(parts[2],parts[3]);
                break;
            case "specificrent":
                library.rentSpecificBook(parts[2],parts[3],parts[4]);
                break;
            case "getavailablebooks":
                library.getAvailableBooks();
                break;
            case "removemember":
                library.removeUser(parts[2]);
                break;
            case "return":
                library.returnBook(parts[2]);
                break;
            case "showrents":
                library.showRents();
                break;
            case "showusers":
                library.showUsers();
                break;
            case "showAdmins":
                library.showAdmins();
                break;
            default:
                System.out.println("Invalid input! Please try again.");

        }
    }
}
