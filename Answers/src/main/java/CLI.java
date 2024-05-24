import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CLI {

    public static final String RESET = "\033[0m";
    public static final String BLACK = "\033[0;30m";
    public static final String RED = "\033[0;31m";
    public static final String GREEN = "\033[0;32m";
    public static final String YELLOW = "\033[0;33m";
    public static final String BLUE = "\033[0;34m";
    public static final String PURPLE = "\033[0;35m";
    public static final String CYAN = "\033[0;36m";
    public static final String WHITE = "\033[0;37m";
    public static final String BLACK_BRIGHT = "\033[0;90m";
    public static final String RED_BRIGHT = "\033[0;91m";
    public static final String GREEN_BRIGHT = "\033[0;92m";
    public static final String YELLOW_BRIGHT = "\033[0;93m";
    public static final String BLUE_BRIGHT = "\033[0;94m";
    public static final String PURPLE_BRIGHT = "\033[0;95m";
    public static final String CYAN_BRIGHT = "\033[0;96m";
    public static final String WHITE_BRIGHT = "\033[0;97m";
    public static boolean adminOrUser;

    private static int idCounter = 100;

    public static synchronized int createID() {
        return idCounter++;
    }

    public static void changeHours(Library l , boolean b) {
        if (!b) {
            int start = l.getOperating_hours1();
            int finished = l.getOperating_hours2();
            System.out.println(BLUE + "The library opens at " + start + " and " + "closes at " + finished + RESET);
            System.out.println(BLUE + "if you want to change the library's operating hours enter YES" + RESET);
            Scanner input = new Scanner(System.in);

            while (true) {
                String entry = input.nextLine();
                if (Objects.equals(entry, "yes") || Objects.equals(entry, "YES")) {
                    System.out.println(BLUE + "please enter the opening hour : " + RESET);
                    while (true) {
                        System.out.print(BLUE + "Enter a number (0-24) for opening hour : " + RESET);
                        String userInput = input.nextLine();
                        try {
                            int number = Integer.parseInt(userInput);
                            if (number >= 0 && number <= 24) {
                                System.out.println(GREEN + "You entered: " + number + RESET);
                                l.setOperating_hours1(number);
                                break;
                            } else {
                                System.out.println(RED + "Invalid input. Please enter a number between 0 and 24." + RESET);
                            }
                        } catch (NumberFormatException e) {
                            System.out.println(RED + "Invalid input. Please enter a number between 0 and 24." + RESET);
                        }
                    }
                    while (true) {
                        System.out.print(BLUE + "Enter a number (0-24) for closing hour : " + RESET);
                        String userInput = input.nextLine();
                        try {
                            int number = Integer.parseInt(userInput);

                            if (number >= 0 && number <= 24) {
                                System.out.println(GREEN + "You entered: " + number + RESET);
                                l.setOperating_hours2(number);
                                break;
                            } else {
                                System.out.println(RED + "Invalid input. Please enter a number between 0 and 24." + RESET);
                            }
                        } catch (NumberFormatException e) {
                            System.out.println(RED + "Invalid input. Please enter a number between 0 and 24." + RESET);
                        }
                    }
                } else {
                    System.out.println(GREEN + "hmm..okay." + RESET);
                    break;
                }
            }
        } else {
            System.out.println(BLUE + "The library opens at " + l.getOperating_hours1() + " and " + "closes at " + l.getOperating_hours2() + RESET);
        }
    }

    public static void printUsers(Library l) {
        System.out.println(BLUE + "Members registered in the library so far:");
        for (NormalUser userid : l.userArray) {
            System.out.println(BLUE + "Name : " + userid.getName());
            System.out.println("Id : " + userid.getUnique_ID());
            System.out.println("Phone number : " + userid.getPhone_number());
            System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-" + RESET);
        }
    }

    public static void addMember(String id, String pass, Library l) {
//چک میکنه ببینه آیا پسورد ادمین درست هست یا خیر
        boolean adminValid = false;
        for (Admin adminUser : l.adminArray) {
            if (Objects.equals(pass, adminUser.getPassword())) {
                adminValid = true;
                break;
            }
        }
        if (!adminValid) {
            System.out.println(RED + "Invalid admin password." + RESET);
            return;
        }
//میگرده ببینه آیا این ایدی گرفته شده یا خیر
        for (User user : l.usersArray) {
            if (String.valueOf(user.getUnique_ID()).equals(id)) {
                System.out.println(RED + "This ID is already taken." + RESET);
                return;
            }
        }
        //حالا میاد مشخصات مورد نیاز دیگه رو دریافت میکنه
        Scanner input2 = new Scanner(System.in);
        String name;
        String phoneNumber;

        while (true) {
            System.out.println(BLUE + "Enter their name please:" + RESET);
            name = input2.nextLine().trim();
            if (name.matches("[a-zA-Z]+")) {
                break;
            } else {
                System.out.println(RED + "You can only use alphabets." + RESET);
            }
        }

        while (true) {
            System.out.println(BLUE + "Enter their phone number starting with 0 :" + RESET);
            phoneNumber = input2.nextLine().trim();
            if (phoneNumber.matches("09\\d{9}")) {
                break;
            } else {
                System.out.println(RED + "Wrong entry. Phone number should be 11 digits starting with 09." + RESET);
            }
        }
//حالا میاد یوزر رو تو ارری لیست هامون ادد میکنه
        int userId = Integer.parseInt(id);
        NormalUser normUser = new NormalUser(name, userId, phoneNumber);
        l.userArray.add(normUser);
        l.usersArray.add(normUser);

        System.out.println(GREEN + "You have successfully registered a new member." + RESET);
        System.out.println(GREEN + "Their ID is " + id + RESET);
        printUsers(l);
    }

    public static void removeMember(String id, String pass, Library l) {
        printUsers(l);
        boolean adminValid = false;
        for (Admin adminUser : l.adminArray) {
            if (Objects.equals(pass, adminUser.getPassword())) {
                adminValid = true;
                break;
            }
        }
        if (!adminValid) {
            System.out.println(RED + "Invalid admin password." + RESET);
            return;
        }

        boolean removed = false;
        NormalUser removeMember;
        for (NormalUser user : l.userArray) {
            if (String.valueOf(user.getUnique_ID()).equals(id)) {
                removeMember = user;
                int userId = Integer.parseInt(id);
                String name = user.getName();
                String phoneNum = user.getPhone_number();
                l.userArray.remove(removeMember);
                l.usersArray.remove(removeMember);
                System.out.println(GREEN + "You have successfully removed a member with the following details : ");
                System.out.println("Name : " + name);
                System.out.println("Id : " + id);
                System.out.println("Phone number : " + phoneNum);
                removed = true;
                printUsers(l);
                System.out.println(RESET);
                return;
            }
        }
        if (!removed) {
            System.out.println(RED + "Member with " + id + " id not found in the library." + RESET);
            return;
        }

    }

    public static void adminPre() {
        System.out.println(RED + "you are not in a position to do that, sorry." + RESET);

    }

    public static void memberRegistry(Library l) {
        Scanner input2 = new Scanner(System.in);
        System.out.println(BLUE + "Enter your name please." + RESET);
        String name;
        String phoneNumber;
        while (true) {
            name = input2.nextLine();
            name = name.trim();
            Pattern pr10 = Pattern.compile("[a-zA-Z]+");
            Matcher match10 = pr10.matcher(name);
            if (match10.matches()) {
                System.out.println(GREEN + "thanks." + RESET);
                break;
            } else {
                System.out.println(RED + "you can not use anything beyond alphabet." + RESET);
            }
        }
        System.out.println(BLUE + "Enter your phone number with 0 ." + RESET);
        while (true) {
            phoneNumber = input2.nextLine();
            if (phoneNumber.length() == 11) {
                if (phoneNumber.charAt(0) == '0' && phoneNumber.charAt(1) == '9') {
                    Pattern pr11 = Pattern.compile("^[0-9]+");
                    Matcher match11 = pr11.matcher(phoneNumber);
                    if (match11.find()) {
                        break;
                    }
                } else System.out.println(RED + "wrong entry" + RESET);
            } else {
                System.out.println(RED + "wrong entry , phone number should be 11 digits." + RESET);
            }
        }

        int id = createID();
        NormalUser normUser = new NormalUser(name, id, phoneNumber);
        l.userArray.add(normUser);
        System.out.println(GREEN + "you have successfully registered as a member." + RESET);
        System.out.println(GREEN + "your id is " + id + RESET);
    }

    public static void adminRegistry(Library l) {
        Scanner input2 = new Scanner(System.in);
        System.out.println(BLUE + "Enter your name please." + RESET);
        String name;
        String phoneNumber;
        while (true) {
            name = input2.nextLine();
            name = name.trim();
            Pattern pr10 = Pattern.compile("[a-zA-Z]+");
            Matcher match10 = pr10.matcher(name);
            if (match10.matches()) {
                break;
            } else {
                System.out.println(RED + "you can not use anything beyond alphabet." + RESET);
            }
        }
        System.out.println(BLUE + "Enter your phone number." + RESET);
        while (true) {
            phoneNumber = input2.nextLine();
            if (phoneNumber.length() == 11) {
                if (phoneNumber.charAt(0) == '0' && phoneNumber.charAt(1) == '9') {
                    Pattern pr11 = Pattern.compile("^[0-9]+");
                    Matcher match11 = pr11.matcher(phoneNumber);
                    if (match11.find()) {
                        break;
                    }
                } else System.out.println(RED + "wrong entry" + RESET);
            } else {
                System.out.println(RED + "wrong entry" + RESET);
            }
        }
        System.out.println(BLUE + "Please enter your password : " + RESET);
        Scanner input3 = new Scanner(System.in);
        String pass;
        while (true) {
            pass = input3.nextLine();
            if (pass.contains(" ")) {
                System.out.println(RED + "Invalid password.Spaces are not allowed." + RESET);
            } else {
                //System.out.println("Password set successfully!");
                break;
            }
        }
        int id = createID();
        System.out.println(GREEN + "You have successfully registered as an admin." + RESET);
        System.out.println(GREEN + "Your id is " + id + " and your password is " + pass + RESET);
        User adminAdd = new User(name, id, phoneNumber);
        Admin adminUser = new Admin(name, id, phoneNumber, pass);
        l.adminArray.add(adminUser);
        l.usersArray.add(adminAdd);
    }

    static int Bookid = 0;

    public static int booksId() {
        return Bookid++;
    }

    public static Book Book(String bookName, String author, String subtitle, int id, boolean Availability_status) {
        Book myBook = new Book(id, bookName, author, Availability_status, subtitle);
        return myBook;
    }

    public static void addBook(Library l, Book b) {
        l.book_repository.add(b);
        System.out.println(GREEN + "you have successfully added the book " + b.getTitle() + RESET);
    }

    public static void rentBook(Library l, String name, boolean k) {
        if (k) {
            boolean bookFound = false;
            for (Book book_repo : l.book_repository) {
                if (book_repo.getTitle().equals(name)) {
                    bookFound = true;
                    if (book_repo.getAvailability_status()) {
                        Scanner input2 = new Scanner(System.in);
                        String nameMember;
                        String id;
                        while (true) {
                            System.out.println(BLUE + "Enter the name please :" + RESET);
                            nameMember = input2.nextLine().trim();
                            if (nameMember.matches("[a-zA-Z]+")) {
                                break;
                            } else {
                                System.out.println(RED + "You can only use alphabets." + RESET);
                            }
                        }

                        while (true) {
                            System.out.println(BLUE + "Enter the id please:" + RESET);
                            id = input2.nextLine().trim();
                            if (id.matches("[0-9]+")) {
                                break;
                            } else {
                                System.out.println(RED + "Wrong entry. ID should be digits only." + RESET);
                            }
                        }
                        int userId = Integer.parseInt(id);
                        boolean userFound = false;

                        for (NormalUser NormUser : l.userArray) {
                            if (NormUser.getUnique_ID() == userId) {
                                userFound = true;
                                if (nameMember.equals(NormUser.getName())) {
                                    int rentId = createID();
                                    LocalDate now = LocalDate.now();
                                    Rent rented = new Rent(book_repo, NormUser, rentId, now);
                                    book_repo.setAvailability_status(false);
                                    System.out.println(GREEN + "You have rented the book named " + name + " successfully.");
                                    System.out.println("Your rental id is " + rentId + " on " + now);
                                    System.out.println("Please remember your rental id, you will need it for returning the book." + RESET);
                                    l.rental_registries.add(rented);
                                    return;
                                } else {
                                    System.out.println(RED + "The name doesn't match the id." + RESET);
                                    return;
                                }
                            }
                        }
                        if (!userFound) {
                            System.out.println(RED + "The id doesn't exist." + RESET);
                        }
                        return;
                    } else {
                        System.out.println(RED + "Sorry, we can't give it to you, someone else has rented the book." + RESET);
                        return;
                    }
                }
            }
            if (!bookFound) {
                System.out.println(RED + "We don't have this book, you can add it later if you want." + RESET);
            }
        } else System.out.println(RED + "you cant rent a book as an admin user." + RESET);
    }

    public static void availableBooks(Library l) {
        boolean noBooks = true;
        for (Book book : l.book_repository) {
            if (book.getAvailability_status()) {
                System.out.println(BLUE);
                System.out.println("Name : " + book.getTitle());
                System.out.println("Author : " + book.getAuthor());
                System.out.println("Description : " + book.getDescription());
                System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-" + RESET);
                noBooks = false;
            }
        }
        if (noBooks) {
            System.out.println(RED + "We don't have any books available, sorry." + RESET);
        }
    }

    public static void returnBook(Library l, String name) {
        boolean bookFound = false;
        for (Rent rent : l.rental_registries) {
            if (rent.bookie.getTitle().equals(name)) {
                bookFound = true;
                if (!rent.bookie.getAvailability_status()) {
                    Scanner input2 = new Scanner(System.in);
                    String nameMember;
                    String idMember;
                    String rentalId;

                    while (true) {
                        System.out.println(BLUE + "Enter your name : " + RESET);
                        nameMember = input2.nextLine().trim();
                        if (nameMember.matches("[a-zA-Z]+")) {
                            break;
                        } else {
                            System.out.println(RED + "Sorry, you must only use alphabets." + RESET);
                        }
                    }
                    while (true) {
                        System.out.println(BLUE + "Enter your id : " + RESET);
                        idMember = input2.nextLine().trim();
                        if (idMember.matches("[0-9]+")) {
                            break;
                        } else {
                            System.out.println(RED + "Sorry, you must only use digits." + RESET);
                        }
                    }
                    while (true) {
                        System.out.println(BLUE + "Enter the rental id :" + RESET);
                        rentalId = input2.nextLine().trim();
                        if (rentalId.matches("[0-9]+")) {
                            break;
                        } else {
                            System.out.println(RED + "Sorry, you must only use digits." + RESET);
                        }
                    }

                    int intRentalId = Integer.parseInt(rentalId);
                    int intMemberId = Integer.parseInt(idMember);

                    if (rent.Rental_ID == intRentalId && rent.NormUser.getUnique_ID() == intMemberId && nameMember.equals(rent.NormUser.getName())) {
                        rent.bookie.setAvailability_status(true);
                        l.rental_registries.remove(rent);
                        System.out.println(GREEN + "You have returned the book named " + name + " successfully." + RESET);
                        return;
                    } else {
                        System.out.println(RED + "Your rental ID or member information is incorrect." + RESET);
                        return;
                    }
                } else {
                    System.out.println(RED + "The book is already available in the library." + RESET);
                    return;
                }
            }
        }
        if (!bookFound) {
            System.out.println(RED + "The book is not registered in our library." + RESET);
        }
    }

    public static void rentBookie(Library l, String name, String memberName, String memberId, boolean k) {
        if (k) {
            boolean bookFound = false;
            for (Book book_repo : l.book_repository) {
                if (book_repo.getTitle().equals(name)) {
                    bookFound = true;
                    if (book_repo.getAvailability_status()) {

                        int userId = Integer.parseInt(memberId);
                        boolean userFound = false;

                        for (NormalUser NormUser : l.userArray) {
                            if (NormUser.getUnique_ID() == userId) {
                                userFound = true;
                                if (memberName.equals(NormUser.getName())) {
                                    int rentId = createID();
                                    LocalDate now = LocalDate.now();
                                    Rent rented = new Rent(book_repo, NormUser, rentId, now);
                                    book_repo.setAvailability_status(false);
                                    System.out.println(GREEN + "You have rented the book named " + name + " successfully." + RESET);
                                    System.out.println(GREEN + "Your rental ID is " + rentId + " on " + now + ".");
                                    System.out.println("Please remember your rental id, you will need it for returning the book." + RESET);
                                    l.rental_registries.add(rented);
                                    return;
                                } else {
                                    System.out.println(RED + "The name doesn't match the ID." + RESET);
                                    return;
                                }
                            }
                        }
                        if (!userFound) {
                            System.out.println(RED + "The ID doesn't exist." + RESET);
                        }
                        return;
                    } else {
                        System.out.println(RED + "Sorry, we can't give it to you, someone else has rented the book." + RESET);
                        return;
                    }
                }
            }
            if (!bookFound) {
                System.out.println(RED + "We don't have this book, you can add it later if you want." + RESET);
            }
        } else System.out.println(RED + "you cant rent book as an admin user." + RESET);
    }

    public static void finito() {
        System.out.println(CYAN + "there is only one thing that could replace a new book, the next book ;)\n");
        System.out.println("hope you enjoyed the moments you used our library." + RESET);
    }

    public static boolean regex(String s, Library lib, boolean b) {
        Pattern pr1 = Pattern.compile("^lib\\s+add\\s+book\\s+<([a-zA-Z0-9]+(?:\\s+[a-zA-Z0-9]*)*)>\\s+<([a-zA-Z0-9]+(?:\\s+[a-zA-Z0-9]*)*)>\\s+<([a-zA-Z0-9]+(?:\\s+[a-zA-Z0-9]*)*)>");
        Matcher match1 = pr1.matcher(s);
        if (match1.find()) {
            addBook(lib, Book(match1.group(1), match1.group(2), match1.group(3), booksId(), true));
            return true;
        }

        Pattern pr2 = Pattern.compile("^lib\\s+get\\s+hrs");
        Matcher match2 = pr2.matcher(s);
        if (match2.find()) {
                changeHours(lib,b);
                return true;
        }

        Pattern pr3 = Pattern.compile("^lib\\s+rent\\s+<([a-zA-Z0-9]+)>");
        Matcher match3 = pr3.matcher(s);
        if (match3.matches()) {
            rentBook(lib, match3.group(1), b);
            return true;
        }

        Pattern pr4 = Pattern.compile("^lib\\s+add\\s+member\\s+<([0-9]+)>\\s+<([^\\s]+)>");
        Matcher match4 = pr4.matcher(s);
        if (match4.find()) {
            if (b == false) {
                addMember(match4.group(1), match4.group(2), lib);
                return true;
            } else {
                adminPre();
            }
        }

        Pattern pr5 = Pattern.compile("^lib\\s+rent\\s+<([a-zA-Z0-9]+(?:\\s+[a-zA-Z0-9]*)*)>\\s+<([a-zA-Z]+(?:\\s+[a-zA-Z]*)*)>\\s+<([0-9]+)>");
        Matcher match5 = pr5.matcher(s);
        if (match5.find()) {
            rentBookie(lib, match5.group(1), match5.group(2), match5.group(3), b);
            return true;
        }

        Pattern pr6 = Pattern.compile("^lib\\s+get\\s+available\\s+books");
        Matcher match6 = pr6.matcher(s);
        if (match6.find()) {
            availableBooks(lib);
            return true;
        }

        Pattern pr7 = Pattern.compile("^lib\\s+remove\\s+member\\s+<([0-9]+)>\\s+<([^\\s]+)>");
        Matcher match7 = pr7.matcher(s);
        if (match7.find()) {
            if (b == false) {
                removeMember(match7.group(1), match7.group(2), lib);
                return true;
            } else {
                adminPre();
            }
        }

        Pattern pr8 = Pattern.compile("^lib\\s+return\\s+<([a-zA-Z0-9]+(?:\\s+[a-zA-Z0-9]*)*)>");
        Matcher match8 = pr8.matcher(s);
        if (match8.find()) {
            returnBook(lib, match8.group(1));
            return true;
        }

        Pattern pr9 = Pattern.compile("^lib\\s+finished\\s*");
        Matcher match9 = pr9.matcher(s);
        if (match9.find()) {
            finito();
            return false;
        }

        Pattern pr10 = Pattern.compile("^lib\\s+login\\s*");
        Matcher match10 = pr10.matcher(s);
        if (match10.find()) {
            login(lib);
            return true;
        }

        return false;
    }

    public static void commands() {
        System.out.println(PURPLE + "If you want to Add a new book to the library" + YELLOW + " ---------->>" + PURPLE + " lib add book <name> <author> <subtitle>\n" + RESET);
        System.out.println(PURPLE + "If you want to Retrieve library operating hours" + YELLOW + " ---------->>" + PURPLE + " lib get hrs\n" + RESET);
        System.out.println(PURPLE + "If you want to Rent a book from the library" + YELLOW + " ---------->>" + PURPLE + " lib rent <bookName>\n" + RESET);
        System.out.println(PURPLE + "If you want to Add a new member to the library (admin privilege required)" + YELLOW + " ---------->>" + PURPLE + " lib add member <studentID> <password>\n" + RESET);
        System.out.println(PURPLE + "If you want to Rent a book for a specific member" + YELLOW + " ---------->>" + PURPLE + " lib rent <bookName> <memberName> <memberID>\n" + RESET);
        System.out.println(PURPLE + "If you want to View available books for rental" + YELLOW + " ---------->>" + PURPLE + " lib get available books.\n" + RESET);
        System.out.println(PURPLE + "If you want to Remove a member from the library (admin privilege required)" + YELLOW + " ---------->>" + PURPLE + " lib remove member <memberID> <password>\n" + RESET);
        System.out.println(PURPLE + "If you want to Return a rented book to the library" + YELLOW + " ---------->>" + PURPLE + " lib return <bookName>\n" + RESET);
        System.out.println(PURPLE + "If you want to back to login page" + YELLOW + " ---------->>" + PURPLE + " lib login\n" + RESET);
        System.out.println(PURPLE + "If you want to exit" + YELLOW + " ---------->>" + PURPLE + " lib finished\n" + RESET);
    }

    public static void login(Library myLib) {
        System.out.println(BLUE + "welcome to our library\nif you want to enter as a normal user press 1.\nand if you want to enter as an admin press 2." + RESET);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String entry1 = scanner.nextLine();
            if (Objects.equals(entry1, "1")) {
                memberRegistry(myLib);
                adminOrUser = true;
                break;
            } else if (Objects.equals(entry1, "2")) {
                adminRegistry(myLib);
                adminOrUser = false;
                break;
            } else {
                System.out.println(RED + "wrong entry , try again.\n" + RESET);
            }
        }
    }

    public static void main(String[] args) {
        Library myLib = new Library("ketabkhoone", 50, 9, 9);

        login(myLib);
        while (true) {
            commands();
            Scanner input = new Scanner(System.in);
            String entry = input.nextLine();
            if (regex(entry, myLib, adminOrUser)) {
                continue;
            } else if (!Objects.equals(entry, "lib finished")) {
                System.out.println(RED + "wrong entry, try again.\n" + RESET);
            } else if (entry.equals("lib finished")) {
                break;
            }
        }
    }
}
