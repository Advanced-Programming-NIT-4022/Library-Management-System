// this class simulates books in the library
import java.util.UUID; // to generate the unique ID for books

public class Book {
    private String title;
    private String author;
    private String description;
    // unique id is based on the title and auther of the book
    private String uniqueBookID;
    public boolean availabilityStatus = true;

    // two arguments constructor
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.uniqueBookID = UUID.nameUUIDFromBytes(
                String.format(title + author).getBytes()).toString();
    }

    // three arguments constructor
    public Book(String title, String author, String description) {
        this.title = title;
        this.author = author;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;

        // the unique id should change
        uniqueBookID = UUID.nameUUIDFromBytes(
                String.format(title + author).getBytes()).toString();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUniqueBookID() {
        return uniqueBookID;
    }
}