import java.sql.ResultSet;
import java.util.Scanner;
import java.util.regex.*;
import java.sql.*;

public class Book {
    private String title;
    private String author;
    private String subtitle;

    public void setTitle(String title) {
        this.title = title;
    }

    public void sesAuthor(String author) {
        boolean flag = true;
        while(flag){
            if(Pattern.matches("^[a-zA-Z\\s]+$", author)) {
                this.author = author.trim();
                flag = false;
            } else {
                System.out.print("You entered invalid name.Try again: ");
                Scanner strScanner = new Scanner(System.in);
                author = strScanner.nextLine();
            }
        }
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public String getSubtitle() {
        return subtitle;
    }
    public void availableBooks() {
        ResultSet rs =Connect.getConnectExecute("SELECT * FROM book WHERE availability = 'true'");
        int i = 1;
        try {
            while(rs.next()) {
                System.out.println(i + ". " + rs.getString("title") + "  (id: " + rs.getString("bookid") + ")");
                i++;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addBook(String title, String author, String subtitle) {
        try {
            Connect.getConnect("INSERT INTO book (title, author, availability, description)" +
                    "VALUES ('"+ title +"','"+ author + "','true','"+ subtitle +"')");
            System.out.println("The book was successfully added");
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }

}
