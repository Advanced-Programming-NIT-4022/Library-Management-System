package com.library;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        String command;
        do {
            System.out.print("> ");
            command = scanner.nextLine();
            processCommand(library, scanner, command);
        } while (!command.equals("exit"));

        scanner.close();
        System.out.println("Library management system closed.");
    }

    private static void processCommand(Library library, Scanner scanner, String command) {
        String[] parts = command.split(" ");

        switch (parts[0]) {
            case "lib":
                if (parts.length < 2) {
                    System.out.println("Invalid command. Use 'lib help' for details.");
                    break;
                }

                switch (parts[1]) {
                    case "add":
                        if (parts.length < 4) {
                            System.out.println("Invalid command. Use 'lib help add book' for details.");
                        } else {
                            String name = parts[2];
                            String author = parts[3];
                            String subtitle = parts.length > 4 ? parts[4] : "";
                            library.addBook(new Book(name, author, subtitle));
                            System.out.println("Book added successfully.");
                        }
                        break;
                    case "get":
                        if (parts.length < 2) {
                            System.out.println("Invalid command. Use 'lib help' for details.");
                        } else {
                            switch (parts[2]) {
                                case "hrs":
                                    System.out.println("Library operating hours: [Enter library hours here]");
                                    break;
                                case "available":
                                    if (parts.length > 3 && parts[3].equals("books")) {
                                        library.displayAvailableBooks();
                                    } else {
                                        System.out.println("Invalid command. Use 'lib get available books' for details.");
                                    }
                                    break;
                                default:
                                    System.out.println("Invalid command. Use 'lib help' for details.");
                            }
                        }
                        break;
                    case "rent":
                        if (parts.length < 3) {
                            System.out.println("Invalid command. Use 'lib help rent' for details.");
                        } else {
                            String bookName = parts[2];
                            if (parts.length > 4) {
                                String memberName = parts[3];
                                int memberID = tryParseInt(parts[4]);
                                library.rentBook(memberName, memberID, bookName);
                            } else {
                                library.rentBook(scanner, bookName);
                            }
                        }
                        break;
                    case "remove":
                        if (parts.length < 3) {
                            System.out.println("Invalid command. Use 'lib help remove member' for details.");
                        } else {
                            int memberID = tryParseInt(parts[2]);
                            library.removeUser(memberID);
                            System.out.println("Member removed successfully.");
                        }
                        break;
                    case "return":
                        if (parts.length < 3) {
                            System.out.println("Invalid command. Use 'lib help return' for details.");
                        } else {
                            String bookName = parts[2];
                            library.returnBook(scanner, bookName);
                        }
                        break;
                    case "help":
                        if (parts.length > 2) {
                            System.out.println("Invalid command. Use 'lib help' for a list of commands.");
                        } else {
                            System.out.println("Available commands:");
                            System.out.println("  lib add book <name> <author> [subtitle]: Add a new book to the library.");
                            System.out.println("  lib get hrs: Retrieve library operating hours.");
                            System.out.println("  lib rent <bookName>: Rent a book from the library (for current user).");
                            System.out.println("  lib rent <bookName> <memberName> <memberID>: Rent a book for a specific member (admin privilege required).");
                            System.out.println("  lib get available books: View available books for rental.");
                            System.out.println("  lib add member <studentID> <password>: Add a new member to the library (admin privilege required).");
                            System.out.println("  lib remove member <memberID>: Remove a member from the library (admin privilege required).");
                            System.out.println("  lib return <bookName>: Return a rented book to the library.");
                            System.out.println("  lib help: Display this help message.");
                            System.out.println("  exit: Exit the library management system.");
                        }
                        break;
                    default:
                        System.out.println("Invalid command. Use 'lib help' for details.");
                }
                break;
            case "exit":
                break;
            default:
                System.out.println("Invalid command. Use 'lib help' for details.");
        }
    }

    private static int tryParseInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input for integer value.");
            return -1; 
        }
    }
}




