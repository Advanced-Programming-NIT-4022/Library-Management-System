package org.example;

public class MyApp {
    public static void main(String[] args) {
        System.out.print("Hi! Welcome to Arva's library♥");
        Library library = new Library("Example Library", 100, "9 AM - 5 PM");

        // Create an instance of LibraryCLI
        LibraryCLI cli = new LibraryCLI(library);

        // Start the interactive session
        cli.run();
    }
}