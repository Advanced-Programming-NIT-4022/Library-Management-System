import java.util.ArrayList;

public class Book {
    static ArrayList<Book> booksArray = new ArrayList<>();
    String title,author,subtitle;
    int uniquebookID;
    boolean availabilityStatus;
    public Book(String C_title,String C_author,boolean C_availabilityStatus,String C_subtitle){
        title=C_title;
        author=C_author;
        availabilityStatus=C_availabilityStatus;
        subtitle=C_subtitle;
    }
}
