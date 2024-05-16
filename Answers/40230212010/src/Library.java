import java.time.LocalDate;
import java.util.*;
import java.lang.*;;

public class Library {
    private User user;
    private String name;
    private int capacity;
    private String operatingHours;
    private Map<String, Book> books;
    private List<User> users;
    private List<Rent> rentals;
    private List<Admin> adminsList;
    private List<NormalUser> normalUsersList;

    public Library(String name, int capacity, String operatingHours) {
        this.name = name;
        this.capacity = capacity;
        this.operatingHours = operatingHours;
        this.books = new HashMap<>();
        this.users = new ArrayList<>();
        this.rentals = new ArrayList<>();
        List<User> normalUsersList = new ArrayList<User>();
        List<Admin> admins = new ArrayList<Admin>();
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

    public void rentBook(String bookName, User user) {

        Book book = this.books.get(bookName);

        if (book == null) {
            System.out.print("book not found: " + bookName);
        }

        if (!book.isAvailable()) {
            System.out.println("Book is currently unavailable: " + bookName);
        }

        String rentalID = UUID.randomUUID().toString().substring(0, 8);

        LocalDate rentalDate = LocalDate.now();
        LocalDate dueDate = rentalDate.plusDays(7);

        Rent newRent = new Rent(rentalID, rentalDate, dueDate, book, user);
        rentals.add(newRent);

        book.setAvailable(false);

        System.out.println("Book rented successfully. Your due date is: " + dueDate);

    }

    public Book findBookByName(String bookName) {
       return books.get(bookName);
    }
    
    public void removeUser(String userID) {
        for (NormalUser user : normalUsersList) {
            if (user.getUniqueID()== userID) {
                normalUsersList.remove(userID);
            }

            for (Admin admin : adminsList) {
                if (user.getUniqueID() == userID) {
                    adminsList.remove(user.getUniqueID());
                }
            }
        }
    }

    

    public void addAdmin(String name, String phoneNumber, String password) {
        Admin newAdmin = new Admin(name, phoneNumber, password);
        adminsList.add(newAdmin);
    }

    public void addNormalUser(String name, String phoneNumber, String registrationDate) {
        NormalUser newNormalUser = new NormalUser(name, phoneNumber, registrationDate);
        normalUsersList.add(newNormalUser);
    }

    public NormalUser getNormalUser(String UniqueID) {
        for (NormalUser user : normalUsersList) {
            if (user.getUniqueID().equals(UniqueID) ) {
                return user;
            }
        }
        return null;
    }

    public Admin getAdmin(String password) {
        for (Admin admin : adminsList) {
            if (admin.getPassword().equals(password)) {
                return admin;
            }
        }
        return null;
    }


    public void returnBook (User user, Book book) {
        if (book.isAvailable()) {
            Rent rent = new Rent(name, null, null, book, null);
            rentals.add(rent);
            book.setAvailable(false);
            System.out.println("book returned successfully!");
        }
        else{
            System.out.println("not available!");
        }

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
