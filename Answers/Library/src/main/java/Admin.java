import java.io.Serializable;
import java.util.UUID;

public class Admin implements Serializable {
    private String fullName;
    private final String ID;
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
    @Override
    public String toString() {
        return "Admin{" +
                "fullName='" + fullName + '\'' +
                ", ID='" + ID + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                // Do not include the password for security reasons
                '}';
    }
}
