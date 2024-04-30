import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Library {
    private String LibraryName;
    private int Capacity;
    private int nextbookid;
    private int nextrentid;
    private int nextuserid;
    private List<Book> books;
    private List<User> users;
    private List<Rent>  rents;
    public Library(int capacity , String libraryName){
        this.LibraryName = libraryName;
        this.Capacity = capacity;
        this.nextbookid = 1;
        this.nextrentid = 1;
        this.nextuserid = 1;
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
        this.rents = new ArrayList<>();
    }
    private User getusername(String name) {
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(name)) {
                return user;
            }
        }
        return null;
    }
    public void addbook(String Title , String Author , String Description){
        Book newbook = new Book(Title , Author , Description , nextbookid++);
        books.add(newbook);
    }
    public void adduser(String Name , int PhoneNumber ){
        NormalUser newuser = new NormalUser(Name , PhoneNumber , nextuserid++ , new Date());
        users.add(newuser);
    }
    public void addadmin(String Name , int PhoneNumber , int PassWord){
        Admin newadmin = new  Admin(Name , PhoneNumber , PassWord , nextuserid++);
        users.add(newadmin);
    }
    public void rentbook(String bookname , String username){
        for(Book book : books){
            if(book.getTitle().equalsIgnoreCase(bookname) && book.isAvailable()){
                User user = getusername(username);
                if(user != null){
                    book.setAvailable(false);
                    rents.add(new Rent(book , user , nextrentid++ , new Date()));
                    System.out.println(user.getName() + "has Returned: " + book.getTitle());
                    return;
                }else{
                    System.out.println("User not found.");
                    return;
                }
            }
        }
        System.out.println("Book not available for rent!");
    }
    public void returnBook(String bookName){
        for(Rent rent : rents){
            if(rent.getBookObject().getTitle().equalsIgnoreCase(bookName)){
                rent.getBookObject().setAvailable(true);
                System.out.println(rent.getUserObject().getName() + " has Returned: " + rent.getBookObject().getTitle());
                rents.remove(rent);
                return;
            }
        }
    }
    public List<Book> getAvailableBook(){
        List<Book> availablebook = new ArrayList<>();
        for(Book book : books){
            if(book.isAvailable()){
                availablebook.add(book);
            }
        }
        return availablebook;
    }
    public void removeuser(int UserID){
        for(User user : users){
            if(user.getUserID() == UserID){
                users.remove(user);
                System.out.println("User Successfully Removed");
                return;
            }
        }
        System.out.println("User not found or can't remove it!!");
    }

}
