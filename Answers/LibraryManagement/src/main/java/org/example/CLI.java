package org.example;

import java.util.Scanner;

public class CLI {
    private static Library library;

    public CLI(Library library) {
        this.library = library;
    }

    public static void start() {
        System.out.println("Type 'command' to see available commands.");

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                String input = scanner.nextLine().trim();
                if (input.equals("exit")) {
                    System.out.println("Exiting...");
                    return;
                } else {
                    perform(input);
                }
            }
        }
    }

    public static void perform(String input) {
        String[] parts = input.split(" ", 2);
        if (parts.length == 0) {
            System.out.println("Command not found.");
            return;
        }
        String command = parts[0].toLowerCase();
        String arguments = (parts.length > 1) ? parts[1] : "";

        switch (command) {
            case "lib":
                edame(arguments);
                break;
            case "exit":
                System.out.println("Exiting...");
                break;
            case "command":
                commands();
                break;
            default:
                System.out.println("Command not found. Type 'command' to see available commands.");
                break;
        }
    }

    public static void edame(String arguments) {
        String[] parts = arguments.split(" ", 2);
        if (parts.length == 0) {
            System.out.println("Command NOT FOUND. Type 'command' to see available commands.");
            return;
        }

        String subCommand = parts[0].toLowerCase();
        String subArguments = (parts.length > 1) ? parts[1] : "";
        switch (subCommand) {
            case "add":
                addBook(subArguments);
                break;
            case "get":
                handleGet(subArguments);
                break;
            case "rent":
                rentBook(subArguments);
                break;
            case "remove":
                removeMember(subArguments);
                break;
            case "return":
                returnBook(subArguments);
                break;
            default:
                System.out.println("Command not found. Type 'command' to see commands.");
                break;
        }
    }

    public static void addBook(String arguments) {
        String[] parts = arguments.split(" ", 3);
        if (parts.length < 3) {
            System.out.println("Invalid command format. Usage: lib add book <name> <author> <subtitle>");
            return;
        }
        String name = parts[0];
        String author = parts[1];
        String subtitle = (parts.length > 2) ? parts[2] : "";
        library.addbook(new Book(name, author, subtitle));
        System.out.println("Book added successfully.");
    }

    public static void handleGet(String arguments) {
        if (arguments.equalsIgnoreCase("hrs")) {
            System.out.println("Operating hours: " + library.getOperatingHours());
        } else {
            System.out.println(library.getbookRepository());
        }
    }

    public static void rentBook(String arguments) {
        String[] parts = arguments.split(" ", 3);
        if (parts.length < 3) {
            System.out.println("Invalid command format.");
            return;
        }
        String bookName = parts[0];
        String memberName = parts[1];
        String memberID = parts[2];
        library.rentbook(bookName, memberName, memberID);
        System.out.println("Book rented successfully.");
    }

    public static void removeMember(String arguments) {
        if (arguments.isEmpty()) {
            System.out.println("Invalid command format.");
            return;
        }
        library.removeuser(arguments);
        System.out.println("Member removed successfully.");
    }

    public static void returnBook(String arguments) {
        if (arguments.isEmpty()) {
            System.out.println("Invalid command format.");
            return;
        }
        library.returnbook(arguments);
        System.out.println("Book returned successfully.");
    }

    public static void commands() {
        System.out.println("Choose a command:");
        System.out.println("lib add book <name> <author> <subtitle>: Add a new book to the library.");
        System.out.println("lib get hrs: Retrieve library operating hours.");
        System.out.println("lib rent <bookName>: Rent a book from the library.");
        System.out.println("lib add member <studentID> <password>: Add a new member to the library (admin privilege required).");
        System.out.println("lib rent <bookName> <memberName> <memberID>: Rent a book for a specific member.");
        System.out.println("lib get available books: See available books for rental.");
        System.out.println("lib remove member <memberID>: Remove a member from the library (admin privilege required).");
        System.out.println("lib return <bookName>: Return a rented book to the library.");
        System.out.println("Exit: Exit the program.");
    }
}
