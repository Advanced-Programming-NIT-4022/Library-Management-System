
import java.util.Scanner;

public class CLI {
    private static Library library;

    public CLI(Library library) {
        this.library = library;
    }

    public void CommandLineArgument(String[] args) {


        for (String Argument : args) {
            if (Argument.equalsIgnoreCase("lib")) {
                continue;
            } else {
                System.out.println("[!] # Invalid Command #");
            }
            if (Argument.equalsIgnoreCase("add")) {
                continue;
            } else {
                System.out.println("[!] # Invalid Command #\n [+] Enter A Method to work with");
            }
            if (Argument.equalsIgnoreCase("book")) {
                LibAddBook(args);
            } else if (Argument.equalsIgnoreCase("Member")) {
                LibAddUser(args);
            } else if (Argument.equalsIgnoreCase("admin")) {
                LibAddAdmin(args);
            }

            if (Argument.equalsIgnoreCase("get")) {
                continue;
            } else {
                System.out.println("[!] # Invalid Command #\n [+] Enter A Method to work with");
            }
            if (Argument.equalsIgnoreCase("hrs")) {
                System.out.println(library.getHrs());

            } else if (args[3].equalsIgnoreCase("available") && args[4].equalsIgnoreCase("books")) {
                library.ShowAvailableBooks();
            }
            if (Argument.equalsIgnoreCase("rent")) {
                if (args.length == 5) {
                    LibRentBook(args);
                }
                if (args.length == 6) {
                    LibRentBookforUser(args);
                }
            } else {
                System.out.println("[!] # Invalid Command #\n [+] Enter A Method to work with");
            }
            if (Argument.equalsIgnoreCase("return")) {
                LibReturnBook(args);
            }
            else{
                System.out.println("[!] # Invalid Command #\n [+] Enter A Method to work with");
            }
            if(args[1].equalsIgnoreCase("remove") && args[2].equalsIgnoreCase("member")){

            }
        }
    }
        public void LibAddBook (String[]args){
            if (args.length == 6) {
                String BookTitle = args[3];
                String BookAuthor = args[4];
                String Description = args[5];
                library.addBook(BookTitle, BookAuthor, Description);
                System.out.println("[+] Book: " + BookTitle + " Added to The Library");
            } else {
                System.out.println("[!] # Unacceptable Arguments #\n [+] Enter (Title , Author , Description) ");
            }
        }

        public void LibAddUser (String[]args){
            if (args.length == 5) {
                String userName = args[3];
                String userPhone = args[4];
                library.addUser(userName, userPhone);
                System.out.println("[+] User: " + userName + " Add to the Library");
            } else {
                System.out.println("[!] # Unacceptable Arguments #\n [+] Enter (userName , userPhone) ");
            }
        }


        public void LibAddAdmin (String[]args){
            if (args.length == 6) {
                String name = args[3];
                String phoneNumber = args[4];
                System.out.println("[+] Enter a password: ");
                Scanner sc = new Scanner(System.in);
                // reads password without showing it on the console (just like setting pass in linux os)
                String Password = String.valueOf(System.console().readPassword());
                System.out.println("[+] Confirm your password: ");
                String confirmPassword = String.valueOf(System.console().readPassword());

                if (Password.equals(confirmPassword)) {
                    System.out.println("[+] Password set successfully!");
                } else {
                    System.out.println("[!] # Passwords do not match. Please try again #");
                }
                sc.close();
                library.addAdmin(name, phoneNumber, Password);
                System.out.println("[+] Admin: " + name + " Added to the Library");
            }
        }

        public void LibRentBook (String[]args){
            if (args.length == 5) {
                String BookName = args[4];
                String UserName = args[3];
                //I don't know how to automatically get the Username without getting the argument from console
                library.BookRental(BookName, UserName);
            } else {
                System.out.println("[!] # Unacceptable Arguments #\n [+] Enter (BookName , UserName) ");
            }
        }

        public void LibRentBookforUser (String[]args){
            if (args.length == 6) {
                String BookName = args[3];
                String UserName = args[4];
                Integer UserID = Integer.valueOf(args[5]);
                //String Exception Handling Needed Here
                library.BookRentalForUser(BookName, UserName, UserID);
            } else {
                System.out.println("[!] # Unacceptable Arguments #\n [+] Enter (BookName , UserName , UserID) ");
            }
        }

        public void LibReturnBook(String[] args){
        if(args.length == 4){
           String BookName = args[3];
           library.ReturnBook(BookName);
        }
        else{
            System.out.println("[!] # Unacceptable Arguments #\n [+] Enter (BookName) ");
        }
        }

        public void LibRemoveUser(String[] args){
        if(args.length == 4){
            //String Exception Handling Needed Here
            Integer UserID = Integer.valueOf(args[3]);
            library.RemoveUser(UserID);
        }
        else {
            System.out.println("[!] # Unacceptable Arguments #\n [+] Enter (UserID) ");
        }
        }
}