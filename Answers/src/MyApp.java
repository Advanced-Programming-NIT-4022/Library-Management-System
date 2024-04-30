// main class for handling the CLI
import java.util.InputMismatchException;
import java.util.Scanner;

public class MyApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to LMS(Library Management System)!");
        System.out.println("enter your library name: ");
        System.out.println("for more information enter command <lib man>");
        System.out.println("\nEnter your command:");
        String command = "";
        while (true) {
            try {
                System.out.print(">>> ");
                command = input.nextLine();
                CLI(command);
            } catch (IllegalArgumentException e) {
                System.out.printf("%s: %s%n", command, e.getMessage());
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.printf("%s: %s%n", command, "Uncompleted command");
            }
        }
    }

    public static void CLI(String command) throws IllegalArgumentException {
        if (command.equals("lib man"))
            Manual.print();
        else if (command.matches("lib return \\w*")) {
            // return a book
        }
        else if (command.equals("lib exit"))
            System.exit(0);
        else
            throw new IllegalArgumentException();
    }
}
