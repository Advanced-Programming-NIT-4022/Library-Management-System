import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

public class Admin implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String fullName;
    private String ID;
    private String phoneNumber;
    private String password;
    static int currentID = 0;
    public Admin(String fullName, String phoneNumber, String password){
        currentID ++;
        this.fullName = fullName;
        this.ID = String.valueOf(currentID);
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
                "fullName='" + getFullName() + '\'' +
                ", ID='" + getID() + '\'' +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                ", password='" + getPassword() + '\'' +
                '}';
    }
}
