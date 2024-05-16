import javax.lang.model.element.Name;
import java.util.*;
public class MyApp {

    public static void main(String[] args){
        Library library= new Library("My Library" , 100 , "9:00 AM - 10:00 PM");
        ArrayList<Admin> admin = new ArrayList<>();
        admin.add(new Admin("Vania" , "40230212088","09333564285","1384"));
        /**************************************************************************************************/
        Book book1 = new Book("The Shadows Between Us","Tricia Levenseller" , "Fantasy");
        Book book2 = new Book("Funny Story","Emily Henry" , "Comedy");
        Book book3 = new Book("The Women","Kristin Hannah" , "Homeric");
        List<Book> bookList = new ArrayList<>();
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        Scanner enter = new Scanner(System.in);
        String choice , name , password , command , Name , Password , Command ;
        boolean m = true, t = true, n = true;
        System.out.println("Welcome to my library.");
        /********************************************************************************************/
        while (m){
            System.out.println("Identify yourself: ");
            System.out.println("1.Admin");
            System.out.println("2.User");
            System.out.println("3.Exit");
            choice = enter.nextLine().trim().toLowerCase();
            switch (choice){
                case "admin":
                    while (t) {
                        System.out.println("Enter your name: ");
                        name = enter.nextLine().trim().toLowerCase();
                        if (name.equals("Vania") || name.equals("vania")) {
                            System.out.println("Enter password: ");
                            password = enter.nextLine().trim().toLowerCase();
                            if (password.equals("1384")) {
                                System.out.println("Hi Vania!");
                                do {
                                    System.out.println("What you want to do? (instead of using space write\"/\"(not for books name) and dont use <>");
                                    System.out.println("If you need help use(lib/-h) or you can \"Exit\"");
                                    command = enter.nextLine();
                                    CheekAdminCommand(command, bookList, admin , library);
                                } while (!command.equals("Exit"));
                                t = false;
                            } else {
                                System.out.println("Wrong password.");
                            }
                        } else {
                            System.out.println("Wrong name.");
                        }
                    }
                    break;
                    /****************************************************************************************/
                case "user":
                    while (n) {
                        System.out.println("Enter your name: ");
                        Name = enter.nextLine().trim().toLowerCase();
                        if (Name.equals("vani")) {
                            System.out.println("Enter your password: ");
                            Password = enter.nextLine().trim().toLowerCase();
                            if (Password.equals("1111")) {
                                System.out.println("Hi!");
                                do {
                                    System.out.println("What you want to do? (instead of using space write\"/\"(not for books name) and dont use <>");
                                    System.out.println("If you need help use(lib/-h) or you can \"Exit\"");
                                    Command = enter.nextLine().toLowerCase().trim();
                                    CheekUserCommand(Command, bookList);
                                } while (!Command.equals("Exit"));
                                n = false;
                            } else {
                                System.out.println("Wrong password.");
                            }
                        } else {
                            System.out.println("Wrong user name.");
                        }
                    }
                    break;
                    /***************************************************************************************/
                case "exit":
                    System.out.println("bye bye:)");
                    m = false;
                    break;
                default:
                    System.out.println("It's wrong.");
            }
        }
    }
/*********************************************************************************************************/
    public static void CheekAdminCommand(String command , List<Book> books , List<Admin> admins , Library library){
        String[] cheekcommand = command.split("/");
        if(cheekcommand[0].equals("lib")){
            if(cheekcommand[1].equals("-h")){
                System.out.println("lib/add/book/<name>/<author>/<subtitle>. --> Add a new book to the library.\n" +
                        "lib/get/hrs. --> Retrieve library operating hours.\n" +
                        "lib/add/member/<name>/<studentID>/<PhoneNumber>/<password>. --> Add a new member to the library.\n" +
                        "lib/remove/member/<memberID>. --> Remove a member from the library.\n" +
                        "lib/get/available/books. --> View available books." );
            }
            else if(cheekcommand[1].equals("add")){

                if (cheekcommand[2].equals("book")){
                    Book book4 = new Book(cheekcommand[3],cheekcommand[4],cheekcommand[5]);
                    books.add(book4);
                    library.addBook(book4);
                    System.out.println("Book added successfully");

                }
                else if (cheekcommand[2].equals("member")) {
                    admins.add(new Admin(cheekcommand[3],cheekcommand[4],cheekcommand[5],cheekcommand[6]));
                    System.out.println("New Admin added successfully");
                }
                else{
                    System.out.println("Wrong command.");
                }

            }
            else if (cheekcommand[1].equals("get")) {

                if (cheekcommand[2].equals("hrs")){
                    System.out.println("Library is open from 9.am to 10.pm");

                }
                else if (cheekcommand[2].equals("available")){
                    for (Book book : books){
                        System.out.println("************************************************");
                        System.out.println(book.toString());
                    }
                }
                else{
                    System.out.println("Wrong command.");
                }
            }
            else if (cheekcommand[1].equals("remove")) {
                String uniqueAId = cheekcommand[3];
                removeAdmin(uniqueAId,admins);
            }
            else {
                System.out.println("Its Wrong.");
            }

        }
        else if (cheekcommand[0].equals("Exit")){
            System.out.println("leaving Admin panel.");
        }else {
            System.out.println("Wrong command.");
        }
    }
/*********************************************************************************************************/
    public static void CheekUserCommand(String command , List<Book> books){
        String[] cheekcommand = command.split("/");
        if (cheekcommand[0].equals("lib")) {
            if(cheekcommand[1].equals("-h")){
                System.out.println("lib/get/hrs. --> Retrieve library operating hours.\n" +
                        "lib/rent/<bookId>. -->  Rent a book from the library.\n" +
                        "lib/rent/<bookId>/<memberName>. -->  Rent a book for a specific member.\n" +
                        "lib/get/available/books. -->  View available books for rental.\n" +
                        "lib/return/<bookName>. -->  Return a rented book to the library.\n");
            }
            else if (cheekcommand[1].equals("rent")) {
                if (cheekcommand.length == 6) {
                    int number = Integer.parseInt(cheekcommand[2]);
                    String memberName = cheekcommand[3];
                    Library.lendBook(number,memberName);
                }
                else {
                    int number = Integer.parseInt(cheekcommand[2]);
                    Library.findBookById(number);
                }

            } else if (cheekcommand[1].equals("get")) {
                if (cheekcommand[2].equals("hrs")) {
                    System.out.println("Library is open from 9.am to 10.pm");
                }
                else if (cheekcommand[2].equals("available")) {
                    for (Book book : books){
                        System.out.println("************************************************");
                        System.out.println(book.toString());
                    }
                }
                else {
                    System.out.println("Wrong command.");
                }
            }
            else if (cheekcommand[1].equals("return")) {
                int number = Integer.parseInt(cheekcommand[2]);
                Library.returnBook(number);
            }
            else {
                System.out.println("Wrong command.");
            }
        }
        else if (cheekcommand[0].equals("Exit")){
            System.out.println("leaving User panel.");
        }else {
            System.out.println("Wrong command.");
        }
    }
/*********************************************************************************************************/
    private static void removeAdmin(String uniqueAId , List<Admin> admins){
        Iterator<Admin> iterator = admins.iterator();
        boolean found = false;
        while (iterator.hasNext()){
            Admin admin = iterator.next();
            if (admin.getUniqueId().equals(uniqueAId)){
                iterator.remove();
                found = true;
                break;
            }
        }
        if(!found){
            System.out.println("There isn't admin with this id.");
        }else {
            System.out.println("Admin deleted.");
        }
    }
}
