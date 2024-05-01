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
    public void adduser(String Name , String PhoneNumber ){
        NormalUser newuser = new NormalUser(Name , PhoneNumber , nextuserid++ , new Date());
        users.add(newuser);
    }
    public void addadmin(String Name , String PhoneNumber , String PassWord){
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
                    System.out.println(user.getName() + "has Rented: " + book.getTitle());
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
    public void removeuser(String PhoneNumber){
        for(User user : users){
            if(user.getPhoneNumber().equalsIgnoreCase(PhoneNumber)){
                users.remove(user);
                System.out.println("User Successfully Removed");
                return;
            }
        }
        System.out.println("User not found or can't remove it!!");
    }
    public void rentBookForUser(String bookName, String memberName, int memberID) {
        Book bookToRent = null;
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(bookName) && book.isAvailable()) {
                bookToRent = book;
                break;
            }
        }
        if (bookToRent == null) {
            System.out.println("Book not available for rent.");
            return;
        }

        User user = null;
        for (User u : users) {
            if (u.getName().equalsIgnoreCase(memberName) && u.getUserID() == memberID) {
                user = u;
                break;
            }
        }
        if (user == null) {
            System.out.println("Member not found.");
            return;
        }

        bookToRent.setAvailable(false);
        rents.add(new Rent(bookToRent, user, nextrentid++, new Date()));
        System.out.println(user.getName() + " has rented: " + bookToRent.getTitle());
    }
}
