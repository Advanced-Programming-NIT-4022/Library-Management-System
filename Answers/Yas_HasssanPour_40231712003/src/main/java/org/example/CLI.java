package org.example;

import java.util.Scanner;

public class CLI {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Welcom to our library! What can we do for you?\n lib add book<name><authos><subtitle>: add a new book to the library\n lib get hrs: Retrieve library opening hours\n lib rent<bookName>: Rent a book from the library\nlib add member<studentID> <password>: Add a new member to the library (admin privilege reqiuered\nlib rent ");
    String input = scanner.nextLine();

        while (true) {
        System.out.println("Enter a command (type 'help' for available commands):");
        String command = scanner.nextLine();
}

