// this class for simulates renting
import java.sql.*;

public class Rent implements Updatable {
    private Book book;
    private NormalUser person;
    private int rentalID;
    private Timestamp rentalTimestamp;

    public Rent(Book book, NormalUser person) {
        this.book = book;
        this.person = person;
        this.rentalTimestamp = new Timestamp(System.currentTimeMillis());
    }

    public Rent(Book book, NormalUser person, Timestamp rentalTimestamp) {
        this.book = book;
        this.person = person;
        this.rentalTimestamp = rentalTimestamp;
    }

    public void update() {
        final String SQL_COMMAND = "SELECT RentalID FROM rents WHERE UserID = ? AND BookID = ? " +
                "AND ReturnDate IS NULL;";

        try (Connection connection = DriverManager.getConnection(MyApp.DB_URL,
                MyApp.DB_USERNAME, MyApp.DB_PASSWORD);
             PreparedStatement updateRent = connection.prepareStatement(SQL_COMMAND)) {

            updateRent.setInt(1, this.person.getUniqueID());
            updateRent.setInt(2, this.book.getUniqueID());

            ResultSet resultSet = updateRent.executeQuery();
            if (resultSet.next())
                this.rentalID = resultSet.getInt("RentalID");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.err.print("Connection to database failed! Terminating...");
            System.exit(1);
        }
    }
    public Book getBook() {
        return book;
    }

    public NormalUser getPerson() {
        return person;
    }

    public int getRentalID() {
        return rentalID;
    }

    public Timestamp getRentalTimestamp() {
        return rentalTimestamp;
    }
}