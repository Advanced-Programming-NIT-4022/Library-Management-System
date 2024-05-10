import java.util.List;
import java.util.Scanner;

public class MyApp {
    public static void main(String[] args) {
        
    }
    public Book getbook() {
        try (Scanner scanner = new Scanner(System.in)) {
            String a = scanner.next();
            String b = scanner.next();
            String c = scanner.next();
            Book book = new Book(a, b, c);
            return book;
        }
    }
    public void setBookinrepo() {
        Library.addBook(getbook());
        Library.saveRepository();
    }
    public User getUser() {
        Scanner scanner = new Scanner(System.in);
            String Name = scanner.nextLine();
            String FamilyName = scanner.nextLine();
            String Id = scanner.nextLine();
            String password = scanner.nextLine();
            String PhoneNumber = scanner.nextLine();
            User user = new User(Name, FamilyName,PhoneNumber, Id, password);
            scanner.close();
            return user; 
    }

    public User getAdmin() {
        Scanner scanner = new Scanner(System.in);
            if(AdminUser.Adminpass==scanner.next()){
            String Name = scanner.nextLine();
            String FamilyName = scanner.nextLine();
            String Id = scanner.nextLine();
            String password = scanner.nextLine();
            String PhoneNumber = scanner.nextLine();
            User user = new User(Name, FamilyName,PhoneNumber, Id, password);
            scanner.close();
            return user;
         }
         else
         return null;
    }

    public void setuser() {
        Library.addUser(getUser());
        Library.saveusers();
    }

    public void loguser(){
        List<User> users = Library.getuser();
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("name:");
            String a = scanner.nextLine();
            
            System.out.println("pass:");
            String a2 = scanner.nextLine();

            for (User user : users) {
                if (user.getName().equals(a) && user.getPassword().equals(a2)) {
                    System.out.println( "!");
                    return;
                }
            }
            System.out.println("huh");
        }
    }
     
    
}
