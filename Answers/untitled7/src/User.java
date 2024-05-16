import java.time.LocalDate;
import java.util.Scanner;

public class User {
    protected String Name, UserID, PhoneNumber;
    private String RegistrationDate;
    private String Password;
    public User(String Name, String UserID, String PhoneNumber){
        this.PhoneNumber=PhoneNumber;
        this.UserID=UserID;
        this.Name=Name;
        this.RegistrationDate= LocalDate.now().toString();
    }
    public User(String Name, String UserID,String Password, String PhoneNumber){
        this.PhoneNumber=PhoneNumber;
        this.UserID=UserID;
        this.Name=Name;
        this.Password=Password;
    }

    public String getName() {
        return Name;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public String getUserID() {
        return UserID;
    }

    public String getPassword() {
        return Password;
    }

    @Override
    public String toString() {
        return "Objname{" + "property1=" + Name+
        UserID+
                PhoneNumber;

    }
}
