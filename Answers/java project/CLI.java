import java.util.List;
import java.util.Scanner;

public class CLI {
    private static Library library = new Library("City Library", 1000, "9 AM - 5 PM");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter command: ");
            String command = scanner.nextLine();
            processCommand(command);
        }
    }

    private static void processCommand(String command) {
        String[] parts = command.split(" ");
        switch (parts[0]) {
            case "lib":
                handleLibraryCommand(parts);
                break;
            default:
                System.out.println("Unknown command");
        }
    }

    private static void handleLibraryCommand(String[] parts) {
        switch (parts[1]) {
            case "add":
                if (parts[2].equals("book")) {
                    String title = parts[3];
                    String author = parts[4];
                    String description = parts[5];
                    library.addBook(title, author, description);
                    System.out.println("Book added successfully");
                } else if (parts[2].equals("member")) {
                    String name = parts[3];
                    String phone = parts[4];
                    String password = parts[5];
                    library.addUser(new Admin(name, phone, password));
                    System.out.println("Member added successfully");
                }
                break;
            case "get":
                if (parts[2].equals("hrs")) {
                    System.out.println("Library operating hours: " + library.getOperatingHours());
                } else if (parts[2].equals("available") && parts[3].equals("books")) {
                    List< Book> availableBooks = library.getAvailableBooks();
                    for (Book book : availableBooks) {
                        System.out.println(book.getTitle() + " by " + book.getAuthor());
                    }
                }
                break;
            case "rent":
                int bookID = Integer.parseInt(parts[2]);
                int userID = Integer.parseInt(parts[3]);
                library.rentBook(bookID, userID);
                System.out.println("Book rented successfully");
                break;
            case "return":
                bookID = Integer.parseInt(parts[2]);
                library.returnBook(bookID);
                System.out.println("Book returned successfully");
                break;
            case "remove":
                if (parts[2].equals("member")) {
                    userID = Integer.parseInt(parts[3]);
                    library.removeUser(userID);
                    System.out.println("Member removed successfully");
                }
                break;
            default:
                System.out.println("Unknown library command");
        }
    }
}