package org.example;

import java.sql.*;
import java.util.*;

public class Book {

    private static final String URL = "jdbc:mysql://localhost/Library";
    private static final String USER = "javalibrary";
    private static final String PASS = "1384";
    private static final String INSERT_QUERY = "INSERT INTO books (id, title, writer, description) VALUES (?, ?, ?, ?)";
    private static final String SELECT_RENT_QUERY = "SELECT rents.rent, rents.title FROM rents JOIN books ON books.id = rents.id_of_title ;";


    public String title;
    public String id;

    public Book() {
        this.id = String.valueOf(new Random().nextInt(20000) + 10000);
    }


    public String title(String input) {
        Scanner scanner = new Scanner(System.in);
        input = input.trim();
        while (input.isEmpty()) {
            System.out.print("Please enter your first name and last name : ");
            input = scanner.nextLine().trim();
        }
        String[] words = input.split(" ");
        StringBuilder formatted = new StringBuilder();
        for (String word : words) {
            formatted.append(Character.toUpperCase(word.charAt(0)))
                    .append(word.substring(1).toLowerCase())
                    .append(" ");
        }
        return formatted.toString().trim();
    }


    public void viewAvailableBooks() {
        // View available books for rental
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASS);
            PreparedStatement statement = connection.prepareStatement(INSERT_QUERY);
            ResultSet resultSet = statement.executeQuery("SELECT books.id , books.title , books.writer , rents.rent FROM books LEFT JOIN rents ON rents.id_of_title = books.id;");
            int n = 1;

            while (resultSet.next()) {
//                System.out.println(resultSet.getString("rent"));
                if ("null".equals(String.valueOf(resultSet.getString("rents.rent")))) {
                    System.out.println(resultSet.getString("id") + "-" + resultSet.getString("title") + " from " + resultSet.getString("writer"));
                    n++;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void viewRentBooks() {

        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASS);
            PreparedStatement statement = connection.prepareStatement(INSERT_QUERY);
            ResultSet resultSet = statement.executeQuery(SELECT_RENT_QUERY);
            int n = 1;
            while (resultSet.next()) {
                if ("rent".equals(String.valueOf(resultSet.getString("rent")))) {
                    System.out.println(n + "-" + resultSet.getString("title"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void setTitle(String title) {
        this.title = title;
    }
}
