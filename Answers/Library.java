package com.library;

import com.library.Book;
import com.library.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {

    private List<Book> books;
    private List<User> users;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully.");
    }

    public String getLibraryHours() {
        return "[Enter library operating hours here]";
    }
    private Book findBookByTitle(String bookTitle) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(bookTitle)) {
                return book;
            }
        }
        return null;
    }
    public void displayAvailableBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in catalogue.");
            return;
        }

        System.out.println("Available Books:");
        for (Book book : books) {
            if (!book.isBorrowed()) {
                System.out.println(book);
            }
        }
    }
    public void rentBook(Scanner scanner, String bookName) {
        User borrower = findCurrentUser(scanner);
        if (borrower == null) {
            System.out.println("Please log in to rent a book.");
            return;
        }

        Book book = findBookByTitle(bookName);
        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        if (book.isBorrowed()) {
            System.out.println("Book is already borrowed.");
            return;
        }
        if (!borrower.canBorrowMoreBooks()) {
            System.out.println("Borrow limit reached for you.");
            return;
        }

        try {
            book.borrow();
            borrower.borrowBook(book);
            System.out.println("Book rented successfully for " + borrower.getName() + ".");
        } catch (IllegalStateException e) {
            System.out.println("Error renting book: " + e.getMessage());
        }
    }
    public void rentBook(String memberName, int memberID, String bookName) {
        System.out.println("Renting book for specific member is not implemented yet.");
    }
    public void returnBook(Scanner scanner, String bookName) {
        User borrower = findCurrentUser(scanner);
        if (borrower == null) {
            System.out.println("Please log in to return a book.");
            return;
        }

        Book book = findBookByTitle(bookName);
        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        if (!book.isBorrowed()) {
            System.out.println("Book is already available.");
            return;
        }

        book.returnBook();
        borrower.borrowBook(book);
        System.out.println("Book returned successfully.");
    }
    public void addUser(User user) {
        System.out.println("Adding users is not implemented yet.");
    }
    public void removeUser(int memberID) {
        System.out.println("Removing users is not implemented yet.");
    }
    private User findUser(String memberName, int memberID) {
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(memberName) || user.getStudentID() == memberID) {
                return user;
            }
        }
        return null;
    }
    private User findCurrentUser(Scanner scanner) {
        System.out.println("Please enter your name to borrow a book: ");
        String name = scanner.nextLine();
        return new User(0, "NA", name); 
    }

    public List<Rent> getRentals() {
        // Return a copy of the rentals list to avoid modifying the original data
        int rentals = 0;
        return new ArrayList<>(rentals);
    }
}


