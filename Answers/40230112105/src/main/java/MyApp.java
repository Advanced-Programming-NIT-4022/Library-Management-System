import java.sql.ResultSet;
import java.util.Scanner;
public class MyApp {

    static void clearScreen() {
        Scanner strScanner = new Scanner(System.in);
        System.out.print("Press any key and \"ENTER\" to continue: ");
        String sarimakh = strScanner.next();
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) {

        Book book = new Book();
        NormalUser normalUser = new NormalUser();
        Rent rent = new Rent();
        Admin admin = new Admin();
        Library lib = new Library();
        String input;
        Scanner strScanner = new Scanner(System.in);
        System.out.println("Hello and welcome to your own library!");
        while (true) {
            System.out.println("***Note that your all commands should be start whit lib The rest of the \n" +
                    "parts of a particular order are written in front of the same order*** \n");
            System.out.println("General options: ");
            System.out.println("   available books(get-available-books)");
            System.out.println("   working hours(get-hrs)");
            System.out.println("Admin options: ");
            System.out.println("   Work as admin(auth)");



            System.out.print(">>> ");
            input = strScanner.nextLine();
            String devide[] = input.split("-");

            if (devide[0].equals("lib")) {
                if (devide[1].equals("auth")){ //admin part
                    System.out.print("What is your id: ");
                    String id = strScanner.next();
                    admin.setId(id);
                    System.out.print("Password: ");
                    String password = strScanner.next();
                    admin.setPassword(password);
                    while(admin.accessed(admin.getId(), admin.getPassword())){
                        System.out.println("   add member(add-member-<name>-<phone number>)");
                        System.out.println("   add book(add-book-<name>-<author>-<subtitle>)");
                        System.out.println("   remove member(remove-member-<user id>)");
                        System.out.println("   remove admin(remove-admin-<admin id>");
                        System.out.println("   rent book(rent-<book ID>-<user ID>)");
                        System.out.println("   return book(return-<book ID>)");
                        System.out.println("   available books(get-available-books)");
                        System.out.println("   working hours(get-hrs)");
                        System.out.println("   exit of admin part(exit)");

                        System.out.print(">>> ");
                        input = strScanner.nextLine();
                        devide = input.split("-");
                        if(devide[0].equals("lib")){
                            if (devide[1].equals("add")) {
                                if (devide[2].equals("book")) {
                                    book.setTitle(devide[3]);
                                    book.sesAuthor(devide[4]);
                                    book.setSubtitle(devide[5]);
                                    book.addBook(book.getTitle(), book.getAuthor(), book.getSubtitle());
                                } else if (devide[2].equals("member")) {
                                    normalUser.setName(devide[3]);
                                    normalUser.setphoneNumber(devide[4]);
                                    normalUser.addMember(normalUser.getPhoneNumber(), normalUser.getName());
                                } else if (devide[2].equals("admin")) {
                                    admin.setName(devide[3]);
                                    admin.setphoneNumber(devide[4]);
                                    admin.setPassword(devide[5]);
                                    admin.addAdmin(admin.getName(), admin.getPhoneNumber());
                                }
                            } else if (devide[1].equals("get")) {
                                if (devide[2].equals("hrs")) {
                                    lib.workingHours();
                                } else if (devide[2].equals("available") && devide[3].equals("books")) {
                                    book.availableBooks();
                                }
                            } else if (devide[1].equals("rent")) {
                                rent.rentBook(devide[2], devide[3]);
                            } else if (devide[1].equals("remove")) {
                                if (devide[2].equals("member")) {
                                    normalUser.setId(devide[3]);
                                    normalUser.removeMember(normalUser.getId(), "student");
                                } else if (devide[2].equals("admin")) {
                                    admin.setId(devide[3]);
                                    admin.removeMember(admin.getId(), "manager");
                                }

                            } else if (devide[1].equals("return")) {
                                rent.returnBook(devide[2]);
                            } else if(devide[1].equals("exit")){
                                System.out.println("You got out of admin access");
                                break;
                            } // admin part
                        } else {
                            System.out.println("Wrong entry");
                        }
                        clearScreen();
                    }
                } else if (devide[1].equals("get")) {
                    if (devide[2].equals("hrs")) {
                        lib.workingHours();
                    } else if (devide[2].equals("available") && devide[3].equals("books")) {
                        book.availableBooks();
                    }
                } else {
                    System.out.print("Wrong entry!");
                }
                clearScreen();
            }
        }
    }
}

