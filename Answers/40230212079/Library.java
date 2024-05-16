import java.util.* ;
public class Library implements CLI {
    String LibName , Libpassword ;
    int LibOpenHour , LibCloseHour ;
    Scanner input = new Scanner(System.in);
    public String command1;

    public Library(String LibName, String Libpassword, int LibOpenHour, int LibCloseHour) {
        this.LibName = LibName;
        this.Libpassword = Libpassword ;
        this.LibOpenHour = LibOpenHour;
        this.LibCloseHour = LibCloseHour;
    }
    public void start( ){
        System.out.println("welcome to the " + this.LibName + " library") ;
        System.out.println("enter one option of the following options please");
        System.out.println("lib add book <name> <author> <subtitle> ");
        System.out.println("lib get hrs");
        System.out.println("lib rent <bookName>");
        System.out.println("lib add member <studentID> <password>");
        System.out.println("lib rent <bookName> <memberName> <memberID>");
        System.out.println("lib get available books");
        System.out.println("lib remove member <memberID");
        System.out.println("lib return <bookName>");
        checkcommand();
    }


    public void checkcommand(){
        command1 = input.nextLine();
        String[] command = command1.split(" ");
        if (command[0].equalsIgnoreCase("lib")){
            if(command[1].equalsIgnoreCase("add")){
                if(command[2].equalsIgnoreCase("book")){

                }else if(command[2].equalsIgnoreCase("member")){

                }
            }
            else if(command[1].equalsIgnoreCase("get")){
                if(command[2].equalsIgnoreCase("hrs")){

                }
                else if(command[2].equalsIgnoreCase("available")){

                }
            }
            else if(command[1].equalsIgnoreCase("rent")){
                if(command[2].isEmpty()){

                }
                else {

                }
            }
            else if(command[0].equalsIgnoreCase("remove")){

            }
            else if(command[0].equalsIgnoreCase("return")){

            }
        }
        else{
            System.out.println("wrong entry , try again :)");
        }
    }

}
