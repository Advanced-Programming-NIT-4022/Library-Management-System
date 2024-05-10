import java.sql.ResultSet;
import java.sql.SQLException;

public class Rent {
    public void rentBook(String id, String userId) {
        ResultSet rs = Connect.getConnectExecute("SELECT availability FROM book WHERE bookid = '" +id+ "'");
        try {
            if (rs.next()) {
                if(rs.getBoolean("availability")){
                    ResultSet rs2 = Connect.getConnectExecute("SELECT id FROM student WHERE id = '" +userId+ "'");
                    if(rs2.next()){
                        Connect.getConnect("INSERT INTO rent (bookid, id) VALUES ('" +id+ "','" + userId+ "')");
                        Connect.getConnect("UPDATE book SET availability = 'false' WHERE bookid = '" +id+ "'");
                        System.out.println("Done!Here It's your book");
                    } else {
                        System.out.println("There is no account with this ID");
                    }
                } else {
                    System.out.println("The book isn't available");
                }
            } else {
                System.out.println("The book doesn't exist!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void returnBook(String id) {
        ResultSet rs = Connect.getConnectExecute("SELECT availability FROM book WHERE bookid = '" +id+ "'");
        try {
            if(rs.next()){

                if(!rs.getBoolean("availability")) {
                    Connect.getConnect("UPDATE book SET availability = 'true' WHERE bookid = '" +id+ "'");
                    Connect.getConnect("DELETE FROM rent WHERE bookid = '" +id+ "'");
                    System.out.println("Your book was returned!");
                } else {
                    System.out.println("The book already available!");
                }
            } else {
                System.out.println("The book doesn't exist!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
