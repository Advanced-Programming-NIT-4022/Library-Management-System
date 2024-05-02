package ui;

import basic.classes.Library;

import java.util.Scanner;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInterface {
    String command;
    String operation;
    private final String super_admin_password = "AmirHosseinZg1383";

    Scanner input = new Scanner(System.in);

    Library library = new Library("fucking library", 500);

    public void printLibrarySupportedCommand() {
        System.out.println("lib add book <title> <author> <description>"); //add a new book to the library
        System.out.println("lib get hrs");//retrieve library operating hours
        System.out.println("lib rent <bookName>");//rent a book from the library
        System.out.println("lib add member <studentID> <password>");//add new member to the library(Admin privilege required)
        System.out.println("lib rent <bookName> <memberName> <memberID>");//rent a book for a specific member
        System.out.println("lib get available books");//view available books for rental
        System.out.println("lib remove member <memberID>");//remove a member from the library(admin privilege required)
        System.out.println("lib return <bookName>");//return a rented book to the library
    }


    public void printLobbySupportedCommand() {
        System.out.println("sign in as normal user <name> <phone-number>");
        System.out.println("sign in as admin <name> <phone-number> <password>");
        System.out.println("creating new normal-user account <name> <phone-number>");
        System.out.println("add new super doer ( admin ) <name> <phone-number> <password> " +
                "(attention :the password must have at least 8 characters)"); //admin access required
    }


    public void libraryLobby() {
        //welcome
        System.out.println("Welcome to library PortalPass");

        //sign in : logging in with existing account, sign up : creating new account
        String normal_user_name, admin_name, admin_password;
        Integer normal_user_phone_number, admin_phone_number;

        String regex1 = "sign in as normal user ([a-zA-Z]+(?:\\s[a-zA-Z]+)*) ((9[0-9]{9})|(09[0-9]{9}))";
        String regex2 = "sign in as admin ([a-zA-Z]+(?:\\s[a-zA-Z]+)*) ((9[0-9]{9})|(09[0-9]{9})) ([^ ]{8,})";
        String regex3 = "creating new normal-user account ([a-zA-Z]+(?:\\s[a-zA-Z]+)*) ((9[0-9]{9})|(09[0-9]{9}))";
        String regex4 = "add new super doer ( admin ) ([a-zA-Z]+(?:\\s[a-zA-Z]+)*) ((9[0-9]{9})|(09[0-9]{9})) ([^ ]{8,})";


        while (true) {
            System.out.print("Enter your desired command : (command line is case sensitive) ");
            System.out.println("notice : for see list of supported command use the following instruction :");
            System.out.println("lobby --help");
            System.out.print(">>");
            operation = input.nextLine();

            if(Pattern.compile(regex1).matcher(operation).find()){
                normal_user_name = Pattern.compile(regex1).matcher(operation).group(1);
                normal_user_phone_number = Integer.parseInt(Pattern.compile(regex1).matcher(operation).group(2));
                break;
            }
            else if(Pattern.compile(regex2).matcher(operation).find()){
                admin_name = Pattern.compile(regex2).matcher(operation).group(1);
                admin_phone_number = Integer.parseInt(Pattern.compile(regex2).matcher(operation).group(2));
                admin_password = Pattern.compile(regex2).matcher(operation).group(3);
                break;
            }
            else if(Pattern.compile(regex3).matcher(operation).find()){
                normal_user_name = Pattern.compile(regex1).matcher(operation).group(1);
                normal_user_phone_number = Integer.parseInt(Pattern.compile(regex1).matcher(operation).group(2));
                break;
            }
            else if(Pattern.compile(regex4).matcher(operation).find()){
                System.out.println("adding new admin for library management require super admin password , enter password : \n>>");
                if(Objects.equals(input.nextLine(), super_admin_password)){
                    admin_name = Pattern.compile(regex2).matcher(operation).group(1);
                    admin_phone_number = Integer.parseInt(Pattern.compile(regex2).matcher(operation).group(2));
                    admin_password = Pattern.compile(regex2).matcher(operation).group(3);
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

        


    }
}
