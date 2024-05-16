import java.time.LocalDate;
import java.util.*;

public class Library {
    private String name;
    private int capacity;
    private String operatingHours;
    private Map<String, Book> books;
    private List<User> users;
    private List<Rent> rentals;

    public Library(String name, int capacity, String operatingHours) {
        this.name = name;
        this.capacity = capacity;
        this.operatingHours = operatingHours;
        this.books = new HashMap<>();
        this.users = new ArrayList<>();
        this.rentals = new ArrayList<>();
    }

    public void addBook(String title, String description, String author) {

        if (this.books.containsValue(new Book(title, description, author))) {
            System.out.println("This book already exists in the library.");
            return;
        }

        Book book = new Book(title, description, author);
        this.books.put(book.getBookID(), book);
        System.out.println("Book added successfully.");
    }

    public void removebook(String bookID) {
        this.books.remove(bookID);
    }

    public Book getBooks(String bookID) {

        return books.get(bookID);
    }

    public ArrayList<Book> getAvailableBooks() {
        ArrayList<Book> Availablebooks = new ArrayList<>();
        for (Book book : books.values()) {
            if (book.isAvailable()) {
                Availablebooks.add(book);
            }
        }
        return Availablebooks;
    }

    public void rentBook(String bookName, NormalUser user) {

        Book book = this.books.get(bookName);

        // Check if book exists
        if (book == null) {
            System.out.print("book not found: " + bookName);
        }

        // Check if book is available
        if (!book.isAvailable()) {
            System.out.println("Book is currently unavailable: " + bookName);
        }

        // Generate a unique rental ID (consider using UUID for guaranteed uniqueness)
        String rentalID = UUID.randomUUID().toString().substring(0, 8);

        // Set due date to 7 days from rental date
        LocalDate rentalDate = LocalDate.now();
        LocalDate dueDate = rentalDate.plusDays(7);

        // Create and add a new Rent object
        Rent newRent = new Rent(rentalID, rentalDate, dueDate, book, user);
        rentals.add(newRent);

        // Mark book as unavailable
        book.setAvailable(false);

        System.out.println("Book rented successfully. Your due date is: " + dueDate);

        // Update book availability counts (consider using an AtomicInteger for thread
        // safety if needed)
        // atomicIntegerBooksRented.getAndIncrement();

        // Handle other potential exceptions as needed (e.g., BookNotAvailableException,
        // DuplicateRentalException)

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getOperatingHours() {
        return operatingHours;
    }

    public void setOperatingHours(String operatingHours) {
        this.operatingHours = operatingHours;
    }

    public Map<String, Book> getBooks() {
        return books;
    }

    public void setBooks(Map<String, Book> books) {
        this.books = books;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Rent> getRentals() {
        return rentals;
    }

    public void setRentals(List<Rent> rentals) {
        this.rentals = rentals;
    }

}
