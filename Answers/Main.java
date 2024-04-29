import javax.swing.plaf.IconUIResource;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("log in as Admin : 1" + "\n" + "log in as user : 2");
        while (true) {
            try {
                int x = input.nextInt();
                if (x == 1) {
                    new Admin();
                    break;
                } else if (x == 2) {
                    new NormalUser();
                    break;
                } else {
                    System.out.println("Wrong! try again");
                }
            } catch (Exception e) {
                System.out.println("You cant use letters,only integers!!");
                break;
            }
        }

    }
}

