import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Library {
    private String libName;
    private int libCap;
    private String oprHours;

    // repos & registries
    public myFileCLass usersFileHandle;
    public myFileCLass adminsFileHandle;
    public myFileCLass booksFileHandle;
    public myFileCLass rentalFileHandle;
    // verifications
    public Verifications v;
    // constructor
    public Library(String name, String duration, int cap){
        this.oprHours = duration;
        this.libCap = cap;
        this.libName = name;
        usersFileHandle = new myFileCLass();
        adminsFileHandle = new myFileCLass();
        booksFileHandle = new myFileCLass();
        rentalFileHandle = new myFileCLass();
        usersFileHandle.dir = "Users.txt";
        adminsFileHandle.dir = "Admins.txt";
        booksFileHandle.dir = "Books.txt";
        rentalFileHandle.dir = "Rental.txt";
    }
    // getters
    public String getLibName() { return this.libName; }
    public int getLibCap() { return this.libCap; }
    public String getOprHours() { return this.oprHours; }


    public void add_normalUser(){ // sign-up just for normal users
        String id, username, pass, phonenumber;
        User u;
        Scanner scn = new Scanner(System.in);
        Scanner scn1 = new Scanner(System.in);
        v = new Verifications();
        // first string verification
        System.out.println("Enter your id :");
        System.out.println("Your id must be numerical with length between 10 and 15");
        while (true){
            id = scn.nextLine();
            if(v.userIdValidator(id))
                break;
            else{
                System.out.println("Wrong format, try again.");
            }
        }
        System.out.println("Enter username :");
        System.out.println("Username must include 0->9 and  a->z and A->Z , just underline '_' not dash '-'");
        while (true){
            username = scn.nextLine();
            if(v.userUsernameValidator(username)){
                break;
            }
            else{
                System.out.println("Wrong format, try again.");
            }
        }
        System.out.println("Enter a phonenumber :");
        System.out.println("User phonenumber must start with any number instead of 0 with length 10");
        while (true){
            phonenumber = scn1.nextLine();
            if(v.userPhonenumberValidator(phonenumber)){
                break;
            }
            else{
                System.out.println("Wrong Format, Try again.");
            }
        }
        // now to check file
        if(usersFileHandle.getUsernameInFile().contains(username) || usersFileHandle.getIDInFile().contains(id)
                || usersFileHandle.getPhoneNumbersInFile().contains(phonenumber)){
            System.out.println("Sorry, We found your id/username/phonenumber , Please goto login panel");
            return;
        }
        System.out.println("Set a password for yourself :");
        System.out.println("Password must include 0->9 and  a->z and A->Z , just underline '_' not dash '-'");
        while (true){
            pass = scn.nextLine();
            if(v.userPasswordValidator(pass)){
                break;
            }
            else{
                System.out.println("Wrong Format, Try Again.");
            }
        }
        u = new User(username, id, phonenumber,"normal", pass);
        usersFileHandle.addUser(u);

    }
    // login as normal user
    // login as admin user
    public void login_normalUsers(){
        String phone, pass, id, user;
        Scanner scn = new Scanner(System.in);
        int flag;
        while(true){
            System.out.println("Enter your Username: (If you forget: type forget)");
            user = scn.nextLine();
            if(Objects.equals(user, "forget")) {
                usersFileHandle.show_myUsername();
                continue;
            }
            else if (v.userUsernameValidator(user) && usersFileHandle.getUsernameInFile().contains(user)) {
                flag = usersFileHandle.getUsernameInFile().indexOf(user);
                break;
            }
            else{
                System.out.println("Username not found/wrong format, try again");
                continue;
            }
        }
        while (true){
            System.out.println("Enter your password :(if you forget , type forget)");
            pass = scn.nextLine();
            if(Objects.equals(pass,"forget")){
                usersFileHandle.show_myPassword();
                continue;
            } else if (v.userPasswordValidator(pass) && Objects.equals(pass, usersFileHandle.getUserPassword().get(flag))) {
                break;
            }
            else{
                System.out.println("Password not found/wrong format, try again");
                continue;
            }
        }

    }

}

/*
System.out.println("Enter your id :");
        id = scn.nextLine();
        if(usersFileHandle.getIDInFile().contains(id)){
            System.out.println("You have been registered before. Login please:-)");
        }
        else {
            while(true){
                if(v.userIdValidator(id)){
                    break;
                }
                else{
                    System.out.println("Enter id again, your ID must be numerical with length between 10 and 15");
                    id = scn.nextLine();
                }
            }
            System.out.println("Enter your username :");
            System.out.println("Username must include 0->9 and  a->z and A->Z , just underline '_' not dash '-'");
            while(true){
                username = scn.nextLine();
                if(!v.userUsernameValidator(username) || usersFileHandle.getUsernameInFile().contains(username)){
                    System.out.println("Wrong Input try again :-|");
                }
                else{
                    break;
                }
            }
            System.out.println("Enter your phonenumber :");
            System.out.println("User phonenumber must start with any number instead of 0 with length 10");
            while(true){
                phonenumber = scn.nextLine();
                if(!v.userPhonenumberValidator(phonenumber) || usersFileHandle.getPhoneNumbersInFile().contains(phonenumber)){
                    System.out.println("Wrong Input try again :-|");
                }
                else{
                    break;
                }
            }

        }
 */
