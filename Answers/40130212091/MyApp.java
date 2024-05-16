
import java.util.Scanner;

public class MyApp {

    public static void main(String[] args) {
        Library library = new Library();
        System.out.println("Hello welcome to " + library.getLibraryName());
        System.out.println("capacity : " + library.getCapacity());
        System.out.println("enter a command");

        Scanner command = new Scanner(System.in);
        String input;
        while (true) {
            System.out.println("~~~  ");
            input = command.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            commandLine(input.split(" "), library);
        }
        command.close();
    }

    public static void commandLine(String[] order, Library library) {
        try {
            if (order[1].equals("lib") && order[2].equals("add") && order[3].equals("book")) {
                library.addBook(order[4], order[5], order[6]);
            } else if (order[1].equals("lib") && order[2].equals("add") && order[3].equals("member")) {
                library.addMember(order[4], order[5]);
            } else if (order[1].equals("lib") && order[2].equals("rent")) {
                library.rentBook(order[4], order[5]);
            } else if (order[1].equals("lib") && order[2].equals("get") && order[3].equals("hrs")) {
                System.out.println(library.getHours());
            } else if (order[1].equals("lib") && order[2].equals("get") && order[3].equals("books")) {
                library.availableBooks();
            } else if (order[1].equals("lib") && order[2].equals("remove") && order[3].equals("member")) {
                library.removeMember(order[4]);

            } else if (order[1].equals("lib") && order[2].equals("return")) {
                library.returnBook(order[4]);
            } else if (order[1].equals("lib") && order[2].equals("help")) {
                System.out.println("lib add book <name> <author> <subtitle>: Add a new book to the library.\n" +
                        "lib get hrs: Retrieve library operating hours.\n" +
                        "lib rent <bookName>: Rent a book from the library.\n" +
                        "lib add member <studentID> <password>: Add a new member to the library (admin privilege required).\n" +
                        "lib rent <bookName> <memberName> <memberID>: Rent a book for a specific member.\n" +
                        "lib get available books: View available books for rental.\n" +
                        "lib remove member <memberID>: Remove a member from the library (admin privilege required).\n" +
                        "lib return <bookName>: Return a rented book to the library.\n" +
                        "lib add admin <AdminName> <PhoneNumber>: Add a new admin to the library\n" +
                        ">>> ");
            }
            else{
                throw new Exception();
            }
        } catch(
    Exception e)

    {
        throw new RuntimeException("enter a correct command");
    }
}
}
