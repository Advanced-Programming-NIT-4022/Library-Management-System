
import java.io.FileWriter;
public class Book extends Library {
    int bookID;
    String title, author;
    boolean availabilityStatus;
    String description;

    private int i = 100;

    public Book(String name, String author, String subtitle){
        this.title = name;
        this.author = author;
        this.description = subtitle;
        this.availabilityStatus = true;
        this.bookID = ++i;

    }

    private int c = 0;


    public String[] add(String book[]) {
        book[c] = bookID + "," + title + "," + author + "," + description+ "," + availabilityStatus;
        c++;
        return book;
    }

    public void rent(String book[], String bookName) {
        char[] h = new char[50];
        for (int k = 0; k < book.length; k++){
            if(book[k] != ","){

            }
        }
    }
}
