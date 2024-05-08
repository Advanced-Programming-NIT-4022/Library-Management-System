import java.util.Scanner;

public class Admin extends User{
    private String AdminPassword;
    private String RegisterDate;
    private static int lastAdminID = LastUserID;
    private int UserID;
    public Admin(String name, String phoneNumber , String Password) {

        super(name, phoneNumber);
        this.UserID = ++lastAdminID;
        RegisterDate = NormalUser.CurrentDateTime();
        this.AdminPassword = Password;

    }


    public String getAdminPassword() {
        return AdminPassword;
    }

    public String toString(){
        return super.toString() + " " + RegisterDate + " " + getAdminPassword();
    }

}
