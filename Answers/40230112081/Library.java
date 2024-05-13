import org.w3c.dom.ls.LSOutput;

import java.io.ObjectStreamException;
import java.sql.SQLOutput;
import java.util.*;
import java.text.SimpleDateFormat;
import java.text.Format;

public class Library {
    private String libName;
    private int libCap;
    private String oprHours;

    public Calendar cal;
    public SimpleDateFormat simpleDate;

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

    public void adminEditPanel(User u){
        String query;
        String id, u_name, u_phone, pass;
        id = u.getUserID();
        u_name = u.getUser_name();
        Scanner scn = new Scanner(System.in);
        u_phone = u.getPhonenumber();
        pass = u.getPassword();
        String cmd;
        v = new Verifications();
        int flag = adminsFileHandle.getUsernameInFile().indexOf(u_name);
        System.out.println("1. Username");
        System.out.println("2. Phonenumber");
        System.out.println("3. Password");
        while (true){
            System.out.println("choose to edit :");
            System.out.print(">>>");
            cmd = scn.nextLine();
            if(Objects.equals(cmd, "Username") || Objects.equals(cmd, "1") || Objects.equals(cmd, "user") || Objects.equals(cmd, "usr")){
                while(true){
                    System.out.println("Enter your new username :");
                    System.out.print(">>>");
                    u_name = scn.nextLine();
                    if(v.userUsernameValidator(u_name)){
                        if(!adminsFileHandle.getUsernameInFile().contains(u_name))
                            break;
                        else{
                            System.out.println("This username is already taken");
                        };
                    }
                    else{
                        System.out.println("Wrong format. try another :-|");
                        System.out.println("Username must include 0->9 and  a->z and A->Z , just underline '_' not dash '-'");
                    }
                }


                query = u.getUserID()+","+u_name+","+u.getPhonenumber()+","+"admin"+","+u.getPassword();
                adminsFileHandle.editLineInFile(adminsFileHandle.lines_of_file().get(flag), query);
                break;
            }
            else if(Objects.equals(cmd, "Phonenumber") || Objects.equals(cmd, "2") || Objects.equals(cmd, "phone") || Objects.equals(cmd, "ph")){
                while(true){
                    System.out.println("Enter your new phonenumber :");
                    System.out.print(">>>");
                    u_phone = scn.nextLine();
                    if(v.userPhonenumberValidator(u_phone)){
                        if(!adminsFileHandle.getPhoneNumbersInFile().contains(u_phone))
                            break;
                        else{
                            System.out.println("This phonenumber is already taken");
                        };
                    }
                    else{
                        System.out.println("Wrong format. try another :-|");
                        System.out.println("User phonenumber must start with any number instead of 0 with length 10");
                    }
                }
                query = u.getUserID()+","+u.getUser_name()+","+u_phone+","+"admin"+","+u.getPassword();
                adminsFileHandle.editLineInFile(adminsFileHandle.lines_of_file().get(flag), query);
                break;
            }
            else if(Objects.equals(cmd, "Password") || Objects.equals(cmd, "3") || Objects.equals(cmd, "pass") || Objects.equals(cmd, "pss")){
                while(true){
                    System.out.println("Enter your new password :");
                    System.out.print(">>>");
                    pass = scn.nextLine();
                    if(v.userPasswordValidator(pass)){
                        break;
                    }
                    else{
                        System.out.println("Wrong format. try another :-|");
                        System.out.println("Password must include 0->9 and  a->z and A->Z , just underline '_' not dash '-'");
                    }
                }
                query = u.getUserID()+","+u.getUser_name()+","+u.getPhonenumber()+","+"admin"+","+pass;
                adminsFileHandle.editLineInFile(adminsFileHandle.lines_of_file().get(flag), query);
                break;
            }
            else{
                System.out.println("Wrong input");
            }
        }
    }

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
            if(v.userIdValidator(id)){
                if(!usersFileHandle.getIDInFile().contains(id) && !adminsFileHandle.getIDInFile().contains(id)){
                    break;
                }
                else{
                    System.out.println("This id is added to repository");
                }
            }
            else{
                System.out.println("Try again");
            }
        }

        System.out.println("Enter user name");
        while (true){
            username = scn.nextLine();
            if(v.userUsernameValidator(username)){
                if(!usersFileHandle.getUsernameInFile().contains(username) && !adminsFileHandle.getUsernameInFile().contains(username)){
                    break;
                }
                else{
                    System.out.println("This username is already taken");
                }
            }
            else{
                System.out.println("Wrong format");
            }
        }

        System.out.println("Enter a phonenumber");
        while (true){
            phonenumber = scn.nextLine();
            if(v.userPhonenumberValidator(phonenumber)){
                if(!usersFileHandle.getPhoneNumbersInFile().contains(phonenumber)){
                    break;
                }
                else{
                    System.out.println("this number is added before");
                }
            }
            else{
                System.out.println("Wrong format.");
            }
        }
        System.out.println("Set a password");
        while (true){
            pass = scn.nextLine();
            if(v.userPasswordValidator(pass)){
                break;
            }
            else{
                System.out.println("Wrong format");
            }
        }
        u = new User(username, id, phonenumber, "normal", pass);
        usersFileHandle.addUser(u);

    }
    // login as normal user
    // login as admin user
    public void login_normalUsers(){
        String phone, pass, id, user;
        v = new Verifications();
        Scanner scn = new Scanner(System.in);
        int flag;
        if(usersFileHandle.lines_of_file().size() != 0){
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
        else{
            System.out.println("There is no normal user in our repository, First sign up please. Thank you. :-)");
        }

    }
    public boolean isLibOpen(){
        String[] hoursParts = this.oprHours.split("-");
        cal = Calendar.getInstance();
        simpleDate = new SimpleDateFormat("hh:mm");
        String date = simpleDate.format(cal.getTime());
        char c = hoursParts[1].charAt(0);
        int vclose = Integer.valueOf(c) - Integer.valueOf('0');
        int close =  vclose + 12;
        char s = hoursParts[0].charAt(0);
        int vopen =Integer.valueOf(s) - Integer.valueOf('0');
        int start = vopen;
        String[] current = date.split(":");
        if(Integer.valueOf(current[0]) >= start && Integer.valueOf(current[0]) < close){
            return true;
        }


        return false;
    }
    public void login_AdminUsers(){
        String phone, pass, id, user;
        v = new Verifications();
        Scanner scn = new Scanner(System.in);
        int flag;
        if(adminsFileHandle.lines_of_file().size() != 0){
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
            User u = new User(user, adminsFileHandle.getIDInFile().get(flag), adminsFileHandle.getPhoneNumbersInFile().get(flag)
                    , "admin", pass);
            adminUserPanel(u);
        }
        else{
            System.out.println("There is no admin in our repository, It means, you have to signup as normal user");
        }

    }
    public void show_helpMenuNormalUser(){
        String cmd;
        Scanner scn = new Scanner(System.in);
        System.out.println("to add a book to library : lib add title author description(nonSpace description & brief)");
        System.out.println("to Rent a book from library : lib rent your_id Book_id");
        System.out.println("to Edit your phonenumber : user edit ph current_ph new_ph");
        System.out.println("to Edit your username : user edit usr current_usr new_usr");
        System.out.println("to Edit your password : user edit pss current_pss new_pss");
        System.out.println("to Return a book : lib return book_id your_id");
        System.out.println("to Show available books :lib show books");
        System.out.println("to show your info/profile :user show profile");
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
    public void show_helpMenuAdmins(){
        Scanner scn = new Scanner(System.in);
        String cmd;
        System.out.println("to add book : lib add book_title book_author book_desc");
        System.out.println("to edit normal user : lib edit (ph/pss/usr) current new_one (usr : username, pss:password, ph : phonenumber");
        System.out.println("to remove user : lib remove user user_id user_name user_phone"); // done
        System.out.println("to remove book : lib remove book book_title book_author book_desc"); // done
        System.out.println("to remove rent : lib remove rental_date user_id book_id");
        System.out.println("to promote normal user : user promote user_id user_name user_phone"); // done
        System.out.println("to show users : lib show users");  // done
        System.out.println("to show books : lib show books (-A : all books , -E : only available books , -R : in-rent books)"); // done
        System.out.println("to show rents : lib show rents"); // done
        System.out.println("to exit your panel : back to your panel"); // done
        System.out.println("to edit your profile :lib edit admin");
        System.out.println("***Attention*** : avoid to enter space more than one , avoid to enter any character, Each command must be space separated");
        System.out.println("for entering space in each field : use underline character '_' ");
        System.out.println("to back to your panel from this menu : just enter back");
        while (true){
            System.out.print(">>>");
            cmd = scn.nextLine();
            if (Objects.equals(cmd, "back")){
                break;
            }
            else{
                System.out.println("Just enter back. :-|");
            }
        }
    }
    public void normalUserPanel(User u){
        cal = Calendar.getInstance();
        simpleDate = new SimpleDateFormat("dd/MMMM/yyyy");
        String date = simpleDate.format(cal.getTime());
        v = new Verifications();
        String cmd;
        String p1,p2, u1,u2, ps1,ps2;
        String query;
        ArrayList<String> list;
        Scanner scn = new Scanner(System.in);
        System.out.println("*******************************************************************");
        System.out.println("Welcome to your panel " + u.getUser_name() + " :");
        System.out.println("Library is open in :" + this.oprHours);
        while (true) {
            System.out.println("Print help to get help with your commands :(Normal user privileges)");
            System.out.print(">>>");
            cmd = scn.nextLine();
            if(Objects.equals(cmd, "help") || Objects.equals(cmd, "Help") || cmd.contains("help")){
                show_helpMenuNormalUser();
            } else if (Objects.equals(cmd ,"close") || Objects.equals(cmd, "exit")) {
                break;

            } else if((cmd.contains("lib") || cmd.contains("user")) && !cmd.contains("*")){
                list = v.get_SectionsPanelQuery(cmd);
                if(Objects.equals(list.get(1), "add")){
                    try {
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
                                    booksFileHandle.getAuthorsFromFileBook().get(i)+","+booksFileHandle.getDescriptionsFromFileBook().get(i)+","+
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
                    }catch (Exception e){
                        System.out.println("Missing args, Try command in correct way.");
                    }
                }
                else if(Objects.equals(list.get(1), "rent")){
                    try{
                        // layer 1 : check availability user_id
                        // layer 2 :   "        "       book_id
                        // layer 3 :   "        "       rentQuery
                        String id = list.get(3);
                        String user_ID = list.get(2);
                        int i = booksFileHandle.getIdFromFileBook().indexOf(id);
                        int f;
                        String rentQuery = date + ","+ user_ID+","+id;
                        if(usersFileHandle.getIDInFile().contains(user_ID)){
                            if(booksFileHandle.getIdFromFileBook().contains(id)){
                                if(!rentalFileHandle.lines_of_file().contains(rentQuery)){
                                    rentalFileHandle.add_to_file(rentQuery);
                                    booksFileHandle.change_status_inFileRent(id);
                                    System.out.println("Rent is done !. :-)");
                                }
                                else{
                                    System.out.println("This rent request is active at this time. Try another book.");
                                }
                            }
                            else{
                                System.out.println("This book id is not available in book repository. :-|");
                            }
                        }
                        else{
                            System.out.println("This user ID is not available in user repository. :-|");
                        }
                    }catch (Exception e){
                        System.out.println("Missing args, apply command in correct way.");
                    }


                }
                else if(Objects.equals(list.get(1), "edit")){
                    // edit your info
                    try{
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
                                System.out.println("Repeat your command, your current phonenumber is not correct in input. ");
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
                    }catch (Exception e){
                        System.out.println("Missing args, Apply command in correct way.");
                    }
                }
                else if(Objects.equals(list.get(1), "return")){
                    try {
                        // lib return id your_id
                        int flag;
                        String bookId = list.get(2), user_id = list.get(3);
                        // edit booksFile : repository // change status if 0 existence or increment existence
                        // edit rentals

                        String rent_Query = "";
                        for(String line : rentalFileHandle.lines_of_file()){
                            if(line.contains(user_id+","+bookId)){
                                rent_Query = rentalFileHandle.getDate_fromSingleLine(line) + "," + user_id+","+bookId;
                                break;
                            }
                        }

                        if(!Objects.equals(rent_Query, "")){
                            rentalFileHandle.editLineInFile(rent_Query, "");
                            booksFileHandle.change_status_inFileReturnCase(bookId);
                        }
                        else{
                            System.out.println("This rental is not available in rents repository. :-|");
                        }
                    }catch (Exception e){
                        System.out.println("Missing args, Apply command in correct way.");
                    }



                }
                else if(Objects.equals(list.get(1), "show")){
                    try{
                        if(Objects.equals(list.get(2), "profile") || Objects.equals(list.get(2), "Profile")){
                            System.out.println("User_id : " + u.getUserID());
                            System.out.println("User_name : "+u.getUser_name());
                            System.out.println("User_phone : "+u.getPhonenumber());
                            System.out.println("Access level : "+u.getRole());
                        }
                        else if(Objects.equals(list.get(2), "Books") || Objects.equals(list.get(2), "books") || Objects.equals(list.get(2), "book")){
                            for(int i = 0;i < booksFileHandle.getStatsFromFileBook().size();i++){
                                if(Objects.equals(booksFileHandle.getStatsFromFileBook().get(i),"available")){
                                    System.out.println(booksFileHandle.getIdFromFileBook().get(i)+
                                            ", "+booksFileHandle.getTitlesFromFileBook().get(i)+" exst : " + booksFileHandle.getExistsFromFileBook().get(i));
                                }
                            }
                        }
                    }catch (Exception e){
                        System.out.println("Missing args, Try command in correct way. ");
                    }
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

    public void adminUserPanel(User u){
        String p1, p2, u1, u2;
        System.out.println("Welcome " + u.getUser_name());
        System.out.println("This is your admin panel.");
        ArrayList<String> list = new ArrayList<>();
        String cmd;
        v = new Verifications();
        Scanner scn = new Scanner(System.in);
        int flag;
        String userID, userName, userPhone;
        String book_t;
        String query;
        String type;
        while (true){
            System.out.println("Enter command (With Space ,Just one space, Please avoid to enter extra characters)");
            System.out.println("Enter help to ");
            System.out.print(">>>");
            cmd = scn.nextLine();
            if(Objects.equals(cmd, "help") || Objects.equals(cmd, "Help")){
                show_helpMenuAdmins();
            }
            else if((cmd.contains("lib") || cmd.contains("user")) && (!cmd.contains("  ") || !cmd.contains("*"))){
                list = v.get_SectionsPanelQuery(cmd);
                if(Objects.equals(list.get(1), "show") || Objects.equals(list.get(1), "Show")){
                    if(Objects.equals(list.get(2), "books")){
                        try {
                            type = list.get(3);
                            booksFileHandle.show_booksFile(type);
                        }
                        catch (Exception e){
                            System.out.println("Missing Argument,");
                        }
                    }
                    else if(Objects.equals(list.get(2), "users")){
                        for(String line : usersFileHandle.lines_of_file()){
                            System.out.println(line);
                        }
                    }
                    else if(Objects.equals(list.get(2), "rents")){
                        for(String line : rentalFileHandle.lines_of_file()){
                            System.out.println(line);
                        }
                    }
                    else{
                        System.out.println("Try command in correct way.");
                    }
                }
                else if(Objects.equals(list.get(1), "promote") || Objects.equals(list.get(1), "Promote")){
                    try {
                        userID = list.get(2);
                        userName = list.get(3);
                        userPhone = list.get(4);
                        flag = usersFileHandle.getIDInFile().indexOf(userID);
                        // user : id,username,phonenumber,role,password
                        query = userID + "," + userName + "," + userPhone + ",admin," + usersFileHandle.getUserPassword().get(flag);
                        if(adminsFileHandle.lines_of_file().contains(query)){
                            System.out.println("You promote this user before. ");
                        }
                        else{
                            adminsFileHandle.add_to_file(query);
                            usersFileHandle.editLineInFile(usersFileHandle.lines_of_file().get(flag), "");
                            System.out.println("Done!");
                        }

                    }
                    catch (Exception e){
                        System.out.println("Try command in correct way.[Missing Argument or ID/Username not in repository]");
                    }
                }
                else if(Objects.equals(list.get(1), "remove") || Objects.equals(list.get(1), "Remove")){ // remove whole with no change
                    if(Objects.equals(list.get(2), "user")){
                        // to remove user : lib remove user user_id user_name user_phone
                        userID = list.get(3);
                        flag = usersFileHandle.getIDInFile().indexOf(userID);
                        if(flag == -1){
                            System.out.println("This id is not in user repository.");
                        }
                        else{
                            usersFileHandle.editLineInFile(usersFileHandle.lines_of_file().get(flag), "");
                        }
                    }
                    else if(Objects.equals(list.get(2), "book")){
                        book_t = list.get(3);
                        flag = booksFileHandle.getTitlesFromFileBook().indexOf(book_t);
                        if(flag != -1){
                            booksFileHandle.editLineInFile(booksFileHandle.lines_of_file().get(flag), "");
                        }
                        else{
                            System.out.println("There is no book such this book in books repository");
                        }
                    }
                    else{
                        System.out.println("Missing arguments. ");
                    }
                }
                else if(Objects.equals(list.get(1), "edit") || Objects.equals(list.get(1), "Edit")){
                    // edit your info
                    if(Objects.equals(list.get(2), "ph")){
                        try {
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
                            if(adminsFileHandle.getPhoneNumbersInFile().contains(p1)){
                                while (true){
                                    if(!adminsFileHandle.getPhoneNumbersInFile().contains(p2))
                                        break;
                                    else{
                                        System.out.println("This phonenumber is already taken . try another one");
                                        System.out.print(">>>");
                                        p2 = scn.nextLine();
                                    }
                                }

                                int i = adminsFileHandle.getPhoneNumbersInFile().indexOf(p1);
                                if(Objects.equals(p1, u.getPhonenumber())){
                                    query = adminsFileHandle.getIDInFile().get(i)+","+
                                            adminsFileHandle.getUsernameInFile().get(i)+","+p2+",normal,"+adminsFileHandle.getUserPassword().get(i);
                                    adminsFileHandle.editLineInFile(adminsFileHandle.lines_of_file().get(i), query);
                                    System.out.println("phonenumber has been updated");
                                }
                                else{
                                    System.out.println("Repeat your command, your current username is not correct in input. ");
                                }

                            }
                            else{
                                System.out.println("There is no phone number like that in users repository");
                            }
                        }
                        catch (Exception e){
                            System.out.println("Missing Arguments.");
                        }
                    }
                    else if(Objects.equals(list.get(2), "usr")){
                        try{
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
                            if(adminsFileHandle.getUsernameInFile().contains(u1)){
                                while (true){
                                    if(!adminsFileHandle.getUsernameInFile().contains(u2))
                                        break;
                                    else{
                                        System.out.println("This username is already taken . try another one");
                                        System.out.print(">>>");
                                        u2 = scn.nextLine();
                                    }
                                }
                                int i = adminsFileHandle.getUsernameInFile().indexOf(u1);
                                if(Objects.equals(u1, u.getUser_name())){
                                    query = adminsFileHandle.getIDInFile().get(i)+","+
                                            u2+","+adminsFileHandle.getPhoneNumbersInFile().get(i)+",normal,"+adminsFileHandle.getUserPassword().get(i);
                                    adminsFileHandle.editLineInFile(adminsFileHandle.lines_of_file().get(i), query);
                                    u.set_new_username(u2);
                                    System.out.println("Your username has been updated");
                                }
                                else{
                                    System.out.println("Repeat your command, your current username is not correct in input. ");
                                }

                            }
                            else{
                                System.out.println("This username is not in users repository");
                            }
                        }
                        catch (Exception e){
                            System.out.println("Missing Arguments,");
                        }
                    }
                    else if(Objects.equals(list.get(2), "pss")){
                        try{
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
                                int i = adminsFileHandle.getUserPassword().indexOf(p1);
                                query = adminsFileHandle.getIDInFile().get(i)+"," + adminsFileHandle.getUsernameInFile().get(i)+","+
                                        adminsFileHandle.getPhoneNumbersInFile().get(i) + ",normal,"+p2;
                                adminsFileHandle.editLineInFile(adminsFileHandle.lines_of_file().get(i), query);
                                System.out.println("Your password has been updated.");
                            }

                        }
                        catch (Exception e){
                            e.printStackTrace();
                            System.out.println("Missing Arguments. ");
                        }
                    }
                    else if(Objects.equals(list.get(2), "admin")){
                        adminEditPanel(u);
                    }
                    else{
                        System.out.println("Try command in correct way. ");
                    }

                }
                else if(Objects.equals(list.get(1), "add") || Objects.equals(list.get(1),"Add")){
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
                                booksFileHandle.getAuthorsFromFileBook().get(i)+","+booksFileHandle.getDescriptionsFromFileBook().get(i)+","+
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
                else{
                    System.out.println("Try command in a correct way.");
                }
            }
            else if(Objects.equals(cmd, "exit")){
                break;
            }
            else{
                System.out.println("wrong command. try again :-|");
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


/*
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
 */

/*
if(i != -1){
                        if(rentalFileHandle.getRentalsUserID().contains(user_ID)){
                            f = rentalFileHandle.getRentalsUserID().indexOf(user_ID);
                            if(!Objects.equals(rentalFileHandle.getRentalsBookID().get(f), id)){
                                if(Objects.equals(booksFileHandle.getStatsFromFileBook().get(i), "in-rent")){
                                    System.out.println("this book "+id+" is actually in rent try another books.");
                                    System.out.println("To show available books try show books command.");
                                }
                                else{
                                    if(usersFileHandle.getIDInFile().contains(user_ID)){
                                        query = date + "," + user_ID + "," + booksFileHandle.getIdFromFileBook().get(i);
                                        booksFileHandle.change_status_inFileRent(booksFileHandle.getIdFromFileBook().get(i));
                                        rentalFileHandle.add_to_file(query);
                                    }
                                    else{
                                        System.out.println("Wrong ID, there is no id in repository like that. :-|");
                                    }
                                }
                            }
                            else{
                                System.out.println("there is rent just like the rent, try another book.");
                            }
                        }
                        else{

                        }
                    }
                    else{
                        System.out.println("This book with this id is not available in book repository. :-|");
                        System.out.println("Try command with appropriate query. :-)");
                    }
 */

/*
if(true){
                        flag = rentalFileHandle.getRentalsUserID().indexOf(user_id);
                        String new_query = "";
                        String line = rentalFileHandle.lines_of_file().get(flag);
                        rentalFileHandle.editLineInFile(line, new_query);
                        booksFileHandle.change_status_inFileReturnCase(bookId);

                    }else{
                        System.out.println("No such rental details are available. :-|");
                    }
 */