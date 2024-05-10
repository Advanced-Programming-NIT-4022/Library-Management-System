package org.example;

import java.util.Scanner;

public class CLI {
    private static Library library;
    public CLI(Library library) {
        this.library = library;
    }
    private static void pcommand() {
        System.out.println("commands are:");
        System.out.println("lib add book <name> <author> <subtitle>: Add a new book to the library.");
        System.out.println("lib get hrs: Retrieve library operating hours.");
        System.out.println("lib rent <bookName>: Rent a book from the library.");
        System.out.println("lib add member <studentID> <password>: Add a new member to the library (admin privilege required).");
        System.out.println("lib rent <bookName> <memberName> <memberID>: Rent a book for a specific member.");
        System.out.println("lib get available books: View available books for rental.");
        System.out.println("lib remove member <memberID>: Remove a member from the library (admin privilege required).");
        System.out.println("lib return <bookName>: Return a rented book to the library.");
        System.out.println("Exit; to exit.");
    }

    private static void Perform(String input) {
        String[] parts = input.split(" ", 2);
        if (parts.length == 0) {
            System.out.println("command not found. Type 'command' to see available commands.");
            return;
        }
        String command = parts[0].toLowerCase();
        String arguments = parts.length > 1 ? parts[1] : "";

        switch (command) {
            case "lib":
                commandControl(arguments);
                break;
            case "exit":
                System.out.println("Exiting Library CLI. Goodbye!");
                break;
            case "command":
                pcommand();
                break;
            default:
                System.out.println("command not founf. Type 'command' to see available commands.");
                break;
        }
    }

    public static void start() {
        System.out.println("Type *command* to see available commands.");

        while (true) {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            if (input.equals("exit")) {
                System.out.println("program is finished");
                return;
            }

            Perform(input);
        }
    }

    public static void commandControl(String arguments) {
        String[] parts = arguments.split(" ", 2);
        if (parts.length == 0) {
            System.out.println("command NOT FOUND. Type 'command' to see available commands.");
            return;
        }

        String subCommand = parts[0].toLowerCase();
        String subArguments = parts.length > 1 ? parts[1] : "";

        switch (subCommand) {
            case "add":
                addCMD(subArguments);
                break;
            case "get":
                handleGetCommand(subArguments);
                break;
            case "rent":
                break;
            case "remove":
                break;
            case "return":
                break;
            default:
                System.out.println("command not found. Type 'command' to see commands.");
                break;
        }
    }

    private static void addCMD(String arguments) {
        String[] parts = arguments.split(" ", 4);
        if (parts.length < 3) {
            System.out.println("Invalid command format. Usage: lib add book <name> <author> <subtitle>");
            return;
        }

        String name = parts[1];
        String author = parts[2];
        String subtitle = parts.length > 3 ? parts[3] : "";
        library.addbook(new Book(Book.idgenerator(), Book.getTitle(), Book.getAuthor(), Book.isAvailable(), " "));
        System.out.println("Book added successfully.");
    }

    private static void handleGetCommand(String arguments) {
        if (arguments.equalsIgnoreCase("hrs")) {
            System.out.println("Operating hours: " + library.getOperatingHours());
        } else {
            System.out.println("Invalid 'get' command. Type 'help' to see available commands.");
        }
    }



}
