import java.util.*;

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
    public static List<Book> bookfinder(String t) {
        
        List<Book> me = Library.getrepo();
        List<Book> b = new ArrayList<Book>();
        int i=1;
        for (Book u : me) {
            if(u.toString1().contains(t)){
                System.out.println(i +"_" + u.toString1());
                b.add(u);
                i++;
            }
        }
        return b;
    }
}
