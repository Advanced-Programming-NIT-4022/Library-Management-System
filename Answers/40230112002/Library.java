import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Library {
    private String Library_Name;
    private int capacity;
    private ArrayList<Book> bookRepository;
    private  ArrayList<User> users;
    private ArrayList<Object> RentalDetails;

    public Library(String Library_Name , Integer capacity){

        this.Library_Name = Library_Name;
        this.capacity = capacity;

        this.users = new ArrayList<>();
        this.bookRepository = new ArrayList<>();
        this.RentalDetails = new ArrayList<>();

    }





    public Library(ArrayList<Book> bookRepository , ArrayList<User> users){

        this.bookRepository = bookRepository;
        this.users = users;
    }
    public void addUser(String userName, String userPhone){
            User newUser = new NormalUser(userName , userPhone);
            users.add(newUser);
        }

public void RemoveUser(Integer UserID){
    users.forEach(user -> {
        if (UserID == users.indexOf(user))
            users.remove(user);
    });}

public void addBook(String BookTitle , String BookAuthor , String BookDescription){
            Book newBook = new Book(BookTitle , BookAuthor , BookDescription );
            bookRepository.add(newBook);
        }

    public void removeBook(Integer BookID){
        bookRepository.forEach(book -> {
            if(BookID == bookRepository.indexOf(book)){
                bookRepository.remove(book);
            }
        });
        }

    public void addAdmin(String name , String phoneNumber , String Password){
        Admin admin = new Admin(name , phoneNumber , Password);
        users.add(admin);
    }
}