package org.LMS;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class CLI {
    private final Scanner scanner = new Scanner(System.in);
    boolean loggedIn = false;
    private Library library;

    CLI() {
        try {
            library = Library.getInstance("My org.LMS.Library", "localhost", "LMS", "LMS_password");
            System.out.println("Welcome to Library!");
            while (true) {
                if (!login()) break;
            }
        } catch (Exception e) {
            System.out.println("Couldn't connect to database!");
        }
    }

    private boolean login() {
        library.currentUser = null;
        User user = null;
        System.out.print("Username: ");
        String username = scanner.nextLine();
        if (username.isBlank()) return false;
        try {
            user = library.getUser(username);
        } catch (SQLException ignored) {

        }
        if (user instanceof NormalUser) {
            loginAsNormalUser((NormalUser) user);
        } else if (user instanceof AdminUser admin) {
            System.out.print("Password: ");
            if (admin.password.verifyPassword(scanner.nextLine())) {
                loginAsAdminUser(admin);
            } else {
                System.out.println("Wrong password!");
            }
        } else {
            System.out.println("User not found!");
        }
        return true;
    }

    void loginAsNormalUser(NormalUser user) {
        library.currentUser = user;
    }

    void loginAsAdminUser(AdminUser admin) {
        library.currentUser = admin;
        loggedIn = true;
        while (loggedIn) {
            System.out.print(">>> ");
            String[] args = UserInput.argumentsToArray(scanner.nextLine());

            OptionSelector userOptions = new OptionSelector();
            userOptions.add("add-user", arguments -> {
                switch (arguments.length) {
                    case 0:
                    case 1:
                    case 2:
                        PrintError.fewArguments();
                        break;
                    case 3:
                        try {
                            // Todo : verifying
                            library.addNormalUser(new NormalUser(arguments[0], arguments[1], arguments[2]));
                        } catch (SQLException e) {
                            System.out.println("Couldn't add User! (username is used by another user)");
                        }
                        break;
                    default:
                        PrintError.manyArguments();
                }
            });

            userOptions.add("add-admin", arguments -> {
                switch (arguments.length) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                        PrintError.fewArguments();
                        break;
                    case 4:
                        try {
                            if(!UserInput.verifyPhoneNumber(arguments[2])){
                                System.out.println("Wrong phone number!");
                                break;
                            }
                            library.addAdminUser(new AdminUser(arguments[0], arguments[1], arguments[2], new Password(arguments[3])));
                        } catch (SQLException e) {
                            System.out.println("Couldn't add User! (username is used by another user)");
                        }
                        break;
                    default:
                        PrintError.manyArguments();
                }
            });
            userOptions.add("remove",arguments -> {
                switch (arguments.length) {
                    case 0:
                        PrintError.fewArguments();
                        break;
                    case 1:
                        try {
                            if (!library.removeUser(Integer.parseInt(arguments[0])))
                                System.out.println("User not found!");
                        } catch (SQLException e) {
                            System.out.println("Couldn't remove book!");
                        }
                        catch (NumberFormatException e){
                            System.out.println("Please enter a number!");
                        }
                        break;
                    default:
                        PrintError.manyArguments();
                }
            });

            userOptions.add("list",arguments -> {

            });


            OptionSelector bookOptions = new OptionSelector();
            bookOptions.add("add", arguments -> {
                switch (arguments.length) {
                    case 0:
                    case 1:
                    case 2:
                        PrintError.fewArguments();
                        break;
                    case 3:
                        try {
                            // Todo : verifying
                            library.addBook(new Book(arguments[0], arguments[1], arguments[2]));
                        } catch (SQLException e) {
                            System.out.println("Couldn't add book!");
                        }
                        break;
                    default:
                        PrintError.manyArguments();
                }
            });

            bookOptions.add("remove", arguments -> {
                switch (arguments.length) {
                    case 0:
                        PrintError.fewArguments();
                        break;
                    case 1:
                        try {
                            if (!library.removeBook(Integer.parseInt(arguments[0])))
                                System.out.println("No book to remove!");
                        } catch (SQLException e) {
                            System.out.println("Couldn't remove book!");
                        }
                        break;
                    default:
                        PrintError.manyArguments();
                }
            });


            bookOptions.add("list", arguments -> {

                if (arguments.length == 0) {
                    try {
                        ArrayList<Book> result = library.listBooks();
                        for (Book book : result) {
                            System.out.println(book.toString());
                        }
                    } catch (SQLException ignored) {
                    }
                } else if (arguments.length == 1) {

                    try {
                        ArrayList<Book> result = library.listBooks(arguments[0]);
                        for (Book book : result) {
                            System.out.println(book.toString());
                        }
                    } catch (SQLException ignored) {
                    }
                }
            });

            bookOptions.add("show-available", arguments -> {
                if (arguments.length == 0) {
                    try {
                        ArrayList<Book> result = library.listBooks(true);
                        for (Book book : result) {
                            System.out.println(book.toString());
                        }
                    } catch (SQLException ignored) {
                    }
                } else if (arguments.length == 1) {

                    try {
                        ArrayList<Book> result = library.listBooks(arguments[0]);
                        for (Book book : result) {
                            System.out.println(book.toString());
                        }
                    } catch (SQLException ignored) {
                    }
                }
            });

            OptionSelector libraryOptions = new OptionSelector();
            libraryOptions.add("book", bookOptions::select);
            libraryOptions.add("user", userOptions::select);

            OptionSelector mainOptions = new OptionSelector();
            mainOptions.add("lib", libraryOptions::select);
            mainOptions.add("exit", arguments -> loggedIn = false);
            mainOptions.select(args);

        }
    }
}
