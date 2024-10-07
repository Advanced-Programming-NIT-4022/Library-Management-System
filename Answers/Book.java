import java.util.HashMap;

public class Book {
    int bookid=1;
    String bookname;
    String author;
    String description;
    boolean dastresi=false;
    HashMap<String,String> writerdooni=new HashMap<>();
    HashMap<String,String> subdooni=new HashMap<>();
    public void bmaker(String bookname, String author, String description) {
        this.bookname = bookname;
        this.author = author;
        this.description = description;
        bookid++;
        this.dastresi=true;
    }
}