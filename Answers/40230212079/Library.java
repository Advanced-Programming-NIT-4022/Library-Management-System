import java.util.* ;
public class Library {
    String LibName , Libpassword ;
    int LibOpenHour , LibCloseHour ;
    Scanner input = new Scanner(System.in);

    public Library(String LibName, String Libpassword, int LibOpenHour, int LibCloseHour) {
        this.LibName = LibName;
        this.Libpassword = Libpassword ;
        this.LibOpenHour = LibOpenHour;
        this.LibCloseHour = LibCloseHour;
    }
    public void start( ){
        System.out.println("welcome to the " + this.LibName + " library") ;
        System.out.println("enter the options number of the following menu please");
        System.out.println("1.Admin");
        System.out.println("2.Normal User");
        System.out.println("3.joind library");
        int command = input.nextInt() ;
        checkcommand();
    }
    public void checkcommand(){

    }

}
