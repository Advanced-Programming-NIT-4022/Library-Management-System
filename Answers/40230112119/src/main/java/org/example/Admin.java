package org.example;

import java.util.ArrayList;

public class Admin extends User{
    public Admin(String name, int ID, char[] phone, String password) {
        super(name, ID, phone, password);
    }

    public void removeBook(ArrayList<Book> booksList, String title) {
        for (int i = 0; i < booksList.size(); i++) {
            if (title.equals(booksList.get(i))) {
                booksList.remove(i);
                break;
            }
        }
    }

    public void addAdmin(){

    }
}
