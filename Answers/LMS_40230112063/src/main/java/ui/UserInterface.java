package ui;

import basic.classes.Library;
import java.util.Scanner;
import java.util.Objects;
import java.util.regex.Pattern;

public class UserInterface {

    Library library = new Library("AmirZg", 500);
    Scanner input = new Scanner(System.in);

    private final String super_admin_password = "AmirHosseinZg1383";


    public void printLibrarySupportedCommand() {
        System.out.println("lib add book <title> <author> <description>"); //add a new book to the library
        System.out.println("lib get hrs");//retrieve library operating hours
        System.out.println("lib rent <bookName> <author> <user_name> <phone_number>");//rent a book for a specific member
        System.out.println("lib get available books");//view available books for rental
        System.out.println("lib remove member <user-name>");//remove a member from the library(admin privilege required)
        System.out.println("lib return <bookName> <author>");//return a rented book to the library
        System.out.println("lib PortalPass");
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


    private String normal_user_name, admin_name, admin_password;
    private Integer normal_user_phone_number, admin_phone_number;

    private final String portalpass_regex1 = "^sign\\s+in\\s+as\\s+normal\\s+user\\s+<([a-zA-Z]+(?:\\s[a-zA-Z]+)*)>\\s+<((9[0-9]{9})|(09[0-9]{9}))>$";
    private final String portalpass_regex2 = "^sign\\s+in\\s+as\\s+admin\\s+<([a-zA-Z]+(?:\\s[a-zA-Z]+)*)>\\s+<((9[0-9]{9})|(09[0-9]{9}))>\\s+<([^ ]{8,})>$";
    private final String portalpass_regex3 = "^creating\\s+new\\s+normal\\s+user\\s+account\\s+<([a-zA-Z]+(?:\\s[a-zA-Z]+)*)>\\s+<((9[0-9]{9})|(09[0-9]{9}))>$";
    private final String portalpass_regex4 = "^add\\s+new\\s+super\\s+doer\\s+<([a-zA-Z]+(?:\\s[a-zA-Z]+)*)>\\s+<((9[0-9]{9})|(09[0-9]{9}))>\\s+<([^ ]{8,})>$";

    private final String lms_command_regex1 = "^lib\\s+add\\s+book\\s+<([0-9]*\\s*[a-zA-Z]+(?:[0-9]*\\s*[a-zA-Z]*)*)>\\s+<([a-zA-Z]+(?:\\s[a-zA-Z]+)*)>\\s+<([0-9]*\\s*[a-zA-Z]+(?:[0-9]*\\s*[a-zA-Z]*)*)>$";
    private final String Lms_command_regex2 = "^lib\\s+get\\s+hrs$";
    private final String lms_command_regex3 = "^lib\\s+rent\\s+<([0-9]*\\s*[a-zA-Z]+(?:[0-9]*\\s*[a-zA-Z]*)*)>\\s+<([a-zA-Z]+(?:\\s[a-zA-Z]+)*)>\\s+<([a-zA-Z]+(?:\\s[a-zA-Z]+)*)>\\s+<((9[0-9]{9})|(09[0-9]{9}))>$";
    private final String lms_command_regex4 = "^lib\\s+get\\s+available\\s+books$";
    private final String Lms_command_regex5 = "^lib\\s+remove\\s+member\\s+<([a-zA-Z]+(?:\\s[a-zA-Z]+)*)>$";
    private final String Lms_command_regex6 = "^lib\\s+return\\s+<([0-9]*\\s*[a-zA-Z]+(?:[0-9]*\\s*[a-zA-Z]*)*)>\\s+<([a-zA-Z]+(?:\\s[a-zA-Z]+)*)>$";
    private final String lms_command_regex7 = "^lib\\s+PortalPass$";

    public void library() {

        // PortalPass
        // Sign in : logging in with existing account, Sign up : creating new account

        System.out.println("Welcome to library PortalPass");
        String operation;

        while (true) {
            System.out.print("Enter your desired command : (command line is case sensitive) ");
            System.out.println("notice : for see list of supported command use the following instruction :");
            System.out.println("lobby --help");
            System.out.print(">>");
            operation = input.nextLine();

            if(Pattern.compile(portalpass_regex1,Pattern.CASE_INSENSITIVE).matcher(operation).find()){
                normal_user_name = Pattern.compile(portalpass_regex1).matcher(operation).group(1);
                normal_user_phone_number = Integer.parseInt(Pattern.compile(portalpass_regex1).matcher(operation).group(2));
                break;
            }
            else if(Pattern.compile(portalpass_regex2,Pattern.CASE_INSENSITIVE).matcher(operation).find()){
                admin_name = Pattern.compile(portalpass_regex2).matcher(operation).group(1);
                admin_phone_number = Integer.parseInt(Pattern.compile(portalpass_regex2).matcher(operation).group(2));
                admin_password = Pattern.compile(portalpass_regex2).matcher(operation).group(3);
                break;
            }
            else if(Pattern.compile(portalpass_regex3,Pattern.CASE_INSENSITIVE).matcher(operation).find()){
                normal_user_name = Pattern.compile(portalpass_regex1).matcher(operation).group(1);
                normal_user_phone_number = Integer.parseInt(Pattern.compile(portalpass_regex1).matcher(operation).group(2));
                break;
            }
            else if(Pattern.compile(portalpass_regex4,Pattern.CASE_INSENSITIVE).matcher(operation).find()){
                System.out.println("adding new admin for library management require super admin password , enter password : \n>>");
                if(Objects.equals(input.nextLine(), super_admin_password)){
                    admin_name = Pattern.compile(portalpass_regex2).matcher(operation).group(1);
                    admin_phone_number = Integer.parseInt(Pattern.compile(portalpass_regex2).matcher(operation).group(2));
                    admin_password = Pattern.compile(portalpass_regex2).matcher(operation).group(3);
                    break;
                }
                else{
                    System.out.println("Access denied , Wrong admin password");
                }

            }
            else{
                System.out.println("invalid command . . . try again");
                System.out.println("Keep in mind that this error may be caused by entering the wrong command or entering the name," +
                        " mobile number or password in the wrong form.");
            }
        }

        // Library System

        String command;
        System.out.println("Welcome to "+library.getLibraryName()+" Library Management System");

    }
}
