// this class simulates the users
// and it is superclass for NormalUser and Admin
import java.util.UUID;

public class User {
    private String name;
    private String uniqueID; // unique id automatically creates in database
    private String phoneNumber;

    // constructor
    public User(String name, String phoneNumber) throws IllegalArgumentException {
        // validate phoneNumber
        String regexPhoneNumber = "(\\+989|09|00989)(0[0-5]|1[0-9]|2[0-3]|3[0-9]|9[0-6]-?\\d{3}-?\\d{4})|" +
                "(991[0134]{5})|(99[09]{6})|(998{6})";
        if (phoneNumber != null && !phoneNumber.matches(regexPhoneNumber))
            throw new IllegalArgumentException("Invalid phone number!");

        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
