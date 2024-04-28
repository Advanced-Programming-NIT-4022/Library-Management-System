import java.util.UUID;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class User {
    private String completeName;
    private  String ID;
    private String phoneNumber;
    private String date_of_registration;
        public static String getFormattedDate() {
            LocalDate date = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            return date.format(formatter);
        }

    public User(String completeName, String phoneNumber){
        this.completeName = completeName;
        this.ID = UUID.randomUUID().toString();
        this.phoneNumber = phoneNumber;
        this.date_of_registration = getFormattedDate();
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

    public String getDate_of_registration() {
        return date_of_registration;
    }

    public void setCompleteName(String completeName) {
        this.completeName = completeName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}