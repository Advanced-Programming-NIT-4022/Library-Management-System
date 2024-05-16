
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;




public class Library {
    static ArrayList<String> userName = new ArrayList<String>();

    static String libName;
    static int s= 8;
    static int end = 22;
    static int capacity;
    static String fileName = "name.txt";
    static String filecapa = "capa.txt";
    static String adminpass ="1234";
    ArrayList<String> fruits = new ArrayList<String>();
    static Scanner lib = new Scanner(System.in);


    static HashMap<String, Integer> libbook = new HashMap<String, Integer>();//get name send capacity

    public static void library() {

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine();

        } catch (IOException x) {
            System.out.println("fail");

        }

        try (BufferedReader reader = new BufferedReader(new FileReader(filecapa))) {
            String line1 = reader.readLine();
        } catch (IOException x) {
            System.out.println("fail");

        }


        System.out.println("pleas choise number");
        System.out.println("1.new name  2.capaciy  3.new operating hours 4.new Book repository");
        System.out.println("5.new User and rental registries");

        String l = lib.nextLine();
        String a, b, c, d, e;
        a = "1";
        b = "2";
        c = "3";
        d = "4";
        e = "5";
        int i, i1, i2, i3, i4, i5 = 2;
        i = a.compareTo(l);
        i1 = b.compareTo(l);
        i2 = c.compareTo(l);
        i3 = d.compareTo(l);
        i4 = e.compareTo(l);


        if (i == 0) {

            System.out.println("library name : ");
            libName = lib.nextLine();
            try (FileWriter writer = new FileWriter(fileName)) {
                writer.write(libName);
                System.out.println(" ok ");
            } catch (IOException x) {
                System.out.println("fail");

            }


        }
        if (i1 == 0) {
            System.out.println("lib capacity : ");
            capacity = lib.nextInt();
            libbook.put(libName, capacity);
            try (FileWriter writer = new FileWriter(filecapa)) {
                writer.write(capacity);
                System.out.println(" ok ");
            } catch (IOException x) {
                System.out.println("fail");


            }
        }
        if (i2 == 0) {

            System.out.println("hors statrt : ");
             s = lib.nextInt();
            System.out.println("hors end : ");
            int end = lib.nextInt();


        }


    }

    public static void showhours(){
        System.out.println("start ="+ s);
        System.out.println("end =" + end);
        CLI.job(Main.c1, Main.userId);

    }
    public static void addmember(String username){

userName.add(User.name1);
        System.out.println("register is sucssfully");
        CLI.job(Main.c1, Main.userId);

    }
    public static void remmember(){

        System.out.println("pleas username : ");
        String name = lib.nextLine();
        User.uname.remove(name);



        for (String fruit : userName) {
            int o = fruit.compareTo(name);
            if(o==0){
                userName.remove(fruit);

                break;
            }
        }
        System.out.println("remove is sucssfully");
        CLI.job(Main.c1, Main.userId);

    }
    public static void reaturn(){
        System.out.println("pleas book name =");
        String add = lib.nextLine();
        for (String fruit : Book.book) {
            boolean r = fruit.equals(add);
            if(r){

                System.out.println("we have this book ");

                break;
            }else {
                Book.book.add(add);
                System.out.println("return is sucssfully");
            }

        }

        CLI.job(Main.c1, Main.userId);


    }


}




