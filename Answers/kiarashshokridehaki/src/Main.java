import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;



public class Main {
    static int c1=1;
    static int userId=1;
    static String MAp2="1234";
    static String Ap2="1234";

    static Scanner choice1 = new Scanner(System.in);
    public static void main(String[]  args) {

        app();


    }
    static void app(){

        System.out.println("1.user\n2.admin");
        System.out.println("Enter the desired number(just number) ");

        String i = choice1.next();
        String a = "1";
        String b = "2";


        int i1 ,i2;
        i1 =i.compareTo(a);





        if(i1==0){
            System.out.println("pass:(deflut:1234)");
            if(choice1.nextInt()==1234){
                CLI.job(c1,userId);
            }else{
                System.out.println("try again");
                app();
            }


        }

        if(b.equals(i)){

            admin();

            }
        }


    static void admin(){

        System.out.println("1.Main Admin\n2.Admin\n(defult  passwod:1234");

        String a12 = choice1.nextLine();

        if(a12.equals("Main Admin")){
            System.out.println("pass:");
            String pass = choice1.nextLine();
            if(pass.equals(MAp2)){
                Admin.requstManAAmin();
            }


        }
        else if(a12.equals("Admin")){
            Admin.requstAmin();
        }

else{
            System.out.println("try again");
            admin();
        }


    }






}

