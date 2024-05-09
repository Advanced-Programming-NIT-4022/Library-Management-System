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
            boolean f1 = file1.createNewFile();
            boolean f2 = file2.createNewFile();
            boolean f3 = file3.createNewFile();
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
        } catch (Exception ignored) {
        }
    }

    public void showAllUser() {
        if (!checkPassword()) {
            System.out.println("Wrong Password ");
            return;
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
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        }
    }

    public void showAllRent() {
        if (this.rentArray.isEmpty()) {
            System.out.println("Rent list is empty ");
            return;
        }
        if (!checkPassword()) {
            System.out.println("Wrong Password");
            return;
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

    public boolean checkPassword() {
        Scanner input = new Scanner(System.in);
        System.out.print("enter Library password : ");
        String password = input.nextLine();
        return libraryPassword.equals(password);
    }

    public boolean userCheckPassword(int userid) {
        Scanner input = new Scanner(System.in);
        System.out.print("enter User password: ");
        String userPassword = input.nextLine();
        return this.userArray.get(userid - 1).password.equals(userPassword);
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

    public void addBook(String bookName, String bookAuthor) {
        if (!checkPassword()) {
            System.out.println("Wrong Password");
            return;
        }
        Book book = new Book(bookName, bookAuthor, this.booksId, true);
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
        if (!checkPassword()) {
            System.out.println("Wrong Password");
            return;
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
        if (!checkPassword()) {
            System.out.println("Wrong Password");
            return;
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
        if (!checkPassword()) {
            System.out.println("Wrong Password ");
            return;
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

    public void showAllCommand() {
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        System.out.println("Book options : ");
        System.out.println("lib add book <bookName> <bookAuthor>");
        System.out.println("lib remove book <bookID>");
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        System.out.println("User options : ");
        System.out.println("lib add user <userName> <phoneNumber> <password>");
        System.out.println("lib remove user <userID>");
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        System.out.println("Show : ");
        System.out.println("lib show all book");
        System.out.println("lib show all user");
        System.out.println("lib show all rent");
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        System.out.println("Rent & Return : ");
        System.out.println("lib rent book <userID> <bookID> ");
        System.out.println("lib return book <userID> <bookID>");
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
    }

    public void checkCommand(String command) {
        if (command.equals("exit")) {
            System.exit(0);
        } else {
            String[] commandSegs = command.split(" ");
            if (commandSegs[0].equals("lib")) {
                if (commandSegs[1].equals("-h") && commandSegs.length == 2) {
                    showAllCommand();
                } else if (commandSegs[1].equals("add")) {
                    if (commandSegs.length == 5 && commandSegs[2].equals("book") && commandSegs[3].matches("[a-zA-Z]+") && commandSegs[4].matches("[a-zA-Z]+")) {
                        addBook(commandSegs[3], commandSegs[4]);
                    } else if (commandSegs.length == 6 && commandSegs[2].equals("user") && commandSegs[3].matches("[a-zA-Z]+") && commandSegs[4].matches("[0-9]+")) {
                        addUser(commandSegs[3], commandSegs[4], commandSegs[5]);
                    } else {
                        System.out.println("Wrong try agin");
                    }
                } else if (commandSegs[1].equals("remove")) {
                    if (commandSegs.length == 4 && commandSegs[2].equals("user") && commandSegs[3].matches("[0-9]+")) {
                        removeUser(Integer.parseInt(commandSegs[3]));

                    } else if (commandSegs.length == 4 && commandSegs[2].equals("book") && commandSegs[3].matches("[0-9]+")) {
                        removeBook(Integer.parseInt(commandSegs[3]));

                    } else {
                        System.out.println("Wrong try agin");
                    }
                } else if (commandSegs[1].equals("show") && commandSegs[2].equals("all") && commandSegs.length == 4) {
                    if (commandSegs[3].equals("book")) {
                        showAllBook();

                    } else if (commandSegs[3].equals("user")) {
                        showAllUser();
                    } else if (commandSegs[3].equals("rent")) {
                        showAllRent();
                    } else {
                        System.out.println("Wrong try agin");
                    }

                } else if (commandSegs[1].equals("rent") && commandSegs[2].equals("book") && commandSegs[3].matches("[0-9]+") && commandSegs[4].matches("[0-9]+") && commandSegs.length == 5) {
                    rentBook(Integer.parseInt(commandSegs[3]), Integer.parseInt(commandSegs[4]));
                }


                else if (commandSegs[1].equals("return") && commandSegs[2].equals("book") && commandSegs[3].matches("[0-9]+") && commandSegs[4].matches("[0-9]+") && commandSegs.length == 5) {
                    returnBook(Integer.parseInt(commandSegs[3]), Integer.parseInt(commandSegs[4]));
                } else {
                    System.out.println("Wrong try agin");
                    return;
                }
            }

        }
    }


        public void run() {
            System.out.println("xxx Welcome to " + this.libraryName + " xxx");
            if (!isLibraryOpen()) {
                System.out.println("Sorry we are closed right now please try agin betwin" + openHour+" - " + closeHour);
            } else {
                while (true) {
                    System.out.println("For see options write lib -h");
                    System.out.println("For exit write exit");
                    Scanner input = new Scanner(System.in);
                    String command = input.nextLine();
                    checkCommand(command);
                }

            }
        }
    }

