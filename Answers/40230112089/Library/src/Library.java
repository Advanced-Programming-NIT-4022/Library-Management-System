import java.io.*;
import java.net.SocketTimeoutException;
import java.sql.SQLOutput;
import java.util.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
public class Library {
    String libraryName;
    String libraryPassword;
    int openHour;
    int closeHour;

    ArrayList<User> userArray = new ArrayList<>();
    ArrayList<Book> bookArray = new ArrayList<>();
    ArrayList<Rent> rentArray = new ArrayList<>();
    ArrayList<Admin> adminArray = new ArrayList<>();
    int usersId = 1;
    int booksId = 1;
    int rentsId = 1;

    public Library(String libraryName, int openHour, int closeHour, String libraryPassword) {
        this.libraryName = libraryName;
        this.openHour = openHour;
        this.closeHour = closeHour;
        this.libraryPassword = libraryPassword;
        checkFiles();
        fileUpdater();
        if (!this.bookArray.isEmpty()) {
            booksId = this.bookArray.size() + 1;
        }
        if (!this.userArray.isEmpty()) {
            usersId = this.userArray.size() + 1;
        }
        if (!this.rentArray.isEmpty()) {
            rentsId = this.rentArray.size() + 1;
        }
    }

    public void checkFiles() {
        try {
            File file1 = new File("rents.txt");
            File file2 = new File("Users.txt");
            File file3 = new File("Books.txt");
            File file4 = new File("Admins.txt");
            boolean f1 = file1.createNewFile();
            boolean f2 = file2.createNewFile();
            boolean f3 = file3.createNewFile();
            boolean f4 = file4.createNewFile();
        } catch (Exception ignored) {
        }
    }

    public void fileSaver() {
        try {
            //کلاس FileOutputStream یک جریان خروجی برای نوشتن داده‌ها به یک فایل فراهم می‌کند.
            FileOutputStream fileOutput1 = new FileOutputStream("Books.txt");
            //کلاس ObjectOutputStream در جاوا یک جریان خروجی است که می‌تواند اشیاء جاوا را به یک جریان خروجی باینری بنویسد
            ObjectOutputStream objOutput1 = new ObjectOutputStream(fileOutput1);
            //به فایل می نویسد ان جریان باینری را
            objOutput1.writeObject(this.bookArray);
            fileOutput1.close();
            objOutput1.close();
            FileOutputStream fileOutput2 = new FileOutputStream("Users.txt");
            ObjectOutputStream objOutput2 = new ObjectOutputStream(fileOutput2);
            objOutput2.writeObject(this.userArray);
            fileOutput2.close();
            objOutput2.close();
            FileOutputStream fileOutput3 = new FileOutputStream("Rents.txt");
            ObjectOutputStream objOutput3 = new ObjectOutputStream(fileOutput3);
            objOutput3.writeObject(this.rentArray);
            fileOutput3.close();
            objOutput3.close();
            FileOutputStream fileOutput4 = new FileOutputStream("Admins.txt");
            ObjectOutputStream objOutput4 = new ObjectOutputStream(fileOutput4);
            objOutput4.writeObject(this.adminArray);
            fileOutput4.close();
            objOutput4.close();
        } catch (Exception ignored) {
        }
    }

    public void fileUpdater() {
        try {
            //داده ها را از فایل باینری میخوانیم
            FileInputStream fileInput1 = new FileInputStream("Books.txt");
            //خواندن اشیا سریالیزه از جریان ورودی
            ObjectInputStream objInput1 = new ObjectInputStream(fileInput1);
            this.bookArray = (ArrayList<Book>) objInput1.readObject();
            //دستورات ObjectInputStream را بسته و فایل را ازاد میکند
            fileInput1.close();
            objInput1.close();
            FileInputStream fileInput2 = new FileInputStream("Users.txt");
            ObjectInputStream objInput2 = new ObjectInputStream(fileInput2);
            this.userArray = (ArrayList<User>) objInput2.readObject();
            fileInput2.close();
            objInput2.close();
            FileInputStream fileInput3 = new FileInputStream("Rents.txt");
            ObjectInputStream objInput3 = new ObjectInputStream(fileInput3);
            this.rentArray = (ArrayList<Rent>) objInput3.readObject();
            fileInput3.close();
            objInput3.close();
            FileInputStream fileInput4 = new FileInputStream("Admins.txt");
            ObjectInputStream objInput4 = new ObjectInputStream(fileInput4);
            this.adminArray = (ArrayList<Admin>) objInput4.readObject();
            fileInput4.close();
            objInput4.close();
        } catch (Exception ignored) {
        }
    }

