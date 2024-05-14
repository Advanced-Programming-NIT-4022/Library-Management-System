import java.sql.*;

public class Book {
    private String title;
    private String author;
    private String description;
    private int uniqueID; // unique id automatically generate in database
    public boolean availabilityStatus = true;

    // two arguments constructor
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // three arguments constructor
    public Book(String title, String author, String description) {
        this.title = title;
        this.author = author;
        this.description = description;
    }

    public void uniqueIDUpdate() {
        final String SQL_COMMAND = "SELECT BookID FROM BOOKS WHERE Title = ? AND Author = ?";

        try (Connection connection = DriverManager.getConnection(MyApp.DB_URL,
                MyApp.DB_USERNAME, MyApp.DB_PASSWORD);
             PreparedStatement selectID = connection.prepareStatement(SQL_COMMAND)) {

            selectID.setString(1, this.title);
            selectID.setString(2, this.author);

            ResultSet resultSet = selectID.executeQuery();
            if (resultSet.next())
                this.uniqueID = resultSet.getInt("BookID");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.err.print("Connection to database failed! Terminating...");
            System.exit(1);
        }
    }

    public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public String getDescription() {
        return description;
    }
    
    public int getUniqueID() {
        return uniqueID;
    }
}