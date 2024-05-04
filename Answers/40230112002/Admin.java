import java.util.Scanner;

public class Admin extends User{
    private String AdminPassword;
    private String RegisterDate;
    private static int lastAdminID = LastUserID;
    private int UserID;
    public Admin(String name, String phoneNumber , String Password) {

        super(name, phoneNumber);
        this.UserID = ++lastAdminID;
        AdminPassword = setAdminPassword();
        RegisterDate = NormalUser.CurrentDateTime();
        this.AdminPassword = Password;

    }


    public String getAdminPassword() {
        return AdminPassword;
    }

    public String setAdminPassword() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your Password: ");
        AdminPassword = sc.nextLine();
        ///can be conditioned to 8 char length
        System.out.println("Password Successfully updated !!!");
        return AdminPassword;
    }

    public String toString(){
        return super.toString() + " " + RegisterDate + " " + getAdminPassword();
    }

}
