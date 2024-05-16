import java.util.* ;
public class Library implements CLI {
    int countID = 0 ;
    String LibName , Libpassword ;
    int LibOpenHour , LibCloseHour ;
    Scanner input = new Scanner(System.in);
    public String command1;

    public Library(String LibName, String Libpassword, int LibOpenHour, int LibCloseHour) {
        this.LibName = LibName;
        this.Libpassword = Libpassword;
        this.LibOpenHour = LibOpenHour;
        this.LibCloseHour = LibCloseHour;
    }
    public void start(){
        System.out.println("welcome to the " + this.LibName + " library") ;
        System.out.println("enter one option of the following options please");
        System.out.println("lib add member as a NormalUser <name> <ID> <phonnumber>");
        System.out.println("lib add member as a Admin <name> <ID> <phonnumber> <password>");
        System.out.println("lib add a book <Title> <Author> ");
        checkcommand();
    }
    public void checkcommand(){
        command1 = input.nextLine();
        String[] command = command1.split(" ");
        if (command[0].equalsIgnoreCase("lib")){
            if(command[5].equalsIgnoreCase("NormalUser")){
                NormalUser obj = new NormalUser(command[6],command[7],command[8]);
            }
            else if(command[5].equalsIgnoreCase("Admin")){
                Admin obj1 = new Admin(command[6],command[7],command[8],command[9]);
            }

        }
        else if(command[3].equalsIgnoreCase("book")){
            countID++;
            Book obj2 = new Book(command[4],command[5],countID);
        }
        else {
            System.out.println("wrong entry , try again :)");
        }
    }
  }