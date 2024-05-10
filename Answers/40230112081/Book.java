

public class Book {
    private String id;
    private String title;
    private String author;
    private String description;
    private String status;
    private int existence;

    // constructor
    public Book(String id,String title,String author,String description,String status,int existence)
    {
        this.id = id;
        this.title = title;
        this.author = author;
        this.description = description;
        this.status  = status;
        this.existence = existence;
    }

    // getters
    public String getId() { return this.id; }
    public String getTitle() { return this.title; }
    public String getAuthor() { return this.author; }
    public String getDescription() { return this.description; }
    public String getStatus() { return this.status; }
    public int getExistence() { return this.existence; }

    // setter
    public void change_status(String new_stat) {
        this.status = new_stat;
    }

    public void inc_existence(){
        this.existence++;
    }
}