    public void showAllUser() {
        System.out.println("enter admin or owner:");
        Scanner input = new Scanner(System.in);
        String type = input.nextLine();
        if (type.equals("owner")){
            if (!checkLibraryPassword()) {
                System.out.println("Wrong Password");
                return;
            }
        }
        if (type.equals("admin")){
            if (!checkAdminIdPas()) {
                System.out.println("Wrong information");
                return;
            }
        }
        if (this.userArray.isEmpty()) {
            System.out.println("User list is empty");
            return;
        }
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        for (int i = 0; i < this.userArray.size(); i++) {
            System.out.println((i + 1) + "-");
            System.out.println("User name          : " + this.userArray.get(i).userName);
            System.out.println("User id            : " + this.userArray.get(i).userId);
            System.out.println("User password      : " + this.userArray.get(i).password);
            System.out.println("User phone number  : " + this.userArray.get(i).phoneNumber);
            System.out.println("User register date : " + this.userArray.get(i).registerDate);
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        }
    }


    public void showAllAdmin() {
        if (!checkLibraryPassword()) {
            System.out.println("Wrong Password");
            return;
        }
        if (this.adminArray.isEmpty()) {
            System.out.println("Admin list is empty");
            return;
        }
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        for (int i = 0; i < this.adminArray.size(); i++) {
            System.out.println((i + 1) + "-");
            System.out.println("Admin name          : " + this.adminArray.get(i).userName);
            System.out.println("Admin id            : " + this.adminArray.get(i).userId);
            System.out.println("Admin password      : " + this.adminArray.get(i).password);
            System.out.println("Admin phone number  : " + this.adminArray.get(i).phoneNumber);
            System.out.println("Admin register date : " + this.adminArray.get(i).registerDate);
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        }
    }

    public void showAllBook() {
        if (this.bookArray.isEmpty()) {
            System.out.println("Book list is empty");
            return;
        }
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        for (int i = 0; i < this.bookArray.size(); i++) {
            System.out.println((i + 1) + "-");
            System.out.println("Book name    : " + this.bookArray.get(i).bookName);
            System.out.println("Book id      : " + this.bookArray.get(i).bookId);
            System.out.println("Book author  : " + this.bookArray.get(i).bookAuthor);
            System.out.println("Availability : " + this.bookArray.get(i).isAvailable);
            System.out.println("description : " + this.bookArray.get(i).description);
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        }
    }

    public void showAllRent() {
        if (this.rentArray.isEmpty()) {
            System.out.println("Rent list is empty ");
            return;
        }
        System.out.println("enter admin or owner:");
        Scanner input = new Scanner(System.in);
        String type = input.nextLine();
        if (type.equals("owner")){
            if (!checkLibraryPassword()) {
                System.out.println("Wrong Password");
                return;
            }
        }
        if (type.equals("admin")){
            if (!checkAdminIdPas()) {
                System.out.println("Wrong information");
                return;
            }
        }
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        for (int i = 0; i < this.rentArray.size(); i++) {
            System.out.println((i + 1) + "-");
            System.out.println("Rent id      : " + this.rentArray.get(i).rentId);
            System.out.println("Rent date    : " + this.rentArray.get(i).rentDate);
            System.out.println("Rent book id : " + this.rentArray.get(i).book.bookId);
            System.out.println("Rent user id : " + this.rentArray.get(i).user.userId);
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        }
    }

    public boolean checkUserId(int userId) {
        boolean result = false;
        for (int i = 0; i < this.userArray.size(); i++) {
            if (this.userArray.get(i).userId == userId) {
                result = true;
            }
        }
        return result;
    }

    public boolean checkAdminUserId(int userId) {
        boolean result = false;
        for (int i = 0; i < this.adminArray.size(); i++) {
            if (this.adminArray.get(i).userId == userId) {
                result = true;
            }
        }
        return result;
    }

    public boolean checkLibraryPassword() {
        Scanner input = new Scanner(System.in);
        System.out.print("enter Library password : ");
        String password = input.nextLine();
        return libraryPassword.equals(password);
    }


    public boolean userCheckPassword(int userid) {
        boolean result = false;
        Scanner input = new Scanner(System.in);
        System.out.print("enter User password: ");
        String userPassword = input.nextLine();
        for (int i = 0; i <userArray.size() ; i++) {
          if (this.userArray.get(i).userId ==userid && this.userArray.get(i).password.equals(userPassword)) {
              result=true;
          }
        }
        return result ;
    }

