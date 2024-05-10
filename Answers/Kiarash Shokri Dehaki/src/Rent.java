import java.util.HashMap;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Rent {
    static int rentId = 1;
    static HashMap<Integer,  LocalDateTime> people = new HashMap<Integer, LocalDateTime >();

    static Scanner rentbook = new Scanner(System.in);
    static String username = rentbook.nextLine();
    static String bookname = rentbook.nextLine();



     static void rentBook(int userId){

        System.out.println("rentID =" +rentId);
        Book renbook = new Book();
         int c1=0;

         NormalUser renUser =  new NormalUser();

         LocalDateTime myObj = LocalDateTime.now();
         people.put(rentId,myObj);


        Book.informationBook(CLI.i12, CLI.i13, CLI.i14, c1,userId);//should send to library



    }
}
