
public class Book extends Library {
    private int bookID;
    private String title, author;
    private boolean availabilityStatus;
    private String description;

    private int i = 100;

    public Book(String name, String author, String subtitle){
        this.title = name;
        this.author = author;
        this.description = subtitle;
        this.availabilityStatus = true;
        this.bookID = ++i;

    }

    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public boolean getAvailabilityStatus(){
        return availabilityStatus;
    }

    public void setAvailabilityStatus(boolean c){
        availabilityStatus = c;
    }

    public String getDescription() {
        return description;
    }


}
