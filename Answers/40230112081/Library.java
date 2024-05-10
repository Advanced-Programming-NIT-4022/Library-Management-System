import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
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
        v = new Verifications();
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
        User u = new User(user,usersFileHandle.getIDInFile().get(flag),usersFileHandle.getPhoneNumbersInFile().get(flag),"normal",pass);
        normalUserPanel(u);

    }
    public void login_AdminUsers(){
        String phone, pass, id, user;
        v = new Verifications();
        Scanner scn = new Scanner(System.in);
        int flag;
        while(true){
            System.out.println("Enter your Username: (If you forget: type forget)");
            user = scn.nextLine();
            if(Objects.equals(user, "forget")) {
                adminsFileHandle.show_myUsername();
                continue;
            }
            else if (v.userUsernameValidator(user) && adminsFileHandle.getUsernameInFile().contains(user)) {
                flag = adminsFileHandle.getUsernameInFile().indexOf(user);
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
                adminsFileHandle.show_myPassword();
                continue;
            } else if (v.userPasswordValidator(pass) && Objects.equals(pass, adminsFileHandle.getUserPassword().get(flag))) {
                break;
            }
            else{
                System.out.println("Password not found/wrong format, try again");
                continue;
            }
        }

    }
    public void show_helpMenuNormalUser(){
        String cmd;
        Scanner scn = new Scanner(System.in);
        System.out.println("to add a book to library : lib add title author description(nonSpace description & brief)");
        System.out.println("to Rent a book from library : lib rent your_id Book_title");
        System.out.println("to Edit your phonenumber : user edit ph current_ph new_ph");
        System.out.println("to Edit your username : user edit usr current_usr new_usr");
        System.out.println("to Edit your password : user edit pss current_pss new_pss");
        System.out.println("to Return a book : lib return book_title your_id");
        System.out.println("to logout& close : enter close/exit");
        System.out.println("to get back to your panel : Enter back");
        while (true){
            System.out.print(">>>");
            cmd = scn.nextLine();
            if(Objects.equals(cmd, "back") || Objects.equals(cmd, "Back"))
                break;
            else{
                System.out.println("Wrong input : Try again.");
            }
        }
    }
    public void normalUserPanel(User u){
        v = new Verifications();
        String cmd;
        String p1,p2, u1,u2, ps1,ps2;
        String query;
        ArrayList<String> list;
        Scanner scn = new Scanner(System.in);
        System.out.println("*******************************************************************");
        System.out.println("Welcome to your panel " + u.getUser_name() + " :");
        while (true) {
            System.out.println("Print help to get help with your commands :(Normal user privileges)");
            System.out.print(">>>");
            cmd = scn.nextLine();
            if(Objects.equals(cmd, "help") || Objects.equals(cmd, "Help") || cmd.contains("help")){
                show_helpMenuNormalUser();
            } else if (Objects.equals(cmd ,"close") || Objects.equals(cmd, "exit")) {
                break;

            } else if((cmd.contains("lib") || cmd.contains("user")) && (!cmd.contains("  ") || !cmd.contains("*"))){
                list = v.get_SectionsPanelQuery(cmd);
                if(Objects.equals(list.get(1), "add")){
                    // add book
                    String title, auth, desc;
                    title = list.get(2);
                    auth = list.get(3);
                    desc = list.get(4);
                    if(booksFileHandle.getAuthorsFromFileBook().contains(auth) && booksFileHandle.getTitlesFromFileBook().contains(title) &&
                        booksFileHandle.getDescriptionsFromFileBook().contains(desc)){
                        // inc existence
                        System.out.println("This book is added before.");
                        int i = booksFileHandle.getAuthorsFromFileBook().indexOf(auth);
                        String new_exst = String.valueOf(Integer.valueOf(booksFileHandle.getExistsFromFileBook().get(i))+1);
                        query = booksFileHandle.getIdFromFileBook().get(i) + "," +booksFileHandle.getTitlesFromFileBook().get(i)+","+
                                booksFileHandle.getAuthorsFromFileBook()+","+booksFileHandle.getDescriptionsFromFileBook().get(i)+","+
                                "available,"+new_exst;
                        booksFileHandle.editLineInFile(booksFileHandle.lines_of_file().get(i), query);
                    }
                    else{
                        // add a new book
                        String id = String.valueOf(booksFileHandle.set_id()+1);
                        String existence = "1";
                        query = id+","+title+","+auth+","+desc+","+"available,"+existence;
                        booksFileHandle.add_to_file(query);
                        System.out.println("Book is added successfully.");
                    }
                }
                else if(Objects.equals(list.get(1), "rent")){
                    // rent a book
                }
                else if(Objects.equals(list.get(1), "edit")){
                    // edit your info
                    if(Objects.equals(list.get(2), "ph")){
                        // edit phonenumber
                        p1 = list.get(3);
                        p2 = list.get(4);
                        while(true){
                            if(v.userPhonenumberValidator(p2)){
                                break;
                            }
                            else{
                                System.out.println("Enter valid username .");
                                System.out.println("User phonenumber must start with any number instead of 0 with length 10");
                                p2 = scn.nextLine();
                            }
                        }
                        while (true){
                            if(!usersFileHandle.getPhoneNumbersInFile().contains(p2))
                                break;
                            else{
                                System.out.println("This phonenumber is already taken . try another one");
                                System.out.print(">>>");
                                p2 = scn.nextLine();
                            }
                        }

                        int i = usersFileHandle.getPhoneNumbersInFile().indexOf(p1);
                        if(Objects.equals(p1, u.getPhonenumber())){
                            query = usersFileHandle.getIDInFile().get(i)+","+
                                   usersFileHandle.getUsernameInFile().get(i)+","+p2+",normal,"+usersFileHandle.getUserPassword().get(i);
                            usersFileHandle.editLineInFile(usersFileHandle.lines_of_file().get(i), query);
                            System.out.println("phonenumber has been updated");
                        }
                        else{
                            System.out.println("Repeat your command, your current username is not correct in input. ");
                        }

                    }
                    else if(Objects.equals(list.get(2), "usr")){
                        u1 = list.get(3);
                        u2 = list.get(4);
                        while(true){
                            if(v.userUsernameValidator(u2)){
                                break;
                            }
                            else{
                                System.out.println("Enter valid username .");
                                System.out.println("Username must include 0->9 and  a->z and A->Z , just underline '_' not dash '-'");
                                u2 = scn.nextLine();
                            }
                        }
                        while (true){
                            if(!usersFileHandle.getUsernameInFile().contains(u2))
                                break;
                            else{
                                System.out.println("This username is already taken . try another one");
                                System.out.print(">>>");
                                u2 = scn.nextLine();
                            }
                        }
                        int i = usersFileHandle.getUsernameInFile().indexOf(u1);
                        if(Objects.equals(u1, u.getUser_name())){
                            query = usersFileHandle.getIDInFile().get(i)+","+
                                    u2+","+usersFileHandle.getPhoneNumbersInFile().get(i)+",normal,"+usersFileHandle.getUserPassword().get(i);
                            usersFileHandle.editLineInFile(usersFileHandle.lines_of_file().get(i), query);
                            u.set_new_username(u2);
                            System.out.println("Your username has been updated");
                        }
                        else{
                            System.out.println("Repeat your command, your current username is not correct in input. ");
                        }

                    }
                    else if(Objects.equals(list.get(2), "pss")){
                        p1 = list.get(3);
                        p2 = list.get(4);
                        while (true){
                            if(v.userPasswordValidator(p2)){
                                break;
                            }
                            else{
                                System.out.println("Wrong format, try another password.");
                            }
                        }

                        if(!Objects.equals(p1, u.getPassword())){
                            System.out.println("Try command again, current password is not correct.");
                        }
                        else{
                            int i = usersFileHandle.getUserPassword().indexOf(p1);
                            query = usersFileHandle.getIDInFile().get(i)+"," + usersFileHandle.getUsernameInFile().get(i)+","+
                                    usersFileHandle.getPhoneNumbersInFile().get(i) + ",normal,"+p2;
                            usersFileHandle.editLineInFile(usersFileHandle.lines_of_file().get(i), query);
                            System.out.println("Your password has been updated.");
                        }

                    }
                }
                else if(Objects.equals(list.get(1), "return")){
                    // return a book

                }
                else{
                    System.out.println("Wrong format :-|");
                }

            }
            else{
                System.out.println("Wrong format, try again .");
            }
        }


    }

    public void adminUserPanel(){

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
