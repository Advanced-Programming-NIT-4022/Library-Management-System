package org.example;

import java.sql.*;

public class Database {
    static final String DB_URL = "jjdbc:mysql://localhost:3306/LMS";
    static final String USER = "root";
    static final String PASS = "lms613";
    public void db(String table, int command) {
        try {
            Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + table);

            switch(table) {
                case "books":
                    switch(command) {
                        case 1: //update info
                            rs.moveToInsertRow();
                            rs.updateString("title","John");
                            rs.updateString("last","Paul");
                            rs.updateInt("age",40);
                        case 2:
                    }
            }

        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }
}

