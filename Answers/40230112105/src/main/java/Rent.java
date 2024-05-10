import java.sql.ResultSet;
import java.sql.SQLException;

public class Rent {
    public void rentBook(String id, String userId) {
        ResultSet rs = Connect.getConnectExecute("SELECT availability FROM book WHERE bookid = '" +id+ "'");
        try {
            if (rs.next() || rs.getString("availability").equals("true")) {
                ResultSet rs2 = Connect.getConnectExecute("SELECT id FROM student WHERE id = '" +userId+ "'");
                if(rs2.next()){
                    Connect.getConnect("INSERT INTO rent (bookid, id) VALUES ('" +id+ "','" + userId+ "')");
                    System.out.println("Done!Here It's your book");
                } else {
                    System.out.println("There is no account with this ID");
                }
            } else {
                System.out.println("The book isn't available or doesn't exist!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
