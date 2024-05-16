import java.util.ArrayList;

public class NormalUser extends User{
    private String RegistrationDate;
    public NormalUser(String Name, String UserID, String PhoneNumber){
        super(Name, UserID, PhoneNumber);
        this.RegistrationDate=RegistrationDate;
    }

    public String getRegistrationDate() {
        return RegistrationDate;
    }

    public static ArrayList<NormalUser> NormalUsers = new ArrayList<>();

    public static void NormalUserSignUp(NormalUser a){
        NormalUsers.add(a);
    }
}
