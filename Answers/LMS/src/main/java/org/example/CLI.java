package org.example;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static javax.print.attribute.standard.MediaSizeName.B;
import static javax.swing.text.html.HTML.Attribute.N;

public class CLI {

    public static void blue() {
        System.out.print("\033[1;36m");
    }
    public static void white() {
        System.out.print("\033[0m");
    }
    public static void red() {
        System.out.print("\033[1;31m");
    }
    public static void green() {
        System.out.print("\033[1;32m");
    }
    public static void yellow() {
        System.out.print("\033[1;33m");
    }
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_NILI = "\u001B[36m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_GRAY = "\u001B[37m";
    public static void print() {
        System.out.println("""
                if you want to add a new book to the library..........ENTER lib add book <name> <author> <subtitle>: .
                or Retrieve library operating hours...................ENTER lib get hrs\s
                or Rent a book from the library.......................ENTER lib rent <bookName>
                or Add a new member to the library....................ENTER lib add member
                or Add a new admin to the library.....................ENTER lib add admin
                or Rent a book for a specific member..................ENTER lib rent <bookName> <memberName> <memberID>\s
                or View available books for rental....................ENTER lib get available books\s
                or Remove a member from the library...................ENTER lib remove member 
                or Return a rented book to the library................ENTER lib return <bookName>""");
    }

    public static void printColoredText() {
        System.out.println(ANSI_NILI + "If you want to add a new book to the library..........ENTER" +
                ANSI_PURPLE + " lib add book <name> <author> <subtitle>\n" +
                ANSI_NILI + "or Retrieve library operating hours...................ENTER" +
                ANSI_PURPLE + " lib get hrs\n"+
                ANSI_NILI+ "or Rent a book from the library.......................ENTER" +
                ANSI_YELLOW + " lib rent <bookName>\n" +
                ANSI_NILI + "or Rent a book for a specific member..................ENTER" +
                ANSI_PURPLE + " lib rent <bookName> <memberName> <memberID>\n"+
                ANSI_NILI + "or Add a new member to the library....................ENTER" +
                ANSI_YELLOW + " lib add member\n"+
                ANSI_NILI+ "or Add a new admin to the library.....................ENTER" +
                ANSI_YELLOW + " lib add admin\n" +
                ANSI_NILI+ "or View available books for rental....................ENTER" +
                ANSI_PURPLE + " lib get available books\n" +
                ANSI_NILI + "or Remove a member from the library...................ENTER" +
                ANSI_YELLOW + " lib remove member\n"+
                ANSI_NILI+ "or Return a rented book to the library................ENTER" +
                ANSI_PURPLE + " lib return <bookName>\n" +
                ANSI_NILI + "or View members ......................................ENTER" +
                ANSI_PURPLE + " List\n" +
                ANSI_YELLOW + "Yellow ones are for admins only");

        blue();
    }

    public static void addbook(Library L, Book B) {
        L._Book_repository.add(B);
        yellow();
        System.out.println("Your book has been successfully registered");
        blue();
    }
    static int x=0;
    public static int idgeneratormember() {
        return ++x;
    }
    static int y=0;
    public static int idgeneratoradmin() {
        return ++y;
    }
    public static Book buildingbook(int ID, String title, String author, Boolean availability, String description) {
        Book b = new Book(ID, title, author, availability, description);
        return b;
    }
    public static boolean duplication(Library L, String title){
        for (Book Book : L._Book_repository){
            if(Objects.equals(Book.get_Title(), title)){
                return true;
            }
        }
        return false;
    }
    public static void rent(Library L , String name  ){
        System.out.println("Please enter your name ");
        Scanner scanner = new Scanner(System.in);
        String membername = scanner.next();
        System.out.println("Please enter your id ");
        long id = scanner.nextInt();
        boolean khastam=false;
        outerloop:
        while (true){
            Normal member = null;
            for (Normal N : L._Trustee) {
                if (Objects.equals(N.getName(), membername) && N.getId() == id) {
                    member=N;
                    khastam=true;
                    break ;
                }
                else if (Objects.equals(N.getName(), membername) && N.getId() != id) {
                    yellow();
                    System.out.println("Sorry we can't give this book because your name doesn't match with your id.");
                    blue();
                    khastam=true;
                    break outerloop;
                }
            }
            if(!khastam){
                yellow();
                System.out.println("Sorry we don't have you as a member in our list so we can't give you the book .if you're really interested, sign in first");
                blue();
                break ;
            }
            int count =0;
            boolean avail=false;
            Book bookToRent = null;
            for (Book B : L._Book_repository) {
                if (Objects.equals(B.get_Title(), name)) {
                    count++;
                    if(B.get_Availability()){
                        avail=true;
                        bookToRent = B;
                        break;
                    }
                }
            }
            if(count==0){
                yellow();
                System.out.println("Sorry it seems like we don't have this book. You can add it to our library.");
                blue();
                break ;
            }
            else if(count==1 && avail){
                bookToRent.set_Availability(false);
                Rent rent = new Rent(bookToRent, member, id);
                L._rental_registries.add(rent);
                yellow();
                System.out.println("Here is your book. please take care of it");
                blue();
                break ;
            }
            else if(!avail){
                System.out.println("Sorry it seems like someone else has already rented this book. check it out later");
                break ;
            }
        }
    }
    public static void rents(Library L, String name) {
        boolean check=false;
        boolean off=false;
        if (L._Book_repository.isEmpty()) {
            System.out.println("You have not registered a book yet.");}
        else{
            Scanner scanner = new Scanner(System.in);
            for (Book Book : L._Book_repository) {
                if (Book.get_Title().equals(name)) {
                    off = true;
                    if (Book.get_Availability()) {
                        System.out.println("Please enter your name ");
                        String n = scanner.next();
                        System.out.println("Please enter your id ");
                        long id = scanner.nextInt();
                        for (Normal N : L._Trustee) {
                            if (Objects.equals(n, N.getName())) {
                                if (id == N.getId()) {
                                    Rent rent = new Rent(Book, N, id);
                                    L._rental_registries.add(rent);
                                    yellow();
                                    System.out.println("The book has been successfully rented");
                                    blue();
                                    check = true;
                                    Book.set_Availability(false);
                                    break;
                                }
                            }
                        }
                        if (!check) {
                            System.out.println("We don't have a member with this name in our list. If you want to rent a book, you have to be a member first.\n");
                            break;
                        }
                    } else {
                        System.out.println("It seems that this book have been rented, check it out later");
                        break;
                    }
                }
            }
        }
        if(!check && !off){
            System.out.println("This book is not available at the moment, We would appreciate if you add it to our library.");}
    }
    public static void renttt(Library L, String name) {
        boolean bookFound = false;
        boolean bookRented = false;

        if (L._Book_repository.isEmpty()) {
            System.out.println("You have not registered a book yet.");
            return;
        }

        Scanner scanner = new Scanner(System.in);

        for (Book book : L._Book_repository) {
            if (book.get_Title().equals(name)) {
                bookFound = true;
                if (book.get_Availability()) {
                    System.out.println("Please enter your name: ");
                    String memberName = scanner.next();
                    System.out.println("Please enter your ID: ");
                    long memberId = scanner.nextLong();

                    for (Normal member : L._Trustee) {
                        if (Objects.equals(memberName, member.getName()) && memberId == member.getId()) {
                            Rent rent = new Rent(book, member, memberId);
                            L._rental_registries.add(rent);
                            System.out.println("\033[1;33mThe book has been successfully rented\033[0m"); // yellow text
                            book.set_Availability(false);
                            bookRented = true;
                            break;
                        }
                    }

                    if (!bookRented) {
                        System.out.println("We don't have a member with this name in our list. If you want to rent a book, you have to be a member first.");
                    }
                } else {
                    System.out.println("It seems that this book has already been rented, check it out later.");
                }
                break; // Exit the loop once the book is found and processed
            }
        }

        if (!bookFound) {
            System.out.println("This book is not available at the moment. We would appreciate it if you added it to our library.");
        }

        scanner.close();
    }
    public static void rentttt(Library L, String name) {
        boolean bookFound = false;
        boolean bookRented = false;
        if (L._Book_repository.isEmpty()) {
            System.out.println("You have not registered a book yet.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        for (Book book : L._Book_repository) {
            if (book.get_Title().equals(name)) {
                bookFound = true;
                if (book.get_Availability()) {
                    System.out.print("Please enter your name: ");
                    String memberName = "";
                    long memberId = -1;

                    if (scanner.hasNext()) {
                        memberName = scanner.next();
                    } else {
                        System.out.println("No input received for member name.");
                        break;
                    }

                    System.out.print("Please enter your ID: ");
                    try {
                        if (scanner.hasNextLong()) {
                            memberId = scanner.nextLong();
                        } else {
                            System.out.println("Invalid input for ID. Please enter a numeric value.");
                            scanner.next(); // Clear the invalid input
                            break;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input for ID. Please enter a numeric value.");
                        scanner.next(); // Clear the invalid input
                        break;
                    }

                    for (Normal member : L._Trustee) {
                        if (Objects.equals(memberName, member.getName()) && memberId == member.getId()) {
                            Rent rent = new Rent(book, member, memberId);
                            L._rental_registries.add(rent);
                            System.out.println("\033[1;33mThe book has been successfully rented\033[0m"); // yellow text
                            book.set_Availability(false);
                            bookRented = true;
                            break;
                        }
                    }

                    if (!bookRented) {
                        System.out.println("We don't have a member with this name in our list. If you want to rent a book, you have to be a member first.");
                    }
                } else {
                    System.out.println("It seems that this book has already been rented, check it out later.");
                }
                break; // Exit the loop once the book is found and processed
            }
        }

        if (!bookFound) {
            System.out.println("This book is not available at the moment. We would appreciate it if you added it to our library.");
        }

        scanner.close();
    }

    public static void returnbook(Library L, String name) {
        boolean match = true;
        for (Book Book : L._Book_repository) {
            if (Book.get_Title().equals(name)) {
                if (Book.get_Availability()) {
                    yellow();
                    System.out.println("It seems that we already have this book, give it to someone else");
                    blue();
                    match = false;
                    break;
                } else {
                    yellow();
                    Book.set_Availability(true);
                    System.out.println("Thanks for bringing our book back, hope you enjoyed it!");
                    blue();
                    match =false;
                    break;
                }
            }
        }
         if(match) {
            System.out.println("It seems that this book doesn't belong to our library ");
        }
    }
    static String phonenumber(String number) {
        if (number.length() != 10) {
            return "wrong";
        }
        char[] num = number.toCharArray();
        if (num[0] != '9') {
            return "wrong";
        }
        if (!number.matches("[0-9]+")) {
            return "wrong";
        }
        return '0' + number;
    }
    public static void membership(Library L) {
        Scanner scanner4 = new Scanner(System.in);
        System.out.println("Please enter your name");
        String name = scanner4.next();
        long userid = idgeneratormember();
        System.out.println("Please enter your phone number without the 0");
        String number = scanner4.next();
        while (true) {
            if (phonenumber(number).equals("wrong")) {
                red();
                System.out.println("Wrong entry. Try again.");
                blue();
                number = scanner4.next();
            }
            else {
                break;
            }
        }
        yellow();
        System.out.println("You have been successfully registered as a member.\nHere is you id: " + userid +".");
        blue();
        Normal normal_user = new Normal(name, userid, number);
        L._Trustee.add(normal_user);

    }
    public static void adminship(Library L) {
        Scanner scanner4 = new Scanner(System.in);
        System.out.println("Please enter your name");
        String name = scanner4.next();
        long userid = idgeneratoradmin();
        System.out.println("Please enter your phone number without the 0");
        String number = scanner4.next();
        while (true) {
            if (phonenumber(number).equals("wrong")) {
                red();
                System.out.println("Wrong entry. Try again.");
                blue();
                number = scanner4.next();
            } else {
                break;
            }
        }
        System.out.println("Please enter your password");
        String password = scanner4.next();
        yellow();
        System.out.println("You have been successfully registered as an admin.\nHere is you id: " + userid +".");
        blue();
        Admin admin = new Admin(name, userid, number, password);
        L._Boss.add(admin);
    }
    public static void addmemberbyadmin(Library L){

        Scanner scanner4 = new Scanner(System.in);
        System.out.println("Please enter member's name");
        String name = scanner4.next();
        long userid = idgeneratormember();
        System.out.println("Please enter their phone number without the 0");
        String number = scanner4.next();
        while (true) {
            if (phonenumber(number).equals("wrong")) {
                red();
                System.out.println("Wrong entry. Try again.");
                blue();
                number = scanner4.nextLine();
            } else {
                break;
            }
        }
        yellow();
        System.out.println("Your member have been successfully registered .\nHere is their id: " + userid +".");
        blue();
        Normal normal_user = new Normal(name, userid, number);
        L._Trustee.add(normal_user);
    }
    public static void addadminbyadmin(Library L){

        Scanner scanner4 = new Scanner(System.in);
        System.out.println("Please enter admin's name");
        String name = scanner4.next();
        long userid = idgeneratoradmin();
        System.out.println("Please enter their phone number without the 0");
        String number = scanner4.next();
        while (true) {
            if (phonenumber(number).equals("wrong")) {
                red();
                System.out.println("Wrong entry. Try again.");
                blue();
                number = scanner4.nextLine();
            } else {
                break;
            }
        }
        System.out.println("Please enter their password");
        String password = scanner4.next();
        yellow();
        System.out.println("Your admin have been successfully registered .\nHere is their id: " + userid +".");
        blue();
        Admin admin = new Admin(name, userid, number, password);
        L._Boss.add(admin);
    }
    public static void addmember(Library L ) {
        boolean true_boss = false;
        String name_boss = null;
        Scanner scanner4 = new Scanner(System.in);
        System.out.println("Dear admin please enter your personal password ");
        String password= scanner4.next();
        for (Admin A : L._Boss) {
            {
                if (Objects.equals(A.get_Password(), password)) {
                    true_boss = true;
                    name_boss = A.getName();
                }
            }
        }
        if (true_boss) {
            addmemberbyadmin(L);
            yellow();
            System.out.println("Done by " + name_boss);
            blue();
        }
        else {
            System.out.println("Sorry we didn't add your member because the admin couldn't remember their password.");
        }

    }
    public static void addadmin(Library L ) {
        boolean true_boss = false;
        String name_boss = null;
        Scanner scanner4 = new Scanner(System.in);
        System.out.println("Dear admin please enter your personal password ");
        String password= scanner4.next();
        for (Admin A : L._Boss) {
            {
                if (Objects.equals(A.get_Password(), password)) {
                    true_boss = true;
                    name_boss = A.getName();
                }
            }
        }
        if (true_boss) {
            addadminbyadmin(L);
            yellow();
            System.out.println("Done by " + name_boss);
            blue();
        }
        else {
            System.out.println("Sorry we didn't add your member because the admin couldn't remember their password.");
        }

    }
    public static void remove_member(Library L) {
        System.out.println("choose the member you want to remove and type their id ");
        for (Normal N : L._Trustee) {
            {
                yellow();
                System.out.println("------------------------------------");
                blue();
                System.out.println("NAME:  " + N.getName());
                System.out.println("USERID:  " + N.getId());
                yellow();
                System.out.println("------------------------------------");
                blue();
            }
        }
        Scanner S = new Scanner(System.in);
        long id = S.nextInt();
        while (true) {
            boolean remove = false;
            for (Normal N : L._Trustee) {
                {
                    if (id == N.getId()) {
                        L._Trustee.remove(N);
                        System.out.println( N.getName() +" was successfully deleted.");
                        remove = true;
                        break;
                    }
                }
            }
            if (remove) {
                break;
            } else {
                System.out.println("It seems like we don't have a member with this id so you cannot remove it.");
            }
        }

    }
    public static void wrongpose() {
        red();
        System.out.println(" Sorry! You are not at admin position so you can't do this command.");
        blue();
    }

    public static void showbooks(Library L) {
        if (L._Book_repository.isEmpty()) {
            System.out.println("You have not registered a book yet.");
        } else {
            for (Book B : L._Book_repository) {
                yellow();
                System.out.println("------------------------------");
                if (B.get_Availability()) {
                    blue();
                    System.out.println(B.get_Title() + "                 available");
                    yellow();
                } else {
                    blue();
                    System.out.println(B.get_Title() + ANSI_GRAY + "                 rented");
                    yellow();
                }
                System.out.println("------------------------------");
                blue();
            }

        }
    }
    public static void changehrs() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please your library's opening hour");

        int[] h = new int[2];
        h[0] = scanner.nextInt();
        while (true) {
            if (h[0]>=0 && h[0]<=24) {
                break;
            } else {
                red();
                System.out.println("what? choose an actual number that is inside the clock");
                blue();
                h[0] = scanner.nextInt();
            }
        }
        System.out.println("Please your library's closing hour");
        h[1] = scanner.nextInt();
        while (true) {
            if (h[1]>=0 && h[1]<=24 && h[1] > h[0]) {
                break;
            } else if (h[1]>=0 && h[1]<=24 && h[1] < h[0]) { yellow();
                System.out.println("Wow! a magical library!! How come the opening time is after the closing time? anyway0_0");
                blue();
                break;
            } else {
                red();
                System.out.println("what? choose an actual number that is inside the clock");
                blue();
                h[1] = scanner.nextInt();
            }
        }

    }
//    public static void rentspeceficc( String name ,String membername , long id, Library L  ){
//        System.out.println("sher o ver aval");
//        if (L._Book_repository.isEmpty()) {
//            System.out.println("You have not registered a book yet.");}
//        else{
//            System.out.println("sher o ver dovom");
//            boolean match = false;
//            boolean available = true;
//            while (true) {
//                for (Book B : L._Book_repository) {
//                    if (B.get_Title().equals(name)) {
//                        System.out.println("sher o ver sevom");
//                        match = true;
//                        if (B.get_Availability()) {
//                            for (Normal N : L._Trustee) {
//                                if (Objects.equals(N.getName(), membername)) {
//                                    System.out.println("fcfcfgcgcfgccfgc");
//                                    if (N.getId() == id) {
//                                        available = false;
//                                        Rent rent = new Rent(B, N, id);
//                                        L._rental_registries.add(rent);
//                                        yellow();
//                                        System.out.println("Here is your book. please take care of it");
//                                        blue();
//                                    } else {
//                                        System.out.println("Sorry we can't give this book because your name doesn't match with your id.");
//                                    }
//                                } else {
//                                    System.out.println("Sorry we don't have you as a member in our list so we can't give it to you.if you're really interested, sign in first");
//                                }
//                            }
//                        } else if(available) {
//                            System.out.println("Sorry it seems like someone else has already rented this book. check it out later");
//                        }
//                        break;
//                    }
//                }
//                break;
//            }
//            if (match == false) {
//            }
//        }
//    }
//    public static void rentspecefic1(String name, String membername, long id, Library L) {
//        System.out.println("Initial check");
//        if (L._Book_repository.isEmpty()) {
//            System.out.println("You have not registered a book yet.");
//            return;
//        }
//        boolean bookFound = false;
//        boolean bookAvailable = false;
//        for (Book B : L._Book_repository) {
//            if (B.get_Title().equals(name)) {
//                bookFound = true;
//                if (B.get_Availability()) {
//                    for (Normal N : L._Trustee) {
//                        if (Objects.equals(N.getName(), membername)) {
//                            if (N.getId() == id) {
//                                Rent rent = new Rent(B, N, id);
//                                L._rental_registries.add(rent);
//                                System.out.println("Here is your book. Please take care of it.");
//                                return;
//                            } else {
//                                System.out.println("Sorry we can't give this book because your name doesn't match with your ID.");
//                                return;
//                            }
//                        }
//                    }
//                    System.out.println("Sorry we don't have you as a member in our list, so we can't give it to you. If you're really interested, sign in first.");
//                    return;
//                } else {
//                    bookAvailable = false;
//                }
//                break;
//            }
//        }
//
//        if (!bookFound) {
//            System.out.println("Sorry it seems like we don't have this book. You can add it to our library.");
//        } else {
//            System.out.println("Sorry it seems like someone else has already rented this book. Check it out later.");
//        }
//    }
    public static void rentspecefic( String name ,String membername , long id, Library L  ){
        boolean khastam=false;
        outerloop:
        while (true){
            Normal member = null;
            for (Normal N : L._Trustee) {
                if (Objects.equals(N.getName(), membername) && N.getId() == id) {
                    member=N;
                    khastam=true;
                    break ;
                }
                else if (Objects.equals(N.getName(), membername) && N.getId() != id) {
                    yellow();
                    System.out.println("Sorry we can't give this book because your name doesn't match with your id.");
                    blue();
                    khastam=true;
                    break outerloop;
                }
            }
            if(!khastam){
                yellow();
                System.out.println("Sorry we don't have you as a member in our list so we can't give you the book .if you're really interested, sign in first");
                blue();
                break ;
            }
            int count =0;
            boolean avail=false;
            Book bookToRent = null;
            for (Book B : L._Book_repository) {
                if (Objects.equals(B.get_Title(), name)) {
                    count++;
                    if(B.get_Availability()){
                        avail=true;
                        bookToRent = B;
                        break;
                    }
                }
            }
            if(count==0){
                yellow();
                System.out.println("Sorry it seems like we don't have this book. You can add it to our library.");
                blue();
                break ;
            }
            else if(count==1 && avail){
                bookToRent.set_Availability(false);
                Rent rent = new Rent(bookToRent, member, id);
                L._rental_registries.add(rent);
                yellow();
                System.out.println("Here is your book. please take care of it");
                blue();
                break ;
            }
            else if(!avail){
                System.out.println("Sorry it seems like someone else has already rented this book. check it out later");
                break ;
            }
        }
    }
//    public static void rentttt(String name, String membername, long id, Library L) {
//        Normal member = null;
//        for (Normal N : L._Trustee) {
//            if (Objects.equals(N.getName(), membername)) {
//                if (N.getId() == id) {
//                    member = N;
//                    break;
//                } else {
//                    System.out.println("Sorry we can't give this book because your name doesn't match with your id.");
//                    return;
//                }
//            }
//        }
//        if (member == null) {
//            System.out.println("Sorry we don't have you as a member in our list so we can't give you the book. If you're really interested, sign in first.");
//            return;
//        }
//        Book bookToRent = null;
//        int count = 0;
//        for (Book B : L._Book_repository) {
//            if (Objects.equals(B.get_Title(), name)) {
//                bookToRent = B;
//                count++;
//            }
//        }
//        if (count == 0) {
//            System.out.println("Sorry it seems like we don't have this book. You can add it to our library.");
//            return;
//        }
//        if (count == 1) {
//            Rent rent = new Rent(bookToRent, member, id);
//            L._rental_registries.add(rent);
//            System.out.println("Book rented successfully.");
//        } else {
//            System.out.println("Sorry, there are multiple copies of the book. Please specify which one.");
//        }
//    }

    public static void list(Library L){
        for (Normal N : L._Trustee) {
            System.out.println( N.getName() + "--->" + N.getId());
        }
    }
    public static boolean checking(String c, Library L, boolean position) {
        Pattern pr1 = Pattern.compile("^lib\\s+add\\s+book\\s+<([a-zA-Z0-9]+(?:\\s+[a-zA-Z0-9]*)*)>\\s*<([a-zA-Z0-9]+(?:\\s+[a-zA-Z0-9]*)*)>\\s*<([a-zA-Z0-9]+(?:\\s+[a-zA-Z0-9]*)*)>");
        Matcher m1 = pr1.matcher(c);


        Pattern pr2 = Pattern.compile("^lib\\s+get\\s+hrs\\s*");
        Matcher m2 = pr2.matcher(c);

        Pattern pr5 = Pattern.compile("^lib\\s+rent\\s+<([a-zA-Z0-9]+(?:\\s+[a-zA-Z0-9]*)*)>\\s*<([a-zA-Z0-9]+(?:\\s+[a-zA-Z0-9]*)*)>\\s*<([0-9]+(?:\\s+[0-9]*)*)>");
        Matcher m5 = pr5.matcher(c);

        Pattern pr3 = Pattern.compile("^lib\\s+rent\\s+<([a-zA-Z0-9]+(?:\\s+[a-zA-Z0-9]*)*)>\\s*");
        Matcher m3 = pr3.matcher(c);


        Pattern pr4 = Pattern.compile("^lib\\s+add\\s+member\\s*");
        Matcher m4 = pr4.matcher(c);


        Pattern pr9 = Pattern.compile("^lib\\s+add\\s+admin\\s*");
        Matcher m9 = pr9.matcher(c);

        Pattern pr6 = Pattern.compile("^lib\\s+get\\s+available\\s+books\\s*");
        Matcher m6 = pr6.matcher(c);


        Pattern pr7 = Pattern.compile("^lib\\s+remove\\s+member\\s*");
        Matcher m7 = pr7.matcher(c);


        Pattern pr8 = Pattern.compile("^lib\\s+return\\s+<([a-zA-Z0-9]+(?:\\s+[a-zA-Z0-9]*)*)>\\s*");
        Matcher m8 = pr8.matcher(c);

        Pattern pr10 = Pattern.compile("^List");
        Matcher m10 = pr10.matcher(c);


        if (m1.find()) {
            if(!duplication(L, m1.group(1))) {
                addbook(L, buildingbook(idgeneratormember(), m1.group(1), m1.group(2), true, m1.group(3)));
            }
            else{
                System.out.println("We already own a book with this title. If you want to add it choose another name or put numbers in it's title");
            }
            return true;
        }
        else if (m2.find()) {
            changehrs();
            return true;
        }
        else if (m3.matches()) {
            if (position){
                rent(L, m3.group(1));
            } else {
                wrongpose();
            }
            return true;
        }
        else if (m4.find()) {
            if (position) {
                addmember(L);
            } else {
                wrongpose();
            }
            return true;
        }
        else if(m5.find()){
            long id = Long.parseLong(m5.group(3));
            rentspecefic(m5.group(1) , m5.group(2) , id , L);
            return true;
        }
        else if (m6.find()) {
            showbooks(L);
            return true;
        }
        else if (m7.find()) {
            if (position) {
                remove_member(L);
            } else {
                wrongpose();
            }
            return true;
        }
        else if (m8.find()) {
            returnbook(L, m8.group(1));
            return true;
        }
        if (m9.find()) {
            if (position) {
                addadmin(L);
            } else {
                wrongpose();
            }
            return true;
        }
        if (m10.find()) {
            list(L);
            return true;
        }
        else
        { return false;}
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        blue();
        System.out.println("Welcome to our website! If you want to submit your library enter YES");
        while (true) {
            String answer = scanner.next();
            if (Objects.equals(answer, "YES")) {
                break;
            } else {
                red();
                System.out.println("Try again");
            }
        }
        blue();
        scanner.nextLine();
        System.out.println("Please your library's name");
        String name = scanner.nextLine();
        System.out.println("Please your library's capacity");
        String cap = scanner.next();
        Pattern pr9 = Pattern.compile("([0-9]+)\\s*");
        while (true) {
            Matcher m9 = pr9.matcher(cap);
            if (m9.find()) {
                break;
            } else {
                red();
                System.out.println("you have to answer with numbers. TRY AGAIN!");
                blue();
            }
            cap = scanner.next();
        }
        int[] h = new int[2];
        changehrs();
        Library LIE = new Library(name, cap, h);
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Now tell me if you want to be a member or an admin");
        Scanner scanner2 = new Scanner(System.in);
        String anwser3 = scanner2.next();
        boolean pose = true;
        while (true) {
            if (Objects.equals(anwser3, "member")) {
                membership(LIE);
                pose = false;
                break;
            } else if (Objects.equals(anwser3, "admin")) {
                adminship(LIE);
                break;
            } else {
                red();
                System.out.println("irrelevant:D try again");
                blue();
                anwser3 = scanner2.next();

            }
        }
        printColoredText();
        Scanner scanner7 = new Scanner(System.in);
        while (true) {
            while (true) {
                String command = scanner7.nextLine();
                if (checking(command, LIE, pose)) {
                    break;
                } else {
                    red();
                    System.out.println("Wrong command! Please try again.");
                    blue();
                }
            }

            System.out.println(ANSI_PURPLE + "if you have no other commands, enter YES otherwise press any key" + ANSI_NILI);
            String answer1 = scanner1.next();
            if (Objects.equals(answer1, "YES")) {
                break;
            }
            System.out.println("choose your command from list below:");
            printColoredText();
        }

        yellow();
        System.out.println("Thank you for choosing our Library Management System.\n" +
                "We're excited to provide you with an efficient and user-friendly platform for all your library needs. Happy reading!");
    }
}