    public boolean checkBookId(int bookId) {
        boolean result = false;
        for (int i = 0; i < this.bookArray.size(); i++) {
            if (this.bookArray.get(i).bookId == bookId) {
                result = true;
                break;
            }
        }
        return result;
    }
    public boolean  checkAdminIdPas(){
        boolean result =false;
        System.out.println("enter admin Id :");
        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        int adminId = input.nextInt();
        System.out.println("enter admin password :");
        String adminPass = input2.nextLine();
        for (int i = 0; i <adminArray.size() ; i++) {
            if (this.adminArray.get(i).userId ==adminId && this.adminArray.get(i).password.equals(adminPass)) {
                result=true;
            }
        }
        return result ;
    }

    public void addBook(String bookName, String bookAuthor,String description) {
        System.out.println("enter admin or owner:");
        Scanner input = new Scanner(System.in);
        String type = input.nextLine();
        if (type.equals("owner")){
            if (!checkLibraryPassword()) {
                System.out.println("Wrong Password");
                return;
            }
        }
        if (type.equals("admin")){
            if (!checkAdminIdPas()) {
                System.out.println("Wrong information");
                return;
            }
        }
        Book book = new Book(bookName, bookAuthor, this.booksId, true,description);
        this.booksId++;
        this.bookArray.add(book);
        System.out.println("Book id : " + book.bookId);
        System.out.println(" Book added");
        fileSaver();
    }

    public void removeBook(int bookId) {
        if (!checkBookId(bookId)) {
            System.out.println("Wrong Book");
            return;
        }
        System.out.println("enter admin or owner:");
        Scanner input = new Scanner(System.in);
        String type = input.nextLine();
        if (type.equals("owner")){
            if (!checkLibraryPassword()) {
                System.out.println("Wrong Password");
                return;
            }
        }
        if (type.equals("admin")){
            if (!checkAdminIdPas()) {
                System.out.println("Wrong information");
                return;
            }
        }
        for (int i = 0; i < this.bookArray.size(); i++) {
            if (this.bookArray.get(i).bookId == bookId) {
                this.bookArray.remove(i);
                break;
            }
        }
        System.out.println(" Book removed");
        fileSaver();
    }

    public void addUser(String userName, String phoneNumber, String password) {
        System.out.println("enter admin or owner:");
        Scanner input = new Scanner(System.in);
        String type = input.nextLine();
        if (type.equals("owner")){
            if (!checkLibraryPassword()) {
                System.out.println("Wrong Password");
                return;
            }
        }
        if (type.equals("admin")){
            if (!checkAdminIdPas()) {
                System.out.println("Wrong information");
                return;
            }
        }
        User user = new User(userName, phoneNumber, this.usersId, new Date().toString(), password);
        this.userArray.add(user);
        this.usersId++;
        System.out.println("User id : " + user.userId);
        System.out.println("User added ");
        fileSaver();
    }



    public void removeUser(int userId) {
        if (!checkUserId(userId)) {
            System.out.println("Wrong User");
            return;
        }
        System.out.println("enter admin or owner:");
        Scanner input = new Scanner(System.in);
        String type = input.nextLine();
        if (type.equals("owner")){
            if (!checkLibraryPassword()) {
                System.out.println("Wrong Password");
                return;
            }
        }
        if (type.equals("admin")){
            if (!checkAdminIdPas()) {
                System.out.println("Wrong information");
                return;
            }
        }
        for (int i = 0; i < this.userArray.size(); i++) {
            if (this.userArray.get(i).userId == userId) {
                this.userArray.remove(i);
                break;
            }
        }
        System.out.println("User removed");
        fileSaver();
    }


    public void addAdmin(String userName, String phoneNumber, String password) {
        if (!checkLibraryPassword()) {
            System.out.println("Wrong Password");
            return;
        }
        Admin admin = new Admin(userName, phoneNumber, this.usersId, new Date().toString(), password);
        this.adminArray.add(admin);
        this.usersId++;
        System.out.println("User id : " + admin.userId);
        System.out.println("Admin added ");
        fileSaver();
    }


    public void removeAdmin(int userId) {
        if (!checkAdminUserId(userId)) {
            System.out.println("Wrong Admin");
            return;
        }
        if (!checkLibraryPassword()) {
            System.out.println("Wrong Password ");
            return;
        }
        for (int i = 0; i < this.adminArray.size(); i++) {
            if (this.adminArray.get(i).userId == userId) {
                this.adminArray.remove(i);
                break;
            }
        }
        System.out.println("Admin removed");
        fileSaver();
    }


