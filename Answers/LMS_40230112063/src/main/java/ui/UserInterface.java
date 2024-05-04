package ui;

import basic.classes.Library;

import java.util.Scanner;
import java.util.regex.Pattern;

public class UserInterface {

    Library library = new Library("AmirZg", 500, "7am to 11pm");
    Scanner input = new Scanner(System.in);
    String operation;
    private String signed_in_name;
    private Integer signed_in_phone_number;


    public void printLibrarySupportedCommand() {
        System.out.println("lib add book <title> <author> <description>"); //add a new book to the library
        System.out.println("lib get hrs");//retrieve library operating hours
        System.out.println("lib rent <bookName> <author>");//rent a book for a specific member
        System.out.println("lib get available books");//view available books for rental
        System.out.println("lib remove member <user-name> <phone_number>");//remove a member from the library(admin privilege required)
        System.out.println("lib return <bookName> <author>");//return a rented book to the library
        System.out.println("lib remove book <title> <author>"); //remove a book from the library(admin privilege required)
        System.out.println("lib PortalPass");
        System.out.println("Exit");
        System.out.println("*** Be sure to use the <> operator to send arguments in the command line ***");
    }


    public void printPortalPassSupportedCommand() {
        System.out.println("sign in as normal user <name> <phone-number>");
        System.out.println("sign in as admin <name> <phone-number> <password>");
        System.out.println("creating new normal-user account <name> <phone-number>");
        System.out.println("add new super doer ( admin ) <name> <phone-number> <password> " +
                "(attention :the password must have at least 8 characters)"); //admin access required
        System.out.println("*** Be sure to use the <> operator to send arguments in the command line ***");
    }


    public void libraryPortalPass() {
        // PortalPass
        // Sign in : logging in with existing account, Sign up : creating new account

        System.out.println("Welcome to library PortalPass");

        String admin_password;
        final String portalpass_regex1 = "^sign\\s+in\\s+as\\s+normal\\s+user\\s+<([a-zA-Z]+(?:\\s[a-zA-Z]+)*)>\\s+<((9[0-9]{9})|(09[0-9]{9}))>$";
        final String portalpass_regex2 = "^sign\\s+in\\s+as\\s+admin\\s+<([a-zA-Z]+(?:\\s[a-zA-Z]+)*)>\\s+<((9[0-9]{9})|(09[0-9]{9}))>\\s+<([^ ]{8,})>$";
        final String portalpass_regex3 = "^creating\\s+new\\s+normal\\s+user\\s+account\\s+<([a-zA-Z]+(?:\\s[a-zA-Z]+)*)>\\s+<((9[0-9]{9})|(09[0-9]{9}))>$";
        final String portalpass_regex4 = "^add\\s+new\\s+super\\s+doer\\s+<([a-zA-Z]+(?:\\s[a-zA-Z]+)*)>\\s+<((9[0-9]{9})|(09[0-9]{9}))>\\s+<([^ ]{8,})>$";
        final String portalpass_help_regex = "^PortalPass\\s+--help$";

        while (true) {
            System.out.print("Enter your desired command : ");
            System.out.println("notice : To see list of supported command use the following instruction :");
            System.out.println("PortalPass --help");
            System.out.print(">>");
            operation = input.nextLine();


            if (Pattern.compile(portalpass_help_regex, Pattern.CASE_INSENSITIVE).matcher(operation).find()) {
                printPortalPassSupportedCommand();
                System.out.println("--------------------------------------------------------------");
            } else if (Pattern.compile(portalpass_regex1, Pattern.CASE_INSENSITIVE).matcher(operation).find()) {
                signed_in_name = Pattern.compile(portalpass_regex1, Pattern.CASE_INSENSITIVE).matcher(operation).group(1);
                signed_in_phone_number = Integer.parseInt(Pattern.compile(portalpass_regex1, Pattern.CASE_INSENSITIVE).matcher(operation).group(2));
                if (library.memberExistenceChecker(signed_in_name, signed_in_phone_number) != null) {
                    System.out.println("You signed in successfully as normal user with name and phone number :  " + signed_in_name + "," + signed_in_phone_number);
                    System.out.println("--------------------------------------------------------------");
                    break;
                } else {
                    System.out.println("There is no user with the given information in registered user list .");
                    System.out.println("--------------------------------------------------------------");
                }
            } else if (Pattern.compile(portalpass_regex2, Pattern.CASE_INSENSITIVE).matcher(operation).find()) {
                signed_in_name = Pattern.compile(portalpass_regex2, Pattern.CASE_INSENSITIVE).matcher(operation).group(1);
                signed_in_phone_number = Integer.parseInt(Pattern.compile(portalpass_regex2, Pattern.CASE_INSENSITIVE).matcher(operation).group(2));
                admin_password = Pattern.compile(portalpass_regex2, Pattern.CASE_INSENSITIVE).matcher(operation).group(3);
                if (library.adminExistenceChecker(signed_in_name, signed_in_phone_number, admin_password) != null) {
                    System.out.println("You signed in successfully as admin with name and phone number : " + signed_in_name + "," + signed_in_phone_number);
                    System.out.println("--------------------------------------------------------------");
                    break;
                } else {
                    System.out.println("There is no admin with the given information in registered admin list .");
                    System.out.println("--------------------------------------------------------------");
                }

            } else if (Pattern.compile(portalpass_regex3, Pattern.CASE_INSENSITIVE).matcher(operation).find()) {
                signed_in_name = Pattern.compile(portalpass_regex1, Pattern.CASE_INSENSITIVE).matcher(operation).group(1);
                signed_in_phone_number = Integer.parseInt(Pattern.compile(portalpass_regex1, Pattern.CASE_INSENSITIVE).matcher(operation).group(2));
                library.addMember(signed_in_name, signed_in_phone_number);
                System.out.println("A new normal user account has been created and you have successfully logged in with name and phone number : " + signed_in_name + "," + signed_in_phone_number);
                System.out.println("--------------------------------------------------------------");
                break;
            } else if (Pattern.compile(portalpass_regex4, Pattern.CASE_INSENSITIVE).matcher(operation).find()) {
                System.out.println("adding new admin for library management require  admin password . enter password : \n>>");
                if (library.passwordExistenceChecker(input.nextLine())) {
                    signed_in_name = Pattern.compile(portalpass_regex2, Pattern.CASE_INSENSITIVE).matcher(operation).group(1);
                    signed_in_phone_number = Integer.parseInt(Pattern.compile(portalpass_regex2, Pattern.CASE_INSENSITIVE).matcher(operation).group(2));
                    admin_password = Pattern.compile(portalpass_regex2, Pattern.CASE_INSENSITIVE).matcher(operation).group(3);
                    library.addAmin(signed_in_name, signed_in_phone_number, admin_password);
                    System.out.println("A new super doer account has been created and you have successfully logged in with name and phone number : " + signed_in_name + "," + signed_in_phone_number);
                    System.out.println("--------------------------------------------------------------");
                    break;
                } else {
                    System.out.println("Access denied , Wrong admin password");
                }

            } else {
                System.out.println("invalid command . . . try again");
                System.out.println("Keep in mind that this error may be caused by entering the wrong command or entering the name," +
                        " mobile number or password in the wrong form.");
                System.out.println("--------------------------------------------------------------");
            }
        }
    }


