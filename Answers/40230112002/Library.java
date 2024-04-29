import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Library {
    Scanner sc = new Scanner(System.in);
    final String LIBRARY_NAME = "The Jedi Temple library";
    int capacity;
    int Operating_Hours;
    ArrayList<Book> bookRepository;
    ArrayList<User> users;
    ArrayList<Object> RentalDetails;





    public Library(ArrayList<Book> bookRepository , ArrayList<User> users){

        this.bookRepository = bookRepository;
        this.users = users;
    }
    public void addMember(Integer MemberID , String Password){
        if(Password.equals(Admin.getPassword())){
            System.out.println("Enter User Name: ");
            String userName = sc.nextLine();
            System.out.println("Enter User Phone number: ");
            String userPhone = sc.nextLine();
            User newUser = new User(userName , userPhone);
            users.add(newUser);
        }
    }

    public void removeMember(Integer MemberID , String Password){
        if(Password.equals(Admin.getPassword())){
        for (User i : users) {
            if(i.getUnique_UserID() == MemberID ){
                users.remove(i);
                }
            }
        }
    }


    public void addBook(Integer BookID , String Password){
        if(Password.equals(Admin.getPassword())){
            System.out.println("Enter Book title: ");
            String BookTitle = sc.nextLine();
            System.out.println("Enter Book Author: ");
            String BookAuthor = sc.nextLine();
            System.out.println("Enter Book Description: (Optional)");
            String BookDescription = sc.nextLine();
            Book newBook = new Book(BookTitle , BookAuthor , BookDescription );
            bookRepository.add(newBook);
        }
    }

    public void removeBook(Integer BookID , String Password){
        if(Password.equals(Admin.getPassword())){
            for (Book i : bookRepository) {
                if(i.getUnique_BookID() == BookID ){
                    bookRepository.remove(i);
                }
            }
        }
    }

    public void bookRental(String booktitle){
        for(Book i : bookRepository){
            if(i.getTitle().equals(booktitle)){
                if(i.getAvailabiliy_Status()){
                    i.setAvailability_status(false);
                    Rent.RentBookLOG();
                }
                else{
                    System.out.println("Book Not Found . Rental Failed");
                }
            }
        }
    }
}
