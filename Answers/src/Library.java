import java.util.ArrayList;

public class Library {
    private String name;
    private long capacity;
    private String operatingHours;
    private ArrayList<Book> bookRepository;
    private ArrayList<User> libraryUsers;
    Library(String name, long capacity, String operatingHours, ArrayList<Book> bookRepository
            , ArrayList<User> libraryUsers) {
        this.name = name;
        this.capacity = capacity;
        this.operatingHours = operatingHours;
        this.bookRepository = bookRepository;
        this.libraryUsers = libraryUsers;
    }

    public ArrayList<Book> getBookRepository() {
        return bookRepository;
    }

    public ArrayList<User> getLibraryUsers() {
        return libraryUsers;
    }
}
