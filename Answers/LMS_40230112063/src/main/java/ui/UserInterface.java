package ui;

import basic.classes.Library;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInterface {

    Library library = new Library("AmirZg", 500, "7am to 11pm");
    Scanner input = new Scanner(System.in);
    String operation;
    private String signed_in_name, signed_in_phone_number;


    public void printLibrarySupportedCommand() {
        System.out.println("╔════════════════════════════════════════════════════════════╗");
        System.out.println("║                  Library Supported Commands                ║");
        System.out.println("╠════════════════════════════════════════════════════════════╣");
        System.out.println("║ lib add book <title> <author> <description>                ║");
        System.out.println("║ lib get hrs                                                ║");
        System.out.println("║ lib rent <bookName> <author>                               ║");
        System.out.println("║ lib get available books                                    ║");
        System.out.println("║ lib remove member <user-name> <phone_number>               ║");
        System.out.println("║ lib return <bookName> <author>                             ║");
        System.out.println("║ lib remove book <title> <author>                           ║");
        System.out.println("║ lib PortalPass                                             ║");
        System.out.println("║ Exit                                                       ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝");
        System.out.println("*** Be sure to use the <> operator to send arguments in the command line ***");
    }


    public void printPortalPassSupportedCommand() {
        System.out.println("╔════════════════════════════════════════════════════════════╗");
        System.out.println("║                PortalPass Supported Commands               ║");
        System.out.println("╠════════════════════════════════════════════════════════════╣");
        System.out.println("║ sign in as normal user <name> <phone-number>               ║");
        System.out.println("║ sign in as admin <name> <phone-number> <password>          ║");
        System.out.println("║ show all registered normal user accounts full information  ║");
        System.out.println("║ show all registered super doer accounts full information   ║");
        System.out.println("║ creating new normal user account <name> <phone-number>     ║");
        System.out.println("║ add new super doer <name> <phone-number> <password>        ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝");
        System.out.println("*** Be sure to use the <> operator to send arguments in the command line ***");
    }


    public void libraryPortalPass() {
        // PortalPass
        // Sign in : logging in with existing account, Sign up : creating new account

        System.out.println("\n\n");
        System.out.println("═══════════════════════════════════════════════════════════════════");
        System.out.println("════════════"+"Welcome to library PortalPass"+"═══════════════");
        System.out.println("\n\n");
        String admin_password;

        while (true) {
            System.out.println("═ ══ ══ ══ ══ ══ ══ ══ ══ ══ ══ ══ ══ ══ ══ ══ ══ ══ ══ ══ ══");

            System.out.println("Enter your desired command: ");
            System.out.println("╔══════════════════════════════════════════════════════════════╗");
            System.out.println("║ Notice: To see the list of supported commands, use the       ║");
            System.out.println("║ following instruction:                                       ║");
            System.out.println("║                                                              ║");
            System.out.println("║     PortalPass --help                                        ║");
            System.out.println("╚══════════════════════════════════════════════════════════════╝");
            System.out.print(">> ");
            operation = input.nextLine();


            final Pattern portalpass_sign_in_user_pattern = Pattern.compile("^sign\\s+in\\s+as\\s+normal\\s+user\\s+<([a-zA-Z]+(?:\\s[a-zA-Z]+)*)>\\s+<((9[0-9]{9})|(09[0-9]{9}))>$", Pattern.CASE_INSENSITIVE);
            final Matcher portalpass_sign_in_user_matcher = portalpass_sign_in_user_pattern.matcher(operation);

            final Pattern portalpass_sign_in_admin_pattern = Pattern.compile("^sign\\s+in\\s+as\\s+admin\\s+<([a-zA-Z]+(?:\\s[a-zA-Z]+)*)>\\s+<((9[0-9]{9})|(09[0-9]{9}))>\\s+<([^ ]{8,})>$", Pattern.CASE_INSENSITIVE);
            final Matcher portalpass_sign_in_admin_matcher = portalpass_sign_in_admin_pattern.matcher(operation);

            final Pattern portalpass_new_user_account_pattern = Pattern.compile("^creating\\s+new\\s+normal\\s+user\\s+account\\s+<([a-zA-Z]+(?:\\s[a-zA-Z]+)*)>\\s+<((9[0-9]{9})|(09[0-9]{9}))>$", Pattern.CASE_INSENSITIVE);
            final Matcher portalpass_new_user_account_matcher = portalpass_new_user_account_pattern.matcher(operation);

            final Pattern portalpass_add_admin_pattern = Pattern.compile("^add\\s+new\\s+super\\s+doer\\s+<([a-zA-Z]+(?:\\s[a-zA-Z]+)*)>\\s+<((9[0-9]{9})|(09[0-9]{9}))>\\s+<([^ ]{8,})>$", Pattern.CASE_INSENSITIVE);
            final Matcher portalpass_add_admin_matcher = portalpass_add_admin_pattern.matcher(operation);

            final Pattern portalpass_help_pattern = Pattern.compile("^PortalPass\\s+--help$", Pattern.CASE_INSENSITIVE);
            final Matcher portalpass_help_matcher = portalpass_help_pattern.matcher(operation);

            final Pattern portalpass_all_registered_members_pattern = Pattern.compile("^show\\s+all\\s+registered\\s+normal\\s+user\\s+accounts\\s+full\\s+information$", Pattern.CASE_INSENSITIVE);
            final Matcher portalpass_all_registered_members_matcher = portalpass_all_registered_members_pattern.matcher(operation);

            final Pattern portalpass_all_registered_admins_pattern = Pattern.compile("^show\\s+all\\s+registered\\s+super\\s+doer\\s+accounts\\s+full\\s+information$", Pattern.CASE_INSENSITIVE);
            final Matcher portalpass_all_registered_admins_matcher = portalpass_all_registered_admins_pattern.matcher(operation);

            if (portalpass_help_matcher.find()) {
                printPortalPassSupportedCommand();
                System.out.println("═ ══ ══ ══ ══ ══ ══ ══ ══ ══ ══ ══ ══ ══ ══ ══ ══ ══ ══ ══ ══");
            } else if (portalpass_sign_in_user_matcher.find()) {
                signed_in_name = portalpass_sign_in_user_matcher.group(1);
                signed_in_phone_number = portalpass_sign_in_user_matcher.group(2);
                signed_in_phone_number = signed_in_phone_number.startsWith("0") ? signed_in_phone_number : ("0").concat(signed_in_phone_number);
                if (library.memberExistenceChecker(signed_in_name, signed_in_phone_number) != null) {
                    System.out.println("You signed in successfully as normal user with name and phone number :  " + signed_in_name + "," + signed_in_phone_number);
                    System.out.println("═ ══ ══ ══ ══ ══ ══ ══ ══ ══ ══ ══ ══ ══ ══ ══ ══ ══ ══ ══ ══");
                    break;
                } else {
                    System.out.println("╔════════════════════════════════════════════════════════════╗");
                    System.out.println("║ There is no user with the given information in registered  ║");
                    System.out.println("║ user list .                                                ║");
                    System.out.println("╚════════════════════════════════════════════════════════════╝");
                }
            } else if (portalpass_sign_in_admin_matcher.find()) {
                signed_in_name = portalpass_sign_in_admin_matcher.group(1);
                signed_in_phone_number = portalpass_sign_in_admin_matcher.group(2);
                signed_in_phone_number = signed_in_phone_number.startsWith("0") ? signed_in_phone_number : ("0").concat(signed_in_phone_number);
                admin_password = portalpass_sign_in_admin_matcher.group(3);
                if (library.adminExistenceChecker(signed_in_name, signed_in_phone_number, admin_password) != null) {
                    System.out.println("╔════════════════════════════════════════════════════════════╗");
                    System.out.println("║ You signed in successfully as admin with name and phone    ║");
                    System.out.println("║ number : " + signed_in_name + "," + signed_in_phone_number + "               ║");
                    System.out.println("╚════════════════════════════════════════════════════════════╝");
                    System.out.println("═ ══ ══ ══ ══ ══ ══ ══ ══ ══ ══ ══ ══ ══ ══ ══ ══ ══ ══ ══ ══");
                    break;
                } else {
                    System.out.println("╔════════════════════════════════════════════════════════════╗");
                    System.out.println("║ There is no admin with the given information in registered ║");
                    System.out.println("║ admin list .                                               ║");
                    System.out.println("╚════════════════════════════════════════════════════════════╝");
                }

            } else if (portalpass_new_user_account_matcher.find()) {
                signed_in_name = portalpass_new_user_account_matcher.group(1);
                signed_in_phone_number = portalpass_new_user_account_matcher.group(2);
                signed_in_phone_number = signed_in_phone_number.startsWith("0") ? signed_in_phone_number : ("0").concat(signed_in_phone_number);
                library.addMember(signed_in_name, signed_in_phone_number);
                System.out.println("╔════════════════════════════════════════════════════════════╗");
                System.out.println("║ A new normal user account has been created and you have    ║");
                System.out.println("║ successfully logged in with name and phone number :        ║");
                System.out.println("║ " + signed_in_name + "," + signed_in_phone_number + "                           ║");
                System.out.println("╚════════════════════════════════════════════════════════════╝");
                break;
            } else if (portalpass_add_admin_matcher.find()) {
                System.out.println("adding new admin for library management require admin access . enter your name , phone number and password respectively : ");
                System.out.print(">>");
                String name, phone_number, password;
                name = input.nextLine();
                System.out.print(">>");
                phone_number = input.nextLine();
                System.out.print(">>");
                password = input.nextLine();
                if (library.adminExistenceChecker(name, phone_number, password) != null) {
                    signed_in_name = portalpass_add_admin_matcher.group(1);
                    signed_in_phone_number = portalpass_add_admin_matcher.group(2);
                    signed_in_phone_number = signed_in_phone_number.startsWith("0") ? signed_in_phone_number : ("0").concat(signed_in_phone_number);
                    admin_password = portalpass_add_admin_matcher.group(3);
                    library.addAmin(signed_in_name, signed_in_phone_number, admin_password);
                    System.out.println("╔════════════════════════════════════════════════════════════╗");
                    System.out.println("║ A new super doer account has been created and you have     ║");
                    System.out.println("║ successfully logged in with name and phone number :        ║");
                    System.out.println("║ " + signed_in_name + "," + signed_in_phone_number + "                           ║");
                    System.out.println("╚════════════════════════════════════════════════════════════╝");
                    break;
                } else {
                    System.out.println("╔════════════════════════════════════════════════════════════╗");
                    System.out.println("║ Access denied, Wrong admin password                        ║");
                    System.out.println("╚════════════════════════════════════════════════════════════╝");
                }

            } else if (portalpass_all_registered_members_matcher.find()) {
                System.out.println("Showing all registered normal user accounts full information require admin access . enter your name , phone number and password respectively :");
                System.out.print(">>");
                String name, phone_number, password;
                name = input.nextLine();
                System.out.print(">>");
                phone_number = input.nextLine();
                phone_number = phone_number.startsWith("0") ? phone_number : ("0").concat(phone_number);
                System.out.print(">>");
                password = input.nextLine();
                if (library.adminExistenceChecker(name, phone_number, password) != null) {
                    library.printAllMembers();
                    System.out.println("═ ══ ══ ══ ══ ══ ══ ══ ══ ══ ══ ══ ══ ══ ══ ══ ══ ══ ══ ══ ══");
                } else {
                    System.out.println("╔════════════════════════════════════════════════════════════╗");
                    System.out.println("║ Access denied, Wrong admin password                        ║");
                    System.out.println("╚════════════════════════════════════════════════════════════╝");
                }

            } else if (portalpass_all_registered_admins_matcher.find()) {
                System.out.println("Showing all registered super doer user accounts full information require admin access . enter your name , phone number and password respectively :");
                System.out.print(">>");
                String name, phone_number, password;
                name = input.nextLine();
                System.out.print(">>");
                phone_number = input.nextLine();
                phone_number = phone_number.startsWith("0") ? phone_number : ("0").concat(phone_number);
                System.out.print(">>");
                password = input.nextLine();
                if (library.adminExistenceChecker(name, phone_number, password) != null) {
                    library.printAllAdmins();
                    System.out.println("═ ══ ══ ══ ══ ══ ══ ══ ══ ══ ══ ══ ══ ══ ══ ══ ══ ══ ══ ══ ══");
                } else {
                    System.out.println("╔════════════════════════════════════════════════════════════╗");
                    System.out.println("║ Access denied, Wrong admin password                        ║");
                    System.out.println("╚════════════════════════════════════════════════════════════╝");
                }

            } else {
                System.out.println("invalid command . . . try again");
                System.out.println("Keep in mind that this error may be caused by entering the wrong command or entering the name," +
                        " mobile number or password in the wrong form.");
                System.out.println("═ ══ ══ ══ ══ ══ ══ ══ ══ ══ ══ ══ ══ ══ ══ ══ ══ ══ ══ ══ ══");
            }
        }
    }


    public void libraryLobby() {

        library.dataRetriever(); // Retrieve all data from database

        libraryPortalPass();

        // Library System
        System.out.println("╔══════════════════════════════════════════════╗");
        System.out.println("║ Welcome to " + library.getLibraryName() + " Library Management System  ║");
        System.out.println("╚══════════════════════════════════════════════╝");



        while (true) {
            System.out.println("Enter your desired command:");
            System.out.println("╔════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("║ (Notice) To see the list of supported commands, use the  following instruction:║");
            System.out.println("║ Library System --help                                                          ║");
            System.out.println("╚════════════════════════════════════════════════════════════════════════════════╝");
            System.out.print(">>");

            operation = input.nextLine();

            final Pattern lms_add_book_pattern = Pattern.compile("^lib\\s+add\\s+book\\s+<([0-9]*\\s*[a-zA-Z]+(?:[0-9]*\\s*[a-zA-Z]*)*)>\\s+<([a-zA-Z]+(?:\\s[a-zA-Z]+)*)>\\s+<([0-9]*\\s*[a-zA-Z]+(?:[0-9]*\\s*[a-zA-Z]*)*)>$", Pattern.CASE_INSENSITIVE);
            final Matcher lms_add_book_matcher = lms_add_book_pattern.matcher(operation);

            final Pattern lms_get_operating_hours_pattern = Pattern.compile("^lib\\s+get\\s+hrs$", Pattern.CASE_INSENSITIVE);
            final Matcher lms_get_operating_hours_matcher = lms_get_operating_hours_pattern.matcher(operation);

            final Pattern lms_rent_book_pattern = Pattern.compile("^lib\\s+rent\\s+<([0-9]*\\s*[a-zA-Z]+(?:[0-9]*\\s*[a-zA-Z]*)*)>\\s+<([a-zA-Z]+(?:\\s[a-zA-Z]+)*)>$", Pattern.CASE_INSENSITIVE);
            final Matcher lms_rent_book_matcher = lms_rent_book_pattern.matcher(operation);

            final Pattern lms_available_book_pattern = Pattern.compile("^lib\\s+get\\s+available\\s+books$", Pattern.CASE_INSENSITIVE);
            final Matcher lms_available_book_matcher = lms_available_book_pattern.matcher(operation);

            final Pattern lms_remove_member_pattern = Pattern.compile("^lib\\s+remove\\s+member\\s+<([a-zA-Z]+(?:\\s[a-zA-Z]+)*)>\\s+<((9[0-9]{9})|(09[0-9]{9}))>$", Pattern.CASE_INSENSITIVE);
            final Matcher lms_remove_member_matcher = lms_remove_member_pattern.matcher(operation);

            final Pattern lms_return_book_pattern = Pattern.compile("^lib\\s+return\\s+<([0-9]*\\s*[a-zA-Z]+(?:[0-9]*\\s*[a-zA-Z]*)*)>\\s+<([a-zA-Z]+(?:\\s[a-zA-Z]+)*)>$", Pattern.CASE_INSENSITIVE);
            final Matcher lms_return_book_matcher = lms_return_book_pattern.matcher(operation);

            final Pattern lms_remove_book_pattern = Pattern.compile("^lib\\s+remove\\s+book\\s+<([0-9]*\\s*[a-zA-Z]+(?:[0-9]*\\s*[a-zA-Z]*)*)>\\s+<([a-zA-Z]+(?:\\s[a-zA-Z]+)*)>$", Pattern.CASE_INSENSITIVE);
            final Matcher lms_remove_book_matcher = lms_remove_book_pattern.matcher(operation);

            final Pattern lms_goPortalPass_pattern = Pattern.compile("^lib\\s+remove\\s+book\\s+<([0-9]*\\s*[a-zA-Z]+(?:[0-9]*\\s*[a-zA-Z]*)*)>\\s+<([a-zA-Z]+(?:\\s[a-zA-Z]+)*)>$", Pattern.CASE_INSENSITIVE);
            final Matcher lms_goPortalPass_matcher = lms_goPortalPass_pattern.matcher(operation);

            final Pattern lms_help_pattern = Pattern.compile("^Library\\s+System\\s+--help$", Pattern.CASE_INSENSITIVE);
            final Matcher lms_help_matcher = lms_help_pattern.matcher(operation);

            final Pattern lms_exit_pattern = Pattern.compile("^Exit", Pattern.CASE_INSENSITIVE);
            final Matcher lms_exit_matcher = lms_exit_pattern.matcher(operation);


            if (lms_help_matcher.find()) {
                printLibrarySupportedCommand();
                System.out.println("*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+");
            } else if (lms_add_book_matcher.find()) {
                String title = lms_add_book_matcher.group(1);
                String author = lms_add_book_matcher.group(2);
                String description = lms_add_book_matcher.group(3);
                library.addBook(title, author, description);
                System.out.println("*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+");
            } else if (lms_get_operating_hours_matcher.find()) {
                System.out.println(library.getOperating_hours());
                System.out.println("*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+");
            } else if (lms_rent_book_matcher.find()) {
                String book_name = lms_rent_book_matcher.group(1);
                String author = lms_rent_book_matcher.group(2);
                library.rentBook(book_name, author, signed_in_name, signed_in_phone_number);
                System.out.println("*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+");
            } else if (lms_available_book_matcher.find()) {
                library.printAvailableBooks();
                System.out.println("*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+");
            } else if (lms_remove_member_matcher.find()) {
                String user_name = lms_remove_member_matcher.group(1);
                String phone_number = lms_remove_member_matcher.group(2);
                phone_number = phone_number.startsWith("0") ? phone_number : ("0").concat(phone_number);
                System.out.println("Removing users from the library require admin access . enter your name , phone number and password respectively :");
                System.out.print(">>");
                String name, phone_number_2, password;
                name = input.nextLine();
                phone_number_2 = input.nextLine();
                phone_number_2 = phone_number_2.startsWith("0") ? phone_number_2 : ("0").concat(phone_number_2);
                password = input.nextLine();
                if (library.adminExistenceChecker(name, phone_number_2, password) != null) {
                    library.rmMember(user_name, phone_number);
                    System.out.println("*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+");
                } else {
                    System.out.println("╔════════════════════════════════════════════════════════════╗");
                    System.out.println("║ Access denied, Wrong admin password                        ║");
                    System.out.println("╚════════════════════════════════════════════════════════════╝");
                }
            } else if (lms_return_book_matcher.find()) {
                String book_name = lms_return_book_matcher.group(1);
                String author = lms_return_book_matcher.group(2);
                library.returnBook(book_name, author, signed_in_name, signed_in_phone_number);
                System.out.println("*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+");
            } else if (lms_remove_book_matcher.find()) {
                String title = lms_remove_book_matcher.group(1);
                String author = lms_remove_book_matcher.group(2);
                System.out.println("Removing books from the book repository require admin access . enter your name , phone number and password respectively :");
                System.out.print(">>");
                String name, phone_number, password;
                name = input.nextLine();
                System.out.print(">>");
                phone_number = input.nextLine();
                phone_number = phone_number.startsWith("0") ? phone_number : ("0").concat(phone_number);
                System.out.print(">>");
                password = input.nextLine();
                if (library.adminExistenceChecker(name, phone_number, password) != null) {
                    library.rmBook(title, author);
                    System.out.println("*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+");
                } else {
                    System.out.println("╔════════════════════════════════════════════════════════════╗");
                    System.out.println("║ Access denied, Wrong admin password                        ║");
                    System.out.println("╚════════════════════════════════════════════════════════════╝");
                }
            } else if (lms_goPortalPass_matcher.find()) {
                System.out.println("════ ════ ════ ════ ════ ════ ════ ════ ════ ════ ═════ ════ ═════ ════ ════");
                libraryPortalPass();
                libraryLobby();
            } else if (lms_exit_matcher.find()) {
                System.out.println("\n\n\n");
                System.out.println("╔══════════════════════════════════════════════════════════════╗");
                System.out.println("║ Good luck!                                                      ║");
                System.out.println("║ Hope to see you again.                                          ║");
                System.out.println("║ Bye :D                                                          ║");
                System.out.println("╚══════════════════════════════════════════════════════════════╝");

                System.exit(0);
            } else {
                System.out.println("╔══════════════════════════════════════════════════════════════╗");
                System.out.println("║ Invalid command... Try again.                                   ║");
                System.out.println("║ Keep in mind that this error may be caused by entering the     ║");
                System.out.println("║ wrong command or entering the name, mobile number, or password ║");
                System.out.println("║ in the wrong form.                                              ║");
                System.out.println("╚══════════════════════════════════════════════════════════════╝");

                System.out.println("*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+");
            }
        }

    }
}
