import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class MyApp {
    public static void main(String[] args) {

        Library library = new Library("Jedi Temple Library" , 100);
        CLI cli = new CLI(library);

        System.out.println("___Welcome to the Jedi Temple Library___");
        System.out.println("Enter a Command: ");
        System.out.println("(Use lib -h for help)\n");

        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.print(">>> ");
            String input = scanner.nextLine();
            if(input.equalsIgnoreCase("quit")){
                break;
            }
            else if(input.equalsIgnoreCase("lib -h")){

                System.out.println("lib add book <name> <author> <subtitle>: Add a new book to the library.\n" +
                        "lib get hrs: Retrieve library operating hours.\n" +
                        "lib rent <bookName>: Rent a book from the library.\n" +
                        "lib add member <studentID> <password>: Add a new member to the library (admin privilege required).\n" +
                        "lib rent <bookName> <memberName> <memberID>: Rent a book for a specific member.\n" +
                        "lib get available books: View available books for rental.\n" +
                        "lib remove member <memberID>: Remove a member from the library (admin privilege required).\n" +
                        "lib return <bookName>: Return a rented book to the library.\n"+
                        "lib add admin <AdminName> <PhoneNumber>: Add a new admin to the library\n" +
                        ">>> ");
            }
            else {
                cli.CommandLineArgument(input.split(" "));
            }
        }

        scanner.close();
    }

}
