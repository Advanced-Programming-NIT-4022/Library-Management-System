import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends User{
    private String Password;
    public Admin(String Name, String UserID, String PhoneNumber, String Password){
        super(Name, UserID, PhoneNumber);
        this.Password=Password;
    }
    public static ArrayList<Admin> Admins = new ArrayList<>();


    public String getPassword() {
        return Password;
    }

    public void AdminSignUp(){
        Scanner input= new Scanner(System.in);
        super.Name=input.nextLine();
        super.UserID=input.nextLine();
        super.PhoneNumber=input.nextLine();
    }
}
