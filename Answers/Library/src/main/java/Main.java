import java.util.Scanner;

public class Main {
    static Library library = new Library();
    static Scanner scanner = new Scanner(System.in);
    public static void CLI(){
            System.out.println("welcome to" + library.getLibName());
            System.out.println("Please write your choice:");
            System.out.println("lib::addBook::<Name>::<Author>::<subtitle>");
            System.out.println("lib::getHour");
            System.out.println("lib::rent::<BookName>");
            System.out.println("lib::addMember::<studentID>::<password>");
            System.out.println("lib::specificRent::<bookName>::<memberName>::<memberID>");
            System.out.println("lib::getAvailableBooks");
            System.out.println("lib::removeMember::<memberID>");
            System.out.println("lib::return::<bookName>");
            System.out.println("lib::addAdmin::<fullName>::<phoneNumber>::<newAdminPassword>");
            System.out.println("exit");
        String input;
        while (true) {
            input = scanner.nextLine();
            if ("exit".equalsIgnoreCase(input)) {
                System.out.println("Good bye :(");
                break;
            }
            processCommand(input);
        }
    }
    public static void processCommand(String command){
        String[] parts = command.split("::");
        String operation = parts[1];
        switch (operation.toLowerCase()){
            case "addbook":
                String name,author,description;
                System.out.println("enter name of book:");
                name = scanner.nextLine();
                System.out.println("enter name of author:");
                author = scanner.nextLine();
                System.out.println("write some description:");
                description = scanner.nextLine();
                library.addBook(name,author,description);
                break;
            case "gethour":
                System.out.println(library.getOperatinghours());
                break;
            case "rent":
                String bookname = scanner.nextLine();
                System.out.println("enter book name:");
                library.rentBook(bookname);
                break;
            case "addmember":
                System.out.println("enter users fullName: ");
                String fullName = scanner.nextLine();
                System.out.println("enter users phoneNumber: ");
                String phoneNumber = scanner.nextLine();
                library.addUser(fullName,phoneNumber);
                break;
            case "addadmin":
                System.out.println("enter admins fullName: ");
                String adminFullName = scanner.nextLine();
                System.out.println("enter admins phoneNumber: ");
                String adminPhoneNumber = scanner.nextLine();
                System.out.println("enter new admins password: ");
                String adminsPassword = scanner.nextLine();
                library.addAdmin(adminFullName,adminPhoneNumber,adminsPassword);
                break;
            case "specificrent":
                System.out.println("enter bookName:");
                String bookName =scanner.nextLine();
                System.out.println("enter members fullName:");
                String fullMemberName = scanner.nextLine();
                System.out.println("enter members ID:");
                String ID = scanner.nextLine();
                library.rentSpecificBook(bookName,fullMemberName,ID);
                break;
            case "getavailablebooks":
                library.getAvailableBooks();
                break;
            case "removemember":
                System.out.println("please enter member id:");
                String memberId = scanner.nextLine();
                library.removeUser(memberId);
                break;
            case "return":
                System.out.println("enter book name:");
                String BookName = scanner.nextLine();
                library.returnBook(BookName);
                break;
            default:
                System.out.println("Invalid input! Please try again.");

        }
    }
}
