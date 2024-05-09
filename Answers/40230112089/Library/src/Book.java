public class Book  {
    int bookId;
    boolean isAvailable;
    String bookAuthor;
    String bookName;
    public Book(String bookName,String bookAuthor,int bookId,boolean isAvailable){
        this.isAvailable = isAvailable;
        this.bookAuthor = bookAuthor;
        this.bookId = bookId;
        this.bookName = bookName;

    }
}
