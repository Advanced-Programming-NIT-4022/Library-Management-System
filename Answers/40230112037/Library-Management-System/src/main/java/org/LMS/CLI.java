package org.LMS;

import java.sql.SQLException;
import java.util.Scanner;

public class CLI {
    private final Scanner scanner = new Scanner(System.in);
    boolean loggedIn = false;
    private Library library;

    CLI() {
        try {
            library = Library.getInstance("My org.LMS.Library", "localhost", "LMS", "LMS_password");
            System.out.println("Welcome to Library!");
            while (true) {
                if (!login()) break;
            }
        } catch (Exception e) {
            System.out.println("Couldn't connect to database!");
        }
    }

    private boolean login() {
        library.currentUser = null;
        User user = null;
        System.out.print("Username: ");
        String username = scanner.nextLine();
        if (username.isBlank()) return false;
        try {
            user = library.getUser(username);
        } catch (SQLException ignored) {

        }
        if (user instanceof NormalUser) {
            loginAsNormalUser((NormalUser) user);
        } else if (user instanceof AdminUser admin) {
            System.out.print("Password: ");
            if (admin.password.verifyPassword(scanner.nextLine())) {
                loginAsAdminUser(admin);
            } else {
                System.out.println("Wrong password!");
            }
        } else {
            System.out.println("User not found!");
        }
        return true;
    }

    void loginAsNormalUser(NormalUser user) {
        library.currentUser = user;
    }

    void loginAsAdminUser(AdminUser admin) {
        library.currentUser = admin;
    }
}
