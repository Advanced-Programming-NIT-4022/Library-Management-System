import java.io.Serializable;
public class Book implements Serializable {
    int bookId;
    boolean isAvailable;
    String bookAuthor;
    String bookName;
    String description;
    public Book(String bookName,String bookAuthor,int bookId,boolean isAvailable,String description){
        this.isAvailable = isAvailable;
        this.bookAuthor = bookAuthor;
        this.bookId = bookId;
        this.bookName = bookName;
        this.description =description;

    }
}
