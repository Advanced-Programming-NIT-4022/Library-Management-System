import java.util.UUID;

public class Admin {
    private String completeName;
    private String ID;
    private String phoneNumber;
    private int password;
    public User(String completeName, String phoneNumber, int password){
        this.completeName = completeName;
        this.ID = UUID.randomUUID().toString();
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public String getCompleteName() {
        return completeName;
    }

    public  String getID() {
        return ID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getPassword() {
        return password;
    }

    public void setCompleteName(String completeName) {
        this.completeName = completeName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPassword(int password) {
        this.password = password;
    }
}
