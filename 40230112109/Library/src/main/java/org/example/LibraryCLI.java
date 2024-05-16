package org.example;

import java.util.List;
import java.util.Scanner;
public class LibraryCLI {
    private Library library;

    public LibraryCLI(Library library) {
        this.library = library;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("\nEnter command:(Write \"help\" to see all commands.) ");
            String command = scanner.nextLine();
            String[] parts = command.split(" ");

            if (parts.length == 0) {
                continue; // Skip empty lines
            }

            String action = parts[0].toLowerCase();

            if ("help".equalsIgnoreCase(action)) {
                printHelpCommands();
                continue;
            }

            if ("add book".equalsIgnoreCase(action)) {
                if (parts.length != 4) {
                    System.out.println("Usage: lib add book <title> <author> [<description>]");
                    continue;
                }
                String title = parts[1];
                String author = parts[2];
                String description = parts.length > 3 ? parts[3] : "";
                library.addBook(new Book(title, author, description));
            } else if ("get hrs".equalsIgnoreCase(action)) {
                System.out.println("Library operating hours are 9 AM - 5 PM.");
            } else if ("rent".equalsIgnoreCase(action)) {
                if (parts.length != 2) {
                    System.out.println("Usage: lib rent <bookTitle>");
                    continue;
                }
                String bookTitle = parts[1];
                Book book = library.findBookById(bookTitle);
                if (book != null && book.isAvailability()) {
                    // Assuming there's a way to find the user by name or ID
                    User user = library.findUserByNameOrId(parts[2]); // Placeholder method
                    if (user != null) {
                        library.rentBook(String.valueOf(book), user);
                    } else {
                        System.out.println("User not found.");
                    }
                } else {
                    System.out.println("Book not available or not found.");
                }
            } else if ("add member".equalsIgnoreCase(action)) {
                if (parts.length != 3) {
                    System.out.println("Usage: lib add member <id> <password>");
                    continue;
                }
                String id = parts[1];
                String password = parts[2];
                library.addUser(new Admins("Admin", id, "", password)); // Simplified for demonstration
            } else if ("rent for member".equalsIgnoreCase(action)) {
                if (parts.length != 4) {
                    System.out.println("Usage: lib rent <bookTitle> <memberName> <memberID>");
                    continue;
                }
                String bookTitle = parts[1];
                String memberName = parts[2];
                String memberID = parts[3];
                // Similar to "rent" but finds the member by name or ID
            } else if ("get available books".equalsIgnoreCase(action)) {
                List<Book> availableBooks = library.getAvailableBooks();
                System.out.println("Available books:");
                for (Book book : availableBooks) {
                    System.out.println(book.getTitle());
                }
            } else if ("remove member".equalsIgnoreCase(action)) {
                if (parts.length != 2) {
                    System.out.println("Usage: lib remove member <id>");
                    continue;
                }
                String id = parts[1];
                // Find and remove the member
            } else if ("return".equalsIgnoreCase(action)) {
                if (parts.length != 2) {
                    System.out.println("Usage: lib return <bookTitle>");
                    continue;
                }
                String bookTitle = parts[1];
                library.returnBook(bookTitle);
            } else {
                System.out.println("Unknown command.");
            }
        }
    }
    private void printHelpCommands() {
        System.out.println("\nAvailable Commands:");
        System.out.println("1. Add a book: lib add book <title> <author> [<description>]");
        System.out.println("2. Get library hours: lib get hrs");
        System.out.println("3. Rent a book: lib rent <bookTitle>");
        System.out.println("4. Add a member: lib add member <id> <password>");
        System.out.println("5. Rent a book for a member: lib rent <bookTitle> <memberName> <memberID>");
        System.out.println("6. Get available books: lib get available books");
        System.out.println("7. Remove a member: lib remove member <id>");
        System.out.println("8. Return a book: lib return <bookTitle>");
        System.out.println("Type 'help' anytime for this list of commands.");
    }
}