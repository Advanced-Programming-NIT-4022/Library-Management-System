import java.util.Scanner;

public class Admin extends NormalUser{

    Scanner sc = new Scanner(System.in);
    private String Password;
    private String regDate;

    public Admin(String name ,String Phone_Number) {
        super(name ,Phone_Number);
        System.out.println("Please Enter your Password: ");
        this.Password = setPassword(sc.nextLine());
        this.regDate = String.valueOf(super.CurrentDateTime());
    }
    public String getPassword(){
        return Password;
    }
    public String setPassword(String newPassword) {
        this.Password = newPassword;
        System.out.println("Password updated successfully for Admin: " );
        return newPassword;
    }

    public String toString(){
        return super.toString() + " " + this.Password;
    }

}
