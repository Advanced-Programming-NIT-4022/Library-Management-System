package org.example;

public class Rent {
    private int rentalID;
    private int rentalDate;
    Book toRent = new Book();
    NormalUser tenant = new NormalUser();

    public void rentABook(Book title) {
        Library lib = new Library();
        int index = lib.getBooksList().indexOf(title);
        Book wanted = lib.getBooksList().get(index);
        if (wanted.getStatus()) {
            /////SQL
            wanted.setStatus(false);
        }
    }
}
