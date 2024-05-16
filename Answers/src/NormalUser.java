import java.sql.*;
import java.util.ArrayList;

public class NormalUser extends User implements Updatable {
    private Timestamp registerTimestamp;
    private ArrayList<Book> rentBooks = new ArrayList<>();

    public NormalUser(String name, String phoneNumber, Timestamp registerDateTime) {
        super(name, phoneNumber);
        this.registerTimestamp = registerDateTime;
    }

    public NormalUser(String name, String phoneNumber) {
        super(name, phoneNumber);
        this.registerTimestamp = new Timestamp(System.currentTimeMillis());
    }

    public NormalUser(int userID, String name) throws Exception {
        super(userID, name);
        final String SQL_COMMAND = "SELECT RegisterTimeStamp FROM users WHERE UserID = ? " +
                "AND UserType = 'normal';";

        try (Connection connection = DriverManager.getConnection(MyApp.DB_URL, MyApp.DB_USERNAME,
                MyApp.DB_PASSWORD);
             PreparedStatement selectUser = connection.prepareStatement(SQL_COMMAND)){

            selectUser.setInt(1, userID);
            ResultSet resultSet = selectUser.executeQuery();

            if (resultSet.next()) {
                registerTimestamp = resultSet.getTimestamp("RegisterTimeStamp");
            } else
                throw new Exception("User with ID = " + userID + "is not a normal user.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.print("Connection to database failed! Terminating...");
            System.exit(1);
        }
    }

    public Timestamp getRegisterTimestamp() {
        return registerTimestamp;
    }

    // rent a book
    public int rentBook(Rent rent) {
        final String SQL_COMMAND = "INSERT INTO rents (UserID, BookID, RentalDate) VALUES (?, ?, ?);";

        try (Connection connection = DriverManager.getConnection(MyApp.DB_URL, MyApp.DB_USERNAME,
                MyApp.DB_PASSWORD);
             PreparedStatement addRentCommand = connection.prepareStatement(SQL_COMMAND)){

            addRentCommand.setInt(1, rent.getPerson().getUniqueID());
            addRentCommand.setInt(2, rent.getBook().getUniqueID());
            addRentCommand.setTimestamp(3, rent.getRentalTimestamp());
            addRentCommand.executeUpdate();

            rent.update();
            rent.getBook().setStatus(false);
            rentBooks.add(rent.getBook());
            return rent.getRentalID();
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.print("Connection to database failed!");
            return 0;
        }
    }

    @Override
    public void update() {
        super.update();
        final String SQL_COMMAND = "SELECT * FROM rents WHERE UserID = ? AND ReturnDate IS NULL;";
        rentBooks.clear();

        try (Connection connection = DriverManager.getConnection(MyApp.DB_URL, MyApp.DB_USERNAME,
                MyApp.DB_PASSWORD);
             PreparedStatement selectRentBooks = connection.prepareStatement(SQL_COMMAND)) {

            selectRentBooks.setInt(1, this.getUniqueID());

            ResultSet resultSet = selectRentBooks.executeQuery();

            while (resultSet.next()) {
                Book book = new Book(resultSet.getInt("BookID"));
                rentBooks.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.print("Connection to database failed!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Book> getRentBooks() {
        update();
        return rentBooks;
    }
}