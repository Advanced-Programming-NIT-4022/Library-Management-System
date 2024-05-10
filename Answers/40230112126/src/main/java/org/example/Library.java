package org.example;


import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Library {

    String capacity, libraryName, operatingHours, libraryPassword;


    Library (String libraryName, String operatingHours, String capacity){

        this.libraryName = libraryName;
        this.operatingHours = operatingHours;
        this.capacity= capacity;

        fileMaker();
        updateFile();


    }


    ArrayList<Book> bookRepo = new ArrayList<>();
    ArrayList<User> userRepo = new ArrayList<>();
    ArrayList<Rent> rentRepo = new ArrayList<>();

    int booksId = 1;
    int usersId = 1;
    int rentsId = 1;

    public void fileMaker() {

        try {
            File f1 = new File("BOOKS.txt");
            File f2 = new File("USERS.txt");
            File f3 = new File("RENTS.txt");

            boolean a = f1.createNewFile();
            boolean b = f2.createNewFile();
            boolean c = f3.createNewFile();
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void saveFile() {
        try {
            FileOutputStream fileOut1 = new FileOutputStream("BOOKS.txt");
            ObjectOutputStream objectOut1 = new ObjectOutputStream(fileOut1);
            objectOut1.writeObject(this.bookRepo);
            fileOut1.close();
            objectOut1.close();

            FileOutputStream fileOut2 = new FileOutputStream("USERS.txt");
            ObjectOutputStream objectOut2 = new ObjectOutputStream(fileOut2);
            objectOut2.writeObject(this.userRepo);
            fileOut2.close();
            objectOut2.close();

            FileOutputStream fileOut3 = new FileOutputStream("Rents.txt");
            ObjectOutputStream objectOut3 = new ObjectOutputStream(fileOut3);
            objectOut3.writeObject(this.rentRepo);
            fileOut3.close();
            objectOut3.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateFile() {
        try {
            FileInputStream fileIn1 = new FileInputStream("BOOKS.txt");
            ObjectInputStream objectIn1 = new ObjectInputStream(fileIn1);
            this.bookRepo = (ArrayList<Book>) objectIn1.readObject();
            fileIn1.close();
            objectIn1.close();

            FileInputStream fileIn2 = new FileInputStream("USERS.txt");
            ObjectInputStream objectIn2 = new ObjectInputStream(fileIn2);
            this.userRepo = (ArrayList<User>) objectIn2.readObject();
            fileIn2.close();
            objectIn2.close();

            FileInputStream fileIn3 = new FileInputStream("RENTS.txt");
            ObjectInputStream objectIn3 = new ObjectInputStream(fileIn3);
            this.rentRepo = (ArrayList<Rent>) objectIn3.readObject();
            fileIn3.close();
            objectIn3.close();
        }
        catch (ClassNotFoundException e){

        }
        catch (IOException e){

        }


    }

    boolean passAuthorizer(int usersId){
        Scanner scanner = new Scanner(System.in);
        System.out.println("please enter your password: ");
        String input = scanner.nextLine();

        for (int i = 0; i < this.userRepo.size(); i++) {
            if (this.userRepo.get(i).userId.equals(this.usersId) ) {
                return true;
            }
        }
        return false;    }


    boolean nameAuthorizer(int userId){
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            System.out.println("please enter your username: ");
            return this.userRepo.get(userId - 1).equals(input);
        }

    public boolean bookAuthorizer(int bookId) {
        boolean result = false;
        for (int i = 0; i < this.bookRepo.size(); i++) {
            if (this.bookRepo.get(i).bookId == bookId) {
                result = true;
                break;
            }
        }
        return result;
    }

    public void AddNewUser(String userName, String phoneNumber, String password) {
        while (!passAuthorizer(usersId)) {
            System.out.println("Password is inccorect!");
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("please enter username: ");
        String tempUserName = scanner.nextLine();

        System.out.println("please enter phone number: ");
        String tempPhoneNumber = scanner.nextLine();
        String tempUserId = String.valueOf(this.usersId);
        User user = new User(tempUserName, tempPhoneNumber, tempUserId, new Date().toString());
        this.userRepo.add(user);
        this.usersId++;
        System.out.println("User id : " + user.userId);
        System.out.println("User added successfully!");
        saveFile();
    }

    public void RemoveUser(int userId) {
        while (!nameAuthorizer(userId)) {
            System.out.println("User not found!");
            return;
        }
        while (!passAuthorizer(usersId)) {
            System.out.println("incorrect password!");
            return;
        }
        for (int i = 0; i < this.userRepo.size(); i++) {
            if (this.userRepo.get(i).userId.equals(userId) ) {
                this.userRepo.remove(i);
                break;
            }
        }
        System.out.println("User removed succesfully!");
        saveFile();
    }

        public void AddNewBook() {
            while (!passAuthorizer(usersId)) {
            System.out.println("wrong password");
            return;
            }

            Scanner scanner = new Scanner(System.in);
            System.out.println("please enter book's name: ");
            String tempBookName = scanner.nextLine();

            System.out.println("please enter the name of author: ");
            String tempBookAuthor = scanner.nextLine();

            System.out.println("please enter a description: ");
            String tempBookDescription = scanner.nextLine();

            Book book = new Book(tempBookName, this.booksId,  tempBookAuthor, tempBookDescription, true);
            this.booksId++;
            this.bookRepo.add(book);
            System.out.println("Book id : " + book.bookId);
            System.out.println("Book added successfully!");
            saveFile();
    }

    public void RentBook(int userId, int bookId) {
        while (!nameAuthorizer(userId)) {
            System.out.println("username invalid!");
            return;
        }
        while (!bookAuthorizer(bookId)) {
            System.out.println("we're sorry, we don't have your requested book at the moment!");
            return;
        }
        while (!passAuthorizer(userId)) {
            System.out.println("Password is incorrect!");
            return;
        }
        int bookIndex = 0, userIndex = 0;
        for (int i = 0; i < this.userRepo.size(); i++) {
            if (this.userRepo.get(i).userId.equals(userId) ) {
                userIndex = i;
            }

        }
        for (int i = 0; i < this.bookRepo.size(); i++) {
            if (this.bookRepo.get(i).bookId == bookId) {
                if (!this.bookRepo.get(i).bookStatus) {
                    System.out.println("Book is already rented :(");
                    return;
                }
                bookIndex = i;
                this.bookRepo.get(i).bookStatus = false;
                break;
            }
        }

        Rent rent = new Rent(this.rentsId, new Date().toString(), this.bookRepo.get(bookIndex), this.userRepo.get(userIndex));
        this.rentRepo.add(rent);
        System.out.println("Book rented successfully!(you have 7 days to return the book or ...)");
        saveFile();
    }

    public void ReturnBook(int userId, int bookId) {
        while (!nameAuthorizer(userId)) {
            System.out.println("User not found!");
            return;
        }
        if (!bookAuthorizer(bookId)) {
            System.out.println("Book not found!");
            return;
        }
        for (int i = 0; i < this.rentRepo.size(); i++) {
            if (this.rentRepo.get(i).bookObj.bookId == bookId && this.rentRepo.get(i).userObj.userId.equals(userId) ) {
                for (int j = 0; j < this.bookRepo.size(); j++) {
                    if (this.bookRepo.get(j).bookId == bookId) {
                        this.bookRepo.get(j).bookStatus = true;
                        break;
                    }
                }
                this.rentRepo.remove(i);
                break;
            }
        }
        System.out.println("Book returned successfully!");
        saveFile();
    }

    public void ShowBookList() {
        if (this.bookRepo.isEmpty()) {
            System.out.println("No book available at the moment!");
            return;
        }
        for (int i = 0; i < this.bookRepo.size(); i++) {
            System.out.println("Book"+ i+1 + ": ");
            System.out.println("Book name    : " + this.bookRepo.get(i).bookTitle);
            System.out.println("Author  : " + this.bookRepo.get(i).bookAuthor);
            System.out.println("Book id      : " + this.bookRepo.get(i).bookId);
            System.out.println("Availability : " + this.bookRepo.get(i).bookStatus);
            System.out.println("===================================================");
        }
    }


}
