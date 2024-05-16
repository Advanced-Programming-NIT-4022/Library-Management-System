import java.util.* ;
public class NormalUser extends User {
    private String userdate ;
    Scanner input1 = new Scanner (System.in);
    public NormalUser(String name , int ID , String phonnumber){
        super(name, ID, phonnumber);
        System.out.println("please enter the date");
        userdate = input1.nextLine();

    }
    public String getUserDate()
    {
        return userdate;
    }
}
