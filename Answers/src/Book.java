public class Book {
    private String title;
    private String author;
    private String description;
    private String uniqueBookID; // unique id automatically generate in database
    public boolean availabilityStatus = true;

    // two arguments constructor
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
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
    
    public String getAuthor() {
        return author;
    }
    
    public String getDescription() {
        return description;
    }
    
    public String getUniqueBookID() {
        return uniqueBookID;
    }
}