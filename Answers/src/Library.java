import javax.naming.NoPermissionException;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Formatter;

public class Library {
    private String name;
    private int capacity;
    private String operatingHours;
    private User user; // user that log in now

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getOperatingHours() {
        return operatingHours;
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
    // return the unique ID of the user
    public int addUser(NormalUser user) {
        final String SQL_COMMAND = "INSERT INTO Users (Name, PhoneNumber, UserType," +
                " RegisterTimestamp) VALUES (?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(MyApp.DB_URL,
                MyApp.DB_USERNAME, MyApp.DB_PASSWORD);
             PreparedStatement insertUser = connection.prepareStatement(SQL_COMMAND)) {

            insertUser.setString(1, user.getName());
            insertUser.setString(2, user.getPhoneNumber());
            insertUser.setString(3, "normal");
            insertUser.setTimestamp(4, user.getRegisterTimestamp());

            insertUser.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.err.print("Connection to database failed!");
            return 0;
        }

        user.uniqueIDUpdate();
        return user.getUniqueID();
    }

    // add admin user
    // return the unique ID of the user
    public int addUser(User admin, String password) {
        final String SQL_COMMAND = "INSERT INTO Users (Name, PhoneNumber, UserType, Password) "
                + "VALUES (?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(MyApp.DB_URL,
                MyApp.DB_USERNAME, MyApp.DB_PASSWORD);
             PreparedStatement insertUser = connection.prepareStatement(SQL_COMMAND)) {

            insertUser.setString(1, admin.getName());
            insertUser.setString(2, admin.getPhoneNumber());
            insertUser.setString(3, "admin");
            insertUser.setString(4, password);

            insertUser.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.err.print("Connection to database failed!");
            return 0;
        }

        // get the unique id from database
        admin.uniqueIDUpdate();
        return admin.getUniqueID();
    }

    public int removeUser(int userID) throws NoPermissionException {
        if (user == null || user instanceof NormalUser)
            throw new NoPermissionException("You don't have permission to remove members!");

        for (int i = 0; i < 3; i++) {
            System.out.print("Enter your password: ");
            String password = MyApp.input.nextLine();
            if (((Admin) user).verify(password))
                break;
            else if (i == 2)
                throw new IllegalArgumentException("3 incorrect password attempts...");
            else
                System.out.println("Invalid password. Try again.");
        }

        final String SQL_COMMAND = "DELETE FROM Users WHERE UserID = ?";
        try (Connection connection = DriverManager.getConnection(MyApp.DB_URL,
                MyApp.DB_USERNAME, MyApp.DB_PASSWORD);
             PreparedStatement deleteUser = connection.prepareStatement(SQL_COMMAND)) {

            deleteUser.setInt(1, userID);
            return deleteUser.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.err.print("Connection to database failed!");
            return 0;
        }
    }

    // add book
    public void addBook(Book book) {
        final String SQL_COMMAND = "INSERT INTO books (BookID, Title, Author, Description) " +
                "VALUES (?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(MyApp.DB_URL,
                MyApp.DB_USERNAME, MyApp.DB_PASSWORD);
            PreparedStatement insertBook = connection.prepareStatement(SQL_COMMAND)) {

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
        }
    }

    // login to library
    public User login(String userID) {
        User user = null;
        final String SQL_COMMAND = "SELECT * FROM Users WHERE UserID = ?";

        try (Connection connection = DriverManager.getConnection(MyApp.DB_URL,
                MyApp.DB_USERNAME, MyApp.DB_PASSWORD);
             PreparedStatement loginUser = connection.prepareStatement(SQL_COMMAND)) {

            loginUser.setString(1, userID);
            ResultSet resultSet = loginUser.executeQuery();

            // If there is no such user
            if (!resultSet.isBeforeFirst())
                return null;
            resultSet.next();

            // get name and phone number of the user
            String name = resultSet.getString("Name");
            String phoneNumber = resultSet.getString("PhoneNumber");

            if (resultSet.getString("UserType").equals("admin")) {
                String password = resultSet.getString("Password");
                user = new Admin(name, phoneNumber, password);
                user.uniqueIDUpdate();
            } else {
                Timestamp registerTimestamp = resultSet.getTimestamp("RegisterTimestamp");
                user = new NormalUser(name, phoneNumber, registerTimestamp);
                user.uniqueIDUpdate();
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.err.print("Connection to database failed! Terminating...");
            System.exit(1);
        }
        return user;
    }

    public void getAvailableBooks() {
        final String SQl_COMMAND = "SELECT BookID, Title, Author, Description " +
                "FROM books WHERE AvailabilityStatus = 1";
        // connect to database books and query database
        try (JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet()) {

            rowSet.setUrl(MyApp.DB_URL);
            rowSet.setUsername(MyApp.DB_USERNAME);
            rowSet.setPassword(MyApp.DB_PASSWORD);
            rowSet.setCommand(SQl_COMMAND);
            rowSet.execute();

            // process query results
            ResultSetMetaData metaData = rowSet.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            System.out.printf("Available books:%n%n");
            // display rowset header
            for (int i = 1; i <= numberOfColumns; i++) {
                if (i > 2)
                    System.out.printf("%-20s\t", metaData.getColumnName(i));
                else
                    System.out.printf("%-15s\t", metaData.getColumnName(i));
            }
            System.out.println();
            // display each row
            while (rowSet.next())
            {
                for (int i = 1; i <= numberOfColumns; i++) {
                    if (i > 2)
                        System.out.printf("%-20s\t", rowSet.getObject(i));
                    else
                        System.out.printf("%-15s\t", rowSet.getObject(i));
                }
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.print("Connection to database failed! Terminating...");
            System.exit(1);
        }
    }
}
