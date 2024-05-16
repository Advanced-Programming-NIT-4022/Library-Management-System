package basic.classes;

import java.sql.*;
import java.util.ArrayList;

public class DataBaseMethods {

    public static void bookDataInsert(ArrayList<Book> bookRepo) {
        final String url = "jdbc:sqlite:/home/amirhosseinzg/lib.db";
        String sql = "INSERT INTO book_repository (title, author, description, book_id, availability_status) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            for (Book book : bookRepo) {
                // Set values for the prepared statement
                pstmt.setString(1, book.title);
                pstmt.setString(2, book.author);
                pstmt.setString(3, book.description);
                pstmt.setString(4, book.book_id);
                pstmt.setInt(5, book.availability_status ? 1 : 0); // 1 represents true , and 0 represents false

                // Execute the insert statement
                pstmt.executeUpdate();
            }

            System.out.println("Data inserted successfully!");

        } catch (SQLException ignored) {
        }
    }

    public static void bookDataRetrieve(ArrayList<Book> bookRepo) {
        final String url = "jdbc:sqlite:/home/amirhosseinzg/lib.db";
        String sql = "SELECT title, author, description, book_id, availability_status FROM book_repository";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                String title = rs.getString("title");
                String author = rs.getString("author");
                String description = rs.getString("description");
                String book_id = rs.getString("book_id");
                int availabilityStatus = rs.getInt("availability_status");

                // Convert availability status to boolean
                boolean isAvailable = (availabilityStatus == 1);

                bookRepo.add(new Book(title, author, description, book_id, isAvailable));
            }

        } catch (SQLException ignored) {
        }
    }

    public static void rentedBookDataInsert(ArrayList<Rent> rented_book_repo) {
        final String url = "jdbc:sqlite:/home/amirhosseinzg/lib.db";
        String sql = "INSERT INTO rented_book_repo (reserved_book_id, reserver_user_id, rental_id, rental_date) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            for (Rent iterator : rented_book_repo) {
                // Set values for the prepared statement
                pstmt.setString(1, iterator.reserved_book_id);
                pstmt.setString(2, iterator.reserver_user_id);
                pstmt.setString(3, iterator.rental_id);
                pstmt.setString(4, iterator.rental_date);

                // Execute the insert statement
                pstmt.executeUpdate();
            }

            System.out.println("Data inserted successfully!");

        } catch (SQLException ignored) {
        }
    }

    public static void rentedBookDataRetrieve(ArrayList<Rent> rented_book_repo) {
        final String url = "jdbc:sqlite:/home/amirhosseinzg/lib.db";
        String sql = "SELECT reserved_book_id, reserver_user_id, rental_id, rental_date FROM rented_book_repo";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                String reserved_book_id = rs.getString("reserved_book_id");
                String reserver_user_id = rs.getString("reserver_user_id");
                String rental_id = rs.getString("rental_id");
                String rental_date = rs.getString("rental_date");

                Rent rent = new Rent(reserved_book_id, reserver_user_id, rental_id);
                rent.rental_date = rental_date;

                rented_book_repo.add(rent);
            }

        } catch (SQLException ignored) {
        }
    }

    public static void adminDataInsert(ArrayList<Admin> admins) {
        final String url = "jdbc:sqlite:/home/amirhosseinzg/lib.db";
        String sql = "INSERT INTO admins (name, id, phone_number, password) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            for (Admin iterator : admins) {
                // Set values for the prepared statement
                pstmt.setString(1, iterator.name);
                pstmt.setString(2, iterator.id);
                pstmt.setString(3, iterator.phone_number);
                pstmt.setString(4, iterator.getPassword());

                // Execute the insert statement
                pstmt.executeUpdate();
            }

            System.out.println("Data inserted successfully!");

        } catch (SQLException ignored) {
        }

    }

    public static void adminDataRetrieve(ArrayList<Admin> admins) {
        final String url = "jdbc:sqlite:/home/amirhosseinzg/lib.db";
        String sql = "SELECT name, id, phone_number, password FROM admins";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                String name = rs.getString("name");
                String id = rs.getString("id");
                String phone_number = rs.getString("phone_number");
                String password = rs.getString("password");

                Admin admin = new Admin(name, id, phone_number, password);
                admins.add(admin);
            }

        } catch (SQLException ignored) {
        }
    }

    public static void normalUserDataInsert(ArrayList<NormalUser> normalUsers) {
        final String url = "jdbc:sqlite:/home/amirhosseinzg/lib.db";
        String sql = "INSERT INTO normalusers (name, id, phone_number, registration_date) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            for (NormalUser iterator : normalUsers) {
                // Set values for the prepared statement
                pstmt.setString(1, iterator.name);
                pstmt.setString(2, iterator.id);
                pstmt.setString(3, iterator.phone_number);
                pstmt.setString(4, iterator.registration_date);

                // Execute the insert statement
                pstmt.executeUpdate();
            }

            System.out.println("Data inserted successfully!");

        } catch (SQLException ignored) {
        }

    }

    public static void normalUserDataRetrieve(ArrayList<NormalUser> normalUsers) {
        final String url = "jdbc:sqlite:/home/amirhosseinzg/lib.db";
        String sql = "SELECT name, id, phone_number, registration_date FROM normalusers";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                String name = rs.getString("name");
                String id = rs.getString("id");
                String phone_number = rs.getString("phone_number");
                String registration_date = rs.getString("registration_date");

                NormalUser normalUser = new NormalUser(name, id, phone_number);
                normalUser.registration_date = registration_date;
                normalUsers.add(normalUser);
            }

        } catch (SQLException ignored) {
        }
    }

}
