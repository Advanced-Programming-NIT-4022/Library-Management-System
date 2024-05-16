package org.LMS;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class CLI {
    private final Scanner scanner = new Scanner(System.in);
    boolean loggedIn = false;
    OptionSelector normalUserMainOptions = new OptionSelector();
    OptionSelector adminUserMainOptions = new OptionSelector();
    private Library library;

    {
        OptionSelector userOptions = new OptionSelector();
        userOptions.add("remove", arguments -> {
            if (arguments.length == 0) {
                try {
                    if (!library.removeUser(library.currentUser.id)) System.out.println("User not found!");
                    else loggedIn = false;
                } catch (SQLException e) {
                    if (e.getErrorCode() == 1451)
                        System.out.println("Couldn't remove User!\nUser have some rented books!");
                    else e.printStackTrace();
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a number!");
                }
            } else {
                PrintError.manyArguments();
            }
        });

        OptionSelector bookOptions = new OptionSelector();


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

        bookOptions.add("show-rented", arguments -> {
            if (arguments.length == 0) {
                try {
                    ArrayList<Book> result = library.listBooks(false, library.currentUser.id);
                    for (Book book : result) {
                        System.out.println(book.toString());
                    }
                } catch (SQLException ignored) {
                }
            } else PrintError.manyArguments();
        });
        bookOptions.add("rent", arguments -> {
            switch (arguments.length) {
                case 0:
                    PrintError.fewArguments();
                    break;
                case 1:
                    try {
                        library.rentBook(library.currentUser.id, Integer.parseInt(arguments[0]));
                    } catch (SQLException e) {
                        if (e.getErrorCode() == 1062)
                            System.out.println("Couldn't rent book!\bBook is already rented!");
                        else e.printStackTrace();
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a number!");
                    }
                    break;
                default:
                    PrintError.manyArguments();
            }
        });

        bookOptions.add("return", arguments -> {
            switch (arguments.length) {
                case 0:
                    PrintError.fewArguments();
                    break;
                case 1:
                    try {
                        if (!library.returnBook(Integer.parseInt(arguments[0])))
                            System.out.println("Book is not rented or not rented by you!");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a number!");
                    }
                    break;
                default:
                    PrintError.manyArguments();
            }
        });

        OptionSelector libraryOptions = new OptionSelector();
        libraryOptions.add("book", bookOptions::select);
        libraryOptions.add("user", userOptions::select);
        libraryOptions.add("get-hrs", arguments -> {
            if (arguments.length > 0) {
                PrintError.manyArguments();
                return;
            }
            System.out.println(library.getHours());
        });

        normalUserMainOptions.add("lib", libraryOptions::select);
        normalUserMainOptions.add("exit", arguments -> loggedIn = false);
        normalUserMainOptions.add("help", arguments -> System.out.println("lib user remove : Remove your user.\n" +
                "lib book list <search word>(optional) : Show all book or search through them.\n" +
                "lib book show-available : Show all available books.\n" +
                "lib book show-rented : Show all books rented by you.\n" +
                "lib book rent <bookID> : Rents a book.\n" +
                "lib book return <bookID> : Returns a book.\n" +
                "lib get-hrs : Retrieve library operating hours.\n" +
                "exit : Logout from library.\n" +
                "help : Show this help."));
    }

    {
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
                        if (!UserInput.verifyPhoneNumber(arguments[2])) {
                            System.out.println("Wrong phone number!");
                            break;
                        }
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
                        if (!UserInput.verifyPhoneNumber(arguments[2])) {
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
        userOptions.add("remove", arguments -> {
            switch (arguments.length) {
                case 0:
                    PrintError.fewArguments();
                    break;
                case 1:
                    try {
                        if (!library.removeUser(Integer.parseInt(arguments[0]))) System.out.println("User not found!");
                    } catch (SQLException e) {
                        System.out.println("Couldn't remove book!");
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a number!");
                    }
                    break;
                default:
                    PrintError.manyArguments();
            }
        });

        userOptions.add("list", arguments -> {
            try {
                System.out.println("Admins:");
                for (AdminUser admin : library.getAdminUserList()) {
                    System.out.println(admin);
                }
                System.out.println("Normal Users:");
                for (NormalUser normalUser : library.getNormalUserList()) {
                    System.out.println(normalUser);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
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
                        if (arguments[0].isEmpty()) {
                            System.out.println("Book name can't be empty!");
                            break;
                        }
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
        bookOptions.add("rent", arguments -> {
            switch (arguments.length) {
                case 0:
                    PrintError.fewArguments();
                    break;
                case 1:
                    try {
                        library.rentBook(library.currentUser.id, Integer.parseInt(arguments[0]));
                    } catch (SQLException e) {
                        if (e.getErrorCode() == 1062)
                            System.out.println("Couldn't rent book!\bBook is already rented!");
                        else e.printStackTrace();
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a number!");
                    }
                    break;
                case 2:
                    try {
                        library.rentBook(Integer.parseInt(arguments[1]), Integer.parseInt(arguments[0]));
                    } catch (SQLException e) {
                        if (e.getErrorCode() == 1062)
                            System.out.println("Couldn't rent book!\bBook is already rented!");
                        else e.printStackTrace();
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a number!");
                    }
                    break;
                default:
                    PrintError.manyArguments();
            }
        });

        bookOptions.add("return", arguments -> {
            switch (arguments.length) {
                case 0:
                    PrintError.fewArguments();
                    break;
                case 1:
                    try {
                        if (!library.returnBook(Integer.parseInt(arguments[0])))
                            System.out.println("Book is not rented or not rented by you!");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a number!");
                    }
                    break;
                default:
                    PrintError.manyArguments();
            }
        });

        OptionSelector libraryOptions = new OptionSelector();
        libraryOptions.add("book", bookOptions::select);
        libraryOptions.add("user", userOptions::select);
        libraryOptions.add("get-hrs", arguments -> {
            if (arguments.length > 0) {
                PrintError.manyArguments();
                return;
            }
            System.out.println(library.getHours());
        });
        libraryOptions.add("set-hrs", arguments -> {
            switch (arguments.length) {
                case 0:
                    PrintError.fewArguments();
                    break;
                case 1:
                    library.setHours(arguments[0]);
                    break;
                default:
                    PrintError.manyArguments();
            }
        });

        adminUserMainOptions.add("lib", libraryOptions::select);
        adminUserMainOptions.add("exit", arguments -> loggedIn = false);
        adminUserMainOptions.add("help", arguments -> {
        });
    }

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
        loggedIn = true;
        while (loggedIn) {
            System.out.print(">>> ");
            String[] args = UserInput.argumentsToArray(scanner.nextLine());
            normalUserMainOptions.select(args);
        }
    }

    void loginAsAdminUser(AdminUser admin) {
        library.currentUser = admin;
        loggedIn = true;
        while (loggedIn) {
            System.out.print(">>> ");
            String[] args = UserInput.argumentsToArray(scanner.nextLine());
            adminUserMainOptions.select(args);
        }
    }
}
