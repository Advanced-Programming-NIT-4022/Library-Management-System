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
}
