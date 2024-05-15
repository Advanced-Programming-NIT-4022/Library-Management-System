public class Book {
    private static int i=0;
    private final int bookID;
    private String title;
    private String description;
    private String author;
    private boolean isAvailable;
    public Book ( String title, String description, String author){
        this.author=author;
        this.title=title;
        this.description=description;
        this.bookID=++i;
        this.isAvailable=true;
    }
}
