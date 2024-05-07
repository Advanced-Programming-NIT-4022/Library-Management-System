import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Library {
    private String libraryName;
    private int capacity;
    private int nextBookId;
    private int nextRentId;
    private int nextUserId;
    private List<Book> books;
    private List<User> users;
    private List<Rent> rents;

    public Library(int capacity, String libraryName) {
        this.libraryName = libraryName;
        this.capacity = capacity;
        this.nextBookId = 1;
        this.nextRentId = 1;
        this.nextUserId = 1;
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
        this.rents = new ArrayList<>();
    }

    public void addBook(String title, String author, String description) {
        Book newBook = new Book(title, author, description, nextBookId);
        books.add(newBook);
        nextBookId++;
    }

    public void addUser(String name, String phoneNumber) {
        if (isValidPhoneNumber(phoneNumber)) {
            if (!isPhoneNumberTaken(phoneNumber)) {
                User newUser = new NormalUser(name, phoneNumber, nextUserId, new Date());
                users.add(newUser);
                nextUserId++;
                System.out.println("Member Successfully Created.");
            } else {
                System.out.println("This phone number is already in use.");
            }
        } else {
            System.out.println("Invalid phone number format.");
        }
    }


    private boolean isPhoneNumberTaken(String phoneNumber) {
        for (User user : users) {
            if (user.getPhoneNumber().equalsIgnoreCase(phoneNumber)) {
                return true;
            }
        }
        return false;
    }

    public void addAdmin(String name, String phoneNumber, String password) {
        if (isValidPhoneNumber(phoneNumber)) {
            if (!isPhoneNumberTaken(phoneNumber)) {
                Admin newAdmin = new Admin(name, phoneNumber, password, nextUserId);
                users.add(newAdmin);
                nextUserId++;
                System.out.println("Admin Successfully Created.");
            } else {
                System.out.println("This phone number is already in use.");
            }
        } else {
            System.out.println("Invalid phone number format.");
        }
    }

    public void rentBook(String bookName, String userName) {
        Book bookToRent = findAvailableBook(bookName);
        if (bookToRent == null) {
            System.out.println("Book not available for rent.");
            return;
        }

        User user = findUserByName(userName);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        bookToRent.setAvailable(false);
        rents.add(new Rent(bookToRent, user, nextRentId++, new Date()));
        System.out.println(user.getName() + " has rented: " + bookToRent.getTitle());
    }

    private Book findAvailableBook(String bookName) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(bookName) && book.isAvailable()) {
                return book;
            }
        }
        return null;
    }

    private User findUserByName(String userName) {
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(userName)) {
                return user;
            }
        }
        return null;
    }

    public void returnBook(String bookName) {
        Rent rentToRemove = null;
        for (Rent rent : rents) {
            if (rent.getBookObject().getTitle().equalsIgnoreCase(bookName)) {
                rent.getBookObject().setAvailable(true);
                System.out.println(rent.getUserObject().getName() + " has returned: " + rent.getBookObject().getTitle());
                rentToRemove = rent;
                break;
            }
        }
        if (rentToRemove != null) {
            rents.remove(rentToRemove);
        } else {
            System.out.println("Book not rented or already returned.");
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

    public void removeUser(String phoneNumber) {
        for (User user : users) {
            if (user.getPhoneNumber().equalsIgnoreCase(phoneNumber)) {
                users.remove(user);
                System.out.println("User successfully removed.");
                return;
            }
        }
        System.out.println("User not found.");
    }

    public boolean isValidPhoneNumber(String PhoneNumber){
        return PhoneNumber.matches("^<[0-9]{11}>$");
    }
}

