import java.util.*;
public class Libraray {
    private String name;
    private int capacity;
    private String operatingHours;
    private Map<String ,Book> books;
    private List<User> users;
    private List<Rent> rentals;

    public Libraray(String name, int capacity, String operatingHours) {
        this.name = name;
        this.capacity = capacity;
        this.operatingHours = operatingHours;
        this.books = new HashMap<>();
        this.users = new ArrayList<>();
        this.rentals = new ArrayList<>();
    }
    public void addBook( String title, String description, String author) {
        Book book = new Book(title, description, author);
        books.put(book.getBookID(), book);
    }
    public void removebook(String bookID){
        books.remove(bookID);
    }
    public Book getBooks(String bookID) {
        return books.get(bookID);
    }
    public ArrayList<Book> getAvailableBooks(){
        ArrayList<Book> Availablebooks = new ArrayList<>();
        for(Book book: books.values()){
            if (book.isAvailable()) {
                Availablebooks.add(book);
            }
        }
        return Availablebooks;
    }


}
