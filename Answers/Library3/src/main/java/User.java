import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String fullName;
    private String ID;
    private String phoneNumber;
    private String date_of_registration;
    static int currentID = 0;


    public User(String fullName, String phoneNumber){
        currentID++;
        this.fullName = fullName;
        this.ID = String.valueOf(currentID);
        this.phoneNumber = phoneNumber;
        this.date_of_registration = getFormattedDate();
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

    public String getDate_of_registration() {
        return date_of_registration;
    }

    public void setFullName(String completeName) {
        this.fullName = completeName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public static String getFormattedDate() {
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        return date.format(formatter);
    }
    @Override
    public String toString() {
        return "User{" +
                "fullName='" + getFullName() + '\'' +
                ", ID='" + getID() + '\'' +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                ", date_of_registration='" + getDate_of_registration() + '\'' +
                '}';
    }

}

