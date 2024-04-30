// this class simulates the users
// and it is superclass for NormalUser and Admin
import java.util.UUID;

public class User {
    private String name;
    // unique id is based on the name of the user
    private String uniqueID;
    private String phoneNumber;

    // constructor

    public User(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.uniqueID= UUID.nameUUIDFromBytes(phoneNumber.getBytes()).toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

        // the unique id should change
        uniqueID = UUID.nameUUIDFromBytes(this.phoneNumber.getBytes()).toString();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUniqueID() {
        return uniqueID;
    }
}
