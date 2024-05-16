import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
            Scanner scanner = new Scanner(System.in);
        Library library = new Library("Main Library", 1000, "9am to 5pm");
        User user = new User("mmd","902");

        System.out.println("Welcome to " + library.getName() + "!");
        System.out.println("Current capacity: " + library.getCapacity());
        System.out.println("Operating hours: " + library.getOperatingHours());

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add book");
            System.out.println("2. Get hours");
            System.out.println("3. Rent book");
            System.out.println("4. Add member");
            System.out.println("5. Remove member");
            System.out.println("6. Return book");
            System.out.println("7. Get available books");
            System.out.println("8. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter book description: ");
                    String description = scanner.nextLine();
                    library.addBook(title, author, description);
                    System.out.println("Book added successfully.");
                    break;
                case 2:
                    System.out.println("Operating hours: " + library.getOperatingHours());
                    break;
                case 3:
                    System.out.print("Enter book name: ");
                    String bookName = scanner.nextLine();
                    System.out.print("Enter student ID: ");
                    int UniqueID = scanner.nextInt();
                    NormalUser users = user.getNormalUser(UniqueID);
                    if (user == null) {
                        System.out.println("User not found.");
                    } else {
                        library.rentBook(bookName, user);
                    }
                    break;
                case 4:
                    System.out.print("Enter student ID: ");
                    UniqueID = scanner.nextInt();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    Admin admin = user.getAdmin(password);
                    if (admin == null) {
                        System.out.println("Invalid password.");
                    } else {
                        System.out.print("Enter new member name: ");
                        String newName = scanner.nextLine();
                        System.out.print("Enter new member phone number: ");
                        String phoneNumber = scanner.nextLine();
                        library.addNormalUser(newName, UniqueID, phoneNumber);
                        System.out.println("New member added successfully.");
                    }
                    break;
                case 5:
                    System.out.print("Enter member ID: ");
                    String memberID = scanner.nextLine();
                    library.removeUser(memberID);
                    System.out.println("Member removed successfully.");
                    break;
                case 6:
                    System.out.print("Enter book name: ");
                    bookName = scanner.nextLine();
                    library.returnBook(bookName);
                    break;
                case 7:
                    List<Book> availableBooks = library.getAvailableBooks();
                    if (availableBooks.isEmpty()) {
                        System.out.println("No books available.");
                    } else {
                        System.out.println("Available books:");
                        for (Book book : availableBooks) {
                            System.out.println("- " + book.getTitle() + " by " + book.getAuthor());
                        }
                    }
                    break;
                case 8:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    
    }
}
