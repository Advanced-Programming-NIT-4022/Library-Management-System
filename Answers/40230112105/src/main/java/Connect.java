import java.sql.*;

public class Connect {
    static ResultSet getConnect(String Query) {
        ResultSet rs = null;
        try{
            Connection myConn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/library", "postgres", "Nima2325!");
            Statement myStmt = myConn.createStatement();
            rs = myStmt.executeQuery(Query);
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        return rs;
    }
}

