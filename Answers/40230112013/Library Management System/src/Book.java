import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Book {
    private String bookID;
    private String title;
    private String author;
    private boolean isAvailable;
    private String description;

    public Book(String title, String author, String description) {
        this.bookID = UUID.randomUUID().toString();
        this.title = title;
        this.author = author;
        this.description = description;
        this.isAvailable = true;
    }

    public String getBookID() {
        return bookID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String toString1() {
        return "Book{" +
                "bookID='" + bookID + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isAvailable=" + isAvailable +
                ", description='" + description + '\'' +
                '}';
    }
    public static Book bookfinder(String n, String p ) {
        
        List<Book> me = Library.getrepo();
        for (Book u : me) {
            if (u.getTitle().equals(n) && u.getAuthor().equals(p)) {
                System.out.println("book found");
                return u;
            }
        }
        System.out.println("book not found");
        return null;
    }
}
