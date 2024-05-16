import java.lang.reflect.Array;
import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library("Main Library", 1000, "9am to 5pm");

        System.out.println("Welcome to " + library.getName() + "!");
        System.out.println("Current capacity: " + library.getCapacity());
        System.out.println("Operating hours: " + library.getOperatingHours());
        User user = new User(null, null);
        boolean exit = false;
        boolean exit2 = false;
        boolean exit3 = false;

        while (!exit3) {
            while (!exit) {
                System.out.println("Choose your role:");
                System.out.println("1. Admin");
                System.out.println("2. Normal User");
                System.out.println("3. Register");
                System.out.println("4. exit.");
                int choice2 = Integer.parseInt(scanner.nextLine());
                switch (choice2) {
                    case 1:
                        System.out.println("Enter Password:");
                        String password = scanner.nextLine();
                        if (password.equals(Admin.password)) {
                            exit = true;
                        } else {
                            System.out.println("Wrong Password!");
                        }
                        break;
                    case 2:
                        System.out.println("Enter your name:");
                        String name = scanner.nextLine();
                        System.out.println("Enter Password:");
                        String pass2 = scanner.nextLine();
                        if (name.equals(User.name)) {
                            if (pass2.equals(User.password)) {
                                exit = true;
                            }
                        }
                        break;
                    case 3:
                        System.out.println("Enter your name:");
                        String name1 = scanner.nextLine();
                        System.out.println("Enter your Phone Number:");
                        String phoneNumber = scanner.nextLine();
                        System.out.println("Enter Password:");
                        String password3 = scanner.nextLine();
                        user = new User(name1, phoneNumber);
                        User.password = password3;
                        exit = true;
                        break;
                    case 4:
                        System.out.println("thank you...");
                        exit3=true;
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice.");
                        break;
                }

            }
            exit=false;

            while (!exit2) {

                System.out.println("\nChoose an option:");
                System.out.println("1. Add book");
                System.out.println("2. Get hours");
                System.out.println("3. Rent book");
                System.out.println("4. Add member");
                System.out.println("5. Remove member");
                System.out.println("6. Return book");
                System.out.println("7. Get available books");
                System.out.println("8. Back to main menu.");

                int choice = scanner.nextInt();
                scanner.nextLine();

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
                        String UniqueID = scanner.nextLine();
                        library.rentBook(bookName, user);
                        // NormalUser users = library.getNormalUser(UniqueID);
                        // if (user == null) {
                        // System.out.println("User not found.");
                        // } else {
                        // library.rentBook(bookName, user);
                        // }
                        break;
                    case 4:
                        System.out.print("Enter Admin Name: ");
                        UniqueID = scanner.nextLine();
                        System.out.print("Enter password: ");
                        String passwordd = scanner.nextLine();

                        if (passwordd == Admin.password) {
                            System.out.print("Enter new member name: ");
                            String newName = scanner.nextLine();
                            System.out.print("Enter new member phone number: ");
                            String phoneNumber = scanner.nextLine();
                            library.addNormalUser(newName, UniqueID, phoneNumber);
                            System.out.println("New member added successfully.");
                        } else {

                            System.out.println("Invalid password.");
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
                        String bookToReturnName = scanner.nextLine();
                        Book booktoReturn = library.findBookByName(bookToReturnName);
                        library.returnBook(user, booktoReturn);
                        break;
                    case 7:
                        ArrayList<Book> availableBooks = library.getAvailableBooks();
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
                        exit2 = true;
                        break;
                    default:
                        System.out.println("Invalid choice..");
                }

            }
            exit2=false;


        }

    }
}
