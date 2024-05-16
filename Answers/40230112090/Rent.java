

package org.example;

import java.sql.*;
import java.util.*;

public class Rent extends NormalUsers {
    org.example.Book book = new org.example.Book();

    public void rentBook(String titleForBook, String writerForBook) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/Library", "javalibrary", "1384")) {
            try (PreparedStatement statement = connection.prepareStatement("SELECT books.id, books.title, books.writer, normal_users.id AS user_id, normal_users.username FROM books JOIN normal_users LEFT JOIN rents ON books.id = rents.id_of_title WHERE books.title = ? AND books.writer = ? AND rents.id_of_title IS NULL")) {
                statement.setString(1, titleForBook);
                statement.setString(2, writerForBook);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    String bookId = resultSet.getString("id");
                    String userId = resultSet.getString("user_id");
                    String username = resultSet.getString("username");

                    try (PreparedStatement insert = connection.prepareStatement(" INSERT INTO rents (id_of_member, member, id_of_title, title) VALUES ('12343', 'amir', '1111', 'summer');")) {
                        insert.setString(1, userId);
                        insert.setString(2, username);
                        insert.setString(3, bookId);
                        insert.setString(4, titleForBook);
                        insert.setString(5, "rent");
                        insert.executeUpdate();
                        System.out.println("Book rented successfully.");
                    }
                } else {
                    System.out.println("Book not available for rent or does not exist.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void rentBookForSpecialMember(String titleForBook, String writerForBook, String nameForMember, String passwordForMember) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/Library", "javalibrary", "1384")) {
            try (PreparedStatement statement = connection.prepareStatement("SELECT books.id AS book_id, books.title, books.writer, normal_users.id AS user_id, normal_users.username FROM books JOIN normal_users LEFT JOIN rents ON books.id = rents.id_of_title WHERE books.title = ? AND books.writer = ? AND rents.id_of_title IS NULL")) {
                statement.setString(1, titleForBook);
                statement.setString(2, writerForBook);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    String bookId = resultSet.getString("book_id");
                    try (PreparedStatement statement1 = connection.prepareStatement(
                            "SELECT id, username FROM normal_users WHERE username = ? AND password = ?")) {
                        statement1.setString(1, nameForMember);
                        statement1.setString(2, passwordForMember);
                        ResultSet resultSet1 = statement1.executeQuery();
                        if (resultSet1.next()) {
                            String userId = resultSet1.getString("id");
                            String username = resultSet1.getString("username");
                            try (PreparedStatement insert = connection.prepareStatement(
                                    "INSERT INTO rents (id_of_member, member, id_of_title, title , rent) VALUES (?, ?, ?, ? , ?)")) {
                                insert.setString(1, userId);
                                insert.setString(2, username);
                                insert.setString(3, bookId);
                                insert.setString(4, titleForBook);
                                insert.setString(5, "rent");
                                insert.executeUpdate();
                                System.out.println("Book rented successfully.");
                            }
                        } else {
                            System.out.println("Member not found or incorrect password.");
                        }
                    }
                } else {
                    System.out.println("Book not available for rent or does not exist.");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void returnBook(String nameOfBook, String writerOfBook) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/Library", "javalibrary", "1384")) {

            try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT books.id, books.title, books.writer, rents.id_of_member, rents.member, rents.rent FROM books LEFT JOIN rents ON books.id = rents.id_of_title WHERE books.title = ? AND books.writer = ?")) {
                preparedStatement.setString(1, nameOfBook);
                preparedStatement.setString(2, writerOfBook);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    String bookId = resultSet.getString("id");
                    String memberId = resultSet.getString("id_of_member");
                    String rentStatus = resultSet.getString("rent");
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        if ("rent".equals(rentStatus) && memberId.equals(entry.getKey())) {
                            try (PreparedStatement updateBook = connection.prepareStatement("SELECT books.id, books.title, books.writer, rents.id_of_member, rents.member, rents.rent FROM books LEFT JOIN rents ON books.id = rents.id_of_title WHERE books.title = ? AND books.writer = ?")) {
                                updateBook.setString(1, "available");
                                updateBook.setString(2, bookId);
                                updateBook.executeUpdate();
                                System.out.println("The book has been returned to the library.");
                            }
                        } else {
                            System.out.println("The book is not currently rented out or does not match the member's records.");
                        }
                    }
                } else {
                    System.out.println("The desired book was not found.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void rentedOfBook() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/Library", "javalibrary", "1384")) {

            try (PreparedStatement statement = connection.prepareStatement("SELECT books.id, books.title, books.writer, rents.id_of_member, rents.member, rents.rent FROM books LEFT JOIN rents ON books.id = rents.id_of_title WHERE rents.rent = 'Rent'")) {
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    String memberId = resultSet.getString("id_of_member");
                    String memberName = resultSet.getString("member");
                    String bookId = resultSet.getString("id");
                    String bookTitle = resultSet.getString("title");
                    String bookWriter = resultSet.getString("writer");
                    String rentStatus = resultSet.getString("rent");

                    if ("rent".equals(rentStatus) && map.containsKey(memberId) && map.containsValue(memberName)) {
                        System.out.println("id: " + bookId + "   title: " + bookTitle + "  writer: " + bookWriter);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}





















