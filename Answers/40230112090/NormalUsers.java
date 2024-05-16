package org.example;

import java.sql.*;
import java.time.LocalDate;
import java.util.*;

public class NormalUsers extends Book {
    public String id;
    public String phoneNumber;
    public LocalDate localDate;
    public HashMap<String, String> map = new HashMap<>();
    public Scanner input = new Scanner(System.in);


    public NormalUsers() {
        this.localDate = LocalDate.now();
         Random random = new Random();
        this.id = String.format("%04d", random.nextInt(10000));
    }

    public String getPassword(String name, String password, String idInMysql, String updateIdInMysql) {
        String userName1;
        String password1;
        int numberOfRounds = 0;
        Scanner input = new Scanner(System.in);

        while (true) {
            if (numberOfRounds > 0) {
                System.out.println("Please enter the correct password: \n(Enter the number 1 to enter the forgotten password section and enter 2 to exit)");
                String numberForForget = input.nextLine();
                if ("2".equals(numberForForget)) {
                    return "exit";
                } else if ("1".equals(numberForForget)) {
                    forgetPassword(updateIdInMysql); // Call to a method that handles password recovery
                    return "Please log in to the user section again";
                }
            }

            userName1 = title(name.trim());
            password1 = password.trim();

            if (password1.length() > 3 && password1.matches("\\d{4,9}")) {
                if (userApproval(userName1, password1, idInMysql)) {
                    return "success";
                } else {
                    System.out.println("Incorrect username or password.");
                }
            } else {
                System.out.println("Password must be longer than 3 digits and contain only numbers.");
            }
            numberOfRounds++;
        }

    }

    private boolean userApproval(String userName, String password, String idInMysql) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/Library", "javalibrary", "1384");
             PreparedStatement statement = connection.prepareStatement(idInMysql)) {
            statement.setString(1, userName);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String idOfMember = resultSet.getString("id");
                map.put(idOfMember, userName);
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public void forgetPassword(String updateIdInMysql) {
        System.out.print("Please enter your username: ");
        String username = input.nextLine().trim();
        String username1 = title(username);
        int numberOfRounds = 0;
        while (true) {
            if (numberOfRounds > 0) {
                System.out.println("Please enter the correct mobile number:");
            } else {
                System.out.print("Please enter your phone number: ");
            }

            String phoneNumber = "+98" + input.nextLine().trim();
            String newPassword = "";
            if (phoneNumber.matches("\\+98\\d{10}")) {

                int numberOfRounds2 = 0;
                while (true) {
                    if (numberOfRounds2 > 0) {
                        System.out.println("Please enter the correct password:");
                    }
                    System.out.print("New Password: ");
                    newPassword = input.nextLine().trim();

                    if (newPassword.matches("\\d{4,9}")) {
                    } else {
                        System.out.println("Invalid password. Password must be at least 4 digits long and contain only numbers.");
                    }
                    numberOfRounds++;

                    if (newPassword != null) {
                        updatePasswordInDatabase(username1, phoneNumber, newPassword, updateIdInMysql);
                        break;
                    }
                }
            } else {
                System.out.println("Invalid phone number. Please try again.");
            }
            numberOfRounds++;
            if (!newPassword.isEmpty()) {
                break;
            }
        }
    }

    private void updatePasswordInDatabase(String username, String phoneNumber, String newPassword, String updateIdInMysql) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/Library", "javalibrary", "1384");
             PreparedStatement statement = connection.prepareStatement(updateIdInMysql)) {
            statement.setString(1, newPassword);
            statement.setString(2, username);
            statement.setString(3, phoneNumber);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Password changed successfully.");
            } else {
                System.out.println("No user found with the provided username and phone number.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}











