import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello to library\nWhat is your role?\n1.Admin\n2.Normaluser\n3.I want to register.");
        try (Scanner scanner = new Scanner(System.in)) {
            int num = scanner.nextInt();
            switch (num) {
                case 1:
                    
                    break;
                case 2:
                break;
                case 3 :
                System.out.println("**********************\nWhat is your role?\n" +"1.Admin\n" +"2.Normaluser");
                
                break;
                default:
                break;
            }
        }
    }
}
