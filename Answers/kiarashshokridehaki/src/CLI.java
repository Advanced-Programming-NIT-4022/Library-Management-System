import java.util.Scanner;



public class CLI {

    static String job1;
    static String add;
    static String hours;
    static String Rent1;
    static  String member;
    static String avail;
    static String remmember;
    static String retuarn;
    static String bazgasht;

static String[] args;
    static String pas;
    public static void job(int c1,int userId){
        System.out.println("Access list");
        System.out.println("1.lib add book" +
                "\n2.lib get hrs\n3.lib rent\n4.lib add member\n5.lib get available books\n6.lib remove member" +
                "\n7.lib return\n"+"8.back");

        Scanner job = new Scanner(System.in);
        System.out.println("pleas write your job :");
         job1 = job.nextLine().toLowerCase();
       add = "lib add book";
        hours = "lib get hrs";
        Rent1 = "lib rent";
        member  = "lib add member";
        avail = "lib get available books";
        remmember = "lib remove member";
        retuarn = "lib return";
        bazgasht ="back";


        if(add.equals(job1)){
            Book.informationBook(c1,userId);
        }

        else if(avail.equals(job1))
        {
            Book.informationBook(c1,userId);
        }

        else if (Rent1.equals(job1)){
            c1=0;
            Book.informationBook(c1,userId);

        }


        else if (hours.equals(job1)){

     Library.showhours();
        }
        else if (member.equals(job1)) {

            System.out.println("pleas enter admin password");
            pas = job.nextLine();
            if (pas.equals(Library.adminpass)) {
                User.userInform();
            }else{
                System.out.println("pleas try again");

                   pas = job.nextLine();
                   for(int i=0 ;i<100;i++){

                    if (pas.equals(Library.adminpass))
                    {
                       break;
                    }

                }
                User.userInform();
            }
        }



            else if( remmember.equals(job1))
            {
                System.out.println("pleas enter admin password");
                 pas = job.nextLine();
                 if(pas.equals(Library.adminpass)){
              Library.remmember();

                }
                
                
            }


            else if( retuarn.equals(job1)){
            System.out.println("pleas enter admin password");
            pas = job.nextLine();
            if(pas.equals(Library.adminpass)){
                Library.reaturn();

            }
        }
            else  if(bazgasht.equals(job1))
            Main.app();


            else {

            System.out.println("pleas try again");
            job(c1,userId);
        }
            

        }







   }

