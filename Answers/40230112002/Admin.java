import java.util.Scanner;

public class Admin extends User{


    private String AdminPassword;
    private String RegisterDate;


    public Admin(String name, String phoneNumber) {
        super(name, phoneNumber);
        AdminPassword = setAdminPassword();
        RegisterDate = NormalUser.CurrentDateTime();
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
