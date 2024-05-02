package ui;

import basic.classes.Library;

import java.util.Scanner;
import java.util.Objects;

public class UserInterface {
    String command;
    String operation;

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
        System.out.println("add new super doer ( admin ) <name> <phone-number> <password>"); //admin access required
    }


    public void libraryLobby() {
        //welcome
        System.out.println("welcome to " + library.getLibraryName());

        //sign in : logging in with existing account, sign up : creating new account
        String normal_user_name, admin_name, admin_password;
        Integer normal_user_phone_number, admin_phone_number;

        String[] operation_segment;
        boolean flag;

        while (true) {
            flag = false;
            System.out.print("enter your desired command : (command line is case sensitive) ");
            System.out.println("notice : for see list of supported command use the following instruction :");
            System.out.println("lobby --help");
            System.out.print(">>");
            operation = input.nextLine();
            operation_segment = operation.split(" ");

            if (Objects.equals(operation, "lobby --help")) {
                printLobbySupportedCommand();
            } else if (Objects.equals(operation_segment[0], "sign")) {
                if (Objects.equals(operation_segment[1], "in")) {
                    if (Objects.equals(operation_segment[2], "as")) {
                        if (Objects.equals(operation_segment[3], "normal")) {
                            if (Objects.equals(operation_segment[4], "user")) {

                            }
                        } else {
                            flag = true;
                        }
                    } else {
                        flag = true;
                    }
                } else {
                    flag = true;
                }

            } else {
                flag = true;
            }

            if (flag) {
                System.out.println("invalid command ... try again");
            }
        }


    }
}
