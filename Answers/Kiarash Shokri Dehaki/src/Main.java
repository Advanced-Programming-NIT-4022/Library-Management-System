import java.util.ArrayList;
import java.util.Scanner;



public class Main {
    static int c1=1;
    static int userId=1;
    public static void main(String[] args) {

        System.out.println("1.user\n2.admin\n3.other");
        System.out.println("Enter the desired number(just number) ");
        Scanner choice1 = new Scanner(System.in);
        String i = choice1.next();
        String a = "1";
        String b = "2";

        int i1 ,i2;
        i1 =i.compareTo(a);
        i2 =i.compareTo(b);




if(i1==0){

         CLI.job(c1,userId);

    }



    }
}