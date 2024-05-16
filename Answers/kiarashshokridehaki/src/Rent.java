import java.util.ArrayList;
import java.util.HashMap;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Rent {
    static int rentId = 1;
    static HashMap<Integer,  LocalDateTime> people = new HashMap<Integer, LocalDateTime >();
    static HashMap<String,  Integer> shrid = new HashMap<String,  Integer >();
    static Scanner rentbook = new Scanner(System.in);
    static ArrayList<Integer> rId = new ArrayList<>();
    static ArrayList<String> shridd = new ArrayList<>();

    NormalUser renUser =  new NormalUser();
    Book renbook = new Book();
   static  LocalDateTime myObj = LocalDateTime.now();



        static void rentBook(int userId,String nb){

        System.out.println("rentID =" +rentId);
            rId.add(rentId);
            shridd.add(nb);
           int c1=0;
           people.put(rentId,myObj);
             rentId++;








    }
}
