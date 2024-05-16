package org.example;
import java.util.*;
import java.util.stream.Collectors;

public class Library {
    // Attributes
    private String libraryName;
    private int capacity;
    private String operatingHours;
    // String = bookId
    private Map<String, Book> booksMap;
    private List<User> users;
    private List<Rent> rentals;

    //***** Constructor *****//
    Library(String libraryName, int capacity, String operatingHours) {
        this.libraryName = libraryName;
        this.capacity = capacity;
        this.operatingHours = operatingHours;
        this.booksMap = new HashMap<>();
        this.users = new ArrayList<>();
        this.rentals = new ArrayList<>();
    }

    //***** Getters & Setters *****//
    public String getLibraryName() {
        return libraryName;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
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

    public Map<String, Book> getBooksMap() {
        return booksMap;
    }

    public void setBooksMap(Map<String, Book> booksMap) {
        this.booksMap = booksMap;
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

    //***** Methods *****//
    public void addBook(Book book) {
        // Ensure book ID is unique
        String bookId = Book.generateUniqueId();
        book.setBookID(bookId);
        booksMap.put(bookId, book);
        // Check library capacity
        if (users.size() >= capacity) {
            System.out.println("Library is full.");
            return;
        }
        booksMap.put(bookId, book);
    }

    // To find book.
    public Book findBookById(String id) {
        boolean result = false;
        for (int i = 0; i < this.booksMap.size(); i++) {
            if (this.booksMap.get(i).equals(id)) {
                result = true;
            }
        }
        if (!result) {
            System.out.println("This book is not avalibale!");
        }
        return booksMap.get(id);
    }

    // To add a user by admin.
    public void addUser(User user) {
        // Check if the user is an admin trying to add another admin
        if (user instanceof Admins && users.stream().anyMatch(u -> u instanceof Admins)) {
            System.out.println("Only one admin can exist.");
            return;
        }
        users.add(user);
    }

    // To find user.
    public User findUserById(String id) {
        return users.stream().filter(u -> u.getUniqueID().equals(id)).findFirst().orElse(null);
    }

    // To show all book.
    public List<Book> getAvailableBooks() {
        return booksMap.values().stream().filter(Book::isAvailability).collect(Collectors.toList());
    }

    public void returnBook(String bookId) {
        Book book = booksMap.get(bookId);
        if (book != null) {
            Optional<Rent> optionalRental = rentals.stream()
                    .filter(r -> r.getBook().equals(book))
                    .findFirst();
            if (optionalRental.isPresent()) {
                Rent rental = optionalRental.get();
                rental.setReturned(true);
                book.setAvailability(true);
            }
        }
    }

    private String generateUniqueId() {
        return UUID.randomUUID().toString();
    }

    public User findUserByNameOrId(String nameOrId) {
        return users.stream()
                .filter(u -> u.getUniqueID().equals(nameOrId) || u.getUserName().equalsIgnoreCase(nameOrId))
                .findFirst()
                .orElse(null);
    }

    public void rentBook(String bookId, User user) {
        Book book = booksMap.get(bookId);
        if (book != null && book.isAvailability()) {
            // Assuming there's a way to mark a book as unavailable
            book.setAvailability(false);
            // Create a new rental record
            rentals.add(new Rent(book, (NormalUsers) user, new Date()));
            System.out.println("Book rented successfully.");
        } else {
            System.out.println("The book is not available or not found.");
        }
    }
}
