import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class Library {
    private String Library_Name;
    private int capacity;
    private ArrayList<Book> bookRepository;
    private  ArrayList<User> users;
    private ArrayList<Rent> RentalDetails;

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


    public void BookRental(String BookName , String UserName){
        for(Book book : bookRepository){
            if(book.getTitle().equalsIgnoreCase(BookName) && book.getAvailability_status()){
                User user = getUserobject(UserName);
                if(user != null){
                    Rent rent = new Rent(user , book , new Date());
                    RentalDetails.add(rent);
                    System.out.println("|"+book.getTitle() + "| Has been Rented by : " + user.getName() + user.getUserID() + user.getPhoneNumber());
                    return;
                }
                else {
                    System.out.println("[!] # User Not Found #\n\r");
                }
            }
        }
        System.out.println("[!] # Book Not Found #\n\r");
    }

    public void ReturnBook(String BookName){
        for (Book book : bookRepository){
            if (book.getTitle().equalsIgnoreCase(BookName) && book.getAvailability_status().equals(false)){
                book.setAvailability_status(true);
                System.out.println("[+] |"+ book.getTitle() + "| Has been Returned ");
                for(Rent rent : RentalDetails){
                    if(rent.getBookObject().equals(book)){
                        RentalDetails.remove(rent);
                        break;
                    }
                }
            }
        }
    }

    public User getUserobject(String UserName){
        for(User user : users){
            if(user.getName().equalsIgnoreCase(UserName)){
                return user;
            }
        }
        return null;
    }

    public void ShowAvailableBooks(){
        bookRepository.forEach(book -> {
            if(book.getAvailability_status().equals(true)){
                System.out.println(bookRepository.indexOf(book) + ". " + book.getTitle() + " wrote By " + book.getAuthor());
            }
        });
    }


    public void RemoveUser(String UserID){
        for(User user : users){
            if(user.getUserID().equals(UserID)){
                users.remove(user);
                System.out.println("[+] User" + user.getName() +" Has Been Removed");
            }
        }
        System.out.println("[!] # User Not Found #\n\r");
    }

    public void BookRentalForUser(String bookName, String UserName, int UserID) {
        for (Book book : bookRepository) {
            if (book.getTitle().equalsIgnoreCase(bookName) && book.getAvailability_status().equals(true)) {
                for(User user : users){
                    if(user.getName().equalsIgnoreCase(UserName) && user.getUserID().equals(UserID)){
                        book.setAvailability_status(false);
                        Rent newRent = new Rent(user , book , new Date());
                        RentalDetails.add(newRent);
                        System.out.println("[+] "+ bookName + " Has Been Rented by " + UserName + " " + UserID);
                        break;
                    }
                }
            }
        }
    }
}