import java.util.UUID;

public class Admin {
    private String fullName;
    private String ID;
    private String phoneNumber;
    private String password;
    public Admin(String fullName, String phoneNumber, String password){
        this.fullName = fullName;
        this.ID = UUID.randomUUID().toString();
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public  String getID() {
        return ID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
