package com.Library;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
public class Library {
    private static final String BOOKS_FILE = "data/books.xml";
    private static final String USERS_FILE = "data/users.xml";
    private static final String RENTALS_FILE = "data/rentals.xml";

    private String name;
    private int vacancy;
    private String businessHours;

    private List<Book> booksList;
    private List<User> userList;
    private List<Rent> rentalList;

    public Library(String name, int vacancy, String businessHours) {
        this.name = name;
        this.vacancy = vacancy;
        this.businessHours = businessHours;
        this.booksList = new ArrayList<>();
        this.userList = new ArrayList<>();
        this.rentalList = new ArrayList<>();

    }

    public String getName() {
        return name;
    }

    public int getVacancy() {
        return vacancy;
    }

    public String getBusinessHours() {
        return businessHours;
    }
    public void addBook(Book book) {
        booksList.add(book);
        saveBooks();
    }
    public List<Book> getBooks() {
        return booksList;
    }
    public List<Book> getBooksList() {
        List<Book> libraryBook = new ArrayList<>();
        for (int i = 0; i < booksList.size(); i++) {
            Book book = booksList.get(i);
            if (book.isExist()) {
                libraryBook.add(book);
            }
        }
        return libraryBook;
    }
    ////////////////////////////////////////////////////////////
    public void adduser(User user){
        userList.add(user);
        saveUser();
    }
    public List<User> getUser(){
        return userList;
    }
    //////////////////////////////////////////////////////////////
    public void rentBook(Book book, User user) {
        if (!book.isExist()) {
            System.out.println("Sorry ^--^ : the book is currently not available for rental.");
            return;
        } else {

            String rentalDate = LocalDate.now().toString();
            Rent rent = new Rent(book, user, rentalDate);
            rentalList.add(rent);
            book.setExist(false);

            saveBooks();
            saveRentals();

            System.out.println("Book rented successfully!");
        }
    }
        private void saveBooks () {
        }
    }
}


