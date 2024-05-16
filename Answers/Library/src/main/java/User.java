import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class User extends Person implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String date_of_registration;
    static int currentID = 0;

    public User(String fullName, String phoneNumber){
        super(fullName,phoneNumber);
        currentID++;
        this.ID = String.valueOf(currentID);
        this.date_of_registration = getFormattedDate();
    }
    public String getDate_of_registration() {
        return date_of_registration;
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