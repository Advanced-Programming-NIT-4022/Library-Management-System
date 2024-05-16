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
                        Cli.adps();
                        String s = scanner.next();
                        if (s.equalsIgnoreCase(Admin.Adminpass)) {
                            while (i == 1) {
                                Cli.adminList();
                                int j = scanner.nextInt();
                                switch (j) {
                                    case 1:
                                    Library.addBook(Cli.getBook());
                                    System.out.println("anjam shod");
                                    break;
                                    case 2:
                                    Library.showBook();
                                    break;
                                    case 3:
                                    Library.showUser();
                                    break;
                                    case 4:
                                        break;
                                    case 5:
                                        break;
                                    case 6:
                                        break;
                                    default:
                                        break;
                                }
                            Cli.edame();
                            i = scanner.nextInt();   
                            }
                        } else {
                            System.out.println("admin not found");
                        }
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    default:
                        System.out.println("Na motabar");
                        break;
                }
                Cli.edame();
                try{i = scanner.nextInt();}
                                catch(Exception e){
                                  break;
                                }
            }
        }
    }
}