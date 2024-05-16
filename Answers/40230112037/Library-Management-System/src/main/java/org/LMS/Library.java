package org.LMS;

// Todo : create database if not exist

import java.sql.*;
import java.util.ArrayList;

public class Library {
    private final static String database = "LMS";
    private final Connection connection;
    private final Statement statement;
    protected User currentUser;
    private String name;
    private Integer capacity, operatingHours;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    private Library(String name, Connection connection) throws SQLException {
        this.connection = connection;
        statement = connection.createStatement();
    }

    public static Library getInstance(String name, String sqlUrl, String sqlUserName, String sqlPassword) throws SQLException {
        Connection connection;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://" + sqlUrl + "/" + database, sqlUserName, sqlPassword);

        } catch (SQLException e) {
            return null;
        }
        return new Library(name, connection);
    }

    ArrayList<Book> resultSetToBookArrayList(ResultSet resultSet) throws SQLException {
        ArrayList<Book> result = new ArrayList<>();
        while (resultSet.next()) {
            result.add(new Book(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getBoolean(5)));
        }
        return result;
    }

    ArrayList<Book> listBooks() throws SQLException {
        resultSet = statement.executeQuery("SELECT * FROM Books");
        return resultSetToBookArrayList(resultSet);
    }

    ArrayList<Book> listBooks(Boolean available) throws SQLException {
        resultSet = statement.executeQuery("SELECT * FROM Books WHERE isAvailable=" + available);
        return resultSetToBookArrayList(resultSet);
    }

    ArrayList<Book> listBooks(String searchString) throws SQLException {
        preparedStatement = connection.prepareStatement("SELECT * FROM Books WHERE title LIKE ? OR author LIKE ? OR description LIKE ?");
        String searchExpression = '%' + UserInput.sqlLikeRegex(searchString) + '%';
        preparedStatement.setString(1, searchExpression);
        preparedStatement.setString(2, searchExpression);
        preparedStatement.setString(3, searchExpression);
        resultSet = preparedStatement.executeQuery();
        return resultSetToBookArrayList(resultSet);
    }

    ArrayList<Book> listBooks(String searchString, boolean isAvailable) throws SQLException {
        preparedStatement = connection.prepareStatement("SELECT * FROM Books WHERE title isAvailable=" + isAvailable + " AND (LIKE ? OR author LIKE ? OR description LIKE ?)");
        String searchExpression = '%' + UserInput.sqlLikeRegex(searchString) + '%';
        preparedStatement.setString(1, searchExpression);
        preparedStatement.setString(2, searchExpression);
        preparedStatement.setString(3, searchExpression);
        resultSet = preparedStatement.executeQuery();
        return resultSetToBookArrayList(resultSet);
    }

    void addBook(Book book) throws SQLException {
        preparedStatement = connection.prepareStatement("INSERT INTO Books (title,author,isAvailable,description) VALUES (?, ?, ?, ?)");
        preparedStatement.setString(1, book.title);
        preparedStatement.setString(2, book.author);
        preparedStatement.setBoolean(3, book.isAvailable);
        preparedStatement.setString(4, book.description);
        preparedStatement.executeUpdate();
    }

    boolean removeBook(int id) throws SQLException {
        preparedStatement = connection.prepareStatement("DELETE FROM Books WHERE id = " + id);
        return preparedStatement.executeUpdate() != 0;
    }

    User getUser(String username) throws SQLException {
        preparedStatement = connection.prepareStatement("SELECT * FROM Users WHERE username = ?");
        preparedStatement.setString(1, username);
        resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            if (resultSet.getBoolean("isAdmin")) {
                return new AdminUser(resultSet.getInt("id"), resultSet.getString("username"), resultSet.getString("fullName"), resultSet.getString("phoneNumber"), resultSet.getString("password"));
            } else {
                return new NormalUser(resultSet.getInt("id"), resultSet.getString("username"), resultSet.getString("fullName"), resultSet.getString("phoneNumber"), resultSet.getDate("registrationDate"));
            }
        }
        return null;

    }

    void addAdminUser(AdminUser adminUser) throws SQLException {
        preparedStatement = connection.prepareStatement("INSERT INTO Users (username,fullName,phoneNumber,password,isAdmin) VALUES (?,?,?,?,true)");
        preparedStatement.setString(1, adminUser.username);
        preparedStatement.setString(2, adminUser.fullName);
        preparedStatement.setString(3, adminUser.phoneNumber);
        preparedStatement.setString(4, adminUser.password.getHashedPassword());
        preparedStatement.executeUpdate();
    }

    void addNormalUser(NormalUser normalUser) throws SQLException {
        preparedStatement = connection.prepareStatement("INSERT INTO Users (username,fullName,phoneNumber,registrationDate,isAdmin) VALUES (?,?,?,?,false)");
        preparedStatement.setString(1, normalUser.username);
        preparedStatement.setString(2, normalUser.fullName);
        preparedStatement.setString(3, normalUser.phoneNumber);
        preparedStatement.setDate(4, new Date(System.currentTimeMillis()));
        preparedStatement.executeUpdate();
    }
}
