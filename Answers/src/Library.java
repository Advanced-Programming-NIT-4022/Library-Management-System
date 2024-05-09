import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Formatter;

public class Library {
    private String name;
    private int capacity;
    private String operatingHours;
    User user; // user that log in now

    private static final String DB_URL = "jdbc:mysql://localhost/library";
    private static final String DB_USERNAME = "LMSjava";
    private static final String DB_PASSWORD = "lmsjava1234";

    public void saveLibrary() throws FileNotFoundException, SecurityException {
        Formatter output = new Formatter(MyApp.PATH.toString());
        output.format("%s%n%d%n%s", name, capacity, operatingHours);
        output.close();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setOperatingHours(String operatingHours) throws IllegalArgumentException {
        {
            // validate operating hours
            if (!operatingHours.matches("\\d{2}-\\d{2}"))
                throw new IllegalArgumentException("Invalid format (e.g. 08-20).");

            String[] hours = operatingHours.split("-");
            if (Integer.parseInt(hours[0]) > 24 || Integer.parseInt(hours[1]) > 24)
                throw new IllegalArgumentException("Invalid hours.");
        }
        this.operatingHours = operatingHours;
    }

    // add normal user
    public Boolean addUser(NormalUser user) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            PreparedStatement insertUser = connection.prepareStatement(
                    "INSERT INTO Users (Name, PhoneNumber, UserType, RegisterDate, RegisterTime)" +
                            "VALUES (?, ?, ?, ?, ?)")) {

            insertUser.setString(1, user.getName());
            insertUser.setString(2, user.getPhoneNumber());
            insertUser.setString(3, "'normal'");
            insertUser.setString(4, user.getRegisterDate().toString());
            insertUser.setString(5, user.getRegisterTime().toString());

            insertUser.executeUpdate();

            // prompt
            System.out.printf("User <%s> was saved successfully!%n", user.getName());
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.err.print("Connection to database failed!");
            return false;
        }
        return true;
    }

    // add admin user
    public boolean addUser(User admin, String password) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            PreparedStatement insertUser = connection.prepareStatement(
                    "INSERT INTO Users (Name, PhoneNumber, UserType, Password) "
                            + "VALUES (?, ?, ?, ?)")) {

            insertUser.setString(1, admin.getName());
            insertUser.setString(2, admin.getPhoneNumber());
            insertUser.setString(3, "admin");
            insertUser.setString(4, password);

            insertUser.executeUpdate();

            // prompt
            System.out.printf("User <%s> was successfully saved!%n", admin.getName());
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.err.print("Connection to database failed!");
            return false;
        }
        return true;
    }

    // add book
    public boolean addBook(Book book) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            PreparedStatement insertBook = connection.prepareStatement(
                    "INSERT INTO books (UniqueBookID, Title, Author, Description) " +
                            "VALUES (?, ?, ?, ?)")) {

            insertBook.setString(1, book.getUniqueBookID());
            insertBook.setString(2, book.getTitle());
            insertBook.setString(3, book.getAuthor());
            insertBook.setString(4, book.getDescription());

            insertBook.executeUpdate();

            // prompt
            System.out.printf("Book <%s> was successfully saved!%n", book.getTitle());
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.err.print("Connection to database failed!");
            return false;
        }
        return true;
    }
}
