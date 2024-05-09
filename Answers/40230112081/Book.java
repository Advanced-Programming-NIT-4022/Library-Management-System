import javax.print.DocFlavor;

public class Book {
    private String id;
    private String title;
    private String author;
    private String description;
    private String status;

    // constructor
    public Book(String id,String title,String author,String description,String status)
    {
        this.id = id;
        this.title = title;
        this.author = author;
        this.description = description;
        this.status  = status;
    }

    // getters
    public String getId() { return this.id; }
    public String getTitle() { return this.title; }
    public String getAuthor() { return this.author; }
    public String getDescription() { return this.description; }
    public String getStatus() { return this.status; }

    // setter
    public void change_status(String new_stat) {
        this.status = new_stat;
    }
}
