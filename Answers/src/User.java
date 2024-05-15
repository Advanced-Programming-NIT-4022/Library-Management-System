// this class simulates the users
// and it is superclass for NormalUser and Admin
import java.sql.*;

public class User implements Updatable {
    private String name;
    private int uniqueID; // unique id automatically creates in database
    private String phoneNumber;

    // constructor
    public User(String name, String phoneNumber) throws IllegalArgumentException {
        // validate phoneNumber
        String regexPhoneNumber = "(\\+989|09|00989)((0[0-5]|1[0-9]|2[0-3]|3[0-9]|9[0-6])-?\\d{3}-?\\d{4})|" +
                "(99-?1[0134]{2}-?[0134]{4})|(99-?[09]{3}-?[09]{4})";
        if (phoneNumber != null && !phoneNumber.matches(regexPhoneNumber))
            throw new IllegalArgumentException("Invalid phone number!");

        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public void update() {
        final String SQL_COMMAND = "SELECT UserID FROM users WHERE PhoneNumber = ?";

        try (Connection connection = DriverManager.getConnection(MyApp.DB_URL,
                MyApp.DB_USERNAME, MyApp.DB_PASSWORD);
             PreparedStatement selectID = connection.prepareStatement(SQL_COMMAND)) {

            selectID.setString(1, this.phoneNumber);

            ResultSet resultSet = selectID.executeQuery();
            if (resultSet.next())
                this.uniqueID = resultSet.getInt("UserID");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.err.print("Connection to database failed! Terminating...");
            System.exit(1);
        }
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getUniqueID() {
        return uniqueID;
    }

    @Override
    // to string method of admins
    public String toString() {
        return String.format("You are "+ this.getName() + " with id = " + this.getUniqueID());
    }
}
