import java.io.IOException;
import java.util.*;

public class App {
    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            int i = 1;
            while (i == 1) {
                Cli.start();
                switch (scanner.nextInt()) {
                    case 1:
                        i = 1;
                        User us = Cli.avardanuser();
                        if (us != null) {
                            Cli.adps();
                            String s = scanner.next();
                            if (s.equalsIgnoreCase(Admin.Adminpass)) {
                                while (i == 1) {
                                    Cli.adminList();
                                    int j = scanner.nextInt();
                                    switch (j) {
                                        case 1:
                                            Library.addBook(Cli.getBook());
                                            System.out.println("*********************\nanjam shod");
                                            break;
                                        case 2:
                                            Library.showBook();
                                            break;
                                        case 3:
                                            Library.showUser();
                                            break;
                                        case 4:
                                            Cli.bfind();
                                            String h = scanner.next();
                                            List<Book> l = Book.bookfinder(h);
                                            Cli.gh();
                                            int o = scanner.nextInt();
                                            o--;
                                            Cli.rentday();
                                            boolean ax = true;
                                            if (ax == true) {
                                                Library.rentBook(l.get(o), us, scanner.nextInt());
                                                ax = false;
                                            }
                                            break;
                                        case 5:
                                            Library.returnBook(us);
                                            break;
                                        case 6:
                                            Library.removeUser(us);
                                            break;
                                        case 7:
                                            Cli.bfind();
                                            String ui = scanner.next();
                                            List<Book> hg = Book.bookfinder(ui);
                                            Cli.gh();
                                            int po = scanner.nextInt();
                                            po--;
                                            Library.removeBook(hg.get(po));
                                            System.out.println("anjam shod");
                                            break;
                                        case 8 :
                                        Cli.getHours();
                                        Cli.getCapacity();
                                        break;
                                        default:
                                            break;
                                    }
                                    Cli.edame();
                                    i = scanner.nextInt();
                                }
                            } else {
                                System.out.println("admin pass is incorrect");
                            }
                        } else
                            System.out.println("admin not found");
                        break;
                    case 2:
                        i = 1;
                        User uk = Cli.avardanuser();
                        if (uk != null) {
                            while (i == 1) {
                                Cli.userList();
                                int j = scanner.nextInt();
                                switch (j) {
                                    case 1:
                                        Library.addBook(Cli.getBook());
                                        System.out.println("*******************\nanjam shod");
                                        break;
                                    case 2:
                                        Book.bookfinder("o");
                                        break;
                                    case 3:
                                        Cli.bfind();
                                        String h = scanner.next();
                                        List<Book> l = Book.bookfinder(h);
                                        Cli.gh();
                                        int o = scanner.nextInt();
                                        o--;
                                        Cli.rentday();
                                        boolean ax = true;
                                        if (ax == true) {
                                            Library.rentBook(l.get(o), uk, scanner.nextInt());
                                            ax = false;
                                        }
                                        break;
                                    case 4:
                                    Library.returnBook(uk);
                                        break;
                                    case 5:
                                    Cli.getCapacity();
                                    Cli.getHours();
                                    default:
                                        break;
                                }
                            }
                        } else
                            System.out.println("user not found");
                        break;
                    case 3:
                        User user = Cli.rgistr();
                        Library.addUser(user);
                        System.out.println("anjam shod");
                        break;
                    case 4:
                        break;
                    default:
                        System.out.println("Na motabar");
                        break;
                }
                Cli.edame();
                try {
                    i = scanner.nextInt();
                } catch (Exception e) {
                    break;
                }
            }
        }
    }
}