    public void libraryLobby() {

        libraryPortalPass();

        // Library System
        System.out.println("Welcome to " + library.getLibraryName() + " Library Management System");

        final String lms_command_regex1 = "^lib\\s+add\\s+book\\s+<([0-9]*\\s*[a-zA-Z]+(?:[0-9]*\\s*[a-zA-Z]*)*)>\\s+<([a-zA-Z]+(?:\\s[a-zA-Z]+)*)>\\s+<([0-9]*\\s*[a-zA-Z]+(?:[0-9]*\\s*[a-zA-Z]*)*)>$";
        final String lms_command_regex2 = "^lib\\s+get\\s+hrs$";
        final String lms_command_regex3 = "^lib\\s+rent\\s+<([0-9]*\\s*[a-zA-Z]+(?:[0-9]*\\s*[a-zA-Z]*)*)>\\s+<([a-zA-Z]+(?:\\s[a-zA-Z]+)*)>$";
        final String lms_command_regex4 = "^lib\\s+get\\s+available\\s+books$";
        final String lms_command_regex5 = "^lib\\s+remove\\s+member\\s+<([a-zA-Z]+(?:\\s[a-zA-Z]+)*)>\\s+<((9[0-9]{9})|(09[0-9]{9}))>$";
        final String lms_command_regex6 = "^lib\\s+return\\s+<([0-9]*\\s*[a-zA-Z]+(?:[0-9]*\\s*[a-zA-Z]*)*)>\\s+<([a-zA-Z]+(?:\\s[a-zA-Z]+)*)>$";
        final String lms_command_regex7 = "^lib\\s+remove\\s+book\\s+<([0-9]*\\s*[a-zA-Z]+(?:[0-9]*\\s*[a-zA-Z]*)*)>\\s+<([a-zA-Z]+(?:\\s[a-zA-Z]+)*)>$";
        final String lms_goPortalPass_regex = "^lib\\s+PortalPass$";
        final String lms_help_regex = "^Library\\s+System\\s+--help$";
        final String lms_exit_regex = "^Exit";


        while (true) {
            System.out.print("Enter your desired command : ");
            System.out.println("notice : To see list of supported command use the following instruction :");
            System.out.println("Library System --help");
            System.out.print(">>");
            operation = input.nextLine();

            if (Pattern.compile(lms_help_regex, Pattern.CASE_INSENSITIVE).matcher(operation).find()) {
                printLibrarySupportedCommand();
                System.out.println("--------------------------------------------------------------");
            } else if (Pattern.compile(lms_command_regex1, Pattern.CASE_INSENSITIVE).matcher(operation).find()) {
                String title = Pattern.compile(lms_command_regex1, Pattern.CASE_INSENSITIVE).matcher(operation).group(1);
                String author = Pattern.compile(lms_command_regex1, Pattern.CASE_INSENSITIVE).matcher(operation).group(2);
                String description = Pattern.compile(lms_command_regex1, Pattern.CASE_INSENSITIVE).matcher(operation).group(3);
                library.addBook(title, author, description);
                System.out.println("--------------------------------------------------------------");
            } else if (Pattern.compile(lms_command_regex2, Pattern.CASE_INSENSITIVE).matcher(operation).find()) {
                System.out.println(library.getOperating_hours());
                System.out.println("--------------------------------------------------------------");
            } else if (Pattern.compile(lms_command_regex3, Pattern.CASE_INSENSITIVE).matcher(operation).find()) {
                String book_name = Pattern.compile(lms_command_regex3, Pattern.CASE_INSENSITIVE).matcher(operation).group(1);
                String author = Pattern.compile(lms_command_regex3, Pattern.CASE_INSENSITIVE).matcher(operation).group(2);
                library.rentBook(book_name, author, signed_in_name, signed_in_phone_number);
                System.out.println("--------------------------------------------------------------");
            } else if (Pattern.compile(lms_command_regex4, Pattern.CASE_INSENSITIVE).matcher(operation).find()) {
                library.printAvailableBooks();
                System.out.println("--------------------------------------------------------------");
            } else if (Pattern.compile(lms_command_regex5, Pattern.CASE_INSENSITIVE).matcher(operation).find()) {
                String user_name = Pattern.compile(lms_command_regex5, Pattern.CASE_INSENSITIVE).matcher(operation).group(1);
                Integer phone_number = Integer.parseInt(Pattern.compile(lms_command_regex5, Pattern.CASE_INSENSITIVE).matcher(operation).group(2));
                System.out.println("Removing users from the library require admin password . enter password : \n>>");
                if (library.passwordExistenceChecker(input.nextLine())) {
                    library.rmMember(user_name, phone_number);
                    System.out.println("--------------------------------------------------------------");
                } else {
                    System.out.println("Access denied , Wrong admin password");
                    System.out.println("--------------------------------------------------------------");
                }
            } else if (Pattern.compile(lms_command_regex6, Pattern.CASE_INSENSITIVE).matcher(operation).find()) {
                String book_name = Pattern.compile(lms_command_regex6, Pattern.CASE_INSENSITIVE).matcher(operation).group(1);
                String author = Pattern.compile(lms_command_regex6, Pattern.CASE_INSENSITIVE).matcher(operation).group(2);
                library.returnBook(book_name, author, signed_in_name, signed_in_phone_number);
                System.out.println("--------------------------------------------------------------");
            } else if (Pattern.compile(lms_command_regex7, Pattern.CASE_INSENSITIVE).matcher(operation).find()) {
                String title = Pattern.compile(lms_command_regex7, Pattern.CASE_INSENSITIVE).matcher(operation).group(1);
                String author = Pattern.compile(lms_command_regex7, Pattern.CASE_INSENSITIVE).matcher(operation).group(2);
                System.out.println("Removing books from the book repository require admin password . enter password : \n>>");
                if (library.passwordExistenceChecker(input.nextLine())) {
                    library.rmBook(title, author);
                    System.out.println("--------------------------------------------------------------");
                } else {
                    System.out.println("Access denied , Wrong admin password");
                    System.out.println("--------------------------------------------------------------");
                }
            } else if (Pattern.compile(lms_goPortalPass_regex, Pattern.CASE_INSENSITIVE).matcher(operation).find()) {
                System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                libraryPortalPass();
                libraryLobby();
            } else if (Pattern.compile(lms_exit_regex, Pattern.CASE_INSENSITIVE).matcher(operation).find()) {
                System.out.println("\n\n\n");
                System.out.println("Good luck ");
                System.out.println("Hope to see you again \n Bye :D");
                return;
            } else {
                System.out.println("invalid command . . . try again");
                System.out.println("Keep in mind that this error may be caused by entering the wrong command or entering the name," +
                        " mobile number or password in the wrong form.");
                System.out.println("--------------------------------------------------------------");
            }
        }

    }
}
