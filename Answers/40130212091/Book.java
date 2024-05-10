
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
}
