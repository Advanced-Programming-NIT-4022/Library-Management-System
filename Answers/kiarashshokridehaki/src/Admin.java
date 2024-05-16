import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
    static ArrayList<String> Admin = new ArrayList<>();
   static Scanner red = new Scanner(System.in);
    static void requstManAAmin(){
        System.out.println("change pass\nchange hrs\nuserId\nadd Admin\nrent date\nregister date");

        String req = red.nextLine();

        if(req.equals("change pass")){
            changP();
        }

        else  if(req.equals("change hrs")){
            chHrs() ;
        }

        else if(req.equals("add Admin")){
            addA() ;
        }

        else if(req.equals("userId")){
            shUid(); ;
        }

        else if(req.equals("register date")){
            shrgd(); ;
        }
        else if(req.equals("rent date")){
            shrgd(); ;
        }
else {
            System.out.println("try again");
            requstManAAmin();
        }

    }


    static void changP(){
        System.out.println("new pass : ");
        Main.MAp2 =red.nextLine();
        Main.admin();

   }

   static void chHrs(){
       System.out.println("new start hrs : ");
       Library.s =red.nextInt();
       System.out.println("new end hrs : ");
       Library.end =red.nextInt();
       Main.admin();
   }

   static void shUid(){
       System.out.println("name :");
       String esm = red.nextLine();
       for(String i : User.uname){
           if(i.equals(esm)){
               System.out.println(User.User_name_id.get(esm));
               break;
           }else{
               System.out.println("we dont have such a user");
               Main.admin();
           }
       }
       Main.admin();

   }
   static void addA(){
       System.out.println("name :");
       Admin.add(red.nextLine());
       Main.admin();

   }
   static void shrdate(){
       System.out.println("rentdate :");
       int kl=red.nextInt();
       for(int i : Rent.rId){
           if(i==kl){
               System.out.println(Rent.people.get(i));
               break;
           }else{
               System.out.println("we dont have such a user");
               Main.admin();

           }
       }
       Main.admin();
   }

   static void shrgd(){
       System.out.println("name :");
String esm1 =red.nextLine();
       for(String i : User.uname){
           if(i.equals(esm1)){
               System.out.println( NormalUser.Normal.get(esm1));
               break;
           }else{
               System.out.println("we dont have such a user");
               Main.admin();

           }
       }
       Main.admin();


   }


   static  void shreid(){
String e = red.nextLine();;
       for(String i : Rent.shridd){
           if(i.equals(e)){
               System.out.println( NormalUser.Normal.get(e));
               break;
           }else{
               System.out.println("we dont have such a user");
               Main.admin();

           }
       }
       Main.admin();


////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////


   }
   static void requstAmin(){
       System.out.println("change hrs\nuserId\nrent date\nregister date");
       String req = red.nextLine();

       if(req.equals("change hrs")){
           chHrs() ;
       }
else if(req.equals("userId")){
           shUid(); ;
       }
       else if(req.equals("rent date")){
           shrgd(); ;
       }
       else if(req.equals("register date")){
           shrgd(); ;
       }
       else {
           System.out.println("try again");
           requstAmin();
       }



   }


 }