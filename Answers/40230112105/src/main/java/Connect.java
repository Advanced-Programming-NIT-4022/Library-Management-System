import java.sql.*;

public class Connect {
    static void getConnect(String Query) {
        int rs;
        try{
            Connection myConn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/library", "postgres", "Nima2325!");
            Statement myStmt = myConn.createStatement();
            rs = myStmt.executeUpdate(Query);
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }

    static ResultSet getConnectExecute(String Query) {
        ResultSet rs = null;
        try {
            Connection myConn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/library", "postgres", "Nima2325!");
            Statement myStmt = myConn.createStatement();
            rs = myStmt.executeQuery(Query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
}

