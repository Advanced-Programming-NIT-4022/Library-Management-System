// main class for handling the CLI

import javax.naming.NoPermissionException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidParameterException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class  MyApp {
    public static final Library library = new Library(); // our library
    public static final Path PATH = Paths.get(".library.txt");
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        // check to library is existed or not
        if (!Files.exists(PATH)) {
            System.out.println("Welcome to LMS(Library Management System)!");
            System.out.println("You should create your own library first\n");
            while (!createLibrary()); // first we should create a library to use it

            System.out.println("Now you should add a new admin to your library!");
            // add a new admin user
            while (true) {
                System.out.println("\nEnter these information about your admin:");
                try {
                    // get admin name
                    System.out.print("Name: ");
                    String name = input.nextLine();

                    // get admin phone number
                    System.out.print("Phone number: ");
                    String phoneNumber = input.nextLine();

                    // get admin password
                    System.out.print("Password: ");
                    String password = input.nextLine();

                    Admin admin = new Admin(name, phoneNumber, password);

                    if (!library.addUser(admin, password)) {
                        // delete library file
                        File libraryFile = PATH.toFile();
                        libraryFile.delete();

                        System.out.println("Terminating...");
                        System.exit(1);
                    }

                    library.setUser(admin); // this is log in now
                    System.out.println("You are now logged in!\n");
                } catch (IllegalArgumentException e) {
                    System.err.printf("%s%n", e.getMessage());
                    System.out.println("Try again.");
                    continue;
                }

                break;
            }
        }
        else {
            try (Scanner retrieveLibrary = new Scanner(PATH)) {
                library.setName(retrieveLibrary.nextLine());
                library.setCapacity(retrieveLibrary.nextInt());
                library.setOperatingHours(retrieveLibrary.next());

            } catch (IOException e) {
                System.err.printf("%s%n", e.getMessage());
                e.printStackTrace();
            }
        }
        // welcome to library
        System.out.printf("Welcome to %s library.%n", library.getName());
        System.out.println("For more information enter command <lib man>");
        System.out.println("\nEnter your command:");

        while (true) {
            String command = null;

            try {
                if (library.getUser() == null)
                    System.out.print(">>> ");
                else if (library.getUser() instanceof Admin)
                    System.out.print("Admin> ");
                else
                    System.out.printf("%s> ", library.getUser().getName());
                command = input.nextLine();
                CLI(command.trim());
            } catch (InvalidParameterException e) {
                System.err.println("Invalid username. please try again.");
            } catch (IllegalArgumentException e) {
                if (e.getMessage() == null)
                    System.out.printf("command <%s> %s%n", command.trim(), "Not Found.");
                else
                    System.out.printf("%s%n", e.getMessage());
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.printf("command <%s> %s%n", command.trim(), "Not Found.");
            } catch (NoPermissionException e) {
                System.out.printf("%s%n", e.getMessage());
            }
        }
    }

    private static boolean createLibrary() {
        System.out.println("Please enter these information about your library:");

        try {
            System.out.print("name : ");
            library.setName(input.nextLine());

            System.out.print("capacity : ");
            library.setCapacity(input.nextInt());
            input.nextLine();

            System.out.print("operating hours (format : xx-xx): ");
            library.setOperatingHours(input.nextLine());

            library.saveLibrary();

            System.out.println("Your library was created successfully.\n");
        } catch (InputMismatchException e) {
            System.err.printf("%s%n", e.getMessage());
            System.err.println("creation was not successful. Terminating program.");
            System.exit(1); // creation was not successful

        } catch (IllegalArgumentException e) {
            System.err.printf("%s%n%n", e.getMessage());
            System.out.println("Try again.");
            return false;
        } catch (SecurityException securityException) {
            System.err.println("Write permission denied. Terminating.");
            System.exit(1); // terminate the program

        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Error opening file. Terminating.");
            System.exit(1); // terminate the program
        }
        return true;
    }

    public static void CLI(String command) throws IllegalArgumentException, NoPermissionException {
        if (command.matches("lib\\sman"))
            Manual.print();
        else if (command.matches("lib\\slogout")) {
            System.out.printf("%s logged out successfully.%n", library.getUser().getName());
            library.setUser(null);
        } else if (command.matches("lib\\sadd\\sbook\\s\"?[^\"]*\"?\\s\"?[^\"]*\"?\\s?(\"?[^\"]*\"?)?")) {
            // if he didn't admin user yet throw exception
            if (library.getUser() instanceof Admin) {
                String title, author;

                // delete lib add book from command
                command = command.substring(13);

                // find the name of the book
                if (command.startsWith("\"")) {
                    command = command.substring(1);
                    title = command.substring(command.indexOf("\""));

                    // delete title of the book from command
                    command = command.substring(command.indexOf("\""));
                } else {
                    title = command.substring(command.indexOf(" "));

                    // delete title of the book from command
                    command = command.substring(command.indexOf(" "));
                }

                // find the author of the book
                if (command.startsWith("\"")) {
                    command = command.substring(1);
                    author = command.substring(command.indexOf("\""));

                    // delete author of the book from command
                    command = command.substring(command.indexOf("\""));
                } else {
                    author = command.substring(command.indexOf(" "));

                    // delete author of the book from command
                    command = command.substring(command.indexOf(" "));
                }

                // if command doesn't have description
                if (command == null) {
                    Book book = new Book(title, author);
                    library.addBook(book);
                    return;
                }

                String description;

                // find the desciption of the book
                if (command.startsWith("\"")) {
                    command = command.substring(1);
                    description = command.substring(command.indexOf("\""));

                    // delete description of the book from command
                    command = command.substring(command.indexOf("\""));
                } else {
                    description = command.substring(command.indexOf(" "));

                    // delete description of the book from command
                    command = command.substring(command.indexOf(" "));
                }

                // if command has too many argument
                if (command != null)
                    throw new IllegalArgumentException(
                            "You should use \" character to split string with space");

                Book book = new Book(title, author, description);
                library.addBook(book);
            } else
                throw new NoPermissionException("You don't have permission to add books!");
        } else if (command.matches("lib return \\w*")) {
            // return a book
        } else if (command.matches("lib\\slogin\\s\\d+")) {
            String[] temp = command.split("\\s");
            library.setUser(library.login(temp[2]));
            if (library.getUser() == null)
                throw new InvalidParameterException();
            else if (library.getUser() instanceof NormalUser)
                System.out.printf("Hello %s!You logged in successfully.%n", library.getUser().getName());
            else {
                Admin adminUser = (Admin) library.getUser();
                for (int i = 0; i < 3; i++) {
                    System.out.printf("Enter password for %s: ", adminUser.getName());
                    String password = input.nextLine();
                    if (adminUser.verify(password)) {
                        System.out.printf("Hello %s!You logged in successfully.%n", adminUser.getName());
                        return;
                    } else
                        System.out.println("Invalid password. Try again.");
                }
                library.setUser(null);
                throw new IllegalArgumentException("3 incorrect password attempts...");
            }
        } else if (command.matches("lib\\sadd\\smember\\s\"?[^\"]*\"?\\s\\+?\\d+\\s?[^(\"\\s)]*")) {
            // if he didn't admin user yet throw exception
            if (library.getUser() instanceof Admin) {
                String name, phoneNumber;

                String[] temp1 = command.split("\"");
                if (temp1.length == 3) {
                    name = temp1[1];

                    String[] temp2 = temp1[2].split("\\s");
                    phoneNumber = temp2[0];
                    User user;
                    if (temp2.length == 2) {
                        user = new Admin(name, phoneNumber, temp2[1]);
                        library.addUser(user, temp2[1]);
                    } else {
                        user = new NormalUser(name, phoneNumber);
                        library.addUser((NormalUser) user);
                    }
                } else {
                    String[] temp = command.split("\\s");

                    if (temp.length > 6)
                        throw new IllegalArgumentException(
                                "You should use \" character to split string with space");

                    name = temp[3];
                    phoneNumber = temp[4];

                    User user;
                    if (temp.length == 6) {
                        user = new Admin(name, phoneNumber, temp[5]);
                        library.addUser(user, temp[5]);
                    } else {
                        user = new NormalUser(name, phoneNumber);
                        library.addUser((NormalUser) user);
                    }
                } // end if (library.user instanceof Admin)
            } else
                throw new NoPermissionException("You don't have permission to add members!");
        } // end lib add member
        else if (command.matches("lib\\sexit")) {
            System.out.print("Bye.");
            System.exit(0);
        } // end lib exit
        else
            throw new IllegalArgumentException();
    }
}
