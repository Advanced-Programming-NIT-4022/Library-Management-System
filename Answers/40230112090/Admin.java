package org.example;

import java.sql.*;
import java.util.Random;

public class Admin extends NormalUsers {

    public static final String URL = "jdbc:mysql://localhost/Library";
    public static final String USER = "javalibrary";
    public static final String PASS = "1384";
    public static final String INSERT_QUERY = "INSERT INTO admins (id, adminName, adminPassword, phoneNumber) VALUES (?, ?, ?, ?)";
    public static final String INSERT_QUERY2 = "INSERT INTO books (id, title, writer, description) VALUES (?, ?, ?, ?)";
    private final String admin_id;
    Book book1 = new Book();

    public Admin() {
        this.admin_id = String.valueOf(new Random().nextInt(20000) + 10000);


    }

    public void addAdmin(String adminName, String password, String phoneNumber) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASS)) {
            PreparedStatement statement = connection.prepareStatement(INSERT_QUERY);
            ResultSet resultSet = statement.executeQuery("SELECT * FROM admins");
            if (resultSet.next()) {
                String admin_name = resultSet.getString("adminName");
                String admin_password = resultSet.getString("adminPassword");
                String admin_phoneNumber = resultSet.getString("phoneNumber");
                if (adminName.equals(admin_name) && password.equals(admin_password) && phoneNumber.equals(admin_phoneNumber)) {
                    System.out.print("Another person is registered with the profile");

                } else {
                    statement.setString(1, this.admin_id);
                    statement.setString(2, adminName);
                    statement.setString(3, password);
                    statement.setString(4, super.phoneNumber);
                    System.out.print("Dear admin,your profile has been registered");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void removeAdmin(String adminName, String password) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASS)) {
            PreparedStatement statement = connection.prepareStatement(INSERT_QUERY);
            Statement statement1 = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM admins");
            if (resultSet.next()) {
                String admin_name = resultSet.getString("adminName");
                String admin_password = resultSet.getString("adminPassword");
                if (adminName.equals(admin_name) && password.equals(admin_password)) {
                    statement1.executeUpdate("DELETE FROM admins WHERE adminPassword = " + password);
                } else {
                    System.out.println("Admin with this profile was not found");
                }
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addUser(String username, String phoneNumber, String password, int number, int capacity) {
        if (number < capacity) {
            try (Connection connection = DriverManager.getConnection(URL, USER, PASS);
                 PreparedStatement statement = connection.prepareStatement("INSERT INTO normal_users (id, username, phoneNumber, password, localDate) VALUES (?, ?, ?, ?, ?)")) {
                statement.setString(1, super.id);
                statement.setString(2, username);
                statement.setString(3, phoneNumber);
                statement.setString(4, password);
                statement.setString(5, this.localDate.toString());
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println();
        }
    }

    public void removeUser(String userName, String userPassword) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement statement = connection.prepareStatement("INSERT INTO normal_users (id, username, phoneNumber, password, localDate) VALUES (?, ?, ?, ?, ?)")) {
            Statement statement1 = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM normal_users");
            if (resultSet.next()) {
                String user_name = resultSet.getString("username");
                String user_password = resultSet.getString("password");
                if (userName.equals(user_name) && userPassword.equals("user_password")) {
                    statement1.executeUpdate("DELETE FROM normal_users WHERE adminPassword = " + userPassword);
                } else {
                    System.out.println("User with this profile was not found");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addBook(String title, String writer, String description) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement statement = connection.prepareStatement(INSERT_QUERY2)) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM books");
            if (resultSet.next()) {
                String bookName = resultSet.getString("title");
                String bookWriter = resultSet.getString("writer");
                if (title.equals(bookName) && writer.equals(bookWriter)) {
                    System.out.println("Whit this specification, a book has  already been registered");
                }
            } else {
                statement.setString(1, book1.id);
                statement.setString(2, title);
                statement.setString(3, writer);
                statement.setString(4, description);
                statement.executeUpdate();
            }

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeBook(String bookName, String bookWriter) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement statement = connection.prepareStatement(INSERT_QUERY2);
             PreparedStatement statement1 = connection.prepareStatement("DELETE FROM normal_users WHERE title = ? AND writer = ?");
             ResultSet resultSet = statement.executeQuery("SELECT title , writer from books");) {
            String name_book = resultSet.getString("title");
            String writer_book = resultSet.getString("writer");
            if (bookName.equals(name_book) && bookWriter.equals(writer_book)) {
            }
            statement1.setString(1, bookName);
            statement1.setString(2, bookWriter);
            statement1.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}







