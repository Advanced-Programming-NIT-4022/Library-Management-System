import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MyApp {
    public static void main(String[] args) {
        String x;
        Admin admin  = new Admin();
        NormalUser user  = new NormalUser();
            Scanner input = new Scanner(System.in);
            System.out.println("log in as Admin : 1" + "\n" + "log in as user : 2");
            x = input.nextLine();
            // || Pattern.matches("[9][0-9]{9}", phone)
            while (true) {


                if(Pattern.matches("[12]{1}" , x)){
                    if(Objects.equals(x, "1")){
                        admin.Ad();
                    }
                    if(Objects.equals(x, "2")){
                        user.sing();
                    }
                }
                else{
                    System.out.println("wrong try again: ");
                    x = input.nextLine();
                }





            }

    }
}

