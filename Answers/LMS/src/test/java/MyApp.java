import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class MyApp {
    public static void main(String[] args) {
        Library library = new Library(100, "Mega Library o/");
        CLI cli = new CLI(library);
        Scanner scninput = new Scanner(System.in);

        System.out.println("Welcome to Library Management System!");
        System.out.println("Enter 'exit' to quit the program.");

        while(true){
            System.out.println("Enter a Command: ");
            String input = scninput.nextLine();
            String[] command = input.split(" ");

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Exiting the program...");
                break;
            }
            cli.processCommand(command);
        }

        System.out.println("Thank you for choosing our Library Management System.");
        System.out.println("We're excited to provide you with an efficient and user-friendly platform for all your library needs. ");
        System.out.println("Happy reading!");

        scninput.close();
    }
}
