package org.example;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CLI {

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

    public static void addbook(Library L, Book B) {
        L._Book_repository.add(B);
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

    public static void rent(Library L, String name) {
        for (Book Book : L._Book_repository) {
            if (Book.get_Title().equals(name)) {
                if (Book.get_Availability()) {
                    Book.set_Availability(false);
                } else {
                    System.out.println("It seems that this book have been rented, check it out later");
                }
            } else {
                System.out.println("This book is not available at the moment, We would appreciate if you add it to our library.");
            }
        }
    }

    public static void returnbook(Library L, String name) {
        for (Book Book : L._Book_repository) {
            if (Book.get_Title().equals(name)) {
                if (Book.get_Availability()) {
                    System.out.println("It seems that we already have this book, give it to someone else");
                } else {
                    Book.set_Availability(true);
                    System.out.println("Thanks for bringing our book back, hope you enjoyed it!");
                }
            } else {
                System.out.println("It seems that this book doesn't belong to our library ");
            }
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

    static String id(String id) {
        if (id.length() > 13 || id.length() < 4) {
            return "wrong";
        }
        if (!id.matches("[0-9]+")) {
            return "wrong";
        } else {
            return id;
        }
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
                System.out.println("Wrong entry. Try again.");
                number = scanner4.next();
            }
            else {
                break;
            }
        }
        System.out.println("You have been successfully registered as a member.\nHere is you id: " + userid +".");

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
                System.out.println("Wrong entry. Try again.");
                number = scanner4.next();
            } else {
                break;
            }
        }
        System.out.println("Please enter your password");
        String password = scanner4.next();

        System.out.println("You have been successfully registered as an admin.\nHere is you id: " + userid +".");
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
                System.out.println("Wrong entry. Try again.");
                number = scanner4.nextLine();
            } else {
                break;
            }
        }
        System.out.println("Your member have been successfully registered .\nHere is their id: " + userid +".");
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
                System.out.println("Wrong entry. Try again.");
                number = scanner4.nextLine();
            } else {
                break;
            }
        }
        System.out.println("Please enter their password");
        String password = scanner4.next();
        System.out.println("Your admin have been successfully registered .\nHere is their id: " + userid +".");
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
            System.out.println("Done by " + name_boss);
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
            System.out.println("Done by " + name_boss);
        }
        else {
            System.out.println("Sorry we didn't add your member because the admin couldn't remember their password.");
        }

    }

    public static void remove_member(Library L) {
        System.out.println("choose the member you want to remove and type their id ");
        for (Normal N : L._Trustee) {
            {
                System.out.println("------------------------------------");

                System.out.println("NAME:  " + N.getName());
                System.out.println("USERID:  " + N.getId());
                System.out.println("------------------------------------");
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
        System.out.println(" Sorry! You are not at admin position so you can't do this command.");
    }

    public static void showbooks(Library L) {
        for (Book B : L._Book_repository) {
            if (B.get_Availability()) {
                System.out.println(B.get_Title());
            }
        }
    }

    public static void changehrs() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please your library's opening hour");
        int[] h = new int[2];
        h[0] = scanner.nextInt();
        while (true) {
            if (h[0] == 1 || h[0] == 2 || h[0] == 3 || h[0] == 4 || h[0] == 5 || h[0] == 6 || h[0] == 7 || h[0] == 8 || h[0] == 9 || h[0] == 10 || h[0] == 11 || h[0] == 12
                    || h[0] == 13 || h[0] == 14 || h[0] == 15 || h[0] == 16 || h[0] == 17 || h[0] == 18 || h[0] == 19 || h[0] == 20 || h[0] == 21 || h[0] == 22 || h[0] == 23 || h[0] == 24) {
                break;
            } else {
                System.out.println("what? choose an actual number that is inside the clock");
                h[0] = scanner.nextInt();
            }
        }
        System.out.println("Please your library's closing hour");
        h[1] = scanner.nextInt();
        while (true) {
            if ((h[1] == 1 || h[1] == 2 || h[1] == 3 || h[1] == 4 || h[1] == 5 || h[1] == 6 || h[1] == 7 || h[1] == 8 ||
                    h[1] == 9 || h[1] == 10 || h[1] == 11 || h[1] == 12 || h[1] == 13 || h[1] == 14 || h[1] == 15 || h[1] == 16
                    || h[1] == 17 || h[1] == 18 || h[1] == 19 || h[1] == 20 || h[1] == 21 || h[1] == 22 || h[1] == 23 || h[1] == 24) && h[1] > h[0]) {
                break;
            } else if ((h[1] == 1 || h[1] == 2 || h[1] == 3 || h[1] == 4 || h[1] == 5 || h[1] == 6 || h[1] == 7 || h[1] == 8 ||
                    h[1] == 9 || h[1] == 10 || h[1] == 11 || h[1] == 12 || h[1] == 13 || h[1] == 14 || h[1] == 15 || h[1] == 16
                    || h[1] == 17 || h[1] == 18 || h[1] == 19 || h[1] == 20 || h[1] == 21 || h[1] == 22 || h[1] == 23 || h[1] == 24) && h[1] < h[0]) {
                System.out.println("Wow! a magical library!! How come the opening time is after the closing time? anyway0_0");
                break;
            } else {
                System.out.println("what? choose an actual number that is inside the clock");
                h[0] = scanner.nextInt();
            }
        }

    }

    public static void rentspecefic( String name , Library L , long id){
        boolean match =false;
        while (true) {
            for (Book B : L._Book_repository) {
                if (B.get_Title().equals(name)) {
                    match = true;
                    break;
                }
            }

        }


    }

    public static boolean checking(String c, Library L, boolean position) {
        Pattern pr1 = Pattern.compile("^lib\\s+add\\s+book\\s+<([a-zA-Z0-9]+(?:\\s+[a-zA-Z0-9]*)*)>\\s*<([a-zA-Z0-9]+(?:\\s+[a-zA-Z0-9]*)*)>\\s*<([a-zA-Z0-9]+(?:\\s+[a-zA-Z0-9]*)*)>");
        Matcher m1 = pr1.matcher(c);
        if (m1.find()) {
            addbook(L, buildingbook(idgeneratormember(), m1.group(1), m1.group(2), true, m1.group(3)));
            return true;
        }

        Pattern pr2 = Pattern.compile("^lib\\s+get\\s+hrs\\s");
        Matcher m2 = pr2.matcher(c);
        if (m2.find()) {
            changehrs();
            return true;
        }

        Pattern pr3 = Pattern.compile("^lib\\s+rent\\s+<([0-9]+)>\\s*");
        Matcher m3 = pr3.matcher(c);
        if (m3.find()) {
            rent(L, m3.group(1));
            return true;
        }

        Pattern pr4 = Pattern.compile("^lib\\s+add\\s+member\\s*");
        Matcher m4 = pr4.matcher(c);
        if (m4.find()) {
            if (position) {
                addmember(L);
            } else {
                wrongpose();
            }
            return true;
        }

        Pattern pr9 = Pattern.compile("^lib\\s+add\\s+admin\\s*");
        Matcher m9 = pr9.matcher(c);
        if (m9.find()) {
            if (position) {
                addmember(L);
            } else {
                wrongpose();
            }
            return true;
        }

        Pattern pr5 = Pattern.compile("^lib\\s+rent\\s+<([a-zA-Z0-9]+(?:\\s+[a-zA-Z0-9]*)*)>\\S+<([a-zA-Z]+(?:\\s+[a-zA-Z]*)*)>\\S+<([0-9])>\\s*");
        Matcher m5 = pr5.matcher(c);
        if(m5.find()){
           // rentspecefic(m5.group(1) , m5.group(2));
        }

        Pattern pr6 = Pattern.compile("^lib\\s+get\\s+available\\s+books\\s*");
        Matcher m6 = pr6.matcher(c);
        if (m6.find()) {
            showbooks(L);
            return true;
        }

        Pattern pr7 = Pattern.compile("^lib\\s+remove\\s+member\\s*");
        Matcher m7 = pr7.matcher(c);
        if (m7.find()) {
            if (position) {
                remove_member(L);
            } else {
                wrongpose();
            }
            return true;
        }

        Pattern pr8 = Pattern.compile("^lib\\s+return\\s+<([a-zA-Z0-9]+(?:\\s+[a-zA-Z0-9]*)*)>\\s*");
        Matcher m8 = pr8.matcher(c);
        if (m8.find()) {
            returnbook(L, m8.group(1));
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to our website! If you want to submit your library enter YES");
        while (true) {
            String answer = scanner.next();
            if (Objects.equals(answer, "YES")) {
                break;
            } else {
                System.out.println("Try again");
            }
        }
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
                System.out.println("you have to answer with numbers. TRY AGAIN!");
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
                System.out.println("irrelevant:D try again");
                anwser3 = scanner2.next();

            }
        }

        print();
        Scanner scanner7 = new Scanner(System.in);
        while (true) {
            while (true) {
                String command = scanner7.nextLine();
                if (checking(command, LIE, pose)) {
                    break;
                } else {
                    System.out.println("Wrong command! Please try again.");
                    break;
                }
            }
            System.out.println("if you have no other commands, enter YES");
            String answer1 = scanner1.next();
            if (Objects.equals(answer1, "YES")) {
                break;
            }
            System.out.println("choose your command from list below:");
            print();
        }

        System.out.println("Thank you for choosing our Library Management System." +
                " We're excited to provide you with an efficient and user-friendly platform for all your library needs. Happy reading!");
    }
}