    public void deleteAccount(int userId , String password) {
        if (!checkAdminUserId(userId) && !checkUserId(userId)) {
            System.out.println("Wrong userId");
            return;
        }
        else if (checkAdminUserId(userId)) {
            for (int i = 0; i < this.adminArray.size(); i++) {
                System.out.println(this.adminArray.get(i).userId);
                System.out.println(this.adminArray.get(i).password);
                if (this.adminArray.get(i).password.equals(password) && this.adminArray.get(i).userId == userId) {
                    this.adminArray.remove(i);
                    System.out.println("your account deleted");
                    return;
                }
            }
            System.out.println("Wrong password");
        }
        else if (checkUserId(userId)){
            for (int i = 0; i < this.userArray.size(); i++) {
                if (this.userArray.get(i).password.equals(password)  && this.userArray.get(i).userId == userId) {
                    System.out.println(this.userArray.get(i).password);
                    this.userArray.remove(i);
                    System.out.println("your account deleted");
                    return;
                }
            }
            System.out.println("Wrong password");

        }
    }

    public void rentBook(int userId, int bookId) {
        if (!checkBookId(bookId)) {
            System.out.println("Wrong Book");
            return;
        }
        if (!checkUserId(userId)) {
            System.out.println("Wrong User");
            return;
        }
        if (!userCheckPassword(userId)) {
            System.out.println("Wrong Password  ");
            return;
        }
        int bookIndex = 0, userIndex = 0;

        for (int i = 0; i < this.userArray.size(); i++) {
            if (this.userArray.get(i).userId == userId) {
                userIndex = i;
            }

        }
        for (int i = 0; i < this.bookArray.size(); i++) {
            if (this.bookArray.get(i).bookId == bookId) {
                if (!this.bookArray.get(i).isAvailable) {
                    System.out.println("Book is already rented ");
                    return;
                }
                bookIndex = i;
                this.bookArray.get(i).isAvailable = false;
                break;
            }
        }
        Rent rent = new Rent(this.rentsId, new Date().toString(), this.userArray.get(userIndex), this.bookArray.get(bookIndex));
        this.rentArray.add(rent);
        System.out.println(" Book rented ");
        fileSaver();
    }

    public void returnBook(int userId, int bookId) {
        if (!checkUserId(userId)) {
            System.out.println("Wrong user");
            return;
        }
        if (!checkBookId(bookId)) {
            System.out.println("Wrong Book");
            return;
        }
        for (int i = 0; i < this.rentArray.size(); i++) {
            if (this.rentArray.get(i).book.bookId == bookId && this.rentArray.get(i).user.userId == userId) {
                for (int j = 0; j < this.bookArray.size(); j++) {
                    if (this.bookArray.get(j).bookId == bookId) {
                        this.bookArray.get(j).isAvailable = true;
                        break;
                    }
                }
                this.rentArray.remove(i);
                break;
            }
        }
        System.out.println("Book returned");
        fileSaver();
    }

    public boolean isLibraryOpen() {
        String timeZone = "Asia/Tehran";
        LocalDateTime currentTime = LocalDateTime.now(ZoneId.of(timeZone));
        int hour = currentTime.getHour();
        if (hour >= openHour && hour < closeHour) {
            return true;
        } else {
            return false;
        }

    }


    public void getHours(){
        System.out.println("We are open from " + openHour+ " to " + closeHour);
    }
    public void showAllCommand() {
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        System.out.println("Book options : ");
        System.out.println("lib add book <bookName> <bookAuthor> <description>");
        System.out.println("lib remove book <bookID>");
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        System.out.println("User options : ");
        System.out.println("lib add user <userName> <phoneNumber> <password>");
        System.out.println("lib remove user <userID>");
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        System.out.println("Admin options : ");
        System.out.println("lib add admin <userName> <phoneNumber> <password>");
        System.out.println("lib remove admin <userID>");
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        System.out.println("Show : ");
        System.out.println("lib show all book");
        System.out.println("lib show all user");
        System.out.println("lib show all admin");
        System.out.println("lib show all rent");
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        System.out.println("Rent & Return : ");
        System.out.println("lib rent book <userID> <bookID> ");
        System.out.println("lib return book <userID> <bookID>");
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        System.out.println("lib delete account <userID> <password>");
        System.out.println("lib get hrs");
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
    }

