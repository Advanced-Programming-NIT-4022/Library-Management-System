import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

public class Admin extends Person implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String password;
    static int currentID = 0;

    public Admin(String fullName, String phoneNumber, String password) {
        super(fullName, phoneNumber);
        currentID ++;
        this.ID = String.valueOf(currentID);
        this.password = password;
    }
    public String getPassword(){
        return password;
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
                '}';
    }
}
