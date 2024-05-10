import java.util.Scanner;

public class CLI {
    static int pas;
    static int i12,i13,i14,i15,i16,i17,i18;
    public static void job(int c1,int userId){
        System.out.println("Access list");
        System.out.println("1.lib add book" +
                "\n2.lib get hrs\n3.lib rent\n4.lib add member\n5.lib get available books\n6.lib remove member" +
                "\n7.lib return");

        Scanner job = new Scanner(System.in);
        System.out.println("pleas write your job :");
        String job1 = job.nextLine().toLowerCase();
        String add = "lib add book";
        String hours = "lib get hrs";
        String Rent1 = "lib rent";
        String member  = "lib add member";
        String avail  = "lib get available books";
        String remmember  = "lib remove member";
        String retuarn  = "lib return";


         i13 = avail.compareTo(job1);
         i14 = Rent1.compareTo(job1);
         i15 = hours.compareTo(job1);
         i16 = member.compareTo(job1);
         i17 = remmember.compareTo(job1);
         i18= retuarn.compareTo(job1);
        i12 =add.compareTo(job1);

        if(i12==0){
            Book.informationBook(i12,i13,i14,c1,userId);
        }

        else if(i13==0)
        {
            Book.informationBook(i12,i13,i14,c1,userId);
        }

        else if (i14==0){
            c1=0;
            Book.informationBook(i12,i13,i14,c1,userId);

        }
        else if (i15==0){

     Library.showhours();
        }
        else if (i16==0) {

            System.out.println("pleas enter admin password");
            pas = job.nextInt();
            if (Library.adminpass == pas) {
                User.userInform();
            }else{
                System.out.println("pleas try again");

                for(int i=0 ;i<100;i++){
                    pas = job.nextInt();
                    if (Library.adminpass == pas) {
                       break;

                    }
                }
                User.userInform();
            }
        }
            else if(i17==0){
                System.out.println("pleas enter admin password");
                 pas = job.nextInt();
                if(Library.adminpass==pas){
              Library.remmember();

                }
                
                
            }
            else if(i18==0){
            System.out.println("pleas enter admin password");
            pas = job.nextInt();
            if(Library.adminpass==pas){
                Library.reaturn();

            }
        }
            else {

            System.out.println("pleas try again");
            job(c1,userId);
        }
            

        }







   }

