
public class Book {
    private static int i=0;
    private final String bookID;
    private String title;
    private String description;
    private String author;
    private boolean isAvailable;
    public Book ( String title, String description, String author){
        this.author=author;
        this.title=title;
        this.description=description;
        i++;
        this.bookID=String.valueOf(i);
        this.isAvailable=true;
    }
 
    public String getBookID() {
        return bookID;
    }
    public boolean isAvailable() {
        return isAvailable;
    }
    
 
    
}
