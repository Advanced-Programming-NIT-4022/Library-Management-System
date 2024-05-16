
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
    public boolean setAvailable(boolean isAvailable) {
        return isAvailable;
    }

    public static int getI() {
        return i;
    }

    public static void setI(int i) {
        Book.i = i;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    
    
 
    
}
