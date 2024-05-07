
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

        }
    }

        public void LibAddBook(String[] args){
            if(args.length == 6){
                String BookTitle = args[3];
                String BookAuthor = args[4];
                String Description = args[5];
                library.addBook(BookTitle , BookAuthor , Description);
                System.out.println("[+] Book: " + BookTitle + " Added to The Library");
            }
            else{
                System.out.println("[!] # Unacceptable Arguments #\n [+] Enter (Title , Author , Description) ");
            }
        }

        public void LibAddUser(String[] args){
            if(args.length == 5){
            String userName = args[3];
            String userPhone = args[4];
            library.addUser(userName , userPhone);
                System.out.println("[+] User: " + userName + " Add to the Library");
            }
            else{
                System.out.println("[!] # Unacceptable Arguments #\n [+] Enter (userName , userPhone) ");
            }
        }


        public void LibAddAdmin(String[] args){
            if(args.length == 6){
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
                library.addAdmin(name , phoneNumber , Password);
                System.out.println("[+] Admin: " + name+ " Added to the Library");
            }
            }
        }
}