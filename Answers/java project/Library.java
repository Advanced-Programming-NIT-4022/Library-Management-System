import java.util.ArrayList;
import java.util.List;

public class Library {
    private String name;
    private int capacity;
    private String operatingHours;
    private List<Book> books;
    private List<User> users;
    private List<Rent> rentals;

    public Library(String name, int capacity, String operatingHours) {
        this.name = name;
        this.capacity = capacity;
        this.operatingHours = operatingHours;
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
        this.rentals = new ArrayList<>();
    }

    // Method to add a book
    public void addBook(String title, String author, String description) {
        books.add(new Book(title, author, description));
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(int userID) {
        users.removeIf(user -> user.getUserID() == userID);
    }

    public void rentBook(int bookID, int userID) {
        Book book = books.stream().filter(b -> b.getBookID() == bookID && b.isAvailable()).findFirst().orElse(null);
        if (book != null) {
            User user = users.stream().filter(u -> u.getUserID() == userID && u instanceof NormalUser).findFirst().orElse(null);
            if (user != null) {
                book.setAvailable(false);
                rentals.add(new Rent(book, (NormalUser) user));
            }
        }
    }


    public void returnBook(int bookID) {
        Rent rent = rentals.stream().filter(r -> r.getBook().getBookID() == bookID).findFirst().orElse(null);
        if (rent != null) {
            rent.getBook().setAvailable(true);
            rentals.remove(rent);
        }
    }

    public List<Book> getAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.isAvailable()) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }
    public String getOperatingHours() {
        return operatingHours;
    }
}