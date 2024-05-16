import java.util.Scanner;

public class CLI {
    private Library library;
    private NormalUser currentUser;
    private Admin currentAdmin;

    public CLI(Library library) {
        this.library = library;
        this.currentUser = null;
        this.currentAdmin=null;
    }
    private Admin findAdmin(String Name,String UserID,String Password) {
        for (Admin user : library.getAllAdmins()) {
            if (user.getUserID().equals(UserID) && user.getName().equals(Name) && user.getPassword().equals(Password)) {
                currentAdmin=user;
            }
        }
        return currentAdmin;
    }
    private NormalUser findNormalUser(String Name,String UserID) {
        for (NormalUser user : library.getAllNormalUsers()) {
            if (user.getUserID().equals(UserID) && user.getName().equals(Name)) {
                currentUser=user;
            }
        }
        return currentUser;
    }
    public void start(){

            while(currentAdmin==null && currentUser==null) {
                System.out.println("1.Sign in");
                System.out.println("2.Sign up");
                Scanner scanner = new Scanner(System.in);
                int input = scanner.nextInt();
                if (input == 1) {
                    System.out.println("1.Sign in as Admin");
                    System.out.println("2.Sign in as Normal User");
                    int input1 = scanner.nextInt();
                    if (input1 == 1) {
                        System.out.println("insert name:");
                        String name = scanner.next();
                        System.out.println("insert id:");
                        String userid = scanner.next();
                        System.out.println("insert password:");
                        String pass = scanner.next();
                        currentAdmin = findAdmin(name, userid, pass);
                        if (currentAdmin == null) {
                            System.out.println("User not found");
                        } else {
                            System.out.println("Login Successfully");
                        }
                    }
                    if (input1 == 2) {
                        System.out.println("insert name:");
                        String name = scanner.next();
                        System.out.println("insert id:");
                        String userid = scanner.next();
                        currentUser = findNormalUser(name, userid);
                        if (currentUser == null) {
                            System.out.println("User not found");
                        } else {
                            System.out.println("Login Successfully");
                        }
                    }

                }
                if (input == 2) {
                    System.out.println("1.Sign up as Admin");
                    System.out.println("2.Sign up as Normal User");
                    int input1 = scanner.nextInt();
                    if (input1 == 1) {
                        System.out.println("insert name:");
                        String name = scanner.next();
                        System.out.println("insert id:");
                        String userid = scanner.next();
                        System.out.println("insert password:");
                        String pass = scanner.next();
                        System.out.println("insert phonenumber:");
                        String phonenumber = scanner.next();
                        library.addNewAdmin(new Admin(name, userid, phonenumber, pass));
                        System.out.println("Sign up Successfully");

                    }
                    if (input1 == 2) {
                        System.out.println("insert name:");
                        String name = scanner.next();
                        System.out.println("insert id:");
                        String userid = scanner.next();
                        System.out.println("insert phonenumber:");
                        String phonenumber = scanner.next();
                        library.addNewNormalUser(new NormalUser(name, userid, phonenumber));
                        System.out.println("Sign up Successfully");
                    }
                }
            }
            if (currentAdmin!=null){
                System.out.println("1.Add a new book to the library");
                System.out.println("2.Add a new book to the library");
                System.out.println("3.Rent a book from the library");
                System.out.println("4.Add a new member to the library");
                System.out.println("5.Rent a book for a specific member");
                System.out.println("6.View available books for rental");
                System.out.println("7.Remove a member from the library");
                System.out.println("8.Return a rented book to the library");

            }
            if (currentUser!=null){
                System.out.println("1.Add a new book to the library");
                System.out.println("2.Add a new book to the library");
                System.out.println("3.Rent a book from the library");
                System.out.println("4.Rent a book for a specific member");
                System.out.println("5.View available books for rental");
                System.out.println("6.Return a rented book to the library");
                Scanner scanner = new Scanner(System.in);
                int input = scanner.nextInt();
                if(input==1){
                    System.out.println("book name:");
                    String name = scanner.next();
                    System.out.println("book author:");
                    String author = scanner.next();
                    System.out.println("book description:");
                    String description = scanner.next();
                    library.addNewBook(new Book(name,author,description));
                }
                if(input==2){
                    System.out.println("library operating hours: "+library.getOperatingHours());
                }
                if(input==3){
                    System.out.println("book name:");
                    String name = scanner.next();
                    library.newRent(currentUser,);
                }

            }


    }
}