    public void checkCommand(String command ) {
        command = command.trim();
        if (command.equals("exit")) {
            System.exit(0);
        } else if (!command.contains(" ")) {
            System.out.println("Wrong try again");
        } else {

            String[] commandSegs = command.split(" ");

            if (commandSegs[0].equals("lib")) {
                if (commandSegs[1].equals("-h") && commandSegs.length == 2) {
                    showAllCommand();
                }
                else if (commandSegs.length == 3 && commandSegs[1].equals("get") && commandSegs[2].equals("hrs")){
                    getHours();
                }
                else if( commandSegs.length == 5 && commandSegs[1].equals("delete") && commandSegs[2].equals("account") && commandSegs[3].matches("[0-9]+") && commandSegs[4].matches("\\S+"))  {
                    deleteAccount(Integer.parseInt(commandSegs[3]),commandSegs[4]);
                }
                else if (commandSegs[1].equals("add")) {
                    if (commandSegs.length == 6 && commandSegs[2].equals("book") && commandSegs[3].matches("^[a-zA-Z0-9\\/]*$") && commandSegs[4].matches("^[a-zA-Z0-9\\/]*$") && commandSegs[5].matches("^[a-zA-Z0-9\\/]*$")) {

                        addBook(commandSegs[3].replace("/", " "), commandSegs[4].replace("/", " "), commandSegs[5].replace("/", " "));

                    } else if (commandSegs.length == 6 && commandSegs[2].equals("user") && commandSegs[3].matches("^[a-zA-Z0-9\\/]*$") && commandSegs[4].matches("09[0-9]{9}") && commandSegs[5].matches("\\S+")) {
                        addUser(commandSegs[3].replace("/", " "), commandSegs[4], commandSegs[5]);
                    }
                    else if (commandSegs.length == 6 && commandSegs[2].equals("admin") && commandSegs[3].matches("^[a-zA-Z0-9\\/]*$") && commandSegs[4].matches("09[0-9]{9}") && commandSegs[5].matches("\\S+")){
                        addAdmin(commandSegs[3].replace("/", " "), commandSegs[4], commandSegs[5]);
                    } else {
                        System.out.println("Wrong try again");
                    }
                } else if (commandSegs[1].equals("remove")) {
                    if (commandSegs.length == 4 && commandSegs[2].equals("user") && commandSegs[3].matches("[0-9]+")) {
                        removeUser(Integer.parseInt(commandSegs[3]));

                    }
                    if (commandSegs.length == 4 && commandSegs[2].equals("admin") && commandSegs[3].matches("[0-9]+")) {
                        removeAdmin(Integer.parseInt(commandSegs[3]));
                    }
                    else if (commandSegs.length == 4 && commandSegs[2].equals("book") && commandSegs[3].matches("[0-9]+")) {
                        removeBook(Integer.parseInt(commandSegs[3]));

                    } else {
                        System.out.println("Wrong try again");
                    }
                } else if (commandSegs[1].equals("show") && commandSegs[2].equals("all") && commandSegs.length == 4) {
                    if (commandSegs[3].equals("book")) {
                        showAllBook();

                    } else if (commandSegs[3].equals("user")) {
                        showAllUser();
                    } else if (commandSegs[3].equals("admin")) {
                        showAllAdmin();
                    }else if (commandSegs[3].equals("rent")) {
                        showAllRent();
                    } else {
                        System.out.println("Wrong try again");
                    }

                } else if (commandSegs[1].equals("rent") && commandSegs[2].equals("book") && commandSegs[3].matches("[0-9]+") && commandSegs[4].matches("[0-9]+") && commandSegs.length == 5) {
                    rentBook(Integer.parseInt(commandSegs[3]), Integer.parseInt(commandSegs[4]));
                }


                else if (commandSegs[1].equals("return") && commandSegs[2].equals("book") && commandSegs[3].matches("[0-9]+") && commandSegs[4].matches("[0-9]+") && commandSegs.length == 5) {
                    returnBook(Integer.parseInt(commandSegs[3]), Integer.parseInt(commandSegs[4]));
                }
                else {
                    System.out.println("Wrong try again");
                }
            }else{
                System.out.println("Wrong try again");
            }

        }
    }


        public void run() {

            System.out.println("xxx Welcome to " + this.libraryName + " xxx");
            if (!isLibraryOpen()) {
                System.out.println("Sorry we are closed right now please try again betwin" + openHour+" - " + closeHour);
            } else {
                while (true) {

                    System.out.println("For see options write lib -h");
                    System.out.println("For exit write exit");
                    System.out.println("Use the (/) to write a space in the middle of the names");
                    Scanner input = new Scanner(System.in);
                    String command = input.nextLine();
                    checkCommand(command);
                }

            }
        }
    }